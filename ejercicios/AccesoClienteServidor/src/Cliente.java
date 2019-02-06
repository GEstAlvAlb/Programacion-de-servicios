import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Cliente {

	static String nombre;
	static String contraseña;
	static Persona persona;
	static Socket Cliente;
	static ObjectOutputStream objSalida;
	static BufferedReader in;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String Host = "localhost";
		int Puerto = 6000; // Puerto remote
		

		Cliente = new Socket(Host, Puerto);// Crear Flujo de Salida al Servidor

		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el nombre");
		nombre=in.readLine(); // envio el nombre

		System.out.println("Introduce una contraseña");
		contraseña=in.readLine();

		persona=new Persona(nombre, contraseña);
		objSalida = new ObjectOutputStream(Cliente.getOutputStream());// objeto para enviar
		objSalida.writeObject(persona);

		ObjectInputStream objEntrada = new ObjectInputStream(Cliente.getInputStream()); // recive

		persona = (Persona) objEntrada.readObject();

		System.out.println("Fin del envio...");

		in.close();
		Cliente.close();
		objEntrada.close();
		objSalida.close();
	}
}
