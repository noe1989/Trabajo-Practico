package uiDesktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SeleccionarNuevoPersonajeDeDB extends JPanel {
	
	
	ControladorJuego ctrl;
	

	public ControladorJuego getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}
	
	private JTable table;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	
	public SeleccionarNuevoPersonajeDeDB(JFrame frame) {
		JLabel lblSeleccionarPersonajeExistente = new JLabel("Seleccionar Personaje Existente");
		lblSeleccionarPersonajeExistente.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JSeparator separator = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSeleccionar = new JButton("Seleccionar");
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
					.addGap(218)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(btnSeleccionar)
					.addGap(270))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(274, Short.MAX_VALUE)
					.addComponent(lblSeleccionarPersonajeExistente)
					.addGap(194))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSeleccionarPersonajeExistente)
					.addGap(7)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnSeleccionar)
					.addGap(214))
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
