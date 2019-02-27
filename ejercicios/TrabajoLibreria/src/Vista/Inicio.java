package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Inicio extends JFrame {

	private JPanel contentPane;
	public JTextField txNombre;
	public JTextField txContraseña;
	public JButton btConectar;
	private JLabel lblLibro;
	public JTextField txLibro;
	private JLabel lblPocoyo;

	
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txNombre = new JTextField();
		txNombre.setBounds(144, 58, 156, 20);
		contentPane.add(txNombre);
		txNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 61, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(44, 107, 73, 14);
		contentPane.add(lblNewLabel);
		
		txContraseña = new JTextField();
		txContraseña.setBounds(144, 104, 156, 20);
		contentPane.add(txContraseña);
		txContraseña.setColumns(10);
		
		btConectar = new JButton("Conectar");
		btConectar.setBounds(44, 227, 89, 23);
		contentPane.add(btConectar);
		
		lblLibro = new JLabel("Libro");
		lblLibro.setBounds(44, 153, 46, 14);
		contentPane.add(lblLibro);
		
		txLibro = new JTextField();
		txLibro.setBounds(144, 150, 156, 20);
		contentPane.add(txLibro);
		txLibro.setColumns(10);
		
		lblPocoyo = new JLabel("Pocoyo");
		lblPocoyo.setBounds(44, 189, 60, 14);
		contentPane.add(lblPocoyo);
		
		JLabel lblTerminathor = new JLabel("TerminaThor");
		lblTerminathor.setBounds(123, 189, 73, 14);
		contentPane.add(lblTerminathor);
		
		JLabel lblNewLabel_1 = new JLabel("Espidermon");
		lblNewLabel_1.setBounds(206, 189, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Voldemorrr");
		lblNewLabel_2.setBounds(289, 189, 65, 14);
		contentPane.add(lblNewLabel_2);
		
	}
}
