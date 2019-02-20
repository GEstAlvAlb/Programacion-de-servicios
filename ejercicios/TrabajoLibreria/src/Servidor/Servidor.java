package Servidor;

import java.util.ArrayList;
import java.util.List;

import Objetos.Libro;
import Objetos.Persona;

public class Servidor {
	//readAllLines para leer el fichero en un array
	// se tiene que leer con paths
	//List<String>lineas=Files.readAllLines(Paths.get("Ruta"));
	
	
	ArrayList<Libro>idsLibros=new ArrayList<>();
	ArrayList<Persona>nomPersonas=new ArrayList<>();
	Libro Pocoyo= new Libro("Pocoyo", 001, "C:\\a");
	Persona administrador=new Persona("Administrador", "1234");
	
	
	public Servidor() {
		idsLibros.add(Pocoyo);
		nomPersonas.add(administrador);
	}
	
	
}
