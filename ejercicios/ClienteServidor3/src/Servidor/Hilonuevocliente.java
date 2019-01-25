package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilonuevocliente extends Thread {
	Socket clienteConectado;
	

	public Hilonuevocliente(Socket clienteConectado) {
		this.clienteConectado = clienteConectado;
		
	}

	public void run() {
		try {
			String cad = "";
		// Creando el flujo de salida al Cliente
		PrintWriter fsalida;
		
			fsalida = new PrintWriter(clienteConectado.getOutputStream(), true);
		
		// Creando el flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
		while ((cad = fentrada.readLine()) != null) { // recibida cadena del cliente
			fsalida.println(cad);
			// Envío de cadena a un cliente
			System.out.println("Recibiendo: " + cad);
			if (cad.equals("*"))
				break;
		}
		// Cierre de Streams y Sockets
		System.out.println("Cerrando conexión....");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
