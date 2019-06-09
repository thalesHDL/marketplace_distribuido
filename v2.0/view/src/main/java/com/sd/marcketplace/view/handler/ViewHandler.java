package com.sd.marcketplace.view.handler;

import org.jgroups.Message;
import org.jgroups.blocks.RequestHandler;


public class ViewHandler implements RequestHandler {
	
	public Object handle(Message msg) throws Exception {
		System.out.println("[VIEW] handle message: " + "("+ msg.getSrc() + ") - " + msg.getObject());
		return true;
	}

}
