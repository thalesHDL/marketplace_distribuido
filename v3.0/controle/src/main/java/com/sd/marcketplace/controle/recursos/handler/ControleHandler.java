package com.sd.marcketplace.controle.recursos.handler;

import org.jgroups.Message;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.enumerate.Status;
import com.sd.marcketplace.controle.comum.objeto.SendObject;

public class ControleHandler extends BasicoHandler {
	
	@Override
	public Object handle(Message msg) throws Exception {
		System.out.println("[CONTROLE (ControleChannel)] received message: ".concat(msg.toString()));
		return trataMensagem(msg);
	}
	
	private Object trataMensagem(Message msg) throws Exception {
		SendObject receive = (SendObject) msg.getObject();
		return trataAcao(receive);
	}
	
	private Object trataAcao(SendObject sendObj) throws Exception {
		if(sendObj.getAcao().equals(Action.GET_BY_FILTER)) {
			return trataEntidade(sendObj);
		}
		return sendObj;
	}
	
	private Object trataEntidade(SendObject sendObj) throws Exception {
		if(sendObj.getEntidade().equals(Entidade.USUARIO)) {
			return getUsuarioByFilter(sendObj);
		}
		return sendObj;
	}
	
	private Object getUsuarioByFilter(SendObject sendObj) throws Exception {
		this.aguarda();
		this.sharedObj.setObj(sendObj);
		this.sharedObj.setStatus(Status.NOTIFY_MODELO);
		while(true) {
			if(this.sharedObj.getStatus().equals(Status.NOTIFY_CONTROLE)) {
				SendObject newSendObj = new SendObject(this.sharedObj.getObj());
				return newSendObj;
			}
			sleep(10);
		}
	}
	
}
