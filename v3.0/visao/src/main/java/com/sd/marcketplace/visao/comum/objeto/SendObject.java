package com.sd.marcketplace.visao.comum.objeto;

import java.io.Serializable;

import com.sd.marcketplace.visao.comum.enumerate.Action;
import com.sd.marcketplace.visao.comum.enumerate.Entidade;


@SuppressWarnings("serial")
public class SendObject implements Serializable {
	
	private Action acao;
	private Entidade entidade;
	private Object content;
	
	public SendObject() {
		// Empty constructor
	}
	
	public SendObject(SendObject so) {
		this.acao = so.getAcao();
		this.entidade = so.getEntidade();
		this.content = so.getContent();
	}
	
	public SendObject(Action acao, Object content) {
		this.acao = acao;
		this.content = content;
	}
	
	public SendObject(Action acao, Entidade entidade, Object content) {
		this.acao = acao;
		this.entidade = entidade;
		this.content = content;
	}
	

	public Action getAcao() {
		return acao;
	}

	public void setAcao(Action acao) {
		this.acao = acao;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	
	@Override
	public String toString() {
		return "SendObject [acao=" + acao + ", entidade=" + entidade + ", content=" + content + "]";
	}

}
