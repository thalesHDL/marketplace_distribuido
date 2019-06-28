package com.sd.marcketplace.entrega.form;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.sd.marcketplace.entrega.channel.util.enumerate.MenuAction;
import com.sd.marcketplace.entrega.domain.Usuario;

public class Menu {
	
	public static String montaMenu() {
		String str     = " ## ============================================= ## ";
		str = str.concat("\n ## ").concat(MenuAction.CADASTRAR_PRODUTO.getValue().toString()).concat(") Cadastrar Produto                          ## ");
		str = str.concat("\n ## ").concat(MenuAction.LISTAR_PRODUTOS.getValue().toString()).concat(") Listar Produtos                            ## ");
		str = str.concat("\n ## ").concat(MenuAction.SELECIONAR_PRODUTO.getValue().toString()).concat(") Selecionar Produto                         ## ");
		str = str.concat("\n ## ").concat(MenuAction.LISTAR_VENDAS.getValue().toString()).concat(") Listar Vendas                              ## ");
		str = str.concat("\n ## ").concat(MenuAction.SELECIONAR_VENDAS.getValue().toString()).concat(") Selecionar Venda                           ## ");
		str = str.concat("\n ## ").concat(MenuAction.CADASTRAR_USUARIO.getValue().toString()).concat(") Cadastrar Usuario                          ## ");
		str = str.concat("\n ## ").concat(MenuAction.SAIR.getValue().toString()).concat(") Sair                                       ## ");
		str = str.concat("\n ## ============================================= ## ");
		str = str.concat("\n ## Escolha:  ");
		return str;
	}
	
	public static String montaUsuario() {
		String str = "informe os dados do Usuario (email senha nome telefone saldo): ";
		str = str.concat("\nUsuario: ");
		return str;
	}
	
	private void printArray(String[] arrayStr) {
		int i = 0;
		int n = arrayStr.length;
		String str = "[";
		while(i < n) {
			str = str.concat(arrayStr[i]);
			i += 1;
			if (i < n) {
				str = str.concat(", ");
			}
		}
		str = str.concat("]");
		System.out.print(str);
	}
	
	public Usuario getUsuario(Scanner input) {
		System.out.print(montaUsuario());
		String str = input.nextLine();
		String[] listStr = str.split(" ");
		Usuario result = new Usuario();
		result.setEmail(listStr[0]);
		result.setSenha(listStr[1]);
		result.setNome(listStr[2]);
		result.setTelefone(listStr[3]);
		result.setSaldo(BigDecimal.valueOf(Double.valueOf(listStr[4])));
		return result;
	}
	
	public Long getEscolha(Scanner input) {
		System.out.print(montaMenu());
		Long result = input.nextLong();
		input.nextLine();
		return result;
	}
	
}
