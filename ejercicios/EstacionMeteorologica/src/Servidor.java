import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int max = 0;
		int puerto = 6660;
		String [] aTemperaturas = new String[6];
		ClienteHilo [] clientes = new ClienteHilo[6];
		Socket[] scPuestos=new Socket[6];
		PrintWriter salida=null;
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Conexion iniciada");
			while(max<6) {
				Socket clienteConectado = servidor.accept();
				
				scPuestos[max]=clienteConectado;
				System.out.println("Cliente " + (max+1) + " conectado");
				clientes[max] = new ClienteHilo(clienteConectado, aTemperaturas, max);
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
		for(int i = 0;i<aTemperaturas.length-1;i++) {
			System.out.print(aTemperaturas[i] + ", ");
		}
		for(int i = 0; i < 6; i++) {
			try {
				salida = new PrintWriter(scPuestos[i].getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			salida.println(aTemperaturas);
		}
		System.out.print(aTemperaturas[aTemperaturas.length-1] + ". ");
	}
	
}
