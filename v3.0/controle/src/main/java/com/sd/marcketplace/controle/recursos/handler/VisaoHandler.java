package com.sd.marcketplace.controle.recursos.handler;

import org.jgroups.Address;
import org.jgroups.Message;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.objeto.SendObject;

public class VisaoHandler extends BasicoHandler {
	
	protected Address dest;
	
	@Override
	public Object handle(Message msg) throws Exception {
		System.out.println("[CONTROLE (VisaoChannel)] received message: ".concat(msg.toString()));
		return trataMensagem(msg);
	}
	
	private Object trataMensagem(Message msg) throws Exception {
		System.out.println("[CONTROLE (VisaoChannel)] tratando message: ".concat(msg.toString()));
		return trataAcao(msg);
	}
	
	private Object trataAcao(Message msg) throws Exception {
		System.out.println("[CONTROLE (VisaoChannel)] tratando acao : ".concat(msg.toString()));
		System.out.println("[CONTROLE (VisaoChannel)] conteudo : ".concat(msg.getBuffer().toString()));
		System.out.println("[CONTROLE (VisaoChannel)] conteudo : ".concat(msg.getObject().toString()));
		if(((SendObject) msg.getObject()).getAcao().equals(Action.GET_ONE)) {
			return trataEntidade(msg);
		}
		return msg;
	}
	
	private Object trataEntidade(Message msg) throws Exception {
		System.out.println("[CONTROLE (VisaoChannel)] tratando entidade : ".concat(msg.toString()));
		SendObject sendObj = (SendObject) msg.getObject();
		if(sendObj.getEntidade().equals(Entidade.COORDENADOR)) {			
			sendObj.setContent(this.dest);
			msg.setObject(sendObj);
			System.out.println("[CONTROLE (VisaoChannel)] Retornando : ".concat(sendObj.toString()));
			return msg;
		}
		return msg;
	}
	
}
