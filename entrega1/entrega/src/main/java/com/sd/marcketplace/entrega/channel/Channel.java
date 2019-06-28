package com.sd.marcketplace.entrega.channel;

import java.time.LocalDate;
import java.util.Scanner;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

import com.sd.marcketplace.entrega.channel.util.enumerate.Action;
import com.sd.marcketplace.entrega.channel.util.enumerate.Entidade;
import com.sd.marcketplace.entrega.channel.util.enumerate.MenuAction;
import com.sd.marcketplace.entrega.channel.util.objeto.SendObject;
import com.sd.marcketplace.entrega.dao.BancoDeDados;
import com.sd.marcketplace.entrega.domain.Usuario;
import com.sd.marcketplace.entrega.form.Menu;

public class Channel extends ReceiverAdapter implements RequestHandler {
	
	private static final String CANAL_NAME = "Modelo";
	
	private JChannel channel;
	private MessageDispatcher dispacher;
	private Menu menu;
	private BancoDeDados db;
	private Scanner input;
	
	
	public Channel() {
		// Empty constructor
	}
	
	public void startChannel() throws Exception {
		this.db = new BancoDeDados();
		this.menu = new Menu();
		this.channel = new JChannel();
		this.dispacher = new MessageDispatcher(this.channel, null, null, this);
		this.channel.connect(CANAL_NAME);
		// TODO: atualizar o banco de dados
		this.eventLoop();
		this.channel.close();
	}
	
	private void sleep(int t) throws Exception {
		Thread.currentThread();
		Thread.sleep(t);
	}
	
	public void eventLoop() throws Exception {
		input = new Scanner(System.in);
		while(true) {
			Long escolha = this.menu.getEscolha(input);
			trataEscolha(escolha);
			sleep(500);
		}
	}
	
	private void trataEscolha(Long escolha) {
		if (escolha.equals(MenuAction.CADASTRAR_PRODUTO.getValue())) {
			cadastrarProduto();
		}
		if (escolha.equals(MenuAction.CADASTRAR_USUARIO.getValue())) {
			cadastrarUsuario();
		}
	}
	
	private void cadastrarProduto() {
		
	}
	
	private void cadastrarUsuario() {
		Usuario usuario = this.menu.getUsuario(input);
		SendObject obj = new SendObject();
		obj.setAcao(Action.POST);
		obj.setEntidade(Entidade.USUARIO);
		obj.setContent(usuario);
		try {
			RspList result = enviaMultcast(obj);
			if (result.getResults().size() < this.channel.getView().getMembers().size()-1) {
				throw new Exception(); // call rollback
			}
			this.db.usuarioDAO.save(usuario);
		} catch (Exception e) {
			// TODO: roolback
		}
	}
	
	
	protected RspList enviaMultcast(Object obj) throws Exception {	
		System.out.println("ENVIANDO MULTICAST: ".concat(obj.toString()));
		Message message = new Message(null, obj);
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
        RspList result = this.dispacher.castMessage(null, message, opcoes);
        System.out.println("RESPOSTA RECEBIDA: ".concat(result.getResults().toString()));
		return result;
	}

	
	
	
	
	
	
	
	public Object handle(Message msg) throws Exception {
		System.out.println("handle: ".concat(msg.toString()));
		if (msg.getSrc().equals(this.channel.getAddress())) {
			return null;
		}
		return trataMessage(msg);
	}
	
	public Object trataMessage(Message msg) throws Exception {
		SendObject obj = (SendObject) msg.getObject();
		System.out.println("trataMessage: ".concat(obj.toString()));
		return trataAction(obj);
	}
	
	public Object trataAction(SendObject obj) throws Exception {
		System.out.println("trataAction: ".concat(obj.getAcao().getValue().toString()));
		if (obj.getAcao().equals(Action.POST)) {
			return trataPost(obj);
		}
		return obj;
	}
	
	public Object trataPost(SendObject obj) throws Exception {
		System.out.println("trataPost: ".concat(obj.getEntidade().getValue().toString()));
		if (obj.getEntidade().equals(Entidade.USUARIO)) {
			return postUsuario((Usuario) obj.getContent());
		}
		return obj;
	}
	
	public Object postUsuario(Usuario u) {
		System.out.println("postUsuario: ".concat(u.toString()));
		try {
			return this.db.usuarioDAO.save(u);
		} catch (Exception e) {
			return null;
		}
	}

}
