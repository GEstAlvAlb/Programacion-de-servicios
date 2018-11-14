package aeropuerto;

import java.util.concurrent.Semaphore;

public class Aviones(int id_numeros, Semaphore Semaforo) extends Thread{
	
	private int num_aviones;
	private Semaphore Sem_pista;
	this.num_aviones=id_numero;
	this.sem_pista=Semaforo;
	

	public void run(){
		System.out.println("Solicitando Aterrizaje... ");
		
	}
}
