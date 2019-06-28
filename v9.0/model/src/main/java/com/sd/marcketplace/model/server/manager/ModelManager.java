package com.sd.marcketplace.model.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.blocks.ResponseMode;

import comum.util.HeaderUtil;
import comum.util.Util;
import comum.util.cluster.Constantes;
import comum.util.cluster.Opcoes;
import comum.util.cluster.StackProtocolUtil;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;

public class ModelManager extends BaseManager {
	
	private boolean isConnected = false;
	
	protected ModelManager() {
		// Empty constructor
	}
	
	protected void initChannelModel() {
		try {
			modelChannel = new JChannel(false);
			modelChannel.setProtocolStack(StackProtocolUtil.protocolModel());
			modelChannel.getProtocolStack().init();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void initModelMembershipListner() {
		modelDispatcher.setMembershipListener(this);
	}
	
	protected void connectModel() {
		try {
			modelChannel.connect(Constantes.CHANNEL_NAME_MODEL);
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void desconnectModel() {
		modelChannel.close();
	}
	
	@Override
	public void viewAccepted(View view) {
		Util.print(view.toString());
		if (!isConnected) {
			sendCurrentAddressToAll();
			isConnected = true;
		}
    }
	
	protected void sendCurrentAddressToAll() {
		List<Address> content = new ArrayList<Address>();
		content.add(modelChannel.getAddress());
		
		Pacote pacote = new Pacote(Operation.PUT, Entidade.CLUSTER_MODELO, Classe.CONTROLE, content);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_NONE, false, modelChannel.getAddress());
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			modelDispatcher.castMessageWithFuture(null, mensagem, op.getOptions());
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}

}
