package uiDesktop;

import javax.swing.JPanel;

import juego.ControladorJuego;
import util.ApplicationException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SorteoTurno extends JPanel {
	
	private TurnBasedCombat frame;
	
	private ControladorJuego ctrl;
	private JTextField textNroJugador1;
	private JTextField textNroJugador2;
	
	public ControladorJuego getCtrl() {
		return ctrl;
	}



	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}



	/**
	 * Create the panel.
	 */
	public SorteoTurno() {
		

		
		JLabel lblSorteo = new JLabel("Sorteo de turno");
		lblSorteo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnSortear = new JButton("Sortear");
		btnSortear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int op1=0;
				int op2=0;
				
				try {
					op1 = Integer.parseInt(textNroJugador1.getText());
					op2 = Integer.parseInt(textNroJugador2.getText());
				
					if((op1>0 && op1<6) && (op2>0 && op2<6)){
						if(op1!=op2){
							
							ctrl.iniciarPartida();
		
							ctrl.sorteo(op1,op2);
						
							JOptionPane.showMessageDialog(null, "Comienza jugador: "+ ctrl.getPartida().getTurno().getNombre(), 
									"Sorteo", JOptionPane.INFORMATION_MESSAGE);
							play();
						}else{
							throw(new ApplicationException());
						}
					}else{
						throw(new ApplicationException());
					}
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(null, "Por favor ingrese un número", 
					"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
				}catch(ApplicationException e){
					e.fueraDeRango();
				}
				
		}});
		btnSortear.setFont(new Font("Arial", Font.BOLD, 18));
		
		textNroJugador1 = new JTextField();
		textNroJugador1.setColumns(10);
		
		textNroJugador2 = new JTextField();
		textNroJugador2.setColumns(10);
		
		JLabel lblJugador = new JLabel("Jugador 1:");
		
		JLabel lblJugador_1 = new JLabel("Jugador 2:");
		
		JLabel lblElijaUnNumero = new JLabel("Elija un numero de 1 a 5");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblJugador)
					.addGap(65)
					.addComponent(textNroJugador1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(lblJugador_1)
					.addGap(62)
					.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblElijaUnNumero)
						.addComponent(lblSorteo))
					.addGap(259))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(279)
					.addComponent(btnSortear)
					.addContainerGap(307, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSorteo)
					.addGap(18)
					.addComponent(lblElijaUnNumero)
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNroJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJugador)
						.addComponent(lblJugador_1))
					.addGap(203)
					.addComponent(btnSortear)
					.addContainerGap(213, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		

	}

	
	
	public TurnBasedCombat getFrame() {
		return frame;
	}



	public void setFrame(TurnBasedCombat frame) {
		this.frame = frame;
	}



	private void play(){
		
		Play p = new Play();
		
		p.setCtrl(ctrl);
		p.setPartida(ctrl.getPartida());
		p.turnoJugador();

		p.setFrame((TurnBasedCombat) frame);
		
		
		((TurnBasedCombat) frame).cambiarPanel(p, "Play");
		
	}
	
}