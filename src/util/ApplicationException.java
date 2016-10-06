package util;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{

	
	public ApplicationException(){
		super();
	}
	
	public void errorDePuntajes(){
		JOptionPane.showMessageDialog(null, "Puntos de Defensa y/o Evasión incorrectos.", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void errorPuntosDeAtaque(){
		JOptionPane.showMessageDialog(null, "Ingrese puntos de energía que no sean mayores que la energía restante.", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void errorNombrePersonaje(){
		JOptionPane.showMessageDialog(null, "Nombre ingresado ya existe. Por favor, ingrese otro.", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
