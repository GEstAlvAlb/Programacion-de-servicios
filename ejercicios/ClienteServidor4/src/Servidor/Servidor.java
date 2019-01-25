package Servidor;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000; // Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto); // al no ponerle nada coje la ip del ordenador directamente
				
		String cad = "";
		System.out.println("Esperando conexión....");
		Socket clienteConectado = servidor.accept();
		System.out.println("Cliente conectado...");
			//Creando el flujo de salida al Cliente
		PrintWriter fsalida = new PrintWriter(clienteConectado.getOutputStream(), true);
			//Creando el flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
		while ((cad = fentrada.readLine()) != null) { // recibida cadena del cliente
			fsalida.println(cad);
			// Envío de cadena a un cliente
			System.out.println("Recibiendo: " + cad);
			if (cad.equals("salir"))
				break;
		}
			//Cierre de Streams y Sockets
		System.out.println("Cerrando conexión....");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		servidor.close();
	}
}