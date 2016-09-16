package uiDesktop;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class TurnBasedCombat extends JFrame {

	public JPanel contentPane;
	private CardLayout cl = new CardLayout();;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurnBasedCombat frame = new TurnBasedCombat();
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
	public TurnBasedCombat() {
		
		ImageIcon img = new ImageIcon("img/barbaro.png");
		setIconImage(img.getImage());
		 
		/*ImageIcon uno=new ImageIcon(this.getClass().getResource("img/fondoJuego.png")); 
		  JLabel fondo= new JLabel(); 
		  fondo.setIcon(uno); getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		  fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		  setSize(530,400); */
		setSize(530,400); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(cl);
		
		Panel1 p1 = new Panel1(this);		
		cl.addLayoutComponent(p1, "Panel1");
		contentPane.add(p1, "Panel1");
		
		cl.show(contentPane, "Panel1");
		


	}
	
	public void cambiarPanel(JPanel panel, String name){
		
		
		cl.addLayoutComponent(panel, name);
		contentPane.add(panel, name);
		cl.show(contentPane, name);
				
		
	}

	public void cambiarAPanelExistente(String name){
		
		cl.show(contentPane, name);
		
	}
}
