package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

public class Cliente {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; // Puerto remote
		Random rand=new Random();

		Socket Cliente = new Socket(Host, Puerto);// Crear Flujo de Salida al Servidor
		PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
		
		String temperatura= "";
		
		while (temperatura != null) {
			temperatura=String.valueOf(rand.nextInt(30));
			fsalida.println(temperatura); // envio de la cadena al servidor
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		fsalida.close();
		Cliente.close();
	}
}
