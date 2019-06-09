package com.sd.marcketplace.controller.comum.enumerate;

public enum Action {
	
	NONE(0L),
	POST(1L),
	PUT(2L),
	GET_ONE(3L),
	GET_ALL(4L),
	GET_BY_FILTER(5L);
	
	private Long value;
	
	Action(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
