package sarasa;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener {
	 
private Container contenedor;/**declaramos el contenedor*/
JButton botonCambiar;/**declaramos el objeto Boton*/
JLabel labelTitulo;/**declaramos el objeto Label*/
JSeparator separador;

private VentanaPrincipal miVentanaPrincipal;
 
public VentanaPrincipal(){
	  
  setIconImage(new ImageIcon(getClass().getResource("/sarasa/icono2.png")).getImage());
  ((JPanel)getContentPane()).setOpaque(false); 
  ImageIcon uno=new ImageIcon(this.getClass().getResource("/sarasa/imd.png")); 
  JLabel fondo= new JLabel(); 
  fondo.setIcon(uno); getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
  fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
  setSize(601,520);
  iniciarComponentes();
   
  setLocationRelativeTo(null);
}
 
//@param miVentana
 // Enviamos una instancia de la ventana principal
 
public void setVentanaPrincipal(VentanaPrincipal miVentana) {
   miVentanaPrincipal=miVentana;
}
 
private void iniciarComponentes() {
  contenedor=getContentPane();/**instanciamos el contenedor*/
  /**con esto definmos nosotros mismos los tamaños y posicion
   * de los componentes*/
  contenedor.setLayout(null);
  
  /**Propiedades del boton, lo instanciamos, posicionamos y
   * activamos los eventos*/
  
  botonCambiar= new JButton();
  botonCambiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
  botonCambiar.setBackground(SystemColor.activeCaption);
  botonCambiar.setHorizontalAlignment(SwingConstants.LEFT);
  botonCambiar.setText("Iniciar Juego");
  botonCambiar.setBounds(450, 315, 125, 57);
  botonCambiar.addActionListener(this);
  
  /**Propiedades del Label, lo instanciamos, posicionamos y
   * activamos los eventos*/
  labelTitulo= new JLabel();
  labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
  labelTitulo.setForeground(Color.BLUE);
  labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
  labelTitulo.setText("Turn Based Combat");
  labelTitulo.setBounds(117, 11, 318, 33);
  
  separador = new JSeparator();
  separador.setBounds(37, 55, 504, 2);
  getContentPane().add(separador);
   
  /**Agregamos los componentes al Contenedor*/
  contenedor.add(labelTitulo);
  contenedor.add(botonCambiar);
  
   }
  /**Agregamos el evento al momento de llamar la otra ventana*/
  @Override
  public void actionPerformed(ActionEvent evento) {
      if (evento.getSource()==botonCambiar)
 {
          /*enviamos la instancia de la ventana principal para que
          * esta sea Padre de la ventana de dialogo*/
   Ventana miVentanaConfirmacion=new Ventana(miVentanaPrincipal,true);
   miVentanaPrincipal.setVisible(false);
   miVentanaConfirmacion.setVisible(true);
   
 }
    }
}


