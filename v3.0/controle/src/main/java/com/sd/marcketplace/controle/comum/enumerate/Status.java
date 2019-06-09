package com.sd.marcketplace.controle.comum.enumerate;

public enum Status {

	WAIT(0L),
	READY(1L),
	NOTIFY_ALL(2L),
	NOTIFY_CONTROLE(3L),
	NOTIFY_MODELO(4L),
	NOTIFY_VISAO(5L);
	
	private Long value;
	
	Status(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
	
}
