package Trenes;

import static Trenes.Constantes.*;

import java.util.Random;

public class Tren extends Thread {

	static Ventana ventana = new Ventana();
	Linea f = new Linea();

	private int id;
	static int x = 10;
	static int y = 10;

	Tren(int id) {
		this.setName("tren" + (id + 1));
		this.id = id;

	}

	public void run() {

		Random ran = new Random();
		int vuelta = 0;

		while (vuelta <= 1) {// TODO bucle sin fin siempre estan dado vueltas,

			try {

				Estacion.estacion(getName(), id);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			vuelta = vuelta + 1;
			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta);

		}
	}

	public static void recorrido(int disARecorrer, String nombre, int id) {
		int dis = 0;
		int disT = 0;

		Random ran = new Random();

		do {
			dis = ran.nextInt(70);
			disT = dis + disT;
			System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) + " metros");
			ventana.mover(id);
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
