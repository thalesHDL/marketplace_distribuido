package com.sd.marcketplace.view.form.InfoAnuncio;

public enum InfoAnuncioFormOption {
	NONE(0L),
	INFO(1L),
	COMPRAR(2L),
	VOLTAR(3L);
	
	private Long value;
	
	InfoAnuncioFormOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
