package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidades.Personaje;
import juego.ControladorJuego;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.DataPersonaje;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CrearNuevoPersonaje extends JPanel {
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textVida;
	private JTextField textEnergia;
	private JTextField textDefensa;
	private JTextField textEvasion;
	private JTextField textField;
	
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
		lblNuevoPersonaje.setFont(new Font("Arial", Font.BOLD, 20));
		lblNuevoPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCodigoId = new JLabel("Código ID:");
		lblCodigoId.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textID = new JTextField();
		textID.setFont(new Font("Arial", Font.PLAIN, 15));
		textID.setEditable(false);
		textID.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		textNombre.setColumns(10);
		
		JLabel lblPuntosDeBatalla = new JLabel("Puntos de Batalla");
		lblPuntosDeBatalla.setFont(new Font("Arial", Font.BOLD, 15));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textVida = new JTextField();
		textVida.setFont(new Font("Arial", Font.PLAIN, 15));
		textVida.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energía:");
		lblEnergia.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textEnergia = new JTextField();
		textEnergia.setFont(new Font("Arial", Font.PLAIN, 15));
		textEnergia.setColumns(10);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEvasion = new JLabel("Evasión:");
		lblEvasion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEvasion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		textDefensa = new JTextField();
		textDefensa.setFont(new Font("Arial", Font.PLAIN, 15));
		textDefensa.setColumns(10);
		
		textEvasion = new JTextField();
		textEvasion.setFont(new Font("Arial", Font.PLAIN, 15));
		textEvasion.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblPuntos = new JLabel("Pts. Restantes:");
		lblPuntos.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.setFont(new Font("Arial", Font.BOLD, 18));
		btnCrearPersonaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearPersonaje(frame);
			}
		});
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
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigoId)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPuntosDeBatalla))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnergia)
										.addComponent(lblVida))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textEnergia, 0, 0, Short.MAX_VALUE)
										.addComponent(textVida, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEvasion)
								.addComponent(lblDefensa))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textDefensa, 0, 0, Short.MAX_VALUE)
								.addComponent(textEvasion, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
							.addGap(66)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(lblPuntos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(44))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoId)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblPuntosDeBatalla)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPuntos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida)
								.addComponent(lblDefensa)
								.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnergia)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblEvasion)
									.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
					.addComponent(btnCrearPersonaje)
					.addGap(39))
		);
		setLayout(groupLayout);
		
		/*DataPersonaje dbPersonaje = new DataPersonaje();
		
		textID.setText(String.valueOf(dbPersonaje.nuevoId()));*/

	}
	
	private void crearPersonaje(JFrame frame){
		
		Personaje personaje = new Personaje();
		
		personaje.setPuntosTotales(200);
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
	}
}
