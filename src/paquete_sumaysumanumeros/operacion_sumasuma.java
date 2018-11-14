package paquete_sumaysumanumeros;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class operacion_sumasuma {
	private int resultado;
	private int cuentaoperaciones;
	private Random aleatorio;
	private int temporal;
	
	//private Semaphore semaforo;
	
	operacion_sumasuma(){
		resultado=0;
		cuentaoperaciones=0;
		aleatorio=new Random();
		//semaforo=new Semaphore(1);
	}
	
	public void suma(){
		try{
			//semaforo.acquire();
			
			cuentaoperaciones++;
			temporal=resultado;
			
			Thread.sleep(aleatorio.nextInt(1));
			
			temporal=temporal+cuentaoperaciones;
			
			Thread.sleep(aleatorio.nextInt(1));
			
			resultado=temporal;
			
			//semaforo.release();
		} catch (InterruptedException e){}
	}
	
	public int get_resultado(){
		return resultado;
	}
	public int get_cuentaoperaciones(){
		try{
			Thread.sleep(aleatorio.nextInt(100));
		} catch (InterruptedException e){}
		return cuentaoperaciones;
	}
}
