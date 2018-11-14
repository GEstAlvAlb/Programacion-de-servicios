import java.util.*;
import java.util.concurrent.Semaphore;


public class TarroGalletas extends Thread {
	   public void main () {
	        int galletas=10;
	        Semaphore NoHayGalletas =new Semaphore(0);
	        Semaphore HayGalletas =new Semaphore(0);
	        Semaphore mutex =new Semaphore(1);
	     
	        Niño niños =new Niño(galletas,NoHayGalletas,HayGalletas,mutex);
	        Mama madre= new Mama(galletas,NoHayGalletas,HayGalletas,mutex);
	        
	        LanzarNiños()
	        LanzarMadre()
	    }

	private void LanzarNiños() {
		// TODO Auto-generated method stub
		
	}

	