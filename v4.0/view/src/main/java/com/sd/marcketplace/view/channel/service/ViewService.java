package com.sd.marcketplace.view.channel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.jgroups.Address;
import org.jgroups.util.RspList;

import com.sd.marcketplace.view.channel.ControllerChannel;
import com.sd.marcketplace.view.channel.resource.ViewResource;
import com.sd.marcketplace.view.comum.enumerate.Action;
import com.sd.marcketplace.view.comum.enumerate.Entidade;
import com.sd.marcketplace.view.comum.enumerate.Status;
import com.sd.marcketplace.view.comum.objeto.SendObject;
import com.sd.marcketplace.view.entidades.Usuario;

// ONDE IMPLEMENTO AS FUNCOES DE ENVIAR MENSAGEM
public class ViewService extends ViewResource {
	
	protected List<Address> getAllController() throws Exception {
		print("-ViewService- getAllMvc");
		SendObject obj = new SendObject(Action.GET_ALL, Entidade.CONTROLLER, null);
		RspList result = enviaMultcast(obj);
		return (List<Address>) getElementMajority(result);
	}

	protected void registerController() throws Exception {
		print("-ViewService- registerMvc");
		this.clusterController.add(this.channel.getAddress());
		SendObject obj = new SendObject(Action.POST, Entidade.CONTROLLER, this.clusterController);
		RspList result = enviaMultcast(obj);
		new ControllerChannel().startChannel(this.share);
		print("Resultado registerMvc: ".concat(result.getResults().toString()));
	}
	
	protected Usuario getUsuarioByFilter(Usuario usuario) {
		return null; // TODO
	}
	
	protected Usuario postUsuario(Usuario usuario) throws Exception {
		SendObject obj = new SendObject(Action.POST, Entidade.USUARIO, usuario);
		if (this.clusterController.contains(this.channel.getAddress())) {
			this.share.setObj(obj);
			this.share.setStatus(Status.NOTIFY_CONTROLE);
			this.share.setCanUse(false);
			while(true) {
				if (this.share.getStatus().equals(Status.NOTIFY_VISAO)) {
					break;
				}
				sleep(100);
			}
			this.share.setStatus(Status.READY);
			return (Usuario) this.share.getObj().getContent();
		} else {
			RspList result = enviaAnycastFirst(this.clusterController, obj);
			return (Usuario) result.getFirst();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private Object getElementMajority(RspList result) throws Exception {
		List<?> elements = result.getResults();
		if (elements.isEmpty()) {
			return result.getResults();
		}
		
		HashMap<Object, Long> temp = new HashMap<Object, Long>();
		for (Object e : elements) {
			Long j = temp.get(e);
			temp.put(e,(j==null ? 1 : j+1));
		}
				
		Set<Object> keyList = temp.keySet();
		Long maior = -1L;
		Object majority = null;
		for (Object key : keyList) {
			Long value = temp.get(key);
			if (value > maior) {
				maior = value;
				majority = key;
			}
		}
		
		return majority;
	}
}
