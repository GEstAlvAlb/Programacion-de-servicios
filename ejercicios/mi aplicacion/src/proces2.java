import java.io.*;

public class proces2 {
	public static void main(String args[]) throws IOException{
		ProcessBuilder pb= new ProcessBuilder("CMD");
				
				File fBat=new File("C:\\Users\\Alumnot\\Desktop\\programacion_de_servicios\\ejercicios\\bat_y_otros\\fichero.bat");
				File fOut=new File("C:\\Users\\Alumnot\\Desktop\\programacion_de_servicios\\ejercicios\\bat_y_otros\\salida.txt");
				File fErr=new File("C:\\Users\\Alumnot\\Desktop\\programacion_de_servicios\\ejercicios\\bat_y_otros\\error.txt");
				
				pb.redirectInput(fBat);
				pb.redirectOutput(fOut);
				pb.redirectError(fErr);
				pb.start();
	}
	
}
