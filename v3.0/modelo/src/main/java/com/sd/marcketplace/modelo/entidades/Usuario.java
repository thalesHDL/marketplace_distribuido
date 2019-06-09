package com.sd.marcketplace.modelo.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {
	
	private Long id;
	private String email;
	private String senha;
	
	public Usuario() {
		// Empty constructor
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}

}
