import java.util.concurrent.Semaphore;

class Acumula {
	public static int acumulador = 0; // inicializa el acumulador a 0
}

class Sumador extends Thread {
	private int cuenta;
	private Semaphore semaforo;

	// Constructor
	Sumador(int hasta, int id, Semaphore semaforo) {
		this.cuenta = hasta;
		this.semaforo = semaforo;
	}

	// Metodo incrementa el acumulador
	public void sumar(int Acu) {
		Acumula.acumulador = Acu + 1;
	}

	public void run() {
		int Acu;
		for (int i = 0; i < cuenta; i++) {
			try {
				semaforo.acquire(); // Señal Wait del Semaforo. Disminuye en 1 el semaforo
				Acu = Acumula.acumulador;
				System.out.println("En el hilo " + this.getName() + " Acu = " + Acu + " Vuelta " + i);
				sumar(Acu);
				semaforo.release(); // Señal Signal del semaforo. Incrementa en 1 el semaforo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class semanoro1 {
	private static Sumador sumadores[];
	private static Semaphore semaforoprincipal = new Semaphore(1);

	public static void main(String[] args) {
		int n_sum = 4; // int n_sum=Integer.parseInt(args[0]);
		// Crea Array de procesos Sumadores
		sumadores = new Sumador[n_sum];
		// Inicia los Procesos del Array
		for (int i = 0; i < n_sum; i++) {
			sumadores[i] = new Sumador(10000, i, semaforoprincipal);
			sumadores[i].start();
		}

		// Indica al Programa Principal espere a que todos los Procesos estén muertos
		for (int i = 0; i < n_sum; i++) {
			try {
				sumadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Acumulador; " + Acumula.acumulador);
	}
}