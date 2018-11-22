package asd;

import java.util.Random;



public class Carrera extends Thread {
	String nombre;
	int velocidad;
	private int id;
	private static Carrera hilo[]=new Carrera[3];	
	static Interfaz interfaz = new Interfaz();

	public Carrera(int id,String nombre, int velocidad) {
		this.nombre = nombre;
		this.id=id;
		this.velocidad = velocidad;
	}

	public void run() {
		for (int i = 1; i <= 25; i++) {
			System.out.print(nombre + " ");
			interfaz.mover(id);
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
		for (int i=0; i <= 2; i++) {
			hilo[i] = new Carrera(i,"Corredor"+i, random.nextInt(10)+1);
			
		}
		for (int i=0; i <= 2; i++) {
			hilo[i].start();
			
			
		}
		
	}
}