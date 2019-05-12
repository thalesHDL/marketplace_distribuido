package com.sistemas.distribuidos.marcketplace.util.enumerate;

public enum StatusAction {

	SUCCESS(1),
	ERROR_DEFAULT(-1);

	private int status;

	StatusAction(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	
}