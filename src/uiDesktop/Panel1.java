package uiDesktop;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;

import juego.ControladorJuego;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Panel1 extends JPanel {

	ControladorJuego ctrl;
	

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}
	
	
	public Panel1(JFrame frame) {
				
		this.setBackground(new Color(102, 153, 204));
		
		JLabel lblTurnBasedCombat = new JLabel("Turn Based Combat");
		lblTurnBasedCombat.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblTurnBasedCombat.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnInicarJuego = new JButton("Iniciar Juego");
		btnInicarJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iniciarJuego(frame);
				
			}
		});
		btnInicarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInicarJuego.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 556, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(280)
							.addComponent(btnInicarJuego))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(231)
							.addComponent(lblTurnBasedCombat)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTurnBasedCombat)
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(436)
					.addComponent(btnInicarJuego, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		setLayout(groupLayout);
		
	
	}

	
	private void iniciarJuego(JFrame frame){
		
		IniciarJuego init = new IniciarJuego(frame);
		init.setCtrl(ctrl);	
		
		((TurnBasedCombat) frame).cambiarPanel(init, "IniciarJuego");
		
		
		
	}
	
	
}
