package uiDesktop;

import javax.swing.JPanel;

import juego.ControladorJuego;
import juego.Partida;
import util.ApplicationException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import entidades.Personaje;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Play extends JPanel {

	private TurnBasedCombat frame;
	
	private Partida partida;
	
	public Partida getPartida() {
		return partida;
	}



	public void setPartida(Partida partida) {
		this.partida = partida;
	}



	

	public TurnBasedCombat getFrame() {
		return frame;
	}



	public void setFrame(TurnBasedCombat frame) {
		this.frame = frame;
	}





	private ControladorJuego ctrl;
	private JTextField textJugador1;
	private JTextField textJugador2;
	private JTextField textVidaJugador1;
	private JTextField textEnergiaJugador1;
	private JTextField textVidaJugador2;
	private JTextField textEnergiaJugador2;
	private JTextField textEstadoTurno1;
	private JTextField textEstadoTurno2;
	private JButton btnAtacarJugador2;
	private JLabel lblVidaJugador2;
	private JPanelBackground panel2;
	private JLabel lblEnergiaJugador2;
	private JButton btnDefenderJugador2;
	private JPanel panelJugador2;
	private JPanel panelJugador1;
	private JLabel lblVidaJugador1;
	private JLabel lblEnergiaJugador1;
	private JButton btnAtacarJugador1;
	private JButton btnDefenderJugador1;
	private JTextField textPtsAtaqueJug1;
	private JLabel lblPuntosDeAtaqueJug1;
	private JTextField textPtsAtaqueJug2;
	private JLabel lblPuntosDeAtaqueJug2;
	
	
	public ControladorJuego getCtrl() {
		return ctrl;
	}



	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}



	/**
	 * Create the panel.
	 */
	public Play() {
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				MapearJugador1(ctrl.getJugador1());
				MapearJugador2(ctrl.getJugador2());
				
				
			}
		});
		
		JLabel lblTurnBasedCombat = new JLabel("Turn Based Combat");
		lblTurnBasedCombat.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JSeparator separatorTitulo = new JSeparator();
		
		panelJugador1 = new JPanel();
		panelJugador1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panelJugador2 = new JPanel();
		panelJugador2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panelJugador2, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
								.addComponent(separatorTitulo, GroupLayout.PREFERRED_SIZE, 609, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblTurnBasedCombat, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addGap(208))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTurnBasedCombat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separatorTitulo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelJugador2, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(panelJugador1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		textJugador2 = new JTextField();
		textJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		textJugador2.setEditable(false);
		textJugador2.setColumns(10);
		
		panel2 = new JPanelBackground();
		panel2.setBackground("img/arquera.png");
		panel2.setOpaque(false);
		
		textVidaJugador2 = new JTextField();
		textVidaJugador2.setEditable(false);
		textVidaJugador2.setColumns(10);
		
		textEnergiaJugador2 = new JTextField();
		textEnergiaJugador2.setEditable(false);
		textEnergiaJugador2.setColumns(10);
		
		lblVidaJugador2 = new JLabel("Vida:");
		
		lblEnergiaJugador2 = new JLabel("Energ\u00EDa:");
		
		btnAtacarJugador2 = new JButton("Atacar");
		btnAtacarJugador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ptsAtaqueJug2=0;
				try {
					ptsAtaqueJug2 = Integer.parseInt(textPtsAtaqueJug2.getText());
				
					partida.atacar(ptsAtaqueJug2);
								
					MapearJugador1(ctrl.getJugador1());
					MapearJugador2(ctrl.getJugador2());
					
					
					if(ctrl.getJugador1().getVidaActual() <= 0){
						finJuego();					
					}else{
						//Despues de realizar todo, cambiar de panel
						ctrl.cambiarTurno();
						turnoJugador();
					}
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(null, "Por favor ingrese un número", 
							"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
				} catch (ApplicationException e1) {
					e1.errorPuntosDeAtaque();
				}
				
			}
		});
		
		btnDefenderJugador2 = new JButton("Defender");
		btnDefenderJugador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				partida.defender();
				MapearJugador2(ctrl.getJugador2());
				
				//Despues de realizar todo, cambiar de panel
				ctrl.cambiarTurno();
				turnoJugador();
			}
		});
		
		textEstadoTurno2 = new JTextField();
		textEstadoTurno2.setBackground(Color.WHITE);
		textEstadoTurno2.setEditable(false);
		textEstadoTurno2.setHorizontalAlignment(SwingConstants.CENTER);
		textEstadoTurno2.setColumns(10);
		
		textPtsAtaqueJug2 = new JTextField();
		textPtsAtaqueJug2.setColumns(10);
		
		lblPuntosDeAtaqueJug2 = new JLabel("Puntos de ataque: ");
		lblPuntosDeAtaqueJug2.setHorizontalAlignment(SwingConstants.LEFT);
		
		GroupLayout gl_panelJugador2 = new GroupLayout(panelJugador2);
		gl_panelJugador2.setHorizontalGroup(
			gl_panelJugador2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelJugador2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelJugador2.createSequentialGroup()
							.addGroup(gl_panelJugador2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVidaJugador2)
								.addComponent(textVidaJugador2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addGroup(gl_panelJugador2.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelJugador2.createSequentialGroup()
									.addComponent(lblEnergiaJugador2)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panelJugador2.createSequentialGroup()
									.addComponent(textEnergiaJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_panelJugador2.createSequentialGroup()
							.addComponent(btnAtacarJugador2)
							.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
							.addComponent(btnDefenderJugador2)
							.addContainerGap())))
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addGap(108)
					.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addGap(118)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(textEstadoTurno2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPtsAtaqueJug2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(231, Short.MAX_VALUE))
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPuntosDeAtaqueJug2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(192))
		);
		gl_panelJugador2.setVerticalGroup(
			gl_panelJugador2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJugador2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_panelJugador2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVidaJugador2)
						.addComponent(lblEnergiaJugador2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelJugador2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textVidaJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEnergiaJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(textEstadoTurno2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addComponent(lblPuntosDeAtaqueJug2)
					.addGap(18)
					.addComponent(textPtsAtaqueJug2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_panelJugador2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtacarJugador2)
						.addComponent(btnDefenderJugador2))
					.addContainerGap())
		);
		panelJugador2.setLayout(gl_panelJugador2);
		
		textJugador1 = new JTextField();
		textJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		JPanelBackground panel1 = new JPanelBackground();
		panel1.setBackground("img/mago.png");
		panel1.setOpaque(false);
		
		textVidaJugador1 = new JTextField();
		textVidaJugador1.setEditable(false);
		textVidaJugador1.setColumns(10);
		
		textEnergiaJugador1 = new JTextField();
		textEnergiaJugador1.setEditable(false);
		textEnergiaJugador1.setColumns(10);
		
		lblVidaJugador1 = new JLabel("Vida:");
		
		lblEnergiaJugador1 = new JLabel("Energ\u00EDa:");
		
		btnAtacarJugador1 = new JButton("Atacar");
		btnAtacarJugador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ptsAtaqueJug1 =0;
				try{
					ptsAtaqueJug1 = Integer.parseInt(textPtsAtaqueJug1.getText());
				
				
					partida.atacar(ptsAtaqueJug1);					
					MapearJugador1(ctrl.getJugador1());
					MapearJugador2(ctrl.getJugador2());
					
					
					if(ctrl.getJugador2().getVidaActual() <= 0){
						finJuego();
						
					}else{
						//Despues de realizar todo, cambiar de panel
						ctrl.cambiarTurno();
						turnoJugador();
					}
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(null, "Por favor ingrese un número", 
							"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
				}catch (ApplicationException e1) {
					e1.errorPuntosDeAtaque();
				}
				
				
			}
		});
		
		btnDefenderJugador1 = new JButton("Defender");
		btnDefenderJugador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				partida.defender();
				MapearJugador1(ctrl.getJugador1());

				
				//Despues de realizar todo, cambiar de panel
				ctrl.cambiarTurno();
				turnoJugador();
			}
		});
		
		textEstadoTurno1 = new JTextField();
		textEstadoTurno1.setBackground(Color.WHITE);
		textEstadoTurno1.setForeground(Color.BLACK);
		textEstadoTurno1.setEditable(false);
		textEstadoTurno1.setHorizontalAlignment(SwingConstants.CENTER);
		textEstadoTurno1.setColumns(10);
		
		textPtsAtaqueJug1 = new JTextField();
		textPtsAtaqueJug1.setColumns(10);
		
		lblPuntosDeAtaqueJug1 = new JLabel("Puntos \r\nde \r\nataque: ");
		lblPuntosDeAtaqueJug1.setHorizontalAlignment(SwingConstants.LEFT);
		
		GroupLayout gl_panelJugador1 = new GroupLayout(panelJugador1);
		gl_panelJugador1.setHorizontalGroup(
			gl_panelJugador1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelJugador1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelJugador1.createSequentialGroup()
							.addGroup(gl_panelJugador1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVidaJugador1)
								.addComponent(textVidaJugador1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addGroup(gl_panelJugador1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnergiaJugador1)
								.addComponent(textEnergiaJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelJugador1.createSequentialGroup()
							.addComponent(btnAtacarJugador1)
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addComponent(btnDefenderJugador1)))
					.addContainerGap())
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addGroup(gl_panelJugador1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(100))
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addGap(47)
					.addComponent(textEstadoTurno1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPtsAtaqueJug1, 0, 0, Short.MAX_VALUE)
					.addGap(218))
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPuntosDeAtaqueJug1, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(180))
		);
		gl_panelJugador1.setVerticalGroup(
			gl_panelJugador1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJugador1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_panelJugador1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVidaJugador1)
						.addComponent(lblEnergiaJugador1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelJugador1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textVidaJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEnergiaJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(textEstadoTurno1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(lblPuntosDeAtaqueJug1)
					.addGap(18)
					.addComponent(textPtsAtaqueJug1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_panelJugador1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtacarJugador1)
						.addComponent(btnDefenderJugador1))
					.addContainerGap())
		);
		panelJugador1.setLayout(gl_panelJugador1);
		setLayout(groupLayout);
		
		
		
		
	}
	
	
	
	public void MapearJugador1(Personaje p){
		
		textJugador1.setText(p.getNombre());
		textVidaJugador1.setText(String.valueOf(p.getVidaActual()));
		textEnergiaJugador1.setText(String.valueOf(p.getEnergiaActual()));

		
	}
	
	public void MapearJugador2(Personaje p){
		
		textJugador2.setText(p.getNombre());
		textVidaJugador2.setText(String.valueOf(p.getVidaActual()));
		textEnergiaJugador2.setText(String.valueOf(p.getEnergiaActual()));

		
	}
	
	private void setEnablePanel1(Boolean estado){
		if(estado){
			panelJugador1.setBackground(new Color(154, 220, 242));
			textEstadoTurno1.setBackground(Color.green);
			textEstadoTurno1.setText("TURNO");
		}else{
			panelJugador1.setBackground(new Color(238, 238, 238));
			textEstadoTurno1.setBackground(Color.red);
			textEstadoTurno1.setText("ESPERA");
		}
		
		btnAtacarJugador1.setEnabled(estado);
		btnDefenderJugador1.setEnabled(estado);
		
		lblVidaJugador1.setEnabled(estado);
		textVidaJugador1.setEnabled(estado);
		
		lblEnergiaJugador1.setEnabled(estado);
		textEnergiaJugador1.setEnabled(estado);
		
		textJugador1.setEnabled(estado);
		
		lblPuntosDeAtaqueJug1.setEnabled(estado);
		textPtsAtaqueJug1.setEnabled(estado);
		
	}
	
	private void setEnablePanel2(Boolean estado){
		
		if (estado){
			panelJugador2.setBackground(new Color(154, 220, 242));
			textEstadoTurno2.setBackground(Color.green);
			textEstadoTurno2.setText("TURNO");
		}else{
			panelJugador2.setBackground(new Color(238, 238, 238));
			textEstadoTurno2.setBackground(Color.red);
			textEstadoTurno2.setText("ESPERA");
		}
		
		btnAtacarJugador2.setEnabled(estado);
		btnDefenderJugador2.setEnabled(estado);
		
		lblVidaJugador2.setEnabled(estado);
		textVidaJugador2.setEnabled(estado);
		
		lblEnergiaJugador2.setEnabled(estado);
		textEnergiaJugador2.setEnabled(estado);
	
		textJugador2.setEnabled(estado);
		
		lblPuntosDeAtaqueJug2.setEnabled(estado);
		textPtsAtaqueJug2.setEnabled(estado);
	}
	
	public void turnoJugador(){
		int turno;
		
		if(partida.getTurno().getIdPersonaje()==ctrl.getJugador1().getIdPersonaje()){
			turno=1;
			
		}else{
			turno =2;
		}
		
		Boolean estado = true;
		
		switch (turno) {
	        case 1:  
	        	setEnablePanel1(estado);
	        	setEnablePanel2(!estado);
	            break;
	        case 2:
	        	setEnablePanel1(!estado);
	        	setEnablePanel2(estado);
				
	            break;
		}
	}
	
	private void finJuego(){
		JOptionPane.showMessageDialog(null, "Ganador Jugador: "+ partida.getTurno().getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
		
		partida.finJuego();
		
		frame.cambiarAPanelExistente("IniciarJuego");

	
	}
}
