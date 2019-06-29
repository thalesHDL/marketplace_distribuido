package com.sd.marcketplace.view.form.anuncio;

public enum AnuncioFormOption {
	NONE(0L),
	LISTAR(1L),
	FILTRAR(2L),
	SELECIONAR(3L),
	VOLTAR(4L);
	
	private Long value;
	
	AnuncioFormOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
