//package Servidor;
//
//import java.net.Socket;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import Objetos.Libro;
//
//public class HiloCliente extends Thread implements Interface {
//
//	ArrayList<Libro>idsLibros;
//	Socket scCliente;
//	
//	
//	public HiloCliente(Socket scCliente, ArrayList<Libro> idsLibros) {
//		this.idsLibros=idsLibros;
//		this.scCliente=scCliente;
//	}
//
//	@Override
//	public String hoja() throws RemoteException {
//		// TODO Auto-generated method stub
//		return idsLibros.get(0).toString();
//	}
//
//	@Override
//	public void salir() throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
