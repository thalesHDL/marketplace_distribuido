package com.sd.marcketplace.view.receiver;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class ViewReceiver extends ReceiverAdapter {
	
	@Override
	public void receive(Message msg) {
		System.out.println("[VIEW] receive message: " + "(" + msg.getSrc() + ") - " + msg.getObject());
	}
	
	@Override
	public void viewAccepted(View view) {
		System.out.println("[VIEW] nova View do cluster: " + view);
	}
	
}
