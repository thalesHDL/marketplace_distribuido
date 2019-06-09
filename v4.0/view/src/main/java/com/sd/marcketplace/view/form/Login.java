package com.sd.marcketplace.view.form;

import java.util.Scanner;

import com.sd.marcketplace.view.entidades.Usuario;

public class Login {
	
	private static final Long REGISTRAR = 1L;
	private static final Long LOGAR = 2L;
	
	private static final String INFO = "Informe o e-mail e a senha.";
	private static final String EMAIL = "E-mail: ";
	private static final String SENHA = "Senha: ";
	private static final String LOGIN = "Logar (".concat(LOGAR.toString()).concat(")\nRegistrar (").concat(REGISTRAR.toString()).concat(")\nEscolha: ");
	
	private Scanner input;
	private Usuario usuario;
	
	
	public Login() {
		this.usuario = new Usuario();
	}
	
	public Usuario doLogin() {
		this.input = new Scanner(System.in);
		
		System.out.print(LOGIN);
		Long escolha = Long.valueOf(this.input.next());
		
		if (escolha.equals(REGISTRAR)) {
			this.getRegistro();
		}
		if (escolha.equals(LOGAR)) {
			this.getLogin();
		}
		this.input.close();

		return this.usuario;
	}
	
	public Usuario getLogin() {
		System.out.println(INFO);
		System.out.print(EMAIL);
		this.usuario.setEmail(this.input.next());
		System.out.print(SENHA);
		this.usuario.setSenha(this.input.next());
		return this.usuario;
	}
	
	public Usuario getRegistro() {
		return null;
	}

}
