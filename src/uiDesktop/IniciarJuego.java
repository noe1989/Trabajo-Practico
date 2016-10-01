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


@SuppressWarnings("serial")
public class IniciarJuego extends JPanel {

	private JTextField textJugador1;
	private JTextField textJugador2;

	private JButton btnSeleccionar;
	private JButton btnCrear;
	
	ControladorJuego ctrl;
	private JButton btnContinuar;
	

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
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblVs = new JLabel("VS");
		
		textJugador1 = new JTextField();
		textJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		
		textJugador2 = new JTextField();
		textJugador2.setEditable(false);
		textJugador2.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnSeleccionar.isEnabled()){
					seleccionarPersonajeDB(frame);
				}
				
			}
		});
		
		btnCrear = new JButton("Crear Nuevo");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnCrear.isEnabled()){
					crearNuevoPersonaje(frame);
				}
			}
		});
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnContinuar.isEnabled()){
					continuar(frame);
				}
				
			}
		});
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
								.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		
		btnContinuar.setEnabled(false);
		
				
		
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
			btnContinuar.setEnabled(true);
			
		}
		
	}
	
	public void continuar (JFrame frame){
	       
		PlayerSeleccionado ps = new PlayerSeleccionado(frame);
		ps.setCtrl(ctrl);
		((TurnBasedCombat) frame).cambiarPanel(ps, "PlayerSeleccionado");
		
	}
}
