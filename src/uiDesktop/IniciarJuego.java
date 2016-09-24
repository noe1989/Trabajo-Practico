package uiDesktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import juego.ControladorJuego;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class IniciarJuego extends JPanel {

	private JTextField textJugador1;
	private JTextField textJugador2;

	private JButton btnSeleccionar;
	private JButton btnCrear;
	
	ControladorJuego ctrl;
	

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}

	public IniciarJuego(JFrame frame) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				actualizar();
			}
		});
		setBackground(new Color(102, 153, 204));
		
		JLabel lblTitulo = new JLabel("Seleccionar Personaje");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textJugador1 = new JTextField();
		textJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textJugador2 = new JTextField();
		textJugador2.setEditable(false);
		textJugador2.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Arial", Font.BOLD, 18));
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnSeleccionar.isEnabled()){
					seleccionarPersonajeDB(frame);
				}
				
			}
		});
		
		btnCrear = new JButton("Crear Nuevo");
		btnCrear.setFont(new Font("Arial", Font.BOLD, 18));
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnCrear.isEnabled()){
					crearNuevoPersonaje(frame);
				}
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Arial", Font.BOLD, 18));
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				continuar(frame);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(lblTitulo)
					.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(275)
					.addComponent(lblVs)
					.addContainerGap(296, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(btnSeleccionar)
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(106)
					.addComponent(btnCrear)
					.addGap(47))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(226)
					.addComponent(btnContinuar)
					.addContainerGap(247, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(244)
					.addComponent(lblJugador1)
					.addContainerGap(282, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(240)
							.addComponent(textJugador2)))
					.addGap(264))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(251)
					.addComponent(lblJugador2)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblJugador1)
					.addGap(32)
					.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblVs)
					.addGap(29)
					.addComponent(lblJugador2)
					.addGap(18)
					.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSeleccionar)
							.addComponent(btnCrear))
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(btnContinuar)
					.addGap(23))
		);
		setLayout(groupLayout);
		

		
				
		
	}
	
	private void seleccionarPersonajeDB(JFrame frame) {
		
		SeleccionarNuevoPersonajeDeDB selectPersonaje = new SeleccionarNuevoPersonajeDeDB(frame);
		
		selectPersonaje.setCtrl(ctrl);
		
		((TurnBasedCombat) frame).cambiarPanel(selectPersonaje, "SeleccionarPersonajeDB");
		
		
	
		
	}

	private void crearNuevoPersonaje(JFrame frame){
		
		CrearNuevoPersonaje cnp = new CrearNuevoPersonaje(frame);
		
		cnp.setCtrl(ctrl);
		
		((TurnBasedCombat) frame).cambiarPanel(cnp, "CrearNuevoPersonaje");
	}
	
	private void actualizar(){
		
		if(ctrl.getJugador1() != null){
			textJugador1.setText(String.valueOf(ctrl.getJugador1().getNombre()));
		}
		if(ctrl.getJugador2() != null){
				textJugador2.setText(String.valueOf(ctrl.getJugador2().getNombre()));
		}
		
		if(ctrl.getJugador1() != null && ctrl.getJugador2() != null){
			btnSeleccionar.setEnabled(false);
			btnCrear.setEnabled(false);
			
		}
		
	}
	
	public void continuar (JFrame frame){
	       
		PlayerSeleccionado ps = new PlayerSeleccionado(frame);
		ps.setCtrl(ctrl);
		((TurnBasedCombat) frame).cambiarPanel(ps, "PlayerSeleccionado");
		
	}
}
