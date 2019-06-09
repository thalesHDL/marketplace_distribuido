package com.sd.marcketplace.modelo.channel;

import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

public class Verifica implements Runnable {
	
	private static final Long N_ELEMENTOS = 3L;
	
	
	private JChannel channelVisao;
	
	private MessageDispatcher dispatcherVisao;
	
	private List<Address> clusterVisaoControle;
	
	public Verifica(JChannel channelVisao, MessageDispatcher dispatcherVisao, List<Address> clusterVisaoControle) {
		this.channelVisao = channelVisao;
		this.dispatcherVisao = dispatcherVisao;
		this.clusterVisaoControle = clusterVisaoControle;
	}

	public void run() {
		try {
			verificaCluster();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void verificaCluster() throws Exception {
		for (Address a : clusterVisaoControle) {
			Message message = new Message();
			message.setObject("Teste");
			
			RequestOptions opcoes = new RequestOptions(); 
	        opcoes.setMode(ResponseMode.GET_FIRST);
	        
	        RspList result = dispatcherVisao.sendMessage(message, opcoes);
	        if (result.getResults().isEmpty()) {
	        	
	        }
		}
	}

}
