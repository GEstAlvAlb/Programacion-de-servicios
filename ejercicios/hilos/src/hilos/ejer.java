package hilos;


import java.io.*;

public class ejer {
	public static final String RUTA = "C:\\Users\\Alumnot\\Desktop\\Usuarios\\";
	public static final String USU[] = { "Usuario1", "Usuario2", "Usuario3", "Usuario4", "Usuario5" };
	public static final int NUM_USU = 5;

	public static void main(String args[]) throws IOException, InterruptedException {
		ProcessBuilder pb[] = new ProcessBuilder[NUM_USU];
		File fOutUsu[] = new File[NUM_USU];
		File fErr[] = new File[NUM_USU];
		Process pr[] = new Process[NUM_USU];

		for (int i = 0; i <= NUM_USU - 1; i++) {

			pb[i] = new ProcessBuilder("cmd", "/C", "cd " + RUTA + USU[i] + "& dir");
			fOutUsu[i] = new File(RUTA + USU[i] + "salida.txt");
			fErr[i] = new File(RUTA + USU[i] + "error.txt");
			pb[i].redirectOutput(fOutUsu[i]);
			pb[i].redirectError(fErr[i]);
			pb[i].start();

		}

		for (int i = 0; i <= NUM_USU - 1; i++) {
			pr[i] = pb[i].start();
		}
		for (int i = 0; i <= NUM_USU - 1; i++) {
			pr[i].waitFor();
		}

		FileReader f[] = new FileReader[NUM_USU];
		BufferedReader linea[] = new BufferedReader[NUM_USU];
		String cadena = " ";
		try {
			for (int i = 0; i <= NUM_USU - 1; i++) {
				f[i] = new FileReader(RUTA + USU[i] + "salida.txt");
				linea[i] = new BufferedReader(f[i]);
				cadena = linea[i].readLine();
				while (cadena != null) {
					System.out.println(cadena);
					cadena = linea[i].readLine();
				}
				f[i].close();
				linea[i].close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
