package uiDesktop;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.ControladorJuego;

import java.awt.CardLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class TurnBasedCombat extends JFrame {

	public JPanel contentPane;
	private CardLayout cl = new CardLayout();
	
	private ControladorJuego ctrl= new ControladorJuego();

	
	
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

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}

	public TurnBasedCombat() {
		setResizable(false);
				
		
		setIconImage(new ImageIcon("img/barbaro.png").getImage());
		  ((JPanel)getContentPane()).setOpaque(false); 
		  ImageIcon uno=new ImageIcon("img/imd.png"); 
		  JLabel fondo= new JLabel(); 
		  fondo.setIcon(uno); getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		  fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		this.setLocationRelativeTo(null);
		
		 setTitle("Turn Based Combat");
		
		setSize(682,602); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(cl);
		
		Panel1 p1 = new Panel1(this);
		p1.setBackground(new Color(102, 153, 204));
		
		p1.setCtrl(ctrl);
		
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
