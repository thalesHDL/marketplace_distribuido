package com.sd.marcketplace.controller.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.blocks.locking.LockService;
import org.jgroups.util.RspList;

import comum.util.HeaderUtil;
import comum.util.Util;
import comum.util.cluster.Constantes;
import comum.util.cluster.Opcoes;
import comum.util.cluster.StackProtocolUtil;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;
import comum.util.communication.Status;

@SuppressWarnings("unchecked")
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
			lockService = new LockService(modelChannel);
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

	protected void membershipListenerModel(View view) {		
		if (!isConnected) {
			initClusterModel(view);
			isConnected = true; 
		}
		verifyClusterModel(view.getMembers());
	}
	
	protected void verifyClusterModel(List<Address> list) {
		List<Address> newMembers = new ArrayList<Address>(list);
		List<Address> oldMembers = new ArrayList<Address>(clusterModel);
		removeSimilarity(oldMembers, newMembers);
		
		if (!oldMembers.isEmpty()) {
			removeSuspects(oldMembers);
		}
	}
	
	protected void removeSuspects(List<Address> oldMembers) {
		if(oldMembers.isEmpty()) {
			return;
		}
		Address addr = oldMembers.get(0);
		clusterModel.remove(addr);
		oldMembers.remove(0);
		removeSuspects(oldMembers);
	}
	
	protected void removeSimilarity(List<Address> l1, List<Address> l2) {
		removeSimilarity(new ArrayList<Address>(l1), l1, l2);
	}
	
	protected void removeSimilarity(List<Address> controle, List<Address> l1, List<Address> l2) {
		if (controle.isEmpty()) {
			return;
		}
		
		Address addr = controle.get(0);
		if (l2.contains(addr)) {
			l2.remove(addr);
			l1.remove(addr);
		}
		controle.remove(0);
		removeSimilarity(controle, l1, l2);
	}
	
	protected void initClusterModel(View view) {
		List<Address> membersNodeModel = new ArrayList<Address>(getMembersNodeModel());
		updateClusterModel(membersNodeModel);
		Util.print("Cluster: " + clusterModel.toString() + "\n\n");
	}
	
	protected void updateClusterModel(List<Address> list) {
		if (list.isEmpty()) {
			return;
		}
		
		Address addr = list.get(0);
		if (!clusterModel.contains(addr)) {
			clusterModel.add(addr);
		}
		list.remove(0);
		
		updateClusterModel(list);
	}

	protected List<Address> getMembersNodeModel() { 
		List<Address> membersNodeModel = new ArrayList<Address>();
		
		List<Pacote> result = callGetMembersNodeModel();
		for (Pacote pacote: result) {
			if (pacote.getHeader().getStatus().equals(Status.RECEBIDO)) {
				membersNodeModel.add((Address) pacote.getContent());
			}
		}
		return membersNodeModel;
	}
	
	protected List<Pacote> callGetMembersNodeModel() {
		Pacote pacote = new Pacote(Operation.GET_ONE, Entidade.ADDRESS, Classe.MODELO, null);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_ALL, false, modelChannel.getAddress());
		
		RspList<?> result = null;
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			result = modelDispatcher.castMessage(null, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result.toString());
			return (List<Pacote>) result.getResults();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Pacote>();
		}
	}
	
}
