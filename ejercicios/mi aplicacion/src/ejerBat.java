import java.io.*;
public class ejerBat{
	public static final String RUTA="C:\\Users\\Alumnot\\Desktop\\";
	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try{
			
			Process p = Runtime.getRuntime().exec(RUTA + "HolaMundo.bat");
			BufferedReader output = new	BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader error = 	new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String ligne = ""; 


			while((ligne = output.readLine()) != null){
				System.out.println(ligne); 
			}
			while((ligne = error.readLine()) != null) {
				System.out.println(ligne);
			}p.waitFor();
		} catch(IOException e) { e.printStackTrace();
		} catch(InterruptedException e) { e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
}