package Cliente;

import java.io.*;
import java.net.*;

//CLIENTE
public class Cliente {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket();
//Creando socket cliente
//Estableciendo conexión
			InetSocketAddress addr = new InetSocketAddress("192.168.34.34", 5555); // Esta es la ip de ivan o local host
			clientSocket.connect(addr);
//enviando mensaje
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			String mensaje = "mensaje desde el cliente";
			PrintWriter fsalida = new PrintWriter(os, true);
			fsalida.println(mensaje);
//Mensaje eviado, ahora cierro el socket 
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}