import java.util.concurrent.Semaphore;

public class Ni�o implements Runnable {

	public Ni�o(int galletas, Semaphore noHayGalletas, Semaphore hayGalletas, Semaphore mutex) {

	public void run() {
		while (true) // Los ni�os son pachones y siempre estar�n comiendo galletas
			mutex.acquire(); // Aqu� evitamos que dos procesos comprueben el n�mero de galletas a la vez, ya
								// que podr�a darse una falsa lectura
		if (galletas == 0) { // Si no hay galletas...
			NohayGalletas.release(); // Desbloquea a la madre para que rellene
			HayGalletas.acquire(); // Espera a que la madre rellene para continuar
			galletas--; // coge galleta <img class="emoji" draggable="false" alt=""
						// src="https://s0.wp.com/wp-content/mu-plugins/wpcom-smileys/twemoji/2/svg/1f642.svg">
		} else {
			galletas--; // una galleta menos
		}
		mutex.release();
	}
}

}
