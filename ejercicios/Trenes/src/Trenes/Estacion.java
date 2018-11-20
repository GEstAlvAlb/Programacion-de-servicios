package Trenes;

import static Trenes.Semaforos.estacion1;
import static Trenes.Semaforos.estacion2;
import static Trenes.Semaforos.estacion3;
import static Trenes.Semaforos.estacion4;

import java.util.concurrent.Semaphore;

public class Estacion {

	final static Semaphore semaforos[] = { estacion1, estacion2, estacion3, estacion4 };
	final static int[] dis = { 100, 150, 50, 200 };

	public static void estacion(String nombre) throws InterruptedException {
	
		int numEstaciones = 4;
		for (int i = 0; i <= numEstaciones - 1; i++) {
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
			
			Tren.recorrido(dis[i], nombre,10,0);
		}
		;

	
	}

}
