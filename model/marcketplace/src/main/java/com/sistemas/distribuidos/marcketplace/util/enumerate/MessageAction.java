package com.sistemas.distribuidos.marcketplace.util.enumerate;

public enum MessageAction {

	CREATE(1),
	UPDATE(2),
	DELETE(3),
	GET_ONE(4),
	GET_ALL(5);

	private int action;

	MessageAction(int action) {
		this.action = action;
	}

	public int getAction() {
		return this.action;
	}

}