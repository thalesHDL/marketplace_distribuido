package com.sd.marcketplace.controller.server.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;

public class BaseManager extends ReceiverAdapter implements RequestHandler {
	
	protected JChannel controllerChannel;
	protected JChannel modelChannel;
	protected MessageDispatcher controllerDispatcher;
	protected MessageDispatcher modelDispatcher;
	
	protected List<Address> clusterModel;
	
	protected Random rand = new Random();
	
	protected BaseManager() {
		// Empty constructor
	}
	
	protected void initVariaveis() {
		clusterModel = new ArrayList<Address>();
	}

	@Override
	public Object handle(Message msg) throws Exception {
		// method that will be override
		return null;
	}
	
	@Override
	public void viewAccepted(View view) {
		// method that will be override
    }
	
	protected void sleep(int time) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(time);
	}

}
