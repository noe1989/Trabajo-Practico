package uiDesktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

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

	/**
	 * Create the panel.
	 */
	public PlayerSeleccionado(JFrame frame) {
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JLabel lblVS = new JLabel("VS");
		lblVS.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		textJugador1 = new JTextField();
		textJugador1.setEnabled(false);
		textJugador1.setEditable(false);
		textJugador1.setColumns(10);
		
		textJugador2 = new JTextField();
		textJugador2.setEditable(false);
		textJugador2.setEnabled(false);
		textJugador2.setColumns(10);
		
		JLabel lblVida1 = new JLabel("Vida:");
		
		JLabel lblEnergia1 = new JLabel("Energ\u00EDa:");
		
		JLabel lblDefensa1 = new JLabel("Defensa:");
		
		JLabel lblEvasion1 = new JLabel("Evasi\u00F3n:");
		
		JLabel lblPtosTot1 = new JLabel("Puntos Totales:");
		
		JLabel lblVida2 = new JLabel("Vida:");
		
		JLabel lblEnergia2 = new JLabel("Energ\u00EDa:");
		
		JLabel lblDefensa2 = new JLabel("Defensa:");
		
		JLabel lblEvasion2 = new JLabel("Evasi\u00F3n:");
		
		JLabel lblPtosTot2 = new JLabel("Puntos Totales:");
		
		textVida1 = new JTextField();
		textVida1.setEditable(false);
		textVida1.setEnabled(false);
		textVida1.setColumns(10);
		
		textEner1 = new JTextField();
		textEner1.setEnabled(false);
		textEner1.setEditable(false);
		textEner1.setColumns(10);
		
		textDef1 = new JTextField();
		textDef1.setEditable(false);
		textDef1.setEnabled(false);
		textDef1.setColumns(10);
		
		textEva1 = new JTextField();
		textEva1.setEnabled(false);
		textEva1.setEditable(false);
		textEva1.setColumns(10);
		
		textPtosTot1 = new JTextField();
		textPtosTot1.setEnabled(false);
		textPtosTot1.setEditable(false);
		textPtosTot1.setColumns(10);
		
		textVida2 = new JTextField();
		textVida2.setEnabled(false);
		textVida2.setEditable(false);
		textVida2.setColumns(10);
		
		textEner2 = new JTextField();
		textEner2.setEnabled(false);
		textEner2.setEditable(false);
		textEner2.setColumns(10);
		
		textDef2 = new JTextField();
		textDef2.setEnabled(false);
		textDef2.setEditable(false);
		textDef2.setColumns(10);
		
		textEva2 = new JTextField();
		textEva2.setEnabled(false);
		textEva2.setEditable(false);
		textEva2.setColumns(10);
		
		textPtosTot2 = new JTextField();
		textPtosTot2.setEnabled(false);
		textPtosTot2.setEditable(false);
		textPtosTot2.setColumns(10);
		
		JButton btnModificar1 = new JButton("Modificar");
		
		JButton btnModificar2 = new JButton("Modificar");
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(86)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblJugador1)
										.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVida1)
										.addComponent(lblEnergia1)
										.addComponent(lblDefensa1)
										.addComponent(lblEvasion1)
										.addComponent(lblPtosTot1))
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textPtosTot1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textEva1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDef1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textEner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnModificar1)
							.addGap(68)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVS)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblJugador2)
									.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(101))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblVida2)
									.addComponent(lblEvasion2)
									.addComponent(lblDefensa2)
									.addComponent(lblEnergia2)
									.addComponent(lblPtosTot2))
								.addGap(30)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textPtosTot2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textEva2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textDef2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textEner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(26)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar2)
							.addGap(67))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(btnJugar)
					.addGap(206))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador1)
						.addComponent(lblJugador2)
						.addComponent(lblVS))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVida2)
								.addComponent(textVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textEner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDef2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEva2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPtosTot2)
								.addComponent(textPtosTot2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnModificar2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVida1)
								.addComponent(textVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergia1)
								.addComponent(textEner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDefensa1)
								.addComponent(textDef1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEvasion1)
								.addComponent(textEva1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textPtosTot1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPtosTot1))
							.addGap(18)
							.addComponent(btnModificar1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnJugar)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
