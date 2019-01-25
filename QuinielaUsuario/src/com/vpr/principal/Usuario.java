package com.vpr.principal;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Usuario {
	public static void main(String[] args) {
		//Constantes
		final String IP = "192.168.1.134";
		final int HOST = 5555;
		
		//Variables
		int numero;
		Socket sctUser;
		InetSocketAddress addr;
		InputStream is;
		OutputStream os;
		String mensaje;
		
		BufferedReader entrada;
		PrintWriter salida;
		
		
		//Programa principal
		try {
			sctUser = new Socket();
			addr = new InetSocketAddress(IP, HOST);
			
			//conexion
			sctUser.connect(addr);
			System.out.println("CONECTADO");
			salida = new PrintWriter(sctUser.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(sctUser.getInputStream()));
			
			//envio mensaje al server
			numero = intRandom(1,49);
			System.out.println("Envio "+numero);
			salida.println(String.valueOf(numero));
			
			//espero a recibir mensaje del server
			mensaje = entrada.readLine();
			System.out.println("Server: "+mensaje);
			
			//Termino
			System.out.println("Fin del cliente");
			salida.close();
			entrada.close();
			sctUser.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Metodo que devuelve un numero entero aleatorio
	public static int intRandom(int min, int max) {
		Random num = new Random();
		return (min + num.nextInt(max-min+1));
	}
}
