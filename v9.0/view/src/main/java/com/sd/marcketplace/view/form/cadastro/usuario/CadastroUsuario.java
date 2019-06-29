package com.sd.marcketplace.view.form.cadastro.usuario;

import java.math.BigDecimal;

import com.sd.marcketplace.view.form.BaseMenu;

import comum.domain.Usuario;

public class CadastroUsuario extends BaseMenu<CadastroUsuarioOption>  {
	
	@SuppressWarnings("unchecked")
	public CadastroUsuario() throws ClassNotFoundException {
		super((Class<CadastroUsuarioOption>) Class.forName(CadastroUsuarioOption.class.getName()));
	}
	
	public Usuario getDadosUsuario() {		
		System.out.println("Informa os dados do Usuario");
		
		// TODO: colocar mais dados
		
		System.out.print("E-mail: ");
		String email = this.input.nextLine();
		
		System.out.print("Senha: ");
		String senha = this.input.nextLine();
		Usuario usuario = new Usuario(email, senha);
		usuario.setNome("teste");
		usuario.setSaldo(BigDecimal.valueOf(1000));
		return usuario;
	}
	
	
}
