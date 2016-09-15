package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.*;



public class DataPersonaje {
	
	public DataPersonaje(){
		
	}
	
	
	
	public void add(Personaje p){
		
		//ResultSet rs = null;
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into personajes(idPersonaje, nombre, vida, energia, defensa, evasion, puntosTotales)"+"values(?,?,?,?,?,?,?)");
			stmt.setInt(1, p.getIdPersonaje());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getDefensa());
			stmt.setInt(6, p.getEvasion());
			stmt.setInt(7, p.getPuntosTotales());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void update(Personaje p){
		
		
	}
	
	public void delete(Personaje p){
		
		
	}
	
	public ResultSet gridPersonajes(){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT idPersonaje, nombre FROM personajes;");
			rs = stmt.executeQuery();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		
		return rs;
		
		
	}

}
