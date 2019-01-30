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
		int max = 0;
		ServerSocket servidor = new ServerSocket(numeroPuerto); // al no ponerle nada coje la ip del ordenador
																// directamente
		PrintWriter fsalida = null;
		ClienteHilo cliente = null;
		String cad = "";
		System.out.println("Esperando conexión....");

		Socket clienteConectado = servidor.accept();
		
		System.out.println("Cliente conectado");
		cliente = new ClienteHilo(clienteConectado);
		cliente.start();

	}
}