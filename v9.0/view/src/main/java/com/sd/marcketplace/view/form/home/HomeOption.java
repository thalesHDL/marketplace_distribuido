package com.sd.marcketplace.view.form.home;

public enum HomeOption {
	NONE(0L),
	PRODUTOS(1L),
	VENDAS(2L),
	PERFIL(3L),
	SALDO(4L),
	DESCONECTAR(5L);
	
	private Long value;
	
	HomeOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
