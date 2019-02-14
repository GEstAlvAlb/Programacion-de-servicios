

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteHilo extends Thread {

	Socket socket;
	String nombre[];
	BufferedReader fEntrada;
	PrintWriter fSalida;
	ObjectInputStream objEntrada;
	

	ClienteHilo(Socket socket, String nombre[]) {

		this.socket = socket;
		this.nombre=nombre;
		
	}

	public void run() {
		try {
			
			objEntrada = new ObjectInputStream(socket.getInputStream());
			System.out.println(objEntrada);
			
			
			for(String persona:nombre) {
				System.out.println(persona);
				
			}
			
			
			
			fEntrada.close();
			fSalida.close();
			objEntrada.close();
			
			socket.close();
		

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
