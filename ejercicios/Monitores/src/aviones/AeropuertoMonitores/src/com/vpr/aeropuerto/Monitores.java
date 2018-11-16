package aviones.AeropuertoMonitores.src.com.vpr.aeropuerto;

public class Monitores {
	//Atributos
	private static int avionesVolando, avionesAterrizados;
	
	public synchronized void mensajesAvion(int id) {
		System.out.printf("Avion %d volando...\n", id);
		avionesVolando++;
		System.out.printf("Volando: %d\n", avionesVolando);
		
		//System.out.println("2:"+avionesVolando);
		
		
		//espero un tiempo aleatorio hasta que el avion solicite el aterrizaje
		try{Thread.sleep(Metodos.intRandom(7000, 15000));}catch(InterruptedException e) {e.printStackTrace();}
		
		int aux = Metodos.intRandom(0, 4);
		String climaActual = new Clima(aux).getClimaActual();

		System.out.println("Avión "+id+" aterrizando  [Clima: "+climaActual+"]");
		System.out.println("Avión "+id+" aterrizado");
		avionesAterrizados++;
		System.out.printf("Aterrizados: %d\n", avionesAterrizados);
	}
}
