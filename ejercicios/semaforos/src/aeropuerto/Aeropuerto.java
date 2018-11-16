package aeropuerto;

import java.util.concurrent.Semaphore;

import aeropuerto2HEcho.Tiempo;

public class Aeropuerto {
	static int nAviones = 100;

	public static void main(String[] args) {

		Semaphore pista = new Semaphore(1);
		Aviones a_aviones[]=new Aviones();
		int tiempo_actual, aviones_aterrizados, aviones_esperando, tiempo_aterrizaje;

		Tiempo t = new Tiempo();
		Tiempo.start();
		System.out.println("Arrancando atterrizajes...");
		int nAviones;
		a_aviones=new Aviones[nAviones];

		for (int i = 0; i <= 100; i++) {
			a_aviones[i]=new Aviones(i,pista);
			a_aviones[i].start();
			aviones_esperando++;
		}
		
			
		for (int i=0;i<nAviones;i++) {
			try(a_aviones[i].join();{
					
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
}

}
