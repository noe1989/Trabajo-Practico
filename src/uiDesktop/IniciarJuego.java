package uiDesktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entidades.Personaje;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class IniciarJuego extends JPanel {
	private JTextField txtJugador1;
	private JTextField textJugador2;


	/**
	 * Create the panel.
	 */
	public IniciarJuego(JFrame frame) {
		setBackground(new Color(153, 153, 153));
		
		JLabel lblTitulo = new JLabel("Seleccionar Personaje");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblVs = new JLabel("VS");
		
		txtJugador1 = new JTextField();
		txtJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugador1.setEditable(false);
		txtJugador1.setColumns(10);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		
		textJugador2 = new JTextField();
		textJugador2.setEditable(false);
		textJugador2.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarPersonajeDB(frame);
			}
		});
		
		JButton btnCrear = new JButton("Crear Nuevo");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearNuevoPersonaje(frame);
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(lblJugador1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(lblTitulo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(235)
							.addComponent(lblVs))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addComponent(btnSeleccionar)
							.addGap(18)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(215)
							.addComponent(lblJugador2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(192)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(btnContinuar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblJugador1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblVs)
					.addGap(18)
					.addComponent(lblJugador2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSeleccionar)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrear))
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addComponent(btnContinuar)
					.addContainerGap())
		);
		setLayout(groupLayout);

		
				
		
	}
	
	protected void seleccionarPersonajeDB(JFrame frame) {
		
		SeleccionarNuevoPersonajeDeDB selectPersonaje = new SeleccionarNuevoPersonajeDeDB(frame);
		
		((TurnBasedCombat) frame).cambiarPanel(selectPersonaje, "SeleccionarPersonajeDB");
		
	}

	private void crearNuevoPersonaje(JFrame frame){
		
		CrearNuevoPersonaje cnp = new CrearNuevoPersonaje(frame);
		
		((TurnBasedCombat) frame).cambiarPanel(cnp, "CrearNuevoPersonaje");
	}
	
	private void asignarPersonaje(Personaje personaje){
		
		//Acá asignamos cada personaje para cada jugador y mostramos el nombre en los TextFields
	}
}
