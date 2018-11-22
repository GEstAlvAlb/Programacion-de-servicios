package Trenes;

import static Trenes.Constantes.*;


import java.util.concurrent.Semaphore;

public class Estacion {

	final static Semaphore semaforos[] = { estacion1, estacion2, estacion3, estacion4 };
	final static int[] dis = { 100, 150, 50, 200 };

	
	
	
	public static void estacion(String nombre, int id) throws InterruptedException {
	
		
		
		for (int i = 0; i <= NUM_ESTACIONES - 1; i++) {
			Tren.sleep(1000);
			semaforos[i].acquire();
			// System.out.println("Soy el " + nombre + " estoy cogiendo pasageros en la
			// parada 1");
			if (i < 1) {
				semaforos[3].release();
			} else {
				semaforos[i - 1].release();
			}
			System.out.println("Soy el " + nombre + " Saliendo " +(i+1));
			
			Tren.recorrido(dis[i], nombre,id);
		}
		;

	
	}

}
