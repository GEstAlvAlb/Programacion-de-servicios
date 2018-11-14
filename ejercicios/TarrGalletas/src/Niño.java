import java.util.concurrent.Semaphore;

public class Niño implements Runnable {

	public Niño(int galletas, Semaphore noHayGalletas, Semaphore hayGalletas, Semaphore mutex) {

	public void run() {
		while (true) // Los niños son pachones y siempre estarán comiendo galletas
			mutex.acquire(); // Aquí evitamos que dos procesos comprueben el número de galletas a la vez, ya
								// que podría darse una falsa lectura
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
