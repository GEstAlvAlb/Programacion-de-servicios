package Trenes;

import static Trenes.Semaforos.*;

import java.util.Random;

public class Tren  extends Thread {

	Tren(int i, int numEstaciones) {
		this.setName("tren" + i);
	}

	public void run(int numEstaciones) {

		Random ran = new Random();
		int vuelta = 0;
		final int dis1 = 1000;
		final int dis2 = 1500;
		final int dis3 = 500;
		final int dis4 = 2000;

		while (vuelta <= 0) {// TODO bucle sin fin siempre estan dado vueltas,

			for (int i=0;i<=numEstaciones;i++)
			Estacion.estacion(getName(), 1);

			recorrido(dis1, getName());

			Estacion.estacion(getName(), 2);

			recorrido(dis2, getName());

			Estacion.estacion(getName(), 3);

			recorrido(dis3, getName());

			// Semaforo 4
			Estacion.estacion(getName(),4);
			recorrido(dis4, getName());

			vuelta = vuelta + 1;

		}
	}

	public void recorrido(int disARecorrer, String nombre) {
		int dis = 0;
		int disT = 0;

		Random ran = new Random();

		do {
			dis = ran.nextInt(70);
			disT = dis + disT;
			System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) + " metros");

			try {
				Tren.sleep(300 - dis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (disT <= disARecorrer - 70);

		disT = 0;
		dis = 0;
	}
}
