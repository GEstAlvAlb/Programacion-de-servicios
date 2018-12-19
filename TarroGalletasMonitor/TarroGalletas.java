package TarroGalletasMonitor;

import java.util.*;

class misgalletas {
	
	public static int galletas=0; 
	
	
	public synchronized void comogalleta(){
		while (galletas==0){	
			
			try{
				//Me espero a q haya galletas
				
				wait();
			}
			catch (InterruptedException e) {
				System.err.println("Error en como galleta " + e.getMessage());
			}
		}
		//me como una galleta
		galletas--;
		
		}
	public synchronized void rellenotarro(){
		
		//Relleno el tarro
		galletas=10;
		//Despierto a todos los niños que estan esperando
		notifyAll();
	}
	
}

class nino extends Thread { 
	
	private misgalletas tarro;
	nino(int i,misgalletas tarro){
		this.setName("nino"+i);
		this.tarro=tarro;
		
	}
	public void run () {
		
		try{
			while(true) { //Los ninos siempre estarán comiendo galletas
				 //Aquí evitamos que dos procesos comprueben el número de galletas a la vez, ya que podría darse una falsa lectura
				sleep(10);
				System.out.println("soy el " + this.getName() +" voy a comer");
				
				tarro.comogalleta();
					
				System.out.println("soy el " + this.getName() + " y Me comi una galleta. Quedan " + tarro.galletas);

				
			}
		}  catch (InterruptedException e) {e.printStackTrace();}
	}
}

class mama extends Thread { 
	
	private misgalletas tarro;
	mama(misgalletas tarro){
		this.setName("mama");
		this.tarro=tarro;
	}
	public void run () {
		
			while(true)  {//La madre siempre esperando para reponer
				try{
					this.sleep(1000);
				} catch(InterruptedException e){}
				//La madre comprueba si se acaba el tarro
				if (tarro.galletas<=0){
					System.out.println("Soy " + this.getName() + "Voy a rellenar el tarro ");
					tarro.rellenotarro();
					
				}
				
				
			}
	}
}

public class TarroGalletas {

	private static nino a_ninos[];
	
	
	
	public static void main(String[] args) {
		
	
		int num_ninos= 40;
		misgalletas untarro=new misgalletas();
		
		a_ninos=new nino[num_ninos];
		
		System.out.println( "voy a lanzar los niños...");
		//Creando y lanzando niños
		for (int i=0;i<num_ninos;i++){
			a_ninos[i]= new nino(i+1, untarro);
			a_ninos[i].start();
		}
		//Creando y Lanzando a la Madre
		
		System.out.println(" Voy a lanzar a la mama...");
		mama mimama=new mama(untarro);
		mimama.start();
	}
}


