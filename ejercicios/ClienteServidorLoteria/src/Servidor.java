import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int max = 0;
		int puerto = 6660;
		String [] primitiva = new String[6];
		ClienteHilo [] clientes = new ClienteHilo[6];
		Socket[] scUsuarios=new Socket[6];
		PrintWriter salida=null;
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Conexion iniciada");
			while(max<6) {
				Socket clienteConectado = servidor.accept();
				
				scUsuarios[max]=clienteConectado;
				System.out.println("Cliente " + (max+1) + " conectado");
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
		for(int i = 0; i < 6; i++) {
			try {
				salida = new PrintWriter(scUsuarios[i].getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			salida.println(primitiva);
		}
		System.out.print(primitiva[primitiva.length-1] + ". ");
	}
	
}
