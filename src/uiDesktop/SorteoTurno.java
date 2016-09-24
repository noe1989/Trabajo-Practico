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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				
				Boolean sale = true;
				
				int op1 = Integer.parseInt(textNroJugador1.getText());
				int op2 = Integer.parseInt(textNroJugador2.getText());
				
				System.out.println("Numero elegido A: "+op1);
				System.out.println("Numero elegido B: "+op2);
				
				Random rand = new Random();
				int aleatorio;
				
				do{
				
					aleatorio = rand.nextInt(5)+1; 
					System.out.println("Numero aleatorio: "+aleatorio);	
					
					if(op1 == aleatorio){
						int a = 1;	
						ctrl.setTurno(a);
						sale = false;
						System.out.println("Gano el jugador 1");
					}
					 else if(op2 == aleatorio){
						int b = 2;
						ctrl.setTurno(b);
						System.out.println("Gano el jugador 2");
						sale = false;
						}
					
				}while(sale);
				
				System.out.println("Comienza partida");
				
				play();
			}
		});
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

	
	
	public TurnBasedCombat getFrame() {
		return frame;
	}



	public void setFrame(TurnBasedCombat frame) {
		this.frame = frame;
	}



	private void play(){
		
		Play p = new Play();
		
		p.setCtrl(ctrl);
		
		p.turnoJugador();
		
		p.setFrame((TurnBasedCombat) frame);
		
		
		((TurnBasedCombat) frame).cambiarPanel(p, "Play");
		
	}
}