package com.sd.marcketplace.view.server.manager;

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

import comum.domain.Usuario;

public class BaseManager extends ReceiverAdapter implements RequestHandler {
	
	protected JChannel viewChannel;
	protected JChannel controllerChannel;
	protected MessageDispatcher viewDispatcher;
	protected MessageDispatcher controllerDispatcher;
	
	protected List<Address> clusterController;
	protected Usuario usuario;
	
	protected Random rand = new Random();
	
	protected BaseManager() {
		// Empty constructor
	}
	
	protected void initVariaveis() {
		clusterController = new ArrayList<Address>();
		usuario = null;
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
	
	@Override
	public void suspect(Address mbr) {
		// method that will be override
    }
	
	protected void sleep(int time) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(time);
	}

}
