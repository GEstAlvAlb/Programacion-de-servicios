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
		for (int i =0;i==NUM_TRENES-1;i++) {
			vuelta[i]=1;
		}

	}

	static int vuelta[] = new int[NUM_TRENES];

	public void run() {

		while (vuelta[id] < NUM_VUELTAS) {
			
			try {
				Estacion.estacion(getName(), id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			vuelta[id] = vuelta[id] + 1;
			System.out.println("soy " + getName() + " he terminado la vueta " + vuelta[id]);
		}
	}

	public static void recorrido(int disARecorrer, String nombre, int id, int semaforo) {
		int dis = 0;
		int disT = 0;

		do {
			disT = disT + 50;
			// System.out.println("Soy " + nombre + " me quedan " + (disARecorrer - disT) +
			// " metros");
			ventana.mover(id, dis, semaforo, vuelta[id]);

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
