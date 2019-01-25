import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteHilo extends Thread {

	Socket cliente;
	String [] primitiva;
	int posicion;
	
	ClienteHilo(Socket cliente, String [] primitiva,int posicion){
		this.cliente = cliente;
		this.primitiva = primitiva;
		this.posicion = posicion;
	}
	
	public void run() {
		
		try {
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			primitiva[posicion] = fentrada.readLine();
			fentrada.close();
			cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
