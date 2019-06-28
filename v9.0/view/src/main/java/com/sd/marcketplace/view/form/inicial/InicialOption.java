package com.sd.marcketplace.view.form.inicial;

public enum InicialOption {
	NONE(0L),
	LOGIN(1L),
	REGISTRAR(2L),
	SAIR(3L);
	
	private Long value;
	
	InicialOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
