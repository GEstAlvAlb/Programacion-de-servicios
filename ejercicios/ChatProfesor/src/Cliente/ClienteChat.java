package Cliente;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteChat extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Socket socket = null;
	// Preparar Streams
	DataInputStream fentrada; // para mensajes de todos
	DataOutputStream fsalida; // para escribir los mensajes
	String nombre;
	static JTextField mensaje = new JTextField();
	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	JButton boton = new JButton("Enviar");
	JButton desconectar = new JButton("Salir");
	boolean repetir = true;
	
	// Constructor recibe el socket creado y el nombre del cliente
	public ClienteChat(Socket s, String nombre) {
		super(" CONEXION DEL CLIENTE CHAT; " + nombre);
		setLayout(null);
		mensaje.setBounds(10,10,400,30);
		add(mensaje);
		textarea1= new JTextArea();
		scrollpane1=new JScrollPane(textarea1);
		scrollpane1.setBounds(10,50,400,300);
		add(scrollpane1);
		boton.setBounds(420,10,100,30);
		add(boton);
		desconectar.setBounds(420,50,100,30);
		add(desconectar);
		textarea1.setEditable(false);
		boton.addActionListener(this);
		desconectar.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		socket=s;
		this.nombre = nombre;
		
		//crear flujos de E y S. 
		try{
			fentrada = new DataInputStream(socket.getInputStream());
			fsalida = new DataOutputStream(socket.getOutputStream());
			String texto = " > Entra en el Chat ... "+ nombre;
			fsalida.writeUTF(texto); // escribe mensaje de entrada
		} catch (IOException e) {
			System.out.println ("ERROR DE E/S");
			e.printStackTrace();
			System.exit(0);
		}
	} // fin constructor
	
	//al pulsar el boton enviar se envia al flujo de salida el mensaje escrito
	
	//accion cuando se pulsan botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) { //se pulsa el boton Enviar
			String texto= nombre + " > " + mensaje.getText();
			try{
				mensaje.setText("");; // se limpia area de mensaje
				fsalida.writeUTF(texto);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} // fin if
		
		// si se pulsa salir primero se envia mensaje de abandono de chat
		if (e.getSource() == desconectar) { // se pulsa el boton Salir
			String texto = " > Abandona el Chat ..." + nombre;
			try {
				fsalida.writeUTF(texto);
				fsalida.writeUTF("*");
				repetir = false; // para salir del bucle
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}//fin if
	} //fin action
	
	//metodo ejecutar. el cliente lee lo que le envia el hilo y lo muestra en textarea
	public void ejecutar(){
		String texto = "";
		while (repetir) {
			try{
				texto = fentrada.readUTF(); // lee los mensajes
				textarea1.setText(texto); //visualiza mensajes
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR \n" + e.getMessage(),"<<MENSAJE DE ERROR:2>>",JOptionPane.ERROR_MESSAGE);
				repetir=false; // salir del bucle
				
			}
		} //fin while
		try {
			socket.close(); //cerrar socket
			System.exit(0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // fin ejecutar
	
	// en main se pide nombre de usuario, se realiza la conexión y se crea el objeto clientechat
	// arranca ejecutar
	
	public static void main(String[] args) {
		int puerto = 44444;
		String nombre = JOptionPane.showInputDialog("Introduce tu Nick: ");
		Socket s = null;
		try {
			s = new Socket("localhost",puerto);
			
		} catch (IOException e){
			JOptionPane.showMessageDialog(null,  "IMPOSIBLE CONECTAR AL SERVIDOR \n "+ e.getMessage(),"<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if(!nombre.trim().equals("")) { //hay que escribir algo
			ClienteChat cliente = new ClienteChat(s,nombre);
			cliente.setBounds(0,0,540,400);
			cliente.setVisible(true);
			cliente.ejecutar();
			
		} else {
			System.out.println("El nombre esta vacio ...");
		}
	}// fin main

} // Cliente Chat