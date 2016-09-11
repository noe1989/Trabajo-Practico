package sarasa;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

public class Vent3 extends JDialog{
private Container contenedor;
JLabel labelTitulo;
  
public Vent3(Ventana miVentana2, boolean modal){

	/**Al llamar al constructor super(), le enviamos el
  * JFrame Padre y la propiedad booleana que determina
  * que es hija*/
  super(miVentana2, modal);
  contenedor=getContentPane();
  contenedor.setLayout(null);
  //Asigna un titulo a la barra de titulo

  
  labelTitulo= new JLabel();
  labelTitulo.setText("ACA VAN LOS JUGADORES");
  labelTitulo.setBounds(20, 20, 180, 23);
 
  contenedor.add(labelTitulo);
  //tamaño de la ventana
  setSize(350,150);
  //pone la ventana en el Centro de la pantalla
  setLocationRelativeTo(null);
 }
}
