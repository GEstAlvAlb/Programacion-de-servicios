

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteHilo extends Thread {

	Socket socket;
	Persona[]persona;
	BufferedReader fEntrada;
	PrintWriter fSalida;
	ObjectInputStream objEntrada;
	

	ClienteHilo(Socket socket,Persona persona[]) {

		this.socket = socket;
		this.persona=persona;
		
	}

	public void run() {
		try {
			
			objEntrada = new ObjectInputStream(socket.getInputStream());
			System.out.println(objEntrada);
			
			

			
			
			
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
