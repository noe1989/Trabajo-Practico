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
		
		JLabel lblSorteo = new JLabel("Sorteo");
		
		JButton btnSortear = new JButton("Sortear");
		btnSortear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Boolean sale = false;
				
				int op1 = Integer.parseInt(textNroJugador1.getText());
				int op2 = Integer.parseInt(textNroJugador2.getText());
				
				Random rand = new Random();
				int aleatorio = rand.nextInt(5);  
				
				do{
					if(op1 == aleatorio){
						ctrl.setTurno(true);
						sale = true;
					}else{
						if(op2 == aleatorio){
							ctrl.setTurno(false);
							sale = true;
						}
					}
				
				}while(sale);
				
				play(frame);
			}
		});
		
		textNroJugador1 = new JTextField();
		textNroJugador1.setColumns(10);
		
		textNroJugador2 = new JTextField();
		textNroJugador2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addComponent(textNroJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
					.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(153))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(249)
							.addComponent(lblSorteo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addComponent(btnSortear)))
					.addContainerGap(307, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSorteo)
					.addGap(102)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNroJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNroJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(203)
					.addComponent(btnSortear)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		

	}

	
	
private void play(JFrame frame){
		
		Play play = new Play(frame);
		
		play.setCtrl(ctrl);
		
		((TurnBasedCombat) frame).cambiarPanel(play, "Play");
		
	}
}
