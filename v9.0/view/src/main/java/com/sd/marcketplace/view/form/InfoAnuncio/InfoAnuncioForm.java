package com.sd.marcketplace.view.form.InfoAnuncio;

import com.sd.marcketplace.view.form.BaseMenu;

public class InfoAnuncioForm extends BaseMenu<InfoAnuncioFormOption> {
	
	@SuppressWarnings("unchecked")
	public InfoAnuncioForm() throws ClassNotFoundException {
		super((Class<InfoAnuncioFormOption>) Class.forName(InfoAnuncioFormOption.class.getName()));
	}
	
}
