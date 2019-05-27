package com.sd.marcketplace.model.util;

public final class MessageUtil {
	
	public static String menuOptions() {
		String menu = "";
		menu = menu.concat("/*******************************************************************/\n");
		menu = menu.concat("/**                                                               **/\n");
		menu = menu.concat("/** 1) Cadastrar produto                                          **/\n");
		menu = menu.concat("/** 2) Comprar produto                                            **/\n");
		menu = menu.concat("/** 3) Enviar mensagem sobre produto                              **/\n");
		menu = menu.concat("/** 4) Sair                                                       **/\n");
		menu = menu.concat("/**                                                               **/\n");
		menu = menu.concat("/*******************************************************************/\n");
		menu = menu.concat("escolha: ");
		return menu;
	}
	
	public static String messageCadastrarProduto() {
		return "Informe o nome do produto: ";
	}

}
