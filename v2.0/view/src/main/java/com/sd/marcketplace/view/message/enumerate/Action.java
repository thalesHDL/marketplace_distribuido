package com.sd.marcketplace.view.message.enumerate;

public enum Action {
	
	NONE(0L),
	POST(1L),
	PUT(2L),
	GET(3L);
	
	private Long value;
	
	Action(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
