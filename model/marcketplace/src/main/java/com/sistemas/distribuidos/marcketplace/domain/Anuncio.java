package com.sistemas.distribuidos.marcketplace.domain;


import java.time.LocalDate;
import java.io.Serializable;


public class Anuncio implements Serializable {

	// atributes
	private Long id;
	private Produto produto;
	private LocalDate data;
	// decidir o que mais será salvo em um anuncio, ex: fotos, descricao técnica

	// constructors
	public Anuncio() {
		// Empty constructor
	}

	// gets
	public Long getId() {
		return this.id;
	}
	public Produto getProduto() {
		return this.produto;
	}
	public LocalDate getData() {
		return this.data;
	}

	// sets
	public void setId(Long id) {
		this.id = id;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	// hash - equals - tostring

}