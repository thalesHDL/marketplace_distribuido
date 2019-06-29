package com.sd.marcketplace.view.form.anuncio;

import com.sd.marcketplace.view.form.BaseMenu;

public class AnuncioForm extends BaseMenu<AnuncioFormOption>  {
	
	@SuppressWarnings("unchecked")
	public AnuncioForm() throws ClassNotFoundException {
		super((Class<AnuncioFormOption>) Class.forName(AnuncioFormOption.class.getName()));
	}
	
}
