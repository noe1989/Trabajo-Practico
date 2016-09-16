package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.*;



public class DataPersonaje {
	
	private int resultado;
	
	public DataPersonaje(){
		
	}
	
	
	
	public void add(Personaje p){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into personajes(idPersonaje, nombre, vida, energia, defensa, evasion, puntosTotales)"+"values(?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdPersonaje());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getDefensa());
			stmt.setInt(6, p.getEvasion());
			stmt.setInt(7, p.getPuntosTotales());

			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setIdPersonaje(rs.getInt(1));
			}
			
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
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT idPersonaje, nombre, puntosTotales FROM personajes;");
			rs = stmt.executeQuery();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		
		return rs;
		
		
	}
	
	public Personaje getById(int id){
		
		Personaje p = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT idPersonaje, nombre, vida, energia, defensa, evasion, puntosTotales FROM personajes WHERE idPersonaje = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()){
				p = new Personaje();
				p.setIdPersonaje(rs.getInt("idPersonaje"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("puntosTotales"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				FactoryConexion.getInstancia().releaseConn();
		}
		
		
		return p;
	}

}
