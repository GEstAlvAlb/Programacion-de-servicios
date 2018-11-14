import java.io.*;
public class creaprocesocomandoDOS {
	public static void main(String[] args) {
		Runtime r =Runtime.getRuntime();
		String Comando="CMD /C DIR";
		Process p=null;
		try {
			p=r.exec(Comando);
			InputStream is=p.getInputStream(); //da la informacion del programa hijo al programa padre
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String linea;
			
			while((linea=br.readLine())!=null) //lee una linea y comprueba si tiene algo
				System.out.println(linea);
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		// comprobando error /0 bien /1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();// espera al hijo
			System.out.println("valor de Salida" + exitVal);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
