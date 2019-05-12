package com.sistemas.distribuidos.marcketplace.config.message;


public class MessageMarcketplace {

	// atributes
	private int action;
	private Object content;

	// constructors
	public MessageMarcketplace() {
		// Empty constructor
	}

	// gets
	public int getAction() {
		return this.action;
	}
	public Object getContent() {
		return this.content;
	}

	// sets
	public void setAction(int action) {
		this.action = action;
	}
	public void setContent(Object content) {
		this.content = content;
	}


}