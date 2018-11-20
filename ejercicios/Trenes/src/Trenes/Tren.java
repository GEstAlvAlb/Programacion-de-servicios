package Trenes;

import static Trenes.Semaforos.*;

import java.util.Random;

public class Tren extends Thread {

	Linea f = new Linea();
	static Ventana ventana;
	private int numEstaciones;
	static int x=10;
	static int y=10;

	Tren(int i, int numEstaciones, Ventana p) {
		this.setName("tren" + i);
		this.numEstaciones = numEstaciones;
		ventana = p;

	}

	public void run() {

		Random ran = new Random();
		int vuelta = 0;

		while (vuelta <= 1) {// TODO bucle sin fin siempre estan dado vueltas,

			try {

				Estacion.estacion(getName());

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			vuelta = vuelta + 1;
			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta);

		}
	}

	public static void recorrido(int disARecorrer, String nombre,int x, int y) {
		int dis = 0;
		int disT = 0;

		Random ran = new Random();

		do {
			dis = ran.nextInt(70);
			disT = dis + disT;
			System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) + " metros");
			ventana.mover(x, y);
			try {
				Tren.sleep(300 - dis);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (disT <= (disARecorrer - 70));

		disT = 0;
		dis = 0;
	}
}
