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
	
	private Boolean juegoNuevo = false;
	

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
				if(!juegoNuevo){
					actualizar();
				}else{
					jugarDeNuevo();
				}
			}
		});
		setBackground(new Color(102, 153, 204));
		
		JLabel lblTitulo = new JLabel("Seleccionar Personaje");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textJugador1 = new JTextField();
		textJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		
		textJugador2 = new JTextField();
		textJugador2.setHorizontalAlignment(SwingConstants.CENTER);
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(btnSeleccionar)
							.addGap(86)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
							.addComponent(btnCrear)
							.addGap(143))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(btnContinuar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(275)
							.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(274)
							.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(297)
							.addComponent(lblJugador1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(300)
							.addComponent(lblJugador2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(323)
							.addComponent(lblVs))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(236)
							.addComponent(lblTitulo)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblJugador1)
							.addGap(11)
							.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblVs, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblJugador2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSeleccionar)
								.addComponent(btnCrear))))
					.addGap(192)
					.addComponent(btnContinuar)
					.addGap(106))
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
		
		juegoNuevo = true;
		
	}
	
	private void jugarDeNuevo(){
		
		textJugador1.setText(null);
		textJugador2.setText(null);
		
		btnSeleccionar.setEnabled(true);
		btnCrear.setEnabled(true);
		btnContinuar.setEnabled(false);
		
		actualizar();
	}
}
