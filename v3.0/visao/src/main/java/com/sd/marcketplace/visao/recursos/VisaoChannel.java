package com.sd.marcketplace.visao.recursos;


import com.sd.marcketplace.visao.entidades.Usuario;
import com.sd.marcketplace.visao.io.Login;
import com.sd.marcketplace.visao.recursos.servico.VisaoServico;

public class VisaoChannel extends VisaoServico {
	
	private Usuario usuario;
	private Login login;
	
	public VisaoChannel() {
		this.usuario = null;
		this.login = new Login();
	}
	
	
	@Override
	protected void eventLoop() throws Exception {
		System.out.println("eventLoop CORRETO");
		this.logar();
	}
	
	private void logar() throws Exception {
		if(this.usuario == null || this.usuario.getId() == null) {
			this.usuario = this.getUsuarioByFilter(this.login.doLogin());
		}
	}
	

}
