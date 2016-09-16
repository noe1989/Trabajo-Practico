package uiDesktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		
		
		this.setBackground(new Color(153, 153, 153));
		
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
		
		JPanelBackground panelFondoImg = new JPanelBackground();
		
		panelFondoImg.setBackground("img/barbaro.png");
		panelFondoImg.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(162)
							.addComponent(lblTurnBasedCombat))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(panelFondoImg, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(btnInicarJuego)
					.addGap(67))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblTurnBasedCombat)
					.addGap(8)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(panelFondoImg, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(111)
							.addComponent(btnInicarJuego, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(99))
		);
		setLayout(groupLayout);
		
	
	}

	
	private void iniciarJuego(JFrame frame){
		
		IniciarJuego init = new IniciarJuego(frame);
		init.setCtrl(ctrl);	
		
		((TurnBasedCombat) frame).cambiarPanel(init, "IniciarJuego");
		
		
		
	}
	
	
}
