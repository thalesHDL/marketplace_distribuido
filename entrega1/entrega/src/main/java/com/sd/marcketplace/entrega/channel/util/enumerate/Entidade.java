package com.sd.marcketplace.entrega.channel.util.enumerate;

public enum Entidade {
	
	NONE(0L),
	COORDENADOR(1L),
	USUARIO(2L),
	
	VIEW(3L),
	CONTROLLER(4L),
	MODEL(5L);
	
	private Long value;
	
	Entidade(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}

}
