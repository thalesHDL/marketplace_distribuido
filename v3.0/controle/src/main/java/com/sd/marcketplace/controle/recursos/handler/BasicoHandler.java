package com.sd.marcketplace.controle.recursos.handler;

import java.util.Collection;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

import com.sd.marcketplace.controle.comum.enumerate.Status;
import com.sd.marcketplace.controle.comum.objeto.SendObject;
import com.sd.marcketplace.controle.comum.objeto.SharedObject;


public class BasicoHandler implements RequestHandler {
	
	private MessageDispatcher despachante;
	protected SharedObject sharedObj;
	protected JChannel channel;
	
	public BasicoHandler() {
		// Empty constructor
	}
	
	public void initHandler(JChannel canal) {
		this.despachante = new MessageDispatcher(canal, this);
	}

	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return msg;
	}
	
	protected RspList enviaMultcast(SendObject obj) throws Exception {
		Collection<Address> cluster = null;
		
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
        
        RspList result = this.despachante.castMessage(cluster, message, opcoes);
		return result;
	}
	
	protected RspList enviaAnycast(Collection<Address> grupo, SendObject obj) throws Exception {		
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_MAJORITY);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
		return result;
	}
	
	protected RspList enviaAnycast(SendObject obj) throws Exception {	
		Collection<Address> grupo = this.despachante.getChannel().getView().getMembers();
		
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_MAJORITY);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
		return result;
	}
	
	protected Object enviaUnicast(Address endereco, SendObject obj) throws Exception {
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        
        Object result = this.despachante.sendMessage(message, opcoes);
		return result;
	}
	
	
	
	protected void aguarda() throws Exception {
		while(true) {
			if (this.sharedObj.getStatus().equals(Status.READY)) {
				break;
			}
			sleep(10);
		}
		sleep(100);
		if (!this.sharedObj.getStatus().equals(Status.READY)) {
			this.aguarda();
		}
	}
	
	protected void sleep(int t) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(t);
	}

}
