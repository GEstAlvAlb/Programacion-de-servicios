package Servidor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.BooleanControl;

import Objetos.Libro;
import Objetos.Persona;

public class Servidor implements Interface {
	// readAllLines para leer el fichero en un array
	// se tiene que leer con paths
	// List<String>lineas=Files.readAllLines(Paths.get("Ruta"));

	static Registry reg;
	static Servidor servidor;

	ArrayList<Libro> idsLibros = new ArrayList<>();
	ArrayList<Persona> nomPersonas = new ArrayList<>();
	Libro Pocoyo = new Libro("Pocoyo", 001,"./Libros");

	Persona administrador = new Persona("Administrador", "1234");

	public Servidor() {

		idsLibros.add(Pocoyo);
		nomPersonas.add(administrador);

	}

	public static void main(String[] args) {
		try {
			reg = LocateRegistry.createRegistry(8888);
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		servidor = new Servidor();
		try {
			reg.rebind("Interface", (Interface) UnicastRemoteObject.exportObject(servidor, 0));
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
		System.out.println("servidor creado");

	}

	@Override
	public List<String> hoja(String nomLibro, int numPagina) throws IOException {
		List<String> lineas;

		lineas = Files
				.readAllLines(Paths.get(idsLibros.get(0).getRuta() + File.separator + nomLibro+".txt" ));
		System.out.println(nomLibro);

		ArrayList<String> primeros=new ArrayList<String>(lineas.subList(5, 10));
	
		return primeros;
	}

	@Override
	public void salir() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean conectar(String nombre, String contraseña) throws RemoteException {
		int cont=-1;
		boolean bolNombre=false;
		boolean bolContraseña=false;
		
		do {
			cont++;
			System.out.println(cont);
			if(nomPersonas.get(cont).getNombre().equals(nombre)) {
				bolNombre=true;
				System.out.println("llega");
				if(nomPersonas.get(cont).getContraseña().equals(contraseña)) {
					bolContraseña=true;
				}
			}
			
		}while(cont<nomPersonas.size()-1&&bolNombre==false);
		
		if (bolContraseña)
			return true;
		
		return false;
	}

}
