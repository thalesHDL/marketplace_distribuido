package com.sd.marcketplace.view.form.login;

public enum LoginOption {
	NONE(0L),
	CONECTAR(1L),
	VOLTAR(2L);
	
	private Long value;
	
	LoginOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
