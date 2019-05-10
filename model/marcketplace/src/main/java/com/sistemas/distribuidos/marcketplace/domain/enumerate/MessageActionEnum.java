package com.sistemas.distribuidos.marcketplace.domain.enumerate;

public enum MessageActionEnum {

	CREATE(1),
	UPDATE(2),
	DELETE(3),
	GET_ONE(4),
	GET_ALL(5);

	private int action;

	MessageActionEnum(int action) {
		this.action = action;
	}

	public int getAction() {
		return this.action;
	}

}