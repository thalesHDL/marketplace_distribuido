package com.sd.marcketplace.view.server.observer;

import java.time.LocalDate;
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
import comum.domain.Comentario;
import comum.domain.Produto;
import comum.domain.Venda;
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
				usuario = controllerGetUsuarioByFilter(usuario);
				if (usuario.getId() == null) {
					Util.print("login invalido");
					continue;
				}
				pageHome(input);
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
			}else if (escolha.equals(ProdutoOption.SELECIONAR)) {
				pageAnuncio(produtoForm.getProdutoSelecionado(), input);
			} else if (escolha.equals(ProdutoOption.NOVO)) {
				Anuncio anuncio = produtoForm.getDadosProduto();
				controllerPostAnuncio(anuncio);
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
				Util.printList(getAnunciosByFilter(anuncio));
			}else if (escolha.equals(AnuncioFormOption.SELECIONAR)) {
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
				Util.print(getAnuncioById(idAnuncio));
			} else if (escolha.equals(InfoAnuncioFormOption.LISTAR_COMENTARIOS)) {
				Comentario comentario = new Comentario();
				Anuncio anuncio = new Anuncio();
				anuncio.setId(idAnuncio);
				comentario.setAnuncio(anuncio);
				Util.print(getComemtariosByFilter(comentario)); // TODO
			} else if (escolha.equals(InfoAnuncioFormOption.COMENTAR)) {
				Anuncio anuncio = new Anuncio();
				anuncio.setId(idAnuncio);
				Comentario comentario = infoAnuncioForm.getDadosComentario();
				comentario.setData(LocalDate.now());
				comentario.setAnuncio(anuncio);
				comentario.setUsuario(usuario);
				controllerPostComentario(comentario);
			} else if (escolha.equals(InfoAnuncioFormOption.COMPRAR)) {
				Long quantidade = infoAnuncioForm.getQuantidade();
				Anuncio anuncio = new Anuncio();
				anuncio.setId(idAnuncio);
				Venda venda = new Venda();
				venda.setQuantidade(quantidade);
				venda.setData(LocalDate.now());
				venda.setConsumidor(usuario);
				venda.setAnuncio(anuncio);
				
				Anuncio a = getAnuncioById(idAnuncio);
				Util.print(a);
				Util.print(venda);
				Util.print(usuario);
				if (a.getQuantidade() < venda.getQuantidade()) {
					Util.print("Não é possível comprar, pois não há quantidade suficiente");
					continue;
				}
				
				if (a.getPreco().doubleValue()*venda.getQuantidade() > usuario.getSaldo().doubleValue()) {
					Util.print("Usuario não possui saldo suficiente suficiente");
					continue;
				}
				
				controllerPostVenda(venda);
			} else if (escolha.equals(InfoAnuncioFormOption.VOLTAR)) {
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void desconectar() {
		usuario = null;
	}
	
}
