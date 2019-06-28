package com.sd.marcketplace.view.form.inicial;

import com.sd.marcketplace.view.form.BaseMenu;

public class Inicial extends BaseMenu<InicialOption> {
	
	@SuppressWarnings("unchecked")
	public Inicial() throws ClassNotFoundException {
		super((Class<InicialOption>) Class.forName(InicialOption.class.getName()));
	}
	
}
