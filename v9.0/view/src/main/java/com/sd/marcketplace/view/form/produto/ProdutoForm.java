package com.sd.marcketplace.view.form.produto;

import java.math.BigDecimal;

import com.sd.marcketplace.view.form.BaseMenu;

import comum.domain.Anuncio;
import comum.domain.Produto;

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
	
	public Anuncio getDadosProduto() {
		System.out.print("\n\nInforma os dados do produto que se deseja cadasrar: ");
		System.out.print("\nNome: ");
		String nome = this.input.nextLine();
		
		System.out.print("\nDescricao: ");
		String descricao = this.input.nextLine();
		
		System.out.print("\nPreco: : ");
		BigDecimal preco = this.input.nextBigDecimal();
		this.input.nextLine();
		
		System.out.print("\nQuantidade: ");
		Long quantidade = this.input.nextLong();
		this.input.nextLine();
		
		Produto produto = new Produto();
		produto.setNome(nome);
		
		Anuncio anuncio = new Anuncio();
		anuncio.setDescricao(descricao);
		anuncio.setPreco(preco);
		anuncio.setQuantidade(quantidade);
		
		anuncio.setProduto(produto);
		
		return anuncio;
	}
	
}
