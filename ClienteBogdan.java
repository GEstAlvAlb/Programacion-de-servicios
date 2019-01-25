package temperaturas;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Cliente {

	public static void main(String[] args) {
		
		String host = "192.168.34.81";
		int puerto = 6000;
		
		try {
			Socket cliente = new Socket(host,puerto);
			PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(),
					true);
			
			Random rnd = new Random();
			
			int num=0;
			while(true) {
				num = rnd.nextInt(50)+1;
				fsalida.println(String.valueOf(num));
				Thread.sleep(1000);
			}						
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
