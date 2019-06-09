package com.sd.marcketplace.controller.comum.enumerate;

public enum Status {

	WAIT(0L),
	READY(1L),
	NOTIFY_ALL(2L),
	NOTIFY_VISAO(3L),
	NOTIFY_CONTROLE(4L);
	
	private Long value;
	
	Status(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
	
}
