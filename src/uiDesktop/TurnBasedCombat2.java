package uiDesktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

public class TurnBasedCombat2 extends JFrame {

	public JPanel contentPane;
	private CardLayout cl = new CardLayout();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurnBasedCombat2 frame = new TurnBasedCombat2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TurnBasedCombat2() {
		
		ImageIcon img = new ImageIcon("img/barbaro.png");
		setIconImage(img.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(cl);
		
		Panel1 p1 = new Panel1(this);		
		contentPane.add(p1, "Panel1");
		
	

		
		
		
	}
	
	public void cambiarPanel(JPanel panel){
		
		System.out.println("Cambiar panel");
		
	
		
		
	}

}
