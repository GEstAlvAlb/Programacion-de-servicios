package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteHilo extends Thread {
	String temp;
	Socket socket;
	
	ClienteHilo(Socket socket) {

		this.socket=socket;
	}
	
	public void run() {
		try {
			BufferedReader fEntrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while ((temp = fEntrada.readLine()) != null) { 
				temp=fEntrada.readLine();
				System.out.println(temp+" "+socket);
			}
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
	

}
