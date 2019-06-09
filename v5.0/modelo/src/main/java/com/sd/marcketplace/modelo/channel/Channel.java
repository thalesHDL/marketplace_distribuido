package com.sd.marcketplace.modelo.channel;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

public class Channel extends ReceiverAdapter implements RequestHandler {
	
	private static final String VISAO_CHANNEL = "VisaoChannel";
	
	private JChannel channelVisao;
	private JChannel channelControle;
	
	private MessageDispatcher dispatcherVisao;
	private MessageDispatcher dispatcherControle;
	
	private List<Address> clusterVisaoControle;
	
	public Channel() {
		// Empty constructor
	}
	
	public void init() throws Exception {
		this.clusterVisaoControle = new ArrayList<Address>();
		this.channelVisao = new JChannel();
		this.dispatcherVisao = new MessageDispatcher(this.channelVisao, null, null, this);
		this.channelVisao.connect(VISAO_CHANNEL);
		this.channelVisao.setReceiver(this);
		this.eventLoop();
		this.channelVisao.close();
	}
	
	private void eventLoop() throws Exception {
		while(true) {
			sleep(1000);
			
		}
	}
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	protected RspList enviaUnicast(Address endereco, Object obj, MessageDispatcher despachante) throws Exception {	
		System.out.println("ENVIANDO UNICAST: ".concat(obj.toString()));
		Message message = new Message();
		message.setObject(obj);
		
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_FIRST);
        
        RspList result = despachante.sendMessage(message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.toString()));
		return result;
	}
	protected void sleep(int t) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(t);
	}
	
}
