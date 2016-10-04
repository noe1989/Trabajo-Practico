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
	private JTextField textVida;
	private JTextField textEnergia;
	private JTextField textEvasion;
	private JTextField textDefensa;
	private JTextField textPuntosRestantes;
	
	private int ptsTot;
	
	
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
		
		textVida = new JTextField();
		textVida.setColumns(10);
		textVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textEnergia = new JTextField();
		textEnergia.setColumns(10);
		textEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textEvasion = new JTextField();
		textEvasion.setColumns(10);
		textEvasion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textDefensa = new JTextField();
		textDefensa.setColumns(10);
		textDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = 200 - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		JLabel lblVida = new JLabel("Vida:");
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblPuntosRestantes = new JLabel("Puntos Restantes");
		
		textPuntosRestantes = new JTextField();
		textPuntosRestantes.setEditable(false);
		textPuntosRestantes.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(364, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(351, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(243)
					.addComponent(btnAplicar)
					.addContainerGap(292, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(405, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuntosRestantes))
					.addGap(109))
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
						.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVida))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblPuntosRestantes)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDefensa)
								.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPuntosTotales)
								.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addComponent(btnAplicar)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
		textVida.setText(String.valueOf(p.getVida()));
		textDefensa.setText(String.valueOf(p.getDefensa()));
		textEnergia.setText(String.valueOf(p.getEnergia()));
		textEvasion.setText(String.valueOf(p.getEvasion()));
		textPtsTotales.setText(String.valueOf(p.getPuntosTotales()));
		
		textPuntosRestantes.setText(String.valueOf(p.getPuntosTotales()- p.getVida() - p.getDefensa() - p.getEnergia() - p.getEvasion()));
		
		
	}
	
	public Personaje MapearJugadorDeFormulario(Personaje p){
		p.setPuntosTotales(Integer.parseInt(textPtsTotales.getText()));
		p.setDefensa(Integer.parseInt(textDefensa.getText()));
		p.setEnergia(Integer.parseInt(textEnergia.getText()));
		p.setEvasion(Integer.parseInt(textEvasion.getText()));
		p.setVida(Integer.parseInt(textVida.getText()));
		
		
		return p;
	}
}
