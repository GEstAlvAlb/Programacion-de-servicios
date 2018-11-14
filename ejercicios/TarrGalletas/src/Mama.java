import java.util.concurrent.Semaphore;

public class Mama {
	private int galleta;
	private Semaphore noGalletas;
	private Semaphore hayGalletas;
	private Semaphore mutex;
	
	  public Mama(int galletas, Semaphore noHayGalletas, Semaphore hayGalletas, Semaphore mutex) {
	
		   galleta=galletas;
		   noGalleta=new noHayGalletas;
		   hayGalleta=new noHayGalletas;
		   mutex=new noHayGalletas;
		  
	  }

	public void run () {
	        while(true)              			//La madre siempre estará esperando para reponer el tarro
	        	noHayGalletas.acquire(); 		//Aquí se bloquea por que el semáforo "NoHayGalletas" está a 0
	        	mutex.acquire();
	            galletas=5;          	 		//Relleno el tarro de galletas
	        	mutex.release();      			//El semáforo mutex impide que 2 procesos comprueben la variable "galletas" a la vez <img class="emoji" draggable="false" alt="" src="https://s0.wp.com/wp-content/mu-plugins/wpcom-smileys/twemoji/2/svg/1f609.svg">
	        	hayGalletas.release(); 			//Aviso a los niños de que hay galletas poniendo a 1 el semáforo "HayGalletas"
	    }
}
}
