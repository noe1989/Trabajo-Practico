package uiDesktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class IniciarJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	public IniciarJuego() {
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JLabel lblHolaMundo = new JLabel("Hola Mundo");
		lblHolaMundo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(lblHolaMundo)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHolaMundo)
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		setLayout(groupLayout);

		
		
		
		
	}
}
