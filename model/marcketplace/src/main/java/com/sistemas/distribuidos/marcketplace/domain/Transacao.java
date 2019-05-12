package com.sistemas.distribuidos.marcketplace.domain;


import java.time.LocalDate;
import java.io.Serializable;


public class Transacao implements Serializable {

	// atributes
	private Long id;
	private Comprador comprador;
	private Produto produto;
	private LocalDate data;

	// constructors
	public Transacao() {
		// Empty constructor
	}

	// gets
	public Long getId() {
		return this.id;
	}
	public Comprador getComprador() {
		return this.comprador;
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
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	// hash - equals - tostring
	@Override
	public String toString() {
		return "Transacao: {" +
				"id: " + this.id +
				", " + this.comprador +
				", " + this.produto +
				", data: " + this.data
			+ "}";
	}

}