package com.vpr.principal;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		//Constantes
		final String IP = "192.168.1.134";
		final int HOST = 5555;
		final int MAX_USUARIOS = 6;
		
		//Variables
		ServerSocket sctServer;
		InetSocketAddress addr;
		InputStream is;
		OutputStream os;
		
		BufferedReader entrada = null;
		PrintWriter salida = null;
		String mensajeRecibido = "";
		String quiniela = "";
		Socket[] sctUsers = new Socket[MAX_USUARIOS];
		
		//Programa principal
		try {
			sctServer = new ServerSocket();
			addr = new InetSocketAddress(IP, HOST);


			sctServer.bind(addr);
			System.out.println("- SERVER INICIADO -");

			//Acepto usuarios
			for(int i = 0; i < MAX_USUARIOS; i++) {
				Socket sctUser = sctServer.accept();
				sctUsers[i] = sctUser;
				entrada = new BufferedReader(new InputStreamReader(sctUser.getInputStream()));
				mensajeRecibido = entrada.readLine(); //recibo mensaje
				quiniela += "["+mensajeRecibido+"]";
				System.out.println("Recibido - "+mensajeRecibido);
			}
			
			//envio los numeros a los usuarios
			System.out.println("Enviando...");
			for(int i = 0; i < MAX_USUARIOS; i++) {
				salida = new PrintWriter(sctUsers[i].getOutputStream(), true);
				salida.println(quiniela);
			}
			
			//Termino
			System.out.println("Fin del server");
			entrada.close();
			salida.close();
			for(int i = 0; i < MAX_USUARIOS; i++) {
				sctUsers[i].close();
			}
			sctServer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
