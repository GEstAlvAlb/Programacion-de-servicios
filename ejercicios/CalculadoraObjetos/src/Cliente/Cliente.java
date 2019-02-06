package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

public class Cliente {
	static String num1= "";
	static String simbolo= "";
	static String num2= "";
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; // Puerto remote
		Random rand=new Random();

		Socket Cliente = new Socket(Host, Puerto);// Crear Flujo de Salida al Servidor
		PrintWriter fSalida = new PrintWriter(Cliente.getOutputStream(), true);
			// Crear Flujo de Entrada al Servidor
		BufferedReader fEntrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			//Flujo para Entada estandar
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un numero");
		num1=in.readLine();
		fSalida.println(num1);
		System.out.println("Introduce una operacion 'un simbolo' ");
		simbolo=in.readLine();
		fSalida.println(simbolo);
		
		System.out.println("Introduce un numero");
		num2=in.readLine();
		fSalida.println(num2);
		
		
		System.out.println("El total de la operacion es: " + fEntrada.readLine());
		
		
		fSalida.close();
		fEntrada.close();
		System.out.println("Fin del envio...");
		in.close();
		Cliente.close();
	}
}
