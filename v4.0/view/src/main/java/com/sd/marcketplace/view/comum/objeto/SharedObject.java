package com.sd.marcketplace.view.comum.objeto;

import com.sd.marcketplace.view.comum.enumerate.Status;

public class SharedObject {
	
	private Status status;
	private SendObject obj;
	private Boolean canUse;
		
	public SharedObject() {
		this.status = Status.READY;
		this.canUse = true;
	}

	
	public void setContentObject(Object obj) {
		this.obj.setContent(obj);
	}
	
	public Status getStatus() {
		return status;
	}

	public synchronized void setStatus(Status status) throws InterruptedException {
		aguardaLiberar();
		this.status = status;
	}

	public SendObject getObj() {
		return obj;
	}

	public synchronized void setObj(SendObject obj) throws InterruptedException {
		aguardaLiberar();
		this.obj = obj;
	}
	
	public Boolean getCanUse() {
		return canUse;
	}
	public synchronized void setCanUse(Boolean canUse) throws InterruptedException {
		aguardaLiberar();
		this.canUse = canUse;
	}

	
	private void aguardaLiberar() throws InterruptedException {
		while(true) {
			if (this.canUse) {
				break;
			}
			Thread.currentThread();
			Thread.sleep(1000);
		}
	}
	
	@Override
	public String toString() {
		return "SharedObject [status=" + status + ", obj=" + obj + "]";
	}
}
