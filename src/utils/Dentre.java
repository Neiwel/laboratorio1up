package utils;
	import java.io.*;

public class Dentre {
	public static String texto(String mensaje){
		try{
			System.out.print(mensaje);
			String entrada = new BufferedReader(new InputStreamReader(System.in)).readLine();
			return entrada;
		}
		catch(IOException e){
			System.out.println(e);
			System.exit(1);
			return e.toString();
		}
	}
	
	//Metodo que permite entrar UN caracter y se lo paso como argumento al texto para solicitar dicho caracter
	
	public static char caracter(String mensaje){
		String aux = texto(mensaje);
		return aux.charAt(0);
	}
	
	public static int entero(String mensaje){
		Integer dato = new Integer(texto(mensaje));
		return dato.intValue();
	}
}
