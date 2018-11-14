package paquete_sumaysumanumeros;

import java.util.Random;

public class hilo_operacion extends Thread {
	
	private static final int maximo=10;
	operacion_sumasuma haz_calculos;
	
	hilo_operacion(int op,operacion_sumasuma calculos){
		this.setName("suma"+op);
		haz_calculos=calculos;
	}
	
	public void run(){
		
		Random aleatorio=new Random();
		try{

			for (int i=0;i<maximo;i++){
				haz_calculos.suma();
				sleep(aleatorio.nextInt(1));	
				System.out.println("Resultado vale: "+haz_calculos.get_resultado() + "cuenta operaciones vale: "+ haz_calculos.get_cuentaoperaciones());
			}
		}catch (InterruptedException e){}
	}
	
}
