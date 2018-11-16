package aeropuerto2HEcho;

import java.io.*;
import java.lang.*;
import java.util.concurrent.Semaphore;
import java.util.*;

class contadores {
	public static int T_actual = 1;
	public static int aviones_aterrizados = 0;
	public static int aviones_esperando = 0;
	public static int T_aterrizaje = 0;

}

class aviones extends Thread {
	private int num_avion;
	private Semaphore Sem_Pista;

	aviones(int id_numero, Semaphore Semaforo) {
		this.num_avion = id_numero;
		this.Sem_Pista = Semaforo;

	}

	public void run() {

		System.out.println("Solicitando Aterrizaje... Avion " + num_avion);
		try {

			Sem_Pista.acquire();
			System.out.println("Hay " + contadores.aviones_esperando + " aviones esperando.."
					+ Sem_Pista.getQueueLength() + " - " + contadores.aviones_aterrizados + " aterrizados");
			contadores.aviones_esperando--;
			System.out.println(
					"Voy a aterrizar el avión...con tiempo.." + contadores.T_actual + " Aterrizando..." + num_avion);
			this.sleep(contadores.T_aterrizaje);
			contadores.aviones_aterrizados++;
			System.out.println(num_avion + " ...Aterrizado y ya van" + contadores.aviones_aterrizados + " aterrizados");

			Sem_Pista.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class Tiempo extends Thread {

	public Random aleatorio = new Random();
	boolean continua = true;

	public void para() {

		continua = false;
	}

	public void run() {

		while (continua) {

			contadores.T_actual = aleatorio.nextInt(5) + 1;

			switch (contadores.T_actual) {
			case 1:
				contadores.T_aterrizaje = 100;
				break;
			case 2:
				contadores.T_aterrizaje = 200;
				break;
			case 3:
				contadores.T_aterrizaje = 300;
				break;
			case 4:
				contadores.T_aterrizaje = 400;
				break;
			case 5:
			case 6:
				contadores.T_aterrizaje = 4000;
				break;
			default:
				contadores.T_aterrizaje = 10;
				break;
			}

		}
		System.out.println("Parando el tiempo....");

	}
}

public class aeropuerto3 {

	private static Semaphore S_Pista = new Semaphore(1);
	private static aviones a_aviones[];

	public static void main(String[] args) {
		int n_aviones = 50;
		Tiempo tiempo = new Tiempo();
		tiempo.start();
		System.out.println("Arrancando aterrizajes....");
		a_aviones = new aviones[n_aviones];
		for (int i = 0; i < n_aviones; i++) {
			a_aviones[i] = new aviones(i, S_Pista);
			a_aviones[i].start();

			contadores.aviones_esperando++;

			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // espera hasta el siguiente avion

		}

		for (int i = 0; i < n_aviones; i++) {
			try {
				a_aviones[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tiempo.para();
		System.out.println(" Todos los aviones aterrizados....");

	}
}
