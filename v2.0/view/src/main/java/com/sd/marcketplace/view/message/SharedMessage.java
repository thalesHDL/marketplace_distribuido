package com.sd.marcketplace.view.message;

import java.io.Serializable;

import com.sd.marcketplace.view.message.enumerate.Action;


public class SharedMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Action acao;
	private Object content;
	
	public SharedMessage() {
		this.acao = Action.NONE;
	}
	public SharedMessage(Action acao, Object content) {
		this.acao = acao;
		this.content = content;
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
	
	
	@Override
	public String toString() {
		return "SharedMessage [acao=" + acao + ", content=" + content + "]";
	}

	
	
	
	
	
	
	public Boolean initCadastrarProduto(String nomeProduto) {
		synchronized(this) {
			this.content = nomeProduto;
			this.acao = Action.POST; 
		}
		return true;
	}
	
	public Boolean finishAction() {
		synchronized(this) {
			this.acao = Action.NONE; 
		}
		return true;
	}
}
