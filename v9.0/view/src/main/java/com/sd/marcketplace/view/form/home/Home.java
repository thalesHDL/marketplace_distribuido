package com.sd.marcketplace.view.form.home;

import com.sd.marcketplace.view.form.BaseMenu;

public class Home extends BaseMenu<HomeOption> {
	
	@SuppressWarnings("unchecked")
	public Home() throws ClassNotFoundException {
		super((Class<HomeOption>) Class.forName(HomeOption.class.getName()));
	}
	
}
