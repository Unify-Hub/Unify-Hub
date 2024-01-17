package dev.patricksilva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.patricksilva.model.service.VideoService;
import reactor.core.publisher.Flux;

/**
 * Controller class for streaming video frames.
 */
@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	// (TODO: Fix Flux)
	/**
	 * Endpoint to stream video frames as Server-Sent Events.
	 *
	 * @return Flux of ServerSentEvent containing video frames.
	 */
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<byte[]>> streamVideo() {
		return videoService.videoStream.map(frame -> ServerSentEvent.<byte[]>builder().event("video").data(frame.data()).build());
	}
}