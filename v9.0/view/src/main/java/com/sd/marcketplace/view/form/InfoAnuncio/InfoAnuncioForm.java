package com.sd.marcketplace.view.form.InfoAnuncio;

import com.sd.marcketplace.view.form.BaseMenu;

import comum.domain.Comentario;

public class InfoAnuncioForm extends BaseMenu<InfoAnuncioFormOption> {
	
	@SuppressWarnings("unchecked")
	public InfoAnuncioForm() throws ClassNotFoundException {
		super((Class<InfoAnuncioFormOption>) Class.forName(InfoAnuncioFormOption.class.getName()));
	}
	
	public Comentario getDadosComentario() {
		System.out.print("\nmensagem: ");
		String mensagem = this.input.nextLine();

		
		Comentario comentario = new Comentario();
		comentario.setMensagem(mensagem);

		return comentario;
	}
	
	public Long getQuantidade() {
		System.out.print("\n\nQuantidade: ");
		Long quantidade = this.input.nextLong();
		this.input.nextLine();
		
		return quantidade;
	}
	
}
