package com.sd.marcketplace.view.form;

import java.util.Scanner;

public class BaseMenu<T extends Enum<T>> {
	
	private Class<T> type;
	public Scanner input;
	
	public BaseMenu (Class<T> type) {
		this.type = type;
	}
	
	public T start(Scanner input) {
		this.input = input;
		return this.getEscolha();
	}
	
	private T getEscolha() {
//		Util.clearScreen(); // TODO: retirar quando der
		
		System.out.print("\n" + type.getSimpleName() + "\n");
		System.out.print(montaMenu());
		
		Long escolha = this.input.nextLong();
		this.input.nextLine();
		
		T[] options = this.type.getEnumConstants();
		for (T op : options) {
			if (Long.valueOf(op.ordinal()).equals(escolha)) {
				return op;
			}
		}
		return T.valueOf(type, "NONE");
	}
	
	private String montaMenu() {
		StringBuilder opcoes = new StringBuilder();

		T[] options = this.type.getEnumConstants();
		for (T op : options) {
			opcoes.append(this.criaOpcao(op));
		}
		opcoes.append("    Escolha: ");
		return opcoes.toString();
	}
	
	private String criaOpcao(T op) {
		return "    ".concat(op.toString()).concat(" (").concat(Long.valueOf(op.ordinal()).toString()).concat(")\n");
	}
}
