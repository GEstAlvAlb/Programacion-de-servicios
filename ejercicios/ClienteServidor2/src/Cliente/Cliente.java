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

public class Cliente {
	public static void main(String[] args) throws IOException {
		String Host = "192.168.34.161";
		int Puerto = 5555; // Puerto remote

		Socket Cliente = new Socket(Host, Puerto);// Crear Flujo de Salida al Servidor
		PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
			// Crear Flujo de Entrada al Servidor
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			//Flujo para Entada estandar
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String cadena, eco = "";
		System.out.print("Introduce cadena; ");
		cadena = in.readLine(); // lectura por teclado
		while (cadena != null) {
			fsalida.println(cadena); // envio de la cadena al servidor
			//eco = fentrada.readLine(); // recibir la cadena del servidor
			//System.out.println("=>ECO; " + eco);
			System.out.println("Introduce cadena;  ");
			cadena = in.readLine(); // lectura por teclado
			if (cadena.equals("salir")) {
				fsalida.println("[Alberto] "+cadena);
				break;
				
			}
			
		}
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envio...");
		in.close();
		Cliente.close();
	}
}
