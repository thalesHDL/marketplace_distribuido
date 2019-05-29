package com.sd.marcketplace.view.network.message;

import com.sd.marcketplace.view.network.message.enumerate.Action;

public class SharedMessage {
		
	private Action acao;
	private Object content;
	
	public SharedMessage() {
		this.acao = Action.NONE;
	}
	
	public Action getAction() {
		return this.acao;
	}
	
	public Object getContent() {
		return this.content;
	}
	
	public void setAction(Action acao) {
		this.acao = acao;
	}
	
	
	
	
	
	
	
	public Boolean initCadastrarProduto(String nomeProduto) {
		System.out.println("SharedMessage - initCadastrarProduto");
		this.content = nomeProduto;
		this.acao = Action.POST;
		return true;
	}
	
	public Boolean finishAction() {
		System.out.println("ACAO FINALIZADA");
		this.acao = Action.NONE;
		return true;
	}
}
