package com.sd.marcketplace.view.form.login;

import com.sd.marcketplace.view.form.BaseMenu;

import comum.domain.Usuario;

public class Login extends BaseMenu<LoginOption>  {
	
	@SuppressWarnings("unchecked")
	public Login() throws ClassNotFoundException {
		super((Class<LoginOption>) Class.forName(LoginOption.class.getName()));
	}
	
	public Usuario getDadosUsuario() {		
		System.out.println("Informa os dados do Usuario");
		
		System.out.print("E-mail: ");
		String email = this.input.nextLine();
		
		System.out.print("Senha: ");
		String senha = this.input.nextLine();
		
		return new Usuario(email, senha);
	}
	
	
}
