package com.sistemas.distribuidos.marcketplace.domain;


import java.math.BigDecimal;


public class Produto {

	private Long id;
	private String nome;
	private String descricao;
	private Vendedor vendedor;
	private Long quantidade;
	private BigDecimal preco;

}