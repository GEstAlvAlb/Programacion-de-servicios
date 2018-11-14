import java.util.Random;

public class Sacardinero extends Thread {

	private Cuenta c;
	String nom;
	public Sacardinero(String n, Cuenta c) {
		super(n);
		this.c = c;
		
	}

	public void run() {
		Random rand =new Random();
		for (int x=1; x<=4 ;x++) {
			c.Retirardinero(rand.nextInt(10)+1, getName()); //run
		}
				
			
	}
	
}
