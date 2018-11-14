import java.util.concurrent.Semaphore;




public class PasesGrupos {

	public final static int PERSONAS=30;
	public static void main(String[]agrs) throws InterruptedException {
		Semaphore semaforo=new Semaphore(5);		EjecutaHilos[] hilos= new EjecutaHilos[PERSONAS];
		
		
		for(int i=0;i<PERSONAS;i++) {
			hilos[i]= new EjecutaHilos(semaforo);
			hilos[i].start();
			
			Objeto.contador_filas++;
			hilos[i].join((long) hilos[i].Ramdon2());
		}
		try {
			Thread.sleep(300);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		for(int i =0;i<PERSONAS;i++)
		{
			try {
				
				hilos[i].join();
				
			}
			catch(InterruptedException e){ e.printStackTrace();}
		}
		
	}
}
