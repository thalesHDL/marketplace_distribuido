package com.sd.marcketplace.entrega.channel.util.objeto;

import java.io.Serializable;

import com.sd.marcketplace.entrega.channel.util.enumerate.Action;
import com.sd.marcketplace.entrega.channel.util.enumerate.Entidade;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SendObject other = (SendObject) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SendObject [acao=" + acao + ", entidade=" + entidade + ", content=" + content + "]";
	}

}
