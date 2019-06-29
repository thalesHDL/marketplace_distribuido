package com.sd.marcketplace.view.server.observer;

import java.util.Scanner;

import com.sd.marcketplace.view.form.InfoAnuncio.InfoAnuncioForm;
import com.sd.marcketplace.view.form.InfoAnuncio.InfoAnuncioFormOption;
import com.sd.marcketplace.view.form.anuncio.AnuncioForm;
import com.sd.marcketplace.view.form.anuncio.AnuncioFormOption;
import com.sd.marcketplace.view.form.cadastro.usuario.CadastroUsuario;
import com.sd.marcketplace.view.form.cadastro.usuario.CadastroUsuarioOption;
import com.sd.marcketplace.view.form.home.Home;
import com.sd.marcketplace.view.form.home.HomeOption;
import com.sd.marcketplace.view.form.inicial.Inicial;
import com.sd.marcketplace.view.form.inicial.InicialOption;
import com.sd.marcketplace.view.form.login.Login;
import com.sd.marcketplace.view.form.login.LoginOption;
import com.sd.marcketplace.view.form.produto.ProdutoForm;
import com.sd.marcketplace.view.form.produto.ProdutoOption;
import com.sd.marcketplace.view.server.service.ViewService;

import comum.domain.Anuncio;
import comum.domain.Produto;
import comum.util.Util;

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
				usuario = controllerPostUsuario(cadastroUsuario.getDadosUsuario());
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
				pageProdutos(input);
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
	
	private void pageProdutos(Scanner input) throws Exception {
		ProdutoForm produtoForm = new ProdutoForm();
		ProdutoOption escolha = ProdutoOption.NONE;
		
		while(true) {
			escolha = produtoForm.start(input);
			
			if (escolha.equals(ProdutoOption.LISTAR)) {
				Util.printList(getAllProdutos());
			} else if (escolha.equals(ProdutoOption.FILTRAR)) {
				// TODO: call page vendas
			} else if (escolha.equals(ProdutoOption.SELECIONAR)) {
				pageAnuncio(produtoForm.getProdutoSelecionado(), input);
			} else if (escolha.equals(ProdutoOption.NOVO)) {
				// TODO: call page saldo
			} else if (escolha.equals(ProdutoOption.VOLTAR)) {
				return;
			}
		}
	}
	
	private void pageAnuncio(Long idProduto, Scanner input) throws Exception {
		AnuncioForm anuncioForm = new AnuncioForm();
		AnuncioFormOption escolha = AnuncioFormOption.NONE;
		
		while(true) {
			escolha = anuncioForm.start(input);
			
			if (escolha.equals(AnuncioFormOption.LISTAR)) {
				Anuncio anuncio = new Anuncio();
				Produto produto = new Produto();
				produto.setId(idProduto);
				anuncio.setProduto(produto);
				Util.printList(getAnunciosByFilter(anuncio)); // TODO
			} else if (escolha.equals(AnuncioFormOption.FILTRAR)) {
				// TODO: call page vendas
			} else if (escolha.equals(AnuncioFormOption.SELECIONAR)) {
				pageInfoAnuncio(anuncioForm.getAnuncioSelecionado(), input);
			} else if (escolha.equals(AnuncioFormOption.VOLTAR)) {
				return;
			}
		}
	}
	
	private void pageInfoAnuncio(Long idAnuncio, Scanner input) throws Exception {
		InfoAnuncioForm infoAnuncioForm = new InfoAnuncioForm();
		InfoAnuncioFormOption escolha = InfoAnuncioFormOption.NONE;
		
		while(true) {
			escolha = infoAnuncioForm.start(input);
			
			if (escolha.equals(InfoAnuncioFormOption.INFO)) {
				Util.printList(getAnuncioById(idAnuncio)); // TODO
			} else if (escolha.equals(InfoAnuncioFormOption.COMPRAR)) {
				// TODO: call page vendas
			} else if (escolha.equals(InfoAnuncioFormOption.VOLTAR)) {
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void desconectar() {
		usuario = null;
	}
	
}
