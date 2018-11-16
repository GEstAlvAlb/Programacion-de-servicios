package aviones.AeropuertoMonitores.src.com.vpr.aeropuerto;

public class Clima {
	//Constantes
	private final String[] CLIMAS = {"Soleado","Nuboso","Lluvioso","Nevado","Fuertes vientos"};
	
	//Atributos
	private String climaActual;
	
	//Constructor
	public Clima(int climaActual) {
		this.climaActual = CLIMAS[climaActual];
	}
	
	public String getClimaActual() {
		return climaActual;
	}
}
