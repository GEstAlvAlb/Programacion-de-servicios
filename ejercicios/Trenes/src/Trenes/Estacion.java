package Trenes;

import static Trenes.Semaforos.estacion1;
import static Trenes.Semaforos.estacion2;
import static Trenes.Semaforos.estacion3;
import static Trenes.Semaforos.estacion4;

import java.util.concurrent.Semaphore;

public class Estacion {

	private static Semaphore[] semaforos = { estacion1, estacion2, estacion3, estacion4 };

	public static void estacion(String nombre, int parada) {

		try {
			System.out.println("Soy el " + nombre + " estoy cogiendo pasageros en la parada " + parada);
			semaforos[parada].acquire();
			Tren.sleep(1000);
			semaforos[parada-1].release();
			System.out.println("Soy el " + nombre + " Saliendo");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		
	}

}
