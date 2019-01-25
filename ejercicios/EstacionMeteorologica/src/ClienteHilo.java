import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class ClienteHilo extends Thread {

	Socket cliente;
	String [] aTemperatura;
	int posicion;

	
	ClienteHilo(Socket cliente, String [] aTemperatura,int posicion){
		this.cliente = cliente;
		this.aTemperatura = aTemperatura;
		this.posicion = posicion;
	}
	
	public void run() {
		
		try {			
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			aTemperatura[posicion] = fentrada.readLine();
			fentrada.close();
			//cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
