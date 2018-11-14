

import java.awt.TextArea;

import javax.swing.JFrame;

class Ventanas{
	private JFrame ventana=new JFrame();
	private TextArea texto_ventana=new TextArea();
	Ventanas(String nombre){
		ventana.setName(nombre);
		ventana.setTitle(nombre);
		ventana.setSize(400, 900);
		ventana.setVisible(true);
		ventana.add(texto_ventana);
	}
	public void escribecadena(String cadena){
		texto_ventana.setText(texto_ventana.getText() + cadena);
	}
}
