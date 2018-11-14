package Trenes;
import static Trenes.Semaforos.*;

public class Tren extends Thread {

	Tren(int i) {
		this.setName("tren" + i);
	}

	public void run() {

		try {
			while (true) {// TODO bucle sin fin siempre estan dado vueltas,
				estacion4.release();
				System.out.println("Soy el " + getName() + " entrando en el circuito");
				estacion1.acquire();
				
				System.out.println("Soy el " + getName() + " he pasado el semaforo 1");
				estacion2.acquire();
				estacion1.release();
				
				System.out.println("Soy el " + getName() + " he pasado el semaforo 2");
				estacion3.acquire();
				estacion2.release();
				
				System.out.println("Soy el " + getName() + " he pasado el semaforo 3");
				estacion4.acquire();
				estacion3.release();
				
				System.out.println("Soy el " + getName() + " he pasado el semaforo 4");

//				if(Semaforos.estacion2==0) {//miramos si el semaforo 2 esta encendido
//				
//					
//					
//					
//				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
