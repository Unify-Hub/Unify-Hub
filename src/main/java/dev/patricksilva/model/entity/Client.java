package dev.patricksilva.model.entity;

public class Client {
	private String nome;
	private String email;
	private String password;
	private Meeting meeting;
	
	void login() {
		this.password = password;
	}
	
	void register() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}