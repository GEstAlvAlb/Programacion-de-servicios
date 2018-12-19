package com.vpr.aeropuerto;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Metodos {
	//Metodo que devuelve un numero entero aleatorio
	public static int intRandom(int min, int max) {
		Random num = new Random();
		return (min + num.nextInt(max-min+1));
	}
	
	public static void printSemaforo(Semaphore semaforo,String texto) throws InterruptedException {
		semaforo.acquire();
		
		System.out.println(texto);
		try{Thread.sleep(Metodos.intRandom(1000, 2500));}catch(InterruptedException e) {e.printStackTrace();}
		
		semaforo.release();
	}
}
