package com.sd.marcketplace.controller.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.blocks.ResponseMode;

import com.sd.marcketplace.controller.server.receiver.ModelReceiver;

import comum.util.HeaderUtil;
import comum.util.Util;
import comum.util.cluster.Constantes;
import comum.util.cluster.Opcoes;
import comum.util.cluster.StackProtocolUtil;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;

public class ControllerManager extends ModelReceiver {
	
	private boolean isConnected = false;
	
	protected ControllerManager() {
		// Empty constructor
	}
	
	protected void initChannelController() {
		try {
			controllerChannel = new JChannel(false);
			controllerChannel.setProtocolStack(StackProtocolUtil.protocolController());
			controllerChannel.getProtocolStack().init();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void initControllerMembershipListner() {
		controllerDispatcher.setMembershipListener(this);
	}
	
	protected void connectController() {
		try {
			controllerChannel.connect(Constantes.CHANNEL_NAME_CONTROLLER);
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void desconnectController() {
		controllerChannel.close();
	}
	
	
	
	@Override
	public void viewAccepted(View view) {
		Util.print(view.toString());
		if (view.compareTo(controllerChannel.getView()) == Constantes.VIEW_COMPARE_TO_EQUALS) {
			membershipListenerController(view);
		} else {
			membershipListenerModel(view);
		}
    }
	
	protected void membershipListenerController(View view) {
		Util.print(view.toString());
		if (!isConnected) {
			sendCurrentAddressToAll();
			isConnected = true;
		}
	}
	
	protected void sendCurrentAddressToAll() {
		List<Address> content = new ArrayList<Address>();
		content.add(controllerChannel.getAddress());
		
		Pacote pacote = new Pacote(Operation.PUT, Entidade.CLUSTER_CONTROLE, Classe.VISAO, content);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_NONE, false, controllerChannel.getAddress());
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			controllerDispatcher.castMessageWithFuture(null, mensagem, op.getOptions());
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
}
