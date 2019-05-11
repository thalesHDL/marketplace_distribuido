package com.sistemas.distribuidos.marcketplace.domain;


import java.math.BigDecimal;


public class Produto {

	// atributes
	private Long id;
	private String nome;
	private String descricao;
	private Vendedor vendedor;
	private Long quantidade;
	private BigDecimal preco;

	// constructors
	public Produto() {
		// Empty constructor
	}

	// gets
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Vendedor getVendedor() {
		return this.vendedor;
	}
	public Long getQuantidade() {
		return this.quantidade;
	}
	public BigDecimal getPreco() {
		return this.preco;
	}

	// sets
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	// hash - equals - tostring

}