package com.sistemas.distribuidos.marcketplace.domain;


import java.math.BigDecimal;


public class Usuario {

	// atributes
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private BigDecimal saldo;

	// constructors
	public Usuario() {
		// Empty constructor
	}

	// gets
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public String getEmail() {
		return this.email;
	}
	public String getSenha() {
		return this.senha;
	}
	public BigDecimal getSaldo() {
		return this.saldo;
	}

	// sets
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	// hash - equals - tostring

}