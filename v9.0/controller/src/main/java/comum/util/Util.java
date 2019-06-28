package comum.util;

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
		System.out.println(str);
	}
	
	public static void print(Object obj) {
		if (obj == null) {
			System.out.println("null");
		} else {
			System.out.println(obj.toString());
		}
	}
	
}
