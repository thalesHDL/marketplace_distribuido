package com.sd.marcketplace.view.form.produto;

public enum ProdutoOption {
	NONE(0L),
	LISTAR(1L),
	FILTRAR(2L),
	SELECIONAR(3L),
	NOVO(4L),
	VOLTAR(5L);
	
	private Long value;
	
	ProdutoOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
