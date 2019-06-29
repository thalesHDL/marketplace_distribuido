package com.sd.marcketplace.view.form.anuncio;

import com.sd.marcketplace.view.form.BaseMenu;

public class AnuncioForm extends BaseMenu<AnuncioFormOption>  {
	
	@SuppressWarnings("unchecked")
	public AnuncioForm() throws ClassNotFoundException {
		super((Class<AnuncioFormOption>) Class.forName(AnuncioFormOption.class.getName()));
	}
	
	public Long getAnuncioSelecionado() {
		System.out.print("\n\nInforma o id do anuncio selecionado: ");
		
		Long id = this.input.nextLong();
		this.input.nextLine();
		
		return id;
	}
	
}
