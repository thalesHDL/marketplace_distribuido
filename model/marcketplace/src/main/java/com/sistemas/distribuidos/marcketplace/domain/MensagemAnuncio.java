package com.sistemas.distribuidos.marcketplace.domain;


import java.time.LocalDate;
import java.io.Serializable;


public class MensagemAnuncio implements Serializable {

	// atributes
	private Long id;
	private Anuncio anuncio;
	private Usuario usuario;
	private String pergunta;
	private LocalDate data;

	// constructors
	public MensagemAnuncio() {
		// Empty constructor
	}

	// gets
	public Long getId() {
		return this.id;
	} 
	public Anuncio getAnuncio() {
		return this.anuncio;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public String getPergunta() {
		return this.pergunta;
	}
	public LocalDate getData() {
		return this.data;
	}

	// sets
	public void setId(Long id) {
		this.id = id;
	} 
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	// hash - equals - tostring
	@Override
	public String toString() {
		return "MensagemAnuncio: {" +
				"id: " + this.id +
				", " + this.anuncio +
				", " + this.usuario +
				", pergunta: " + this.pergunta +
				", data: " + this.data
			+ "}";
	}

}