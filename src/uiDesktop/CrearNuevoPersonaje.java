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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

@SuppressWarnings("serial")
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
		lblNuevoPersonaje.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNuevoPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCodigoId = new JLabel("Codigo ID:");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.LEFT);
		textID.setEditable(false);
		textID.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setColumns(10);
		
		JLabel lblPuntosDeBatalla = new JLabel("Puntos de Batalla");
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblVida = new JLabel("Vida:");
		
		textVida = new JTextField();
		textVida.setHorizontalAlignment(SwingConstants.LEFT);
		textVida.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia:");
		
		textEnergia = new JTextField();
		textEnergia.setHorizontalAlignment(SwingConstants.LEFT);
		textEnergia.setColumns(10);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		lblEvasion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		textDefensa = new JTextField();
		textDefensa.setHorizontalAlignment(SwingConstants.LEFT);
		textDefensa.setColumns(10);
		
		textEvasion = new JTextField();
		textEvasion.setHorizontalAlignment(SwingConstants.LEFT);
		textEvasion.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblPuntos = new JLabel("Pts. Restantes");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		JButton btnCrearPersonaje = new JButton("Crear Personaje");
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
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigoId)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(textVida, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
								.addComponent(textEnergia, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEvasion)
								.addComponent(lblDefensa))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEvasion, 0, 0, Short.MAX_VALUE))
							.addGap(24)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblPuntos)
									.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(44))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(255)
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(lblPuntos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
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
								.addComponent(separator_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
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
											.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(21)
					.addComponent(btnCrearPersonaje)
					.addGap(39))
		);
		setLayout(groupLayout);
		

	}
	
	private void crearPersonaje(JFrame frame){
		
		Personaje personaje = new Personaje();
		
		//personaje.setPuntosTotales(200) --> lo maneja el controlador
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
