package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

import Objeto.Objeto;

public class Cliente {
	static String num1= "";
	static String simbolo= "";
	static String num2= "";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String Host = "localhost";
		int Puerto = 6000; // Puerto remote
		Random rand=new Random();
		Objeto objeto=new Objeto();//objeto creado

		Socket Cliente = new Socket(Host, Puerto);// Crear Flujo de Salida al Servidor
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un numero");
		objeto.setNum1(Integer.parseInt(in.readLine())); //envio el numero uno
		
		System.out.println("Introduce una operacion 'un simbolo' ");
		objeto.setSimbolo(in.readLine());
		
		System.out.println("Introduce un numero");
		objeto.setNum2(Integer.parseInt(in.readLine()));
		
		ObjectOutputStream objSalida=new ObjectOutputStream(Cliente.getOutputStream());//objeto para enviar
		objSalida.writeObject(objeto);
				
		ObjectInputStream objEntrada=new ObjectInputStream(Cliente.getInputStream()); //recive
		
		objeto=(Objeto)objEntrada.readObject();
				
		
		System.out.println("El total de la operacion es: " + objeto.getResultado());
	
		
		System.out.println("Fin del envio...");
		
		in.close();
		Cliente.close();
		objEntrada.close();
		objSalida.close();
		
	}
}
