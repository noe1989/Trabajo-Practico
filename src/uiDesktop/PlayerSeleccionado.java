package uiDesktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;


import entidades.Personaje;
import juego.ControladorJuego;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PlayerSeleccionado extends JPanel {
	private JTextField textJugador1;
	private JTextField textJugador2;
	private JTextField textVida1;
	private JTextField textEner1;
	private JTextField textDef1;
	private JTextField textEva1;
	private JTextField textPtosTot1;
	private JTextField textVida2;
	private JTextField textEner2;
	private JTextField textDef2;
	private JTextField textEva2;
	private JTextField textPtosTot2;
	
	private ControladorJuego ctrl;

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * Create the panel.
	 */
	public PlayerSeleccionado(JFrame frame) {
		setBackground(new Color(102, 153, 204));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				MapearJugador1(ctrl.getJugador1());
				MapearJugador2(ctrl.getJugador2());
			}
		});
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblVS = new JLabel("VS");
		lblVS.setFont(new Font("Arial", Font.BOLD, 18));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		textJugador1 = new JTextField();
		textJugador1.setFont(new Font("Arial", Font.BOLD, 13));
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		textJugador2 = new JTextField();
		textJugador2.setFont(new Font("Arial", Font.BOLD, 13));
		textJugador2.setEditable(false);
		textJugador2.setColumns(10);
		
		JLabel lblVida1 = new JLabel("Vida:");
		lblVida1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEnergia1 = new JLabel("Energ\u00EDa:");
		lblEnergia1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblDefensa1 = new JLabel("Defensa:");
		lblDefensa1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEvasion1 = new JLabel("Evasi\u00F3n:");
		lblEvasion1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblPtosTot1 = new JLabel("Puntos Totales:");
		lblPtosTot1.setBackground(new Color(102, 153, 204));
		lblPtosTot1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblVida2 = new JLabel("Vida:");
		lblVida2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEnergia2 = new JLabel("Energ\u00EDa:");
		lblEnergia2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblDefensa2 = new JLabel("Defensa:");
		lblDefensa2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblEvasion2 = new JLabel("Evasi\u00F3n:");
		lblEvasion2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblPtosTot2 = new JLabel("Puntos Totales:");
		lblPtosTot2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textVida1 = new JTextField();
		textVida1.setFont(new Font("Arial", Font.PLAIN, 11));
		textVida1.setEditable(false);
		textVida1.setColumns(10);
		
		textEner1 = new JTextField();
		textEner1.setFont(new Font("Arial", Font.PLAIN, 11));
		textEner1.setEditable(false);
		textEner1.setColumns(10);
		
		textDef1 = new JTextField();
		textDef1.setFont(new Font("Arial", Font.PLAIN, 11));
		textDef1.setEditable(false);
		textDef1.setColumns(10);
		
		textEva1 = new JTextField();
		textEva1.setFont(new Font("Arial", Font.PLAIN, 11));
		textEva1.setEditable(false);
		textEva1.setColumns(10);
		
		textPtosTot1 = new JTextField();
		textPtosTot1.setFont(new Font("Arial", Font.PLAIN, 11));
		textPtosTot1.setEditable(false);
		textPtosTot1.setColumns(10);
		
		textVida2 = new JTextField();
		textVida2.setFont(new Font("Arial", Font.PLAIN, 11));
		textVida2.setEditable(false);
		textVida2.setColumns(10);
		
		textEner2 = new JTextField();
		textEner2.setFont(new Font("Arial", Font.PLAIN, 11));
		textEner2.setEditable(false);
		textEner2.setColumns(10);
		
		textDef2 = new JTextField();
		textDef2.setFont(new Font("Arial", Font.PLAIN, 11));
		textDef2.setEditable(false);
		textDef2.setColumns(10);
		
		textEva2 = new JTextField();
		textEva2.setFont(new Font("Arial", Font.PLAIN, 11));
		textEva2.setEditable(false);
		textEva2.setColumns(10);
		
		textPtosTot2 = new JTextField();
		textPtosTot2.setFont(new Font("Arial", Font.PLAIN, 11));
		textPtosTot2.setEditable(false);
		textPtosTot2.setColumns(10);
		
		JButton btnModificar1 = new JButton("Modificar");
		btnModificar1.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarJugador(frame, ctrl.getJugador1());
			}
		});
		btnModificar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnModificar2 = new JButton("Modificar");
		btnModificar2.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarJugador(frame, ctrl.getJugador2());

			}
		});
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sorteo(frame);
			}
		});
		btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(43, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(65)
										.addComponent(lblJugador1))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(21)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblVida1)
											.addComponent(lblEnergia1)
											.addComponent(lblDefensa1)
											.addComponent(lblEvasion1)
											.addComponent(lblPtosTot1))
										.addGap(23)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textPtosTot1, 0, 0, Short.MAX_VALUE)
											.addComponent(textEva1, 0, 0, Short.MAX_VALUE)
											.addComponent(textVida1, 0, 0, Short.MAX_VALUE)
											.addComponent(textDef1, 0, 0, Short.MAX_VALUE)
											.addComponent(textEner1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))))
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(40)
								.addComponent(btnModificar1)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblVS)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVida2)
										.addComponent(lblEvasion2)
										.addComponent(lblDefensa2)
										.addComponent(lblEnergia2)
										.addComponent(lblPtosTot2))
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textVida2, 0, 0, Short.MAX_VALUE)
										.addComponent(textEner2, 0, 0, Short.MAX_VALUE)
										.addComponent(textDef2, 0, 0, Short.MAX_VALUE)
										.addComponent(textEva2, 0, 0, Short.MAX_VALUE)
										.addComponent(textPtosTot2, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
									.addGap(55))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblJugador2))
									.addGap(99)))
							.addGap(10))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar2)
							.addGap(62))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(231)
					.addComponent(btnJugar)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJugador2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVida2)
								.addComponent(textVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEnergia2)
								.addComponent(textEner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDef2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEva2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion2))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPtosTot2)
								.addComponent(textPtosTot2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addComponent(btnModificar2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJugador1)
								.addComponent(lblVS))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(39)
											.addComponent(lblVida1)
											.addGap(18)
											.addComponent(lblEnergia1)
											.addGap(18)
											.addComponent(lblDefensa1)
											.addGap(18)
											.addComponent(lblEvasion1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(31)
											.addComponent(textVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textEner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textDef1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textEva1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textPtosTot1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPtosTot1))))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnModificar1)
									.addGap(9))
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnJugar)
					.addGap(64))
		);
		setLayout(groupLayout);
		
		

	}
	
	
	public void MapearJugador1(Personaje p){
		
		textJugador1.setText(p.getNombre());
		textVida1.setText(String.valueOf(p.getVida()));
		textDef1.setText(String.valueOf(p.getDefensa()));
		textEner1.setText(String.valueOf(p.getEnergia()));
		textEva1.setText(String.valueOf(p.getEvasion()));
		textPtosTot1.setText(String.valueOf(p.getPuntosTotales()));
		
	}
	
	public void MapearJugador2(Personaje p){
		
		textJugador2.setText(p.getNombre());
		textVida2.setText(String.valueOf(p.getVida()));
		textDef2.setText(String.valueOf(p.getDefensa()));
		textEner2.setText(String.valueOf(p.getEnergia()));
		textEva2.setText(String.valueOf(p.getEvasion()));
		textPtosTot2.setText(String.valueOf(p.getPuntosTotales()));
		
	}
	
	public void modificarJugador(JFrame frame, Personaje p){
		
		ModificarJugador mj = new ModificarJugador(frame,p);
		mj.setCtrl(ctrl);	
		
		((TurnBasedCombat) frame).cambiarPanel(mj, "ModificarJugador");
		
	}
	
	private void sorteo(JFrame frame){
		
		SorteoTurno sorteo = new SorteoTurno();
		
		sorteo.setFrame((TurnBasedCombat) frame);
		sorteo.setCtrl(ctrl);
		
		((TurnBasedCombat) frame).cambiarPanel(sorteo, "Sorteo");
		
	}
	
}
