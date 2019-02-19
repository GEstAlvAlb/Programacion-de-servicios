package Objetos;

public class Libro {

	int idLibro;
	String nomLibro;
	String ruta;
	int numLineas;

	public Libro(String nomLibro, int idLibro, String ruta, int numLineas) {
		this.nomLibro = nomLibro;
		this.idLibro = idLibro;
		this.ruta = ruta;
		this.numLineas = numLineas;
	}
	
	

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNomLibro() {
		return nomLibro;
	}

	public void setNomLibro(String nomLibro) {
		this.nomLibro = nomLibro;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getNumLineas() {
		return numLineas;
	}

	public void setNumLineas(int numLineas) {
		this.numLineas = numLineas;
	}

}
