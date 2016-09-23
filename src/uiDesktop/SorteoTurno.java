package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.ControladorJuego;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Font;

public class SorteoTurno extends JPanel {
	
	ControladorJuego ctrl;
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
	public SorteoTurno(JFrame frame) {
		
		JLabel lblSorteo = new JLabel("Sorteo de turno");
		lblSorteo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnSortear = new JButton("Sortear");
		btnSortear.setFont(new Font("Arial", Font.BOLD, 18));
		btnSortear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Boolean sale = true;
				
				int op1 = Integer.parseInt(textNroJugador1.getText());
				int op2 = Integer.parseInt(textNroJugador2.getText());
				
				 
				
				do{
				Random rand = new Random();
				int aleatorio = rand.nextInt(5); 
				System.out.println(aleatorio);	
				 if(op1 == aleatorio){
						ctrl.setTurno(true);
						sale = false;
						System.out.println("aca1");
					}
				 else if(op2 == aleatorio){
							ctrl.setTurno(true);
						System.out.println("aca2");
						sale = false;
						}
				
				}while(sale);
				System.out.println("salio");
				/*play(frame);*/
			}
		});
		
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
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(lblJugador_1)
					.addGap(62)
					.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(213)
					.addComponent(btnSortear)
					.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(186)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSorteo)
						.addComponent(lblElijaUnNumero))
					.addContainerGap(260, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSorteo)
					.addGap(11)
					.addComponent(lblElijaUnNumero)
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNroJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJugador)
						.addComponent(lblJugador_1))
					.addGap(203)
					.addComponent(btnSortear)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		

	}

	
	
private void play(JFrame frame){
		
		Play play = new Play(frame);
		
		play.setCtrl(ctrl);
		
		((TurnBasedCombat) frame).cambiarPanel(play, "Play");
		
	}
}