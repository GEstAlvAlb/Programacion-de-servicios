package Cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.Interfaz;

public class Cliente {
	public static void main(String[] args) {
		Interfaz calc = null;
		try {
			System.out.println("Localizando registro de objetos remotos...");
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			calc = (Interfaz) registry.lookup("Interfaz");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (calc != null) {
			System.out.println("Realizando operaciones con el objeto remoto...");
			try {
				System.out.println("2 + 2 = " + calc.suma(2, 2));
				System.out.println("99 - 45 = " + calc.resta(99, 45));
				System.out.println("125 * 3 = " + calc.multip(125, 3));
				System.out.println("1250 / 5 = " + calc.div(1250, 5));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println("Terminado");
		}
	}
}
