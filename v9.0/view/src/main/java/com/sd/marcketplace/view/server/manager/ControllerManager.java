package com.sd.marcketplace.view.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.blocks.ResponseMode;
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
public class ControllerManager extends BaseManager {
	
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

	
	
	protected void membershipListenerController(View view) {
		if (!isConnected) {
			initClusterController(view);
			isConnected = true; 
		}
	}
	
	protected void initClusterController(View view) {
		List<Address> membersNodeController = new ArrayList<Address>(getMembersNodeController());
		updateClusterController(membersNodeController);
		Util.print("Cluster: " + clusterController.toString() + "\n\n");
	}
	
	protected void updateClusterController(List<Address> list) {
		if (list.isEmpty() || clusterController.size() >= Constantes.MAX_CLUSTER_CONTROLE) {
			return;
		}
		if (clusterController.size() >= Constantes.MIN_CLUSTER_CONTROLE) {
			int sorteio = rand.nextInt(Constantes.SORTEIO_CLUSTER_RANGE);
			if (!(sorteio == Constantes.SORTEIO_CLUSTER_ADD)) {
				return;
			}
		}
		
		int index = rand.nextInt(list.size());
		Address addr = list.get(index);
		if (!clusterController.contains(addr)) {
			clusterController.add(addr);
		}
		list.remove(index);
		
		updateClusterController(list);
	}
	
	protected List<Address> getMembersNodeController() { 
		List<Address> membersNodeController = new ArrayList<Address>();
		
		List<Pacote> result = callGetMembersNodeController();
		for (Pacote pacote: result) {
			if (pacote.getHeader().getStatus().equals(Status.RECEBIDO)) {
				membersNodeController.add((Address) pacote.getContent());
			}
		}
		return membersNodeController;
	}
	
	protected List<Pacote> callGetMembersNodeController() {
		Pacote pacote = new Pacote(Operation.GET_ONE, Entidade.ADDRESS, Classe.CONTROLE, null);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_ALL, false, controllerChannel.getAddress());
		
		RspList<?> result = null;
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			result = controllerDispatcher.castMessage(null, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result.toString());
			return (List<Pacote>) result.getResults();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
			return new ArrayList<Pacote>();
		}
	}
	
	
	

	protected void controllerSuspect(Address addr) {
		if (clusterController.contains(addr)) {
			Util.print("\nSuspeito: " + addr.toString());
			clusterController.remove(addr);
			removeMemberClusterController(addr);
			Util.print("Cluster: " + clusterController.toString());
		}
	}
	
	protected void removeMemberClusterController(Address addr) {
		Pacote pacote = new Pacote(Operation.DELETE_ONE, Entidade.CLUSTER_CONTROLE, Classe.VISAO, addr);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_NONE, false, viewChannel.getAddress());
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			viewDispatcher.castMessageWithFuture(null, mensagem, op.getOptions());
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	
	
	protected Address sorteiaMemberClusterController() throws Exception {
		if (clusterController.isEmpty()) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
		int index = rand.nextInt(clusterController.size());
		return clusterController.get(index);
	}
}
