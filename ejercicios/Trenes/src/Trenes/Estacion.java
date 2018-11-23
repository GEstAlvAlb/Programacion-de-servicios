package Trenes;

import static Trenes.Constantes.*;

import java.util.concurrent.Semaphore;

public class Estacion {

	final static Semaphore semaforos[] = { estacion1, estacion2, estacion3, estacion4,estacion5,estacion6,estacion7 };
	final static int[] dis = { 1100, 550,540, 560,700,700, };

	public static void estacion(String nombre, int id) throws InterruptedException {

		for (int i = 0; i <= NUM_ESTACIONES - 1; i++) {
			Tren.sleep(300);//1000
			semaforos[i].acquire();
			//System.out.println("Soy el " + nombre + " estoy cogiendo pasageros en la parada "+i);
			if (i < 1) {
				semaforos[NUM_ESTACIONES-1].release();
			} else {
				semaforos[i - 1].release();
			}
			//System.out.println("Soy el " + nombre + " Saliendo " + (i ));

			Tren.recorrido(dis[i], nombre, id,i);
		}
		
		
	}

}
