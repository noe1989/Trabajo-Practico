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
import java.awt.Color;
import java.awt.Font;

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
		setBackground(new Color(102, 153, 204));
		
		JLabel lblModificarJugador = new JLabel("Modificar Jugador:");
		lblModificarJugador.setFont(new Font("Arial", Font.BOLD, 15));
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aplicar(frame, p);
			}
		});
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales:");
		lblPuntosTotales.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textPtsTotales = new JTextField();
		textPtsTotales.setEnabled(false);
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
		lblVida.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		lblEnergia.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEvasion = new JLabel("Evasion:");
		lblEvasion.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setFont(new Font("Arial", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModificarJugador)
						.addComponent(lblPuntosTotales)
						.addComponent(lblVida)
						.addComponent(lblEnergia)
						.addComponent(lblEvasion)
						.addComponent(lblDefensa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAplicar)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(214, Short.MAX_VALUE))
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
						.addComponent(lblVida)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnergia))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEvasion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDefensa))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosTotales)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(btnAplicar)
					.addContainerGap())
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
