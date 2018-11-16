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

		while (vuelta <= 10) {// TODO bucle sin fin siempre estan dado vueltas,

			try {
				
				
				Estacion.estacion(getName());

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			vuelta = vuelta + 1;
			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta);

		}
	}

	public static void recorrido(int disARecorrer, String nombre) {
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
