package saluda_profe;

import java.util.concurrent.Semaphore;

class Bienvenida {
	public boolean profellego;

	public Bienvenida() {
		profellego = false;
	}

	// hasta que el profe no salude no empieza la clase
	// por lo que los alumnos esperan con un wait
	public void saludaralProfesor(String nombreA) {
		System.out.println("Soy " + nombreA + ". Buenos días, profesor.");
	}

	// Cuando el profe saluda avisa a los alumnos con notifyall de su llegada
	public void llegadaProfesor(String nombre) {
		System.out.println("Buenos dias a todos. soy el profe " + nombre);
	}
}

class Alumno extends Thread {
	String nombre;
	Bienvenida saludaelalumno;
	Semaphore semaforodelalumno;

	public Alumno(String nombre, Bienvenida mensajedelalumno, Semaphore semaforo_clase) {
		this.nombre = nombre;
		this.saludaelalumno = mensajedelalumno;
		this.semaforodelalumno = semaforo_clase;
	}

	public void run() {
		try {
			Thread.sleep(10);
			System.out.println("Alumno" + this.nombre + " llego.");
			Thread.sleep(10);
			if (saludaelalumno.profellego == false) {
				semaforodelalumno.acquire();
			}
			Thread.sleep(1);
			saludaelalumno.saludaralProfesor(nombre);
		} catch (InterruptedException ex) {
			System.err.println("Thread alumno interrumpido");
			System.exit(-1);
		}
	}
}

class Profesor extends Thread {
	String nombre;
	Bienvenida saludaelprofe;
	Semaphore semaforodelprofe;

	public Profesor(String nombre, Bienvenida mensajeprofesor, Semaphore semaforo_clase) {
		this.nombre = nombre;
		this.saludaelprofe = mensajeprofesor;
		this.semaforodelprofe = semaforo_clase;
	}

	public void run() {
		try {
			Thread.sleep(1);
			System.out.println(nombre + " llego.");
			saludaelprofe.llegadaProfesor(nombre);
			Thread.sleep(1);
			saludaelprofe.profellego = true;
			while (semaforodelprofe.hasQueuedThreads()) {
				semaforodelprofe.release();
			}
		} catch (InterruptedException ex) {
			System.err.println("Threadprofesor interrumpido ");
			System.exit(-1);
		}
	}
}

public class saluda {
	public static void main(String[] args) {
		// Objeto compartido
		Semaphore semaforodeclase = new Semaphore(0);
		Bienvenida b = new Bienvenida();
		String nombrealumno;
		int n_alumnos = 10; // int n_alumnos = Integer.parseInt(args[0]);
		for (int i = 0; i < n_alumnos; i++) {
			nombrealumno = "alumno-" + i;
			new Alumno(nombrealumno, b, semaforodeclase).start();
		}
		Profesor profesor = new Profesor("Jose Manuel", b, semaforodeclase);
		profesor.start();
	}
}
