package com.sistemas.distribuidos.marcketplace.domain;

public class MessageMarcketplace {

	private int action;
	private Object content;


	public MessageMarcketplace() {
		// Empty constructor
	}

	
	public int getAction() {
		return this.action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}


}