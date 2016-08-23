import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;



public class Main {

	public static void main(String[] args) throws SQLException{
		
		System.out.println("Hola Mundo");
		System.out.println("Prueba de JDBC con la DB 'Agencia Personal'\n\n");
		
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/agencia_personal", "root", "root"); 
		
		Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM empresas");
		
		while (rs.next())
		{
		   System.out.println("Razon Social: "+rs.getObject("razon_social")+
		      ", CUIT: "+rs.getObject("cuit")+
		      ", Teléfono: "+rs.getObject("telefono"));
		}
		rs.close();


		
	  } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	   
	   
	   
		
	}
}
