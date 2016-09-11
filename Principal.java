package sarasa;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class Principal {
		 
		public static void main(String[] args) {
		/**Declaramos el objeto*/
		 VentanaPrincipal miVentanaPrincipal;
		 /**Instanciamos el objeto*/
		 miVentanaPrincipal= new VentanaPrincipal();
		 
		 /**Enviamos el objeto como parametro para que sea unico
		  * en toda la aplicación*/
		  miVentanaPrincipal.setVentanaPrincipal(miVentanaPrincipal);
		  
		 /**Hacemos que se cargue la ventana*/
		  miVentanaPrincipal.setVisible(true);

	}

}
