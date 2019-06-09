package com.sd.marcketplace.modelo.comum.enumerate;

public enum Entidade {
	
	NONE(0L),
	USUARIO(1L);
	
	private Long value;
	
	Entidade(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}

}
