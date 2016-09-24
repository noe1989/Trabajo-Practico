package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.JTable;

import database.DataPersonaje;
import entidades.Personaje;
import juego.ControladorJuego;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class SeleccionarNuevoPersonajeDeDB extends JPanel {
	
	
	ControladorJuego ctrl;
	

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}
	
	private JList<String> list;
	private JTable table;
	private DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	
	public SeleccionarNuevoPersonajeDeDB(JFrame frame) {
		setBackground(new Color(102, 153, 204));
		JLabel lblSeleccionarPersonajeExistente = new JLabel("Seleccionar Personaje Existente");
		lblSeleccionarPersonajeExistente.setFont(new Font("Arial", Font.BOLD, 20));
		
		JSeparator separator = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Arial", Font.BOLD, 18));
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int idSeleccionado = Integer.parseInt(String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 0)));
				
				seleccionarPersonaje(frame, idSeleccionado);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(btnSeleccionar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(lblSeleccionarPersonajeExistente)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblSeleccionarPersonajeExistente)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(132)
					.addComponent(btnSeleccionar)
					.addGap(71))
		);
		
		
		setLayout(groupLayout);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		llenarTabla();
		
				

	}
	
	
	private void llenarTabla(){
		   
		DataPersonaje dbPersonaje = new DataPersonaje();
		
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Puntos Totales");
	
		
		try {
	        ResultSet rs = dbPersonaje.gridPersonajes(); 
	        
	        while(rs.next()){
	        	
	        	int id = rs.getInt("idPersonaje");
	        	String nombre = rs.getString("nombre");
	        	int ptsTotales = rs.getInt("puntosTotales");
	        	
	        	Object [] fila = new Object[3];
	        	fila[0] = id;
	        	fila[1] = nombre;
	        	fila[2] = ptsTotales;
	        	
	        	modeloTabla.addRow(fila);
	        }
	        
	        table.setModel(modeloTabla);

	        

	    } catch (SQLException e) {
	      
	    	e.printStackTrace();
	    }
	}
	
	private void seleccionarPersonaje(JFrame frame, int idSeleccionado){
		
		Personaje p = ctrl.buscarPersonaje(idSeleccionado);
		
		if(ctrl.getJugador1() == null){
			ctrl.setJugador1(p);
		}else{
			if(p.getIdPersonaje() != ctrl.getJugador1().getIdPersonaje()){
				ctrl.setJugador2(p);
				}
				else{
					JOptionPane.showMessageDialog(this, "No puede seleccionar el mismo personaje. Por favor elija otro.", 
							"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		
		((TurnBasedCombat) frame).cambiarAPanelExistente("IniciarJuego");
	}

	
}
