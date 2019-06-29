package com.sd.marcketplace.model.server.manager;

import java.util.HashMap;
import java.util.List;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.sd.marcketplace.model.persistencia.mapper.Mapper;
import com.sd.marcketplace.model.persistencia.repository.Repository;

import comum.domain.Usuario;
import comum.util.communication.Pacote;

public class BaseManager extends ReceiverAdapter implements RequestHandler {
	
	@Autowired
	protected Repository repository;
	@Autowired
	protected Mapper mapper;
	
	protected JChannel modelChannel;
	protected MessageDispatcher modelDispatcher;
	
	protected List<Usuario> usuariosLogados;
	protected HashMap<String, Pacote> operationQueue = new HashMap<String, Pacote>();
	
	protected BaseManager() {
		// Empty constructor
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
	
	protected Pacote getOperation(String identifier) {
		return operationQueue.get(identifier);
	}
	
	protected void addOperation(String identifier, Pacote operacao) {
		if (identifier != null) {
			operationQueue.put(identifier, operacao);
		}
	}
	
	protected void removeOperation(String identifier) {
		operationQueue.remove(identifier);
	}

}
