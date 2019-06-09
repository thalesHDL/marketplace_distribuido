package com.sd.marcketplace.view.channel.resource;

import java.util.List;

import org.jgroups.Address;
import org.jgroups.Message;

import com.sd.marcketplace.view.comum.enumerate.Action;
import com.sd.marcketplace.view.comum.enumerate.Entidade;
import com.sd.marcketplace.view.comum.enumerate.Status;
import com.sd.marcketplace.view.comum.objeto.SendObject;
import com.sd.marcketplace.view.comum.objeto.SharedObject;
import com.sd.marcketplace.view.entidades.Usuario;

// ONDE SE RECEBE AS MENSAGENS
public class ViewResource extends Resource {

	protected static final String VIEW_CHANNEL = "ViewChannel";
	protected static final Long N_CONTROLLER = 2L;

	protected SharedObject share;
	protected Usuario user;
	protected List<Address> clusterController;

	@Override
	public Object handle(Message msg) throws Exception {
		print("-ViewResource- handle: ".concat(msg.toString()));
		return trataMessage(msg);
	}

	public Object trataMessage(Message msg) throws Exception {
		print("-ViewResource- trataMessage: ".concat(msg.getObject().toString()));
		if (msg.getSrc().equals(this.channel.getAddress())) {
			return null;
		}
		SendObject obj = (SendObject) msg.getObject();
		return trataAction(obj);
	}

	public Object trataAction(SendObject obj) throws Exception {
		if (obj.getAcao().equals(Action.POST)) {
			print("-ViewResource- trataAction: ".concat(Action.POST.toString()));
			return trataPost(obj);
		}
		if (obj.getAcao().equals(Action.GET_ALL)) {
			print("-ViewResource- trataAction: ".concat(Action.GET_ALL.toString()));
			return trataGetAll(obj);
		}
		return obj;
	}

	public Object trataGetAll(SendObject obj) throws Exception {
		if (obj.getEntidade().equals(Entidade.CONTROLLER)) {
			print("-ViewResource- trataGetAll: ".concat(Entidade.CONTROLLER.toString()));
			return getAllMvc(obj);
		}
		return obj;
	}

	public Object trataPost(SendObject obj) throws Exception {
		if (obj.getEntidade().equals(Entidade.CONTROLLER)) {
			print("-ViewResource- trataPost: ".concat(Entidade.CONTROLLER.toString()));
			return postMvc(obj);
		}
		if (obj.getEntidade().equals(Entidade.USUARIO)) {
			print("-ViewResource- trataPost: ".concat(Entidade.USUARIO.toString()));
			return postUsuario(obj);
		}
		return obj;
	}

	public Object getAllMvc(SendObject obj) throws Exception {
		if (obj.getContent() == null) {
			print("-ViewResource- getAllMvc: null");
		} else {
			print("-ViewResource- getAllMvc: ".concat(obj.getContent().toString()));
		}
		print("-ViewResource- getAllMvc retorno: ".concat(this.clusterController.toString()));
		return this.clusterController;
	}
	public Object postMvc(SendObject obj) throws Exception {
		print("-ViewResource- postMvc: ".concat(obj.getContent().toString()));
		List<Address> tempClusterMvc = (List<Address>) obj.getContent();
		if (!this.clusterController.equals(tempClusterMvc)) {
			this.clusterController = tempClusterMvc;
		}
		return tempClusterMvc;
	}


	
	
	public Object postUsuario(SendObject obj) throws Exception {
		this.share.setObj(obj);
		this.share.setStatus(Status.NOTIFY_CONTROLE);
		this.share.setCanUse(false);
		while (true) {
			if (this.share.getStatus().equals(Status.NOTIFY_VISAO)) {
				break;
			}
			sleep(100);
		}
		this.share.setStatus(Status.READY);
		return (Usuario) this.share.getObj().getContent();

	}

}
