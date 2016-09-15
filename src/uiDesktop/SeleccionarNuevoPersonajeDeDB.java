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

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionarNuevoPersonajeDeDB extends JPanel {
	
	private JList<String> list;
	private JTable table;
	
	private DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	
	/**
	 * Create the panel.
	 */
	public SeleccionarNuevoPersonajeDeDB(JFrame frame) {
		
		JLabel lblSeleccionarPersonajeExistente = new JLabel("Seleccionar Personaje Existente");
		lblSeleccionarPersonajeExistente.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JSeparator separator = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//String nombreSeleccionado = list.getSelectedValue();
				
				String nombreSeleccionado = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(),1));
				
				System.out.println(nombreSeleccionado);
				
				seleccionarPersonaje(frame);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(lblSeleccionarPersonajeExistente))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(198)
							.addComponent(btnSeleccionar)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblSeleccionarPersonajeExistente)
					.addGap(6)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnSeleccionar)
					.addContainerGap())
		);
		
		
		setLayout(groupLayout);
	
		/*list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);		
		llenarLista();*/
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		llenarTabla();
		
				

	}
	

	/*private void llenarLista(){
	   
		DataPersonaje dbPersonaje = new DataPersonaje();
		
		try {
	        ResultSet rs = dbPersonaje.gridPersonajes(); //La consulta tiene que devolver un ResultSet para tratar los datos
	        
	        while(rs.next()){
	            modeloLista.addElement(rs.getString("nombre")); //nombre es el campo de la base de datos
	    
	        }
	        
	        list.setModel(modeloLista);

	        

	    } catch (SQLException e) {
	      
	    	e.printStackTrace();
	    }
	}*/
	
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
	
	private void seleccionarPersonaje(JFrame frame){
		
		((TurnBasedCombat) frame).cambiarAPanelExistente("IniciarJuego");
	}

	
}
