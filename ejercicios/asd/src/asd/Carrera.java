package asd;

import java.util.Random;

public class Carrera extends Thread {
	String nombre;
	int velocidad;
	static Interfaz interfaz = new Interfaz();

	public Carrera(String nombre, int velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}

	public void run() {
		for (int i = 1; i <= 25; i++) {
			System.out.print(nombre + " ");
			interfaz.mover(nombre);
			try {
				sleep(1000 / velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Terminó: " + nombre + "\n");
	}

	public static void main(String[] args) {
		Random random = new Random();
		Carrera friki1 = new Carrera("1", random.nextInt(10));
		Carrera friki2 = new Carrera("2", random.nextInt(10));
		Carrera friki3 = new Carrera("3", random.nextInt(10));

		friki1.start();
		friki2.start();
		friki3.start();
	}
}