package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.Personaje;
import juego.ControladorJuego;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ModificarJugador extends JPanel {

	private ControladorJuego ctrl;
	private JTextField textNombre;
	private JTextField textPtsTotales;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	
	
	public ControladorJuego getCtrl() {
		return ctrl;
	}


	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}


	public ModificarJugador(JFrame frame, Personaje p) {
		
		JLabel lblModificarJugador = new JLabel("Modificar Jugador:");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aplicar(frame, p);
			}
		});
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales:");
		
		textPtsTotales = new JTextField();
		textPtsTotales.setEditable(false);
		textPtsTotales.setColumns(10);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		
		JLabel lblVida = new JLabel("Vida:");
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		JLabel lblDefensa = new JLabel("Defensa:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModificarJugador)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblEvasion)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnergia)
										.addComponent(lblVida))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPuntosTotales)
										.addComponent(lblDefensa))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(243)
							.addComponent(btnAplicar)))
					.addContainerGap(305, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModificarJugador)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVida))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnergia))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEvasion))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPuntosTotales)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(btnAplicar)
					.addGap(38))
		);
		setLayout(groupLayout);
		
		MapearJugadorAFormulario(p);
		
	}
	
	public void aplicar(JFrame frame, Personaje p){
		
		p = MapearJugadorDeFormulario(p);
		ctrl.modificarPersonaje(p);
		
		((TurnBasedCombat) frame).cambiarAPanelExistente("PlayerSeleccionado");
		
	}
	
	public void MapearJugadorAFormulario(Personaje p){
		
		textNombre.setText(p.getNombre());
		txtVida.setText(String.valueOf(p.getVida()));
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		textPtsTotales.setText(String.valueOf(p.getPuntosTotales()));
		
	}
	
	public Personaje MapearJugadorDeFormulario(Personaje p){
		p.setPuntosTotales(Integer.parseInt(textPtsTotales.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setVida(Integer.parseInt(txtVida.getText()));
		
		
		return p;
	}
}
