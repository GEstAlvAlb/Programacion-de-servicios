package paquete_sumaysumanumeros;

//program que crea N hilos y todos suman sobre el mismo objeto Resultado
//una vez observado los resultados tiene comentado el código para implementar
//un semáforo.

import java.util.concurrent.*;
import java.io.*;
import java.lang.*;

public class Sumaysumanumeros {
	
	public static operacion_sumasuma calculando;
	private static final int numhilos=4;

	
	public static void main(String[] args) {
		
		calculando=new operacion_sumasuma();
		hilo_operacion[] hilo_suma=new hilo_operacion[numhilos];
		
		for (int i=0;i<numhilos;i++){
			hilo_suma[i]= new hilo_operacion(i,calculando);
					
			hilo_suma[i].start();
			
		}
		try{
			for (int i=0;i<numhilos;i++){
				hilo_suma[i].join();
			}
		}catch (InterruptedException e) {} 
		System.out.println ("fin del padre");
	}

}
