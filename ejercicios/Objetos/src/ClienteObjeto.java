import java.io.*;
import java.net.*;

public class ClienteObjeto {
	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		String Host = "localhost";
		int Puerto = 6000;// Puerto remoto
		System.out.println("Programa Cliente Iniciado...");
		Socket cliente = new Socket(Host, Puerto);// Flujo de entrada para objetos
		
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());// Se recibe un objeto
		
		Persona dato = (Persona) perEnt.readObject();
		// recibir objeto
		
		System.out.println("Recibo; " + dato.getNombre() + "*" + dato.getEdad());// Modificación del objeto
		dato.setNombre("Juanito Maravilla");
		dato.setEdad(7);
		// Flujo de salida para objetos
		
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());// envio del objeto
		perSal.writeObject(dato);
		System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());// Cerrar Streams y Sockets
		perEnt.close();
		perSal.close();
		cliente.close();
	}

}