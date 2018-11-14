import java.util.concurrent.Semaphore;

public class EjecutaHilos extends Thread{
	
	private Semaphore sema;
	int id=0;
	
	public  EjecutaHilos(Semaphore s ) {
		this.sema=s;

	}
	public void run() {
		
		
		try {
			sleep(Ramdon());
			Objeto.ventana.escribecadena("Hay "+Objeto.contador_filas+"personas esperando en la fila\n");
			sleep(Ramdon());
			sema.acquire();
			Objeto.contador_personas++;
			Objeto.contador_filas--;
			Objeto.ventana2.escribecadena("Esperando en la sala interna de la cola"+Objeto.contador_personas+"\n");
			Objeto.ventana.escribecadena("Hay "+Objeto.contador_filas+"personas esperando en la fila\n");	
			if(Objeto.contador_personas==5) {	
				Objeto.contador_personas=Objeto.contador_personas - 5;
				sema.release(5);
				Objeto.ventana2.escribecadena("Salieron ya 5 personas.Pueden pasar las siguientes\n");
				sleep(Ramdon());
			}
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public int  Ramdon() {
		return (int) (Math.random()*2000+1);
	}
	public int  Ramdon2() {
		return (int) (Math.random()*400+1);
	}
}