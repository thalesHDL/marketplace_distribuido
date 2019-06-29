package comum.util;

import java.util.List;

public final class Util {
	
	public static final String VISAO_CHANNEL = "VisaoChannel";
	public static final String CONTROLE_CHANNEL = "ControleChannel";

	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	
	public static void print(String channelName, String str) {
		System.out.println("[" + channelName + "] : " + str);
	}
	
	public static void print(String str) {
		System.out.println("\n" + str + "\n");
	}
	
	public static void print(Object obj) {
		if (obj == null) {
			System.out.println("\n null \n");
		} else {
			System.out.println("\n" + obj.toString() + "\n");
		}
	}
	
	public static void printList(List<?> list) {
		String str = "\n";
		for (Object obj: list) {
			str += obj.toString() + "\n";
		}
		print(str);
	}
}
