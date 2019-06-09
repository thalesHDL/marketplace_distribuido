package com.sd.marcketplace.visao.recursos.handler;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

import com.sd.marcketplace.visao.comum.enumerate.Action;
import com.sd.marcketplace.visao.comum.enumerate.Entidade;
import com.sd.marcketplace.visao.comum.objeto.SendObject;

public class BasicoHandler implements RequestHandler {
	
	private static final String CANAL_VISAO = "VisaoChannel";
	
	private MessageDispatcher despachante;
	protected Address coord;
	protected JChannel channel;
	
	public BasicoHandler() {
		// Empty constructor
	}
	
	public void initChannel() throws Exception {
		System.out.println("[VISAO] initChannel");
		this.channel = new JChannel();
		
		this.initHandler(this.channel);
		
		this.channel.connect(CANAL_VISAO);
		System.out.println("Integrantes: ".concat(this.channel.getView().getMembers().toString()));
		this.getDest();
		this.eventLoop();
		this.channel.close();
	}
	
	public void initHandler(JChannel canal) throws Exception {
		System.out.println("[VISAO] initHandler");
		this.despachante = new MessageDispatcher(canal, this);
	}

	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return msg;
	}
	
	protected void eventLoop() throws Exception {
		System.out.println("eventLoop ERRADO");
		// Do nothing
	}
	

	
	
	protected RspList enviaMultcast(SendObject obj) throws Exception {				
		Message message = new Message(null, obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
        
        RspList result = this.despachante.castMessage(null, message, opcoes);
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
		this.getDest();
		
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
	
	protected void sleep(int t) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(t);
	}

	
	
	private void getDest() throws Exception {
		System.out.println("[VISAO] getDest");
		System.out.println("### Iniciando processor de pegar o coordenador do cluster ###");
		if (this.coord == null) {
			System.out.println("### Este canal não possui um coordenador ###");
			this.sleep(10000);
			if (this.channel.getView().getMembers().size() > 1) {
				System.out.println("### Enviando messagem para os otros membros atras de um coordenador ###");
				SendObject obj = new SendObject();
				obj.setAcao(Action.GET_ONE);
				obj.setEntidade(Entidade.COORDENADOR);
				System.out.println("Criou sendObj: ".concat(obj.toString()));
								
		        RspList result = this.enviaMultcast(obj); 
		        System.out.println("results: ".concat(result.getResults().toString()));
				System.out.println("[VISAO (VisaoChannel)] coordenador: ".concat(result.toString()));
				System.out.println("[VISAO (VisaoChannel)] address: ".concat(this.channel.getAddress().toString()));
				System.out.println("");
				System.out.println("");
				System.out.println("");
//				this.coord = (Address) result;
				System.out.println("[VISAO (VisaoChannel)] this.coord: ".concat(this.coord.toString()));
				this.getDest();
			}
			System.out.println("### Este canal não possui outros membros ###");
			this.getDest();
		}
		System.out.println("### O coordenador foi identificado ###");
		System.out.println("[VisaoChannel] COORDENADOR: ".concat(this.coord.toString()));
	}
	
}
