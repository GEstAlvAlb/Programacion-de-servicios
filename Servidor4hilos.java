import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class hilonuevocliente extends Thread {
Socket socketclienteconectado;
hilonuevocliente(Socket clienteconectado){
	socketclienteconectado=clienteconectado;
}
public void run() {
	try{
		String cad = "";
		// Creando el flujo de salida al Cliente
		PrintWriter fsalida = new PrintWriter(socketclienteconectado.getOutputStream(), true);
		// Creando el flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(socketclienteconectado.getInputStream()));
	
		while(!cad.equals("*")){ 
			// recibida cadena del cliente
			cad = fentrada.readLine();
			fsalida.println(cad); // Envío de cadena a un cliente
			System.out.println(" Recibiendo: " + cad);			
		}
				
				// Cierre de Streams y Sockets
				System.out.println("Cerrando conexión….");
				fentrada.close();
				fsalida.close();
				socketclienteconectado.close();	
	
	}catch(IOException e){
		System.out.println("Conexion finalizada con el servidor");

	}	
	}
}

public class Servidor4hilos {

	public static void main(String[] args) throws IOException {
		int max=0;
		int numeroPuerto = 6000; // Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		while(max<24) {

			System.out.println("Esperando conexión….");
			Socket clienteConectado = servidor.accept();
			System.out.println("Cliente conectado…");
			hilonuevocliente clientenuevo=new hilonuevocliente(clienteConectado);
			clientenuevo.start();
			max++;
		}
		servidor.close();
	}
}