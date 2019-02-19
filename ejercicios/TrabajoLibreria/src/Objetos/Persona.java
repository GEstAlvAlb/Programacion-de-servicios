package Objetos;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Persona {

	String nombre;
	String contraseña;
	int idLibro;
	int numPagina;
	

	public Persona(String nombre, String contraseña) {
		this.nombre=nombre;
		this.contraseña=contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}
	
	
	
	
}
