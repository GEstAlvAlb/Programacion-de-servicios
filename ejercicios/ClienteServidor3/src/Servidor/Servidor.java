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
	static int num[] = { 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000; // Puerto
		int cont = 0;

		ServerSocket servidor = new ServerSocket(numeroPuerto); // al no ponerle nada coje la ip del ordenador

		// directamente
		while (cont < 6) {

			System.out.println("Esperando conexión....");
			Socket clienteConectado = servidor.accept();
			System.out.println("Cliente conectado...");
			cont++;
			Thread t = new Hilonuevocliente(clienteConectado);
			
			t.start();
		}

	}
}