package com.sd.marcketplace.controller.channel.resource;

import java.util.List;

import org.jgroups.Address;
import org.jgroups.Message;

import com.sd.marcketplace.controller.comum.enumerate.Action;
import com.sd.marcketplace.controller.comum.enumerate.Entidade;
import com.sd.marcketplace.controller.comum.objeto.SendObject;
import com.sd.marcketplace.controller.comum.objeto.SharedObject;
import com.sd.marcketplace.controller.entidades.Usuario;



// ONDE SE RECEBE AS MENSAGENS
public class ControllerResource extends Resource {
	
	protected static final String CONTROLLER_CHANNEL = "ControllerChannel";	
	protected SharedObject share;

	
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
//			return getAllMvc(obj);
		}
		return obj;
	}
	
	public Object trataPost(SendObject obj) throws Exception {
		if (obj.getEntidade().equals(Entidade.CONTROLLER)) {
			print("-ViewResource- trataPost: ".concat(Entidade.CONTROLLER.toString()));
//			return postMvc(obj);
		}
		if (obj.getEntidade().equals(Entidade.USUARIO)) {
			print("-ViewResource- trataPost: ".concat(Entidade.USUARIO.toString()));
			return postUsuario(obj);
		}
		return obj;
	}
	
	public Object postUsuario(SendObject obj) throws Exception {
		// TODO
		Usuario usuario = (Usuario) obj.getContent();
		usuario.setId(10L);
		return usuario;
	}
	
}
