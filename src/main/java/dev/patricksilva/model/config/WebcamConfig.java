package dev.patricksilva.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.sarxos.webcam.Webcam;

@Configuration
public class WebcamConfig {

    /**
     * Bean definition for Webcam.
     *
     * @return Webcam bean representing the default webcam configuration.
     */
    @Bean
    Webcam webcam() {
		return Webcam.getDefault();
	}
}