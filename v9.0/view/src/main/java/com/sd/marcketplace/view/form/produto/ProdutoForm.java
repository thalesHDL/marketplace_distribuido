package com.sd.marcketplace.view.form.produto;

import com.sd.marcketplace.view.form.BaseMenu;

public class ProdutoForm extends BaseMenu<ProdutoOption>  {
	
	@SuppressWarnings("unchecked")
	public ProdutoForm() throws ClassNotFoundException {
		super((Class<ProdutoOption>) Class.forName(ProdutoOption.class.getName()));
	}
	
	public Long getProdutoSelecionado() {
		System.out.print("\n\nInforma o id do produto selecionado: ");
		
		Long id = this.input.nextLong();
		this.input.nextLine();
		
		return id;
	}
	
}
