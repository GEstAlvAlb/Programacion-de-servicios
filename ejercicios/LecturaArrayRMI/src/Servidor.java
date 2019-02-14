import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Interfaz {

	int[] array = new int[] { 1, 23, 4, 56, 7, 54, 48, 1 };

	public int lectura(int a) throws RemoteException {

		return array[a - 1];

	}

	public boolean escritura(int a, int b) throws RemoteException {

		array[a] = b;

		return true;
	}

	public boolean borrado(int a) throws RemoteException {
		array[a] = 0;
		return true;
	}
	public int[] leerTodo() {
		return array;
		
		
	}
	

	public static void main(String[] args) {
		System.out.println("Creando el registro de objetos remotos...");
		Registry reg = null;
		try {
			reg = LocateRegistry.createRegistry(6666);
			// Puerto de ref. del objeto java
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		System.out.println("Creando el objeto servidor e inscribiendolo en el registro...");
		Servidor serverObject = new Servidor();
		try {
			reg.rebind("Interfaz", (Interfaz) UnicastRemoteObject.exportObject(serverObject, 0));
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
	}
}