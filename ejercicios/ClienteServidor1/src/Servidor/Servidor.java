package Servidor;

import java.io.*;
import java.net.*;
import java.util.stream.Stream;

public class Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(); // nuevo socket servidor
				//Realizando bind
			InetSocketAddress addr = new InetSocketAddress("192.168.34.77", 5555); //esta es mi IP o local Host
			serverSocket.bind(addr);
				//Aceptando conexiones
			Socket newSocket = serverSocket.accept();
				//Recibiendo mensaje
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(is));
			String mensaje = fentrada.readLine();
			System.out.println(mensaje);
				//cerrando el nuevo socket
			newSocket.close();
				//cerrando el socket servidor
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}