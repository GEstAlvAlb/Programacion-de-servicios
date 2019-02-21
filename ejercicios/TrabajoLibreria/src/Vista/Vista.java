package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextPane textPane;
	public JLabel lblNomLibro;
	public JButton btnPagSigiente;
	public JButton btnPagAnterior;
	public JButton btSalir;
	public JButton btSalDelLibro ;

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomLibro = new JLabel("New label");
		lblNomLibro.setBounds(24, 11, 197, 14);
		contentPane.add(lblNomLibro);
		
		btnPagSigiente = new JButton("Pagina Siguiente");
		btnPagSigiente.setBounds(509, 59, 132, 23);
		contentPane.add(btnPagSigiente);
		
		btnPagAnterior = new JButton("Pagina Anterior");
		btnPagAnterior.setBounds(509, 97, 132, 23);
		contentPane.add(btnPagAnterior);
		
		btSalir = new JButton("Salir");
		btSalir.setBounds(509, 396, 89, 23);
		contentPane.add(btSalir);
		
		btSalDelLibro = new JButton("Salir del libro");
		btSalDelLibro.setBounds(509, 131, 132, 23);
		contentPane.add(btSalDelLibro);
		
		textPane = new JTextPane();
		textPane.setBounds(24, 59, 461, 360);
		contentPane.add(textPane);
	}
}
