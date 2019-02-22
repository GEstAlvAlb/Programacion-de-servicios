package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import Servidor.Interface;
import Vista.Inicio;
import Vista.Vista;

public class Cliente implements ActionListener {

	static String nombre;
	static String contraseña;
	static String libro;

	static Interface inter;
	static Registry registry;
	static int pag;;
	public Cliente() {

	}

	public static void main(String[] args) {
			
			try {
			Inicio inicio = new Inicio();
			inicio.setVisible(true);
			registry = LocateRegistry.getRegistry("localhost", 8888);
			inter = (Interface) registry.lookup("Interface");

			inicio.btConectar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					nombre = inicio.txNombre.getText();
					contraseña = inicio.txContraseña.getText();
					libro = inicio.txLibro.getText();
				

					try {
						if (inter.conectar("Administrador", "1234")) {// todo volver a escribir
							Vista vista = new Vista();
							inicio.setVisible(false);
							vista.setVisible(true);
							vista.btnPagSigiente.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									List<String> lista;
									try{
										lista = inter.hoja(libro,pag);
										pag=Integer.parseInt(lista.get(lista.size()-1));
										System.out.println(lista);
										vista.textPane.setText(lista.get(0).toString() + "\n" + lista.get(1).toString()
												+ "\n" + lista.get(2).toString() + "\n" + lista.get(3).toString() + "\n"
												+ lista.get(4).toString());
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}
							});
							
							vista.btnPagAnterior.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									List<String> lista;
									try{
										lista = inter.hojaAnte(libro,pag);
										pag=Integer.parseInt(lista.get(lista.size()-1));
										System.out.println(lista);
										vista.textPane.setText(lista.get(0).toString() + "\n" + lista.get(1).toString()
												+ "\n" + lista.get(2).toString() + "\n" + lista.get(3).toString() + "\n"
												+ lista.get(4).toString());
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}
							});
							
							
							

						} else {
							System.out.println("me salgo");
							return;
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
