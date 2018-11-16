package Trenes;

import static Trenes.Semaforos.*;

import java.util.Random;

public class Tren extends Thread {

	private int numEstaciones;

	Tren(int i, int numEstaciones) {
		this.setName("tren" + i);
		this.numEstaciones=numEstaciones;

	}

	public void run() {

		Random ran = new Random();
		int vuelta = 0;
		final int dis1 = 100;
		final int dis2 = 150;
		final int dis3 = 50;
		final int dis4 = 200;

		while (vuelta <= 2) {// TODO bucle sin fin siempre estan dado vueltas,

			try {
				// parada 1

				Tren.sleep(1000);
				estacion1.acquire();
				System.out.println("Soy el " + getName() + " estoy cogiendo pasageros en la parada 1");
				estacion4.release();
				System.out.println("Soy el " + getName() + " Saliendo 1");
				recorrido(dis1, getName());

				// parada2
				System.out.println("Soy el " + getName() + " estoy cogiendo pasageros en la parada 2");
				Tren.sleep(1000);
				estacion2.acquire();
				estacion1.release();
				System.out.println("Soy el " + getName() + " Saliendo 2");
				recorrido(dis2, getName());

				// parada3
				System.out.println("Soy el " + getName() + " estoy cogiendo pasageros en la parada 3");
				Tren.sleep(1000);
				estacion3.acquire();
				estacion2.release();
				System.out.println("Soy el " + getName() + " Saliendo 3");
				recorrido(dis3, getName());

				// parada4
				System.out.println("Soy el " + getName() + " estoy cogiendo pasageros en la parada 4");
				Tren.sleep(1000);
				estacion4.acquire();
				estacion3.release();
				System.out.println("Soy el " + getName() + " Saliendo 4");
				recorrido(dis4, getName());
				

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			vuelta = vuelta + 1;
			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta);

		}
	}

	public void recorrido(int disARecorrer, String nombre) {
		int dis = 0;
		int disT = 0;

		Random ran = new Random();

		do {
			dis = ran.nextInt(70);
			disT = dis + disT;
			// System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) +
			// " metros");

			try {
				Tren.sleep(300 - dis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (disT <= disARecorrer - 70);

		disT = 0;
		dis = 0;
	}
}
