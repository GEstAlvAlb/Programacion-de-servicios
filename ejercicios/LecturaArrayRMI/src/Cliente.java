

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
	public static void main(String[] args) {
		Interfaz inter = null;
		int [] array;
		try {
			System.out.println("Localizando registro de objetos remotos...");
			Registry registry = LocateRegistry.getRegistry("localhost", 6666);
			inter = (Interfaz) registry.lookup("Interfaz");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (inter != null) {
			System.out.println("Realizando operaciones con el objeto remoto...");
			try {
				array=inter.leerTodo();
				for(int dato:array) {
					System.out.print(dato+", ");
				}
				System.out.println("\nLeer la posicion 1 "+ inter.lectura(1));
				System.out.println("cambiar el valor 2" + inter.escritura(2, 8));
				System.out.println("borrar el 3 " + inter.borrado(3));
				array=inter.leerTodo();
				for(int dato:array) {
					System.out.print(dato+", ");
				}

			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println("Terminado");
		}
	}
}
