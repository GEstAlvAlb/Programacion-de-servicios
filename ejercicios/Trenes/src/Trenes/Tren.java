package Trenes;

import static Trenes.Semaforos.*;

import java.util.Random;

public class Tren extends Thread {

	Tren(int i) {
		this.setName("tren" + i);
	}

	public void run() {

		Random ran =new Random();
		int vuelta=0;
		try {
			while (vuelta<=1) {// TODO bucle sin fin siempre estan dado vueltas,
			
				
				//semaforo 1
				System.out.println("Soy el " + getName() + "  estoy semaforo 1");
				estacion1.acquire();
				Tren.sleep(ran.nextInt(1000));
				estacion4.release();
				System.out.println("Soy el " + getName() + " pasado semaforo 1");
				
				
				
				//semaforo 2
				System.out.println("Soy el " + getName() + "  estoy semaforo 2");
				estacion2.acquire();
				Tren.sleep(ran.nextInt(1000));
				estacion1.release();
				System.out.println("Soy el " + getName() + " pasado semaforo 2");
				
				//semaforo 3
				System.out.println("Soy el " + getName() + "  estoy semaforo 3");
				estacion3.acquire();
				Tren.sleep(ran.nextInt(1000));
				estacion2.release();
				System.out.println("Soy el " + getName() + " pasado semaforo 3");
				
				
				//Semaforo 4
				System.out.println("Soy el " + getName() +  "  estoy semaforo 4");
				estacion4.acquire();
				Tren.sleep(ran.nextInt(1000));
				estacion3.release();
				System.out.println("Soy el " + getName() + " pasado semaforo 4");
				
				vuelta=vuelta+1;
				


			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
