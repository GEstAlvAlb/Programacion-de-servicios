import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	static Persona persona[] = new Persona[6];

	static int numeroPuerto = 6000; // Puerto
	static ServerSocket servidor;

	public static void main(String[] args) throws IOException {

		servidor = new ServerSocket(numeroPuerto); // al no ponerle nada coje la ip del ordenador directamente

		persona[1] = new Persona("Ivan", "LaChUpO");
		persona[2] = new Persona("Pepe", "pepito");
		persona[3] = new Persona("juanito", "1234");
		persona[4] = new Persona("Pita", "mela");
		persona[5] = new Persona("federico", "frigorifico");

		

		ClienteHilo cliente = null;
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
