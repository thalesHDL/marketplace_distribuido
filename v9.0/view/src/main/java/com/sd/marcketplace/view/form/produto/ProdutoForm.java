package com.sd.marcketplace.view.form.produto;

import com.sd.marcketplace.view.form.BaseMenu;

public class ProdutoForm extends BaseMenu<ProdutoOption>  {
	
	@SuppressWarnings("unchecked")
	public ProdutoForm() throws ClassNotFoundException {
		super((Class<ProdutoOption>) Class.forName(ProdutoOption.class.getName()));
	}
	
}
