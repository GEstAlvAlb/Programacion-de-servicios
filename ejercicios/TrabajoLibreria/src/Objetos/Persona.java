package Objetos;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Persona {

	String nombre;
	String contrase�a;
	int idLibro;
	int numPagina;
	

	public Persona(String nombre, String contrase�a) {
		this.nombre=nombre;
		this.contrase�a=contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
