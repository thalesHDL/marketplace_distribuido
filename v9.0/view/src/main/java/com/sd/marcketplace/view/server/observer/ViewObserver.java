package com.sd.marcketplace.view.server.observer;

import java.util.Scanner;

import com.sd.marcketplace.view.form.cadastro.usuario.CadastroUsuario;
import com.sd.marcketplace.view.form.cadastro.usuario.CadastroUsuarioOption;
import com.sd.marcketplace.view.form.home.Home;
import com.sd.marcketplace.view.form.home.HomeOption;
import com.sd.marcketplace.view.form.inicial.Inicial;
import com.sd.marcketplace.view.form.inicial.InicialOption;
import com.sd.marcketplace.view.form.login.Login;
import com.sd.marcketplace.view.form.login.LoginOption;
import com.sd.marcketplace.view.server.service.ViewService;

public class ViewObserver extends ViewService {
	
	protected void loopView() {
		try {
			view();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	private void view() throws Exception {
		pageInicial(new Scanner(System.in));
	}
	
	private void pageInicial(Scanner input) throws Exception {
		Inicial inicial = new Inicial();
		InicialOption escolha = InicialOption.NONE;
		
		while(true) {
			escolha = inicial.start(input);
			if (escolha.equals(InicialOption.LOGIN)) {
				pageLogin(input);
			} else if (escolha.equals(InicialOption.REGISTRAR)) {
				pageCadastroUsuario(input);
			} else if (escolha.equals(InicialOption.SAIR)) {
				return;
			}
		}
	}
	
	private void pageCadastroUsuario(Scanner input) throws Exception {
		CadastroUsuario cadastroUsuario = new CadastroUsuario();
		CadastroUsuarioOption escolha = CadastroUsuarioOption.NONE;
		
		while(true) {
			escolha = cadastroUsuario.start(input);
			if (escolha.equals(CadastroUsuarioOption.CADASTRAR)) {
				usuario = viewPostUsuario(cadastroUsuario.getDadosUsuario());
			} else if (escolha.equals(CadastroUsuarioOption.VOLTAR)) {
				return;
			}
		}
	}
	
	private void pageLogin(Scanner input) throws Exception {
		Login login = new Login();
		LoginOption escolha = LoginOption.NONE;
		
		while(true) {
			escolha = login.start(input);
			
			if (escolha.equals(LoginOption.CONECTAR)) {
				usuario = login.getDadosUsuario();
				pageHome(input);
				// TODO: verificar se o usuario esta cadastrado
				//   se estiver mudar para a pageHome
				//   se nao invormar que o usuario n esta correto e mostrar novamente o menu
			} else if (escolha.equals(LoginOption.VOLTAR)) {
				return;
			}
		}
	}
	
	private void pageHome(Scanner input) throws Exception {
		Home home = new Home();
		HomeOption escolha = HomeOption.NONE;
		
		while(true) {
			escolha = home.start(input);
			
			if (escolha.equals(HomeOption.PRODUTOS)) {
				// TODO: call page produtos
			} else if (escolha.equals(HomeOption.VENDAS)) {
				// TODO: call page vendas
			} else if (escolha.equals(HomeOption.PERFIL)) {
				// TODO: call page perfil
			} else if (escolha.equals(HomeOption.SALDO)) {
				// TODO: call page saldo
			} else if (escolha.equals(HomeOption.DESCONECTAR)) {
				desconectar();
				return;
			}
		}
	}
	
	private void desconectar() {
		usuario = null;
	}
	
}