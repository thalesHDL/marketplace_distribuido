package com.sd.marcketplace.view.form.InfoAnuncio;

public enum InfoAnuncioFormOption {
	NONE(0L),
	INFO(1L),
	LISTAR_COMENTARIOS(2L),
	COMENTAR(3L),
	COMPRAR(4L),
	VOLTAR(5L);
	
	private Long value;
	
	InfoAnuncioFormOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
