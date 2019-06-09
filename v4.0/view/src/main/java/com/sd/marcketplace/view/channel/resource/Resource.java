package com.sd.marcketplace.view.channel.resource;

import java.util.Collection;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

public class Resource extends ReceiverAdapter implements RequestHandler {
		
	private MessageDispatcher despachante;
	protected JChannel channel;
	
	public Resource() {
		// Empty constructor
	}
	
	protected void initChannel(String channel) throws Exception {
		this.channel = new JChannel();
		this.initHandler(this.channel);
		this.channel.connect(channel);
		this.channel.setReceiver(this);
		this.eventLoop();
		this.channel.close();
	}
	
	private void initHandler(JChannel canal) throws Exception {
		this.despachante = new MessageDispatcher(canal, this);
	}
	
	protected void eventLoop() throws Exception {
		// Do nothing
	}
	
	
	
	public void viewAccepted(View view) {
		// do nothing
    }
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return msg;
	}
	
	
	
	protected RspList enviaMultcast(Object obj) throws Exception {	
		System.out.println("ENVIANDO MULTICAST: ".concat(obj.toString()));
		Message message = new Message(null, obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
        
        RspList result = this.despachante.castMessage(null, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	protected RspList enviaMultcastFirst(Object obj) throws Exception {	
		System.out.println("ENVIANDO MULTICAST FIRST: ".concat(obj.toString()));
		Message message = new Message(null, obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        opcoes.setAnycasting(false);
        
        RspList result = this.despachante.castMessage(null, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	
	protected RspList enviaAnycast(Collection<Address> grupo, Object obj) throws Exception {	
		System.out.println("ENVIANDO ANYCAST: ".concat(obj.toString()));
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_MAJORITY);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	protected RspList enviaAnycastFirst(Collection<Address> grupo, Object obj) throws Exception {	
		System.out.println("ENVIANDO ANYCAST: ".concat(obj.toString()));
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	protected RspList enviaAnycast(Object obj) throws Exception {	
		System.out.println("ENVIANDO ANYCAST: ".concat(obj.toString()));
		Collection<Address> grupo = this.channel.getView().getMembers();
		
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_MAJORITY);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	protected RspList enviaAnycastFirst(Object obj) throws Exception {	
		System.out.println("ENVIANDO ANYCAST: ".concat(obj.toString()));
		Collection<Address> grupo = this.channel.getView().getMembers();
		
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        opcoes.setAnycasting(true);
        
        RspList result = this.despachante.castMessage(grupo, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	
	protected RspList enviaUnicast(Address endereco, Object obj) throws Exception {	
		System.out.println("ENVIANDO UNICAST: ".concat(obj.toString()));
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        
        RspList result = this.despachante.sendMessage(message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	
	protected void sleep(int t) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(t);
	}
	
	protected String sourceToString() {
		return this.channel.getAddressAsString();
	}
	
	protected void print(String msg) {
		System.out.println(" [".concat(sourceToString()).concat("] (View) ").concat(msg));
	}
	
}
