package Trenes;

import static Trenes.Constantes.*;

import java.util.Random;

public class Tren extends Thread {

	private int id;
	static Ventana ventana;

	Tren(int id, Ventana ventana) {
		this.setName("tren" + (id + 1));
		this.id = id;
		this.ventana = ventana;

	}

	static int vuelta = 1;

	public void run() {

		while (vuelta <= 2) {

			try {
				Estacion.estacion(getName(), id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta);
			vuelta = vuelta + 1;
		}
	}

	public static void recorrido(int disARecorrer, String nombre, int id, int semaforo) {
		int dis = 0;
		int disT = 0;

		do {
			disT = disT + 50;
			// System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) +
			// " metros");
			ventana.mover(id, dis, semaforo, vuelta);

			try {
				Tren.sleep(100);// 300
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (disT < disARecorrer);

		disT = 0;
		dis = 0;
	}
}
