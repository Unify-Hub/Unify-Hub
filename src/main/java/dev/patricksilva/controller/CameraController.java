package dev.patricksilva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.sarxos.webcam.Webcam;

@RestController
@RequestMapping("/camera")
public class CameraController {
	@Autowired
	private Webcam webcam;

	/**
	 * Turns on the camera.
	 *
	 * @return A success message if the camera is turned on successfully, otherwise an error message.
	 */
	@PostMapping("/turnon")
	public String ligarCamera() {
		try {
			webcam.open();
			return "Câmera ligada com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao ligar a câmera: " + e.getMessage();
		}
	}

	/**
	 * Turns off the camera.
	 * 
	 * @return A success message if the camera is turned off successfully, otherwise an error message.
	 */
	@PostMapping("/turnoff")
	public String desligarCamera() {
		try {
			webcam.close();
			return "Câmera Desligada Com Sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao desligar a câmera: " + e.getMessage();
		}
	}
}