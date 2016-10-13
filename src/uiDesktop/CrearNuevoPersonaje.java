package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidades.Personaje;
import juego.ControladorJuego;
import util.ApplicationException;

import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class CrearNuevoPersonaje extends JPanel {
	private JTextField textNombre;
	private JTextField textVida;
	private JTextField textEnergia;
	private JTextField textDefensa;
	private JTextField textEvasion;
	private JTextField textPuntosRestantes;
	
	private int ptsTot = 200;
	
	private ControladorJuego ctrl;
	
	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * Create the panel.
	 */
	public CrearNuevoPersonaje(JFrame frame) {
		setBackground(new Color(102, 153, 204));
		
		JLabel lblNuevoPersonaje = new JLabel("Nuevo Personaje");
		lblNuevoPersonaje.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNuevoPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setColumns(10);
		
		JLabel lblPuntosDeBatalla = new JLabel("Puntos de Batalla");
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblVida = new JLabel("Vida:");
		
		textVida = new JTextField("0");
		textVida.setHorizontalAlignment(SwingConstants.CENTER);
		textVida.setColumns(10);
		textVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		
		JLabel lblEnergia = new JLabel("Energia:");
		
		textEnergia = new JTextField("0");
		textEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		textEnergia.setColumns(10);
		textEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		lblEvasion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		textDefensa = new JTextField("0");
		textDefensa.setHorizontalAlignment(SwingConstants.CENTER);
		textDefensa.setColumns(10);
		textDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textEvasion = new JTextField("0");
		textEvasion.setHorizontalAlignment(SwingConstants.CENTER);
		textEvasion.setColumns(10);
		textEvasion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblPuntos = new JLabel("Pts. Restantes");
		lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textPuntosRestantes = new JTextField();
		textPuntosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntosRestantes.setColumns(10);
		textPuntosRestantes.setText(String.valueOf(ptsTot));
			
		
		
		JButton btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearPersonaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearPersonaje(frame);
			}
		});
		
		JLabel lblMax = new JLabel("Max. 20");
		
		JLabel lblMax_1 = new JLabel("Max. 80");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(185)
							.addComponent(lblNuevoPersonaje))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 625, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPuntosDeBatalla))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnergia)
								.addComponent(lblVida))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textVida, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
								.addComponent(textEnergia, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEvasion)
								.addComponent(lblDefensa))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textDefensa, 0, 0, Short.MAX_VALUE)
								.addComponent(textEvasion, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMax_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMax))
							.addGap(32)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textPuntosRestantes)
								.addComponent(lblPuntos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(244)
							.addComponent(btnCrearPersonaje)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNuevoPersonaje)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(124)
									.addComponent(lblPuntos)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblPuntosDeBatalla)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVida)
										.addComponent(lblDefensa)
										.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMax))
									.addGap(16)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnergia)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblEvasion)
											.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMax_1)))))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGap(8)
					.addComponent(btnCrearPersonaje)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	
		
	}
	
	private void crearPersonaje(JFrame frame){
		
		Personaje personaje = new Personaje();
		
		try{
			if(Integer.parseInt(textPuntosRestantes.getText()) >= 0){
			
				personaje.setDefensa(Integer.parseInt(textDefensa.getText()));
				personaje.setEnergia(Integer.parseInt(textEnergia.getText()));
				personaje.setEvasion(Integer.parseInt(textEvasion.getText()));
				personaje.setVida(Integer.parseInt(textVida.getText()));
				personaje.setNombre(textNombre.getText());
				
				ctrl.agregarPersonaje(personaje);
				
				if(ctrl.getJugador1() == null){
					ctrl.setJugador1(personaje);
				}else{
					ctrl.setJugador2(personaje);
				}
				
				((TurnBasedCombat) frame).cambiarAPanelExistente("IniciarJuego");
			}else{
				throw (new ApplicationException());
			}
		}catch(ApplicationException e){
			e.excedeLimitePtsTotales();
		}
	}
}
