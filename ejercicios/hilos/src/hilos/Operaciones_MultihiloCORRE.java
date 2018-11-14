package hilos;

import java.io.*;
import java.lang.*;

class Operaciones {
	public double Sumas;
	public int Multiplica;
	public double Sumapares;
	public double Sumaimpares;

	Operaciones() {
		this.Sumas = 0;
		this.Multiplica = 1;
		this.Sumapares = 0;
		this.Sumaimpares = 0;
	}
}

class Operacionesenhilos extends Thread {
	private int numhilo;
	Operaciones r;

	Operacionesenhilos(int i, Operaciones resultados) {
		this.numhilo = i;
		this.r = resultados;
	}

	public void run() {
		switch (numhilo) {
		case 1:
			for (int i = 1; i <= 10; i++) {
				r.Sumas = r.Sumas + (double) i;
				System.out.println("Soy el Hilo" + numhilo + " en el número " + i + " y valgo " + r.Sumas);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Hilo Interrumpido.");
				}
			}
			break;
		case 2:
			for (int i = 1; i <= 10; i++) {
				r.Multiplica = r.Multiplica * i;
				System.out.println("Soy el Hilo" + numhilo + " en el número " + i + " y valgo " + r.Multiplica);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Hilo Interrumpido.");
				}
			}
			break;
		case 3:
			int cuenta = 0;
			int i = 0;
			while (cuenta <= 10) {
				if (i % 2 == 0) {
					r.Sumapares = r.Sumapares + i;
					cuenta++;
				}
				System.out.println("Soy el Hilo" + numhilo + " en el número " + "i" + " y valgo " + r.Sumapares);
				i++;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Hilo Interrumpido.");
			}
			break;
		case 4:
			int cuenta2 = 0;
			int j = 0;
			while (cuenta2 <= 10) {
				if (j % 2 == 1) {
					r.Sumaimpares = r.Sumaimpares + j;
					cuenta2++;
				}
				System.out.println("Soy el Hilo" + numhilo + " en el número " + "i" + " y valgo " + r.Sumaimpares);
				j++;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Hilo Interrumpido.");
			}
			break;
		default:
		}
	}
}

public class Operaciones_MultihiloCORRE {
	static int numhilos = 4;
	public Operaciones almacen_operaciones;
	private static Operacionesenhilos HiloOperaciones[];

	public static void main(String[] args) {
		Operaciones almacen_operaciones = new Operaciones();
		HiloOperaciones = new Operacionesenhilos[numhilos];
		for (int i = 0; i < numhilos; i++) {
			HiloOperaciones[i] = new Operacionesenhilos(i + 1, almacen_operaciones);
			HiloOperaciones[i].start();
		}
		System.out.println("“Hilos Creados... Ahora Espero por ellos...");
		try {
			for (int i = 0; i < numhilos; i++) {
				HiloOperaciones[i].join(); // todo add catch exception
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Soy el padre. HIJOS finalizados y tengo los datos...");
		System.out.println(almacen_operaciones.Sumas);
		System.out.println(almacen_operaciones.Multiplica);
		System.out.println(almacen_operaciones.Sumapares);
		System.out.println(almacen_operaciones.Sumaimpares);
	}
}