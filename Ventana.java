package sarasa;

import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JDialog implements ActionListener{
		private Container contenedor;
		JLabel labelTitulo;
		 JButton crearJugador;
		 JButton elegirJugador;
		 private  Ventana ventana2;
		 
		public Ventana(VentanaPrincipal miVentanaPrincipal, boolean modal){
		 /**Al llamar al constructor super(), le enviamos el
		  * JFrame Padre y la propiedad booleana que determina
		  * que es hija*/
		  super(miVentanaPrincipal, modal);
		  contenedor=getContentPane();
		  contenedor.setLayout(null);
		   
		  labelTitulo= new JLabel();
		  labelTitulo.setText("VENTANA DE JUEGO");
		  labelTitulo.setBounds(90, 11, 180, 23);
		 
		  contenedor.add(labelTitulo);
		  
		  elegirJugador = new JButton();
		elegirJugador.setBounds(123, 33, 159, 23);
		elegirJugador.setText("ELEGIR JUGADOR");
		  elegirJugador.addActionListener(this);
		  getContentPane().add(elegirJugador);
		  
		  crearJugador = new JButton("CREAR JUGADOR");
		  crearJugador.setBounds(123, 93, 159, 23);
		  crearJugador.addActionListener(this);
		  getContentPane().add(crearJugador);
		  //tamaño de la ventana
		  setSize(426,183);
		  //pone la ventana en el Centro de la pantalla
		  setLocationRelativeTo(null);
		}
		public void actionPerformed(ActionEvent evento) {
		      if (evento.getSource()==elegirJugador)
		 {
		 Vent3 miVentana3=new Vent3(ventana2,true);
		  // ventana2.setVisible(false);
		 this.dispose();
		   miVentana3.setVisible(true);
		   }
		    if (evento.getSource()==crearJugador){
		    	CrearJugador vent4=new CrearJugador(ventana2,true);
		    	this.dispose();
		    	vent4.setVisible(true);
		    }
}}