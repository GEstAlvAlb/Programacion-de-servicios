package Aeropuerto;

import java.io.*;
import java.lang.*;
import java.util.concurrent.Semaphore;
import java.util.*;

class contadores {
	public static int T_actual=1;
	public static int aviones_aterrizados=0;
	public static int aviones_esperando=0; 
    public static int T_aterrizaje=0;
    
    public synchronized void a_aterrizado(){
    	aviones_aterrizados ++;
    }
    public synchronized void a_esperando(){
    	aviones_esperando ++;
    }
    public synchronized void pido_pista(int num_avion){
    	System.out.println ("Voy a aterrizar el avión..." + num_avion + " " +"con tiempo.." +contadores.T_actual+" Aterrizando..." + num_avion);
    	try{
    		Thread.sleep(T_aterrizaje); 
    	}  catch (InterruptedException e) {e.printStackTrace();}
		System.out.println(num_avion +" ...Aterrizado");
    	
    }
	
}

	class aviones extends Thread {
		private int num_avion;
		private contadores contadordeaviones;
		aviones(int id_numero, contadores contador){
			this.num_avion=id_numero;
			this.contadordeaviones=contador;
			
			
		}
		
		public void run() {
			
			System.out.println("Solicitando Aterrizaje... Avion " + num_avion);
			//try{
				
				
				contadordeaviones.a_esperando();
				contadordeaviones.pido_pista(num_avion);
				
				contadordeaviones.a_aterrizado();
				
				
             //}  catch (InterruptedException e) {e.printStackTrace();}
             
		}
	}
	 class Tiempo extends Thread {
		
		public Random aleatorio= new Random();
		
		public void run(){
			
			while(true) {
			
					contadores.T_actual= aleatorio.nextInt(5)+1;
					
					switch(contadores.T_actual) {
					 case 1: 
						 contadores.T_aterrizaje=100;
					     break;
					 case 2: 
						 contadores.T_aterrizaje=1000;
					     break;
					 case 3: 
						 contadores.T_aterrizaje=1500;
					     break;
					 case 4: 
						 contadores.T_aterrizaje=40;
					     break;
					 case 5: 
					 case 6: 
						 contadores.T_aterrizaje=5000;
					     break;
					 default: 
						 contadores.T_aterrizaje=10;
					     break;
					 }
					
				}
			
			
		}
}
	
public class Aeropuerto {


    
    private static aviones a_aviones[];
    
	
	public static void main (String[] args)  {	
		
		contadores contadordeaviones=new contadores();
		int n_aviones=20;
		Tiempo tiempo= new Tiempo();
        tiempo.start();
		System.out.println("Arrancando aterrizajes....");
        a_aviones=new aviones[n_aviones];
		for ( int i=0; i<n_aviones; i++) {
			a_aviones[i]=new aviones(i,contadordeaviones);
			a_aviones[i].start();
			
			contadordeaviones.a_esperando();
			for ( int j=0;j<10000000;j++); //espera hasta el  siguiente avion
		}
		
		for(int i=0;i<n_aviones;i++){
			try{a_aviones[i].join();} catch (InterruptedException e){e.printStackTrace();}
		}
		tiempo.interrupt();
		System.out.println (" Todos los aviones aterrizados....");

	}
}


