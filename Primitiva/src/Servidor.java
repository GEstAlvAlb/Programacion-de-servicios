import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int max = 0;
		int puerto = 6200;
		String [] primitiva = new String[6];
		ClienteHilo [] clientes = new ClienteHilo[6];
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Conexion iniciada, esperando los numeros para la primitiva");
			while(max<6) {
				Socket clienteConectado = servidor.accept();
				System.out.println("Cliente conectado, " + (max+1) + "º numero de la primitiva recibido.");
				clientes[max] = new ClienteHilo(clienteConectado, primitiva, max);
				clientes[max].start();
				max++;
			}
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i<clientes.length;i++) {
			try {
				clientes[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Numeros de la primitiva -> ");
		for(int i = 0;i<primitiva.length-1;i++) {
			System.out.print(primitiva[i] + ", ");
		}
		System.out.print(primitiva[primitiva.length-1] + ". ");
	}
	
}
