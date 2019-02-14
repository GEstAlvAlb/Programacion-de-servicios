import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	static String persona[] = new String[6];

	static int numeroPuerto = 6000; // Puerto
	static ServerSocket servidor;
	static ClienteHilo cliente = null;
	public static void main(String[] args) throws IOException {

		servidor = new ServerSocket(numeroPuerto); // al no ponerle nada coje la ip del ordenador directamente
		persona[0] = new String("alberto");
		persona[1] = new String("Ivan");
		persona[2] = new String("Pepe");
		persona[3] = new String("juanito");
		persona[4] = new String("Pita");
		persona[5] = new String("federico");

		

		
		String cad = "";
		System.out.println("Esperando conexión....");

		while (true) {
			Socket clienteConectado = servidor.accept();

			System.out.println("Cliente conectado");
			cliente = new ClienteHilo(clienteConectado,persona);
			cliente.start();

		}
	}
}
