package com.sd.marcketplace.view.channel.service;

import org.jgroups.util.RspList;

import com.sd.marcketplace.view.channel.resource.ControllerResource;
import com.sd.marcketplace.view.comum.enumerate.Status;
import com.sd.marcketplace.view.comum.objeto.SendObject;

// ONDE IMPLEMENTO AS FUNCOES DE ENVIAR MENSAGEM
public class ControllerService extends ControllerResource {
	
	public void postUsuario() throws Exception {
		print("-ControllerService- postUsuario");
		RspList result = enviaAnycast(this.share.getObj());
		SendObject obj = this.share.getObj();
		obj.setContent(result.getFirst());
		this.share.setCanUse(true);
		this.share.setObj(obj);
		this.share.setStatus(Status.NOTIFY_VISAO);
		print("Resultado postUsuario: ".concat(result.getResults().toString()));
	}
	
}
