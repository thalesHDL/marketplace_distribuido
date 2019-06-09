package com.sd.marcketplace.entrega.form;

import java.util.Scanner;

public class Menu {
	
	public static String montaMenu() {
		String str     = " ## ============================================= ## ";
		str = str.concat("\n ## 1) Cadastrar Produto                          ## ");
		str = str.concat("\n ## 2) Listar Produtos                            ## ");
		str = str.concat("\n ## 3) Selecionar Produto                         ## ");
		str = str.concat("\n ## 3) Listar Vendas                              ## ");
		str = str.concat("\n ## 3) Selecionar Venda                           ## ");
		str = str.concat("\n ## 4) Sair                                       ## ");
		str = str.concat("\n ## ============================================= ## ");
		str = str.concat("\n ## Escolha:  ");
		
		return str;
	}
	
	public int getEscolha() {
		Scanner input = new Scanner(System.in);
		System.out.print(montaMenu());
		return input.nextInt();
	}
	
}
