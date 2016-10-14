package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.Personaje;
import juego.ControladorJuego;
import util.ApplicationException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

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
	
	private int ptsTotalesJugador;
	
	
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
		textPtsTotales.setHorizontalAlignment(SwingConstants.CENTER);
		textPtsTotales.setEditable(false);
		textPtsTotales.setColumns(10);
		
		textVida = new JTextField();
		textVida.setHorizontalAlignment(SwingConstants.CENTER);
		textVida.setColumns(10);
		textVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = ptsTotalesJugador - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textEnergia = new JTextField();
		textEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		textEnergia.setColumns(10);
		textEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = ptsTotalesJugador - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textEvasion = new JTextField();
		textEvasion.setHorizontalAlignment(SwingConstants.CENTER);
		textEvasion.setColumns(10);
		textEvasion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = ptsTotalesJugador - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		textDefensa = new JTextField();
		textDefensa.setHorizontalAlignment(SwingConstants.CENTER);
		textDefensa.setColumns(10);
		textDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            	ptsTot = ptsTotalesJugador - Integer.parseInt(textVida.getText())- Integer.parseInt(textEnergia.getText())- Integer.parseInt(textDefensa.getText())- Integer.parseInt(textEvasion.getText());
            	
                textPuntosRestantes.setText(String.valueOf(ptsTot));
            }
        });
		
		JLabel lblVida = new JLabel("Vida:");
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblPuntosRestantes = new JLabel("Puntos Restantes");
		
		textPuntosRestantes = new JTextField();
		textPuntosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntosRestantes.setEditable(false);
		textPuntosRestantes.setColumns(10);
		
		JLabel lblMax = new JLabel("Max. 80");
		
		JLabel lblMax_1 = new JLabel("Max. 20");
		
		JLabel label = new JLabel("*Presione ENTER luego de completar cada campo");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModificarJugador)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblPuntosTotales)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblVida)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEnergia)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblDefensa)
											.addComponent(lblEvasion))))
								.addGap(1))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMax)
							.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
							.addComponent(lblPuntosRestantes))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMax_1)
							.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
							.addComponent(textPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(109))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(271)
					.addComponent(btnAplicar)
					.addContainerGap(340, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModificarJugador)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEvasion)
						.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuntosRestantes)
						.addComponent(lblMax))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMax_1))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosTotales)
						.addComponent(textPtsTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addComponent(btnAplicar)
					.addGap(18)
					.addComponent(label)
					.addGap(135))
		);
		setLayout(groupLayout);
		
		MapearJugadorAFormulario(p);
		ptsTotalesJugador = p.getPuntosTotales();
		
	}
	
	public void aplicar(JFrame frame, Personaje p){
		try{
			if (Integer.parseInt(textPuntosRestantes.getText()) >= 0){
				try{
					p = MapearJugadorDeFormulario(p);
					ctrl.modificarPersonaje(p);
					((TurnBasedCombat) frame).cambiarAPanelExistente("PlayerSeleccionado");
				}catch(ApplicationException e){
					e.errorDePuntajes();
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(null, "Por favor ingrese un número", 
							"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				throw (new ApplicationException());
			}
		}catch(ApplicationException e){
			e.excedeLimitePtsTotales();
		}
		
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
	
	public Personaje MapearJugadorDeFormulario(Personaje p) throws ApplicationException{
			p.setPuntosTotales(Integer.parseInt(textPtsTotales.getText()));
			p.setDefensa(Integer.parseInt(textDefensa.getText()));
			p.setEvasion(Integer.parseInt(textEvasion.getText()));
			p.setEnergia(Integer.parseInt(textEnergia.getText()));
			p.setVida(Integer.parseInt(textVida.getText()));
		
			return p;
	}
}
