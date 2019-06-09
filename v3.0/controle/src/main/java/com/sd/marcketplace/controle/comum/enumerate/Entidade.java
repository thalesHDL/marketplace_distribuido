package com.sd.marcketplace.controle.comum.enumerate;

public enum Entidade {
	
	NONE(-1L),
	COORDENADOR(0L),
	USUARIO(1L);
	
	private Long value;
	
	Entidade(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
