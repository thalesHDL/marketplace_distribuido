package com.sd.marcketplace.entrega.channel.util.enumerate;

public enum MenuAction {
	
	CADASTRAR_PRODUTO(1L),
	LISTAR_PRODUTOS(2L),
	SELECIONAR_PRODUTO(3L),
	LISTAR_VENDAS(4L),
	SELECIONAR_VENDAS(5L),
	CADASTRAR_USUARIO(6L),
	SAIR(7L);
	
	private Long value;
	
	MenuAction(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}

}
