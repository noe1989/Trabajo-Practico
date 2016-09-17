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

public class ModificarJugador extends JPanel {

	private ControladorJuego ctrl;
	private JTextField textNombre;
	private JTextField textPtsTotales;
	
	
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
		textPtsTotales.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPuntosTotales)
						.addComponent(lblModificarJugador))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAplicar)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModificarJugador)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosTotales)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(101)
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
		/*textVida.setText(String.valueOf(p.getVida()));
		textDef.setText(String.valueOf(p.getDefensa()));
		textEner.setText(String.valueOf(p.getEnergia()));
		textEva.setText(String.valueOf(p.getEvasion()));*/
		textPtsTotales.setText(String.valueOf(p.getPuntosTotales()));
		
	}
	
	public Personaje MapearJugadorDeFormulario(Personaje p){
		p.setPuntosTotales(Integer.parseInt(textPtsTotales.getText()));
		/*p.setDefensa(Integer.parseInt(textDefensa.getText()));
		p.setEnergia(Integer.parseInt(textEnergia.getText()));
		p.setEvasion(Integer.parseInt(textEvasion.getText()));
		p.setVida(Integer.parseInt(textVida.getText()));
		*/
		
		return p;
	}
}
