package aviones.AeropuertoMonitores.src.com.vpr.aeropuerto;

import java.util.concurrent.Semaphore;

class Avion extends Thread{
	//Atributos
	private Monitores monitor = new Monitores();
	
	private static int cont = 1;
	private int id = 0;
	
	public Avion() {
		id = cont;
		cont++;
	}
	
	public void run() {
		//monitor.incrementaAvionesVolando();
		
		monitor.mensajesAvion(id);

		//monitor.incrementaAvionesAterrizados();
	}

	public int dameId() {
		return id;
	}
}

public class Aeropuerto {
	public static void main(String[] args) {
		//Constantes
		final int MIN_AVIONES = 10;
		final int MAX_AVIONES = 50;
		
		//Variables y objetos
		Avion[] aviones;
		
		//Programa principal
		aviones = new Avion[Metodos.intRandom(MIN_AVIONES, MAX_AVIONES)]; //generara entre 5 y 10 aviones
		
		//creo los hilos
		for(int i=0; i<aviones.length; i++) {
			aviones[i] = new Avion();
		}
		
		//lanzo los hilos
		for(int i=0; i<aviones.length; i++) {
			aviones[i].start();
		}
		
		//el padre espera a los hilos
		for(int i=0; i<aviones.length; i++) {
			try{aviones[i].join();}catch(InterruptedException e) {e.printStackTrace();} 
		}
	}
}
