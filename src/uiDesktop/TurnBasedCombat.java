package uiDesktop;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.ControladorJuego;

import java.awt.CardLayout;

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
		setTitle("Turn Based Combat");
		
		ImageIcon img = new ImageIcon("img/barbaro.png");
		setIconImage(img.getImage());
		 
		setSize(530,400); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(cl);
		
		Panel1 p1 = new Panel1(this);
		
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
