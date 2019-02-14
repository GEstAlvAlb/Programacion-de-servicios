

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
	public int lectura(int a) throws RemoteException;

	public boolean escritura(int a,int b) throws RemoteException;

	public boolean borrado(int a) throws RemoteException;
	
	public int[] leerTodo()throws RemoteException ;


}