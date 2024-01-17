package dev.patricksilva.model.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;

import com.github.sarxos.webcam.Webcam;

import jakarta.annotation.PreDestroy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
public class VideoService {
	@Autowired
	private Webcam webcam;
	
	public final Flux<ServerSentEvent<byte[]>> videoStream;
	private final Timer timer;

	public VideoService() {
		this.videoStream = createVideoStream();
		this.timer = new Timer();
	}
	
	/**
	 * Creates a Flux for streaming video frames.
	 *
	 * @return Flux of ServerSentEvent containing video frames.
	 */
	public Flux<ServerSentEvent<byte[]>> createVideoStream() {
		return Flux.create(sink -> {
			final FluxSink<ServerSentEvent<byte[]>> videoSink = sink;
			
			sink.onDispose(() -> {
				timer.cancel(); // Encerrar a captura ao se desconectar
			});

			// Emite frames em intervalos regulares
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						byte[] frame = captureFrame();
						videoSink.next(ServerSentEvent.builder(frame).build());
					} catch (Exception e) {
						videoSink.error(e);
					}
				}
			}, 0, 100); // Intervalo de 100 milissegundos
		}, FluxSink.OverflowStrategy.LATEST);
	}

	/**
	 * Captures a video frame.
	 *
	 * @return Byte array representing the captured video frame.
	 */
	private byte[] captureFrame() {
		try {
			BufferedImage image = captureImageFromWebcam();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	/**
	 * Captures an image from the webcam.
	 *
	 * @return BufferedImage representing the captured image.
	 */
	private BufferedImage captureImageFromWebcam() {
	    return webcam.getImage();
	}
	
	/**
	 * Method executed on destroying the bean to cancel the timer.
	 */
	@PreDestroy
	public void onDestroy() {
		timer.cancel();
	}
}