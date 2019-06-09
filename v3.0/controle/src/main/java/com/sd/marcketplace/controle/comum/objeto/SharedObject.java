package com.sd.marcketplace.controle.comum.objeto;

import com.sd.marcketplace.controle.comum.enumerate.Status;

public class SharedObject {
	
	private Status status;
	private SendObject obj;
		
	public SharedObject() {
		this.status = Status.READY;
	}

	
	public void setContentObject(Object obj) {
		this.obj.setContent(obj);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SendObject getObj() {
		return obj;
	}

	public void setObj(SendObject obj) {
		this.obj = obj;
	}

	
	@Override
	public String toString() {
		return "SharedObject [status=" + status + ", obj=" + obj + "]";
	}
}
