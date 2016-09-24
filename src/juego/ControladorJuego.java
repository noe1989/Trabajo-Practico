package juego;

import database.DataPersonaje;
import entidades.Personaje;

public class ControladorJuego { 
	
	Personaje Jugador1;
	Personaje Jugador2; 
	
	int Turno;
	
	
	public int getTurno() {
		return Turno;
	}


	public void setTurno(int turno) {
		Turno = turno;
	}


	public Personaje getJugador1() {
		return Jugador1;
	}


	public void setJugador1(Personaje jugador1) {
		Jugador1 = jugador1;
	}


	public Personaje getJugador2() {
		return Jugador2;
	}


	public void setJugador2(Personaje jugador2) {
		Jugador2 = jugador2;
	}



	
	
	public void agregarPersonaje(Personaje personaje){
	
		DataPersonaje dbPersonaje = new DataPersonaje();
		
		personaje.setPuntosTotales(200); //Cada vez que se agrega un nuevo personaje siempre tiene inicialmente 200 puntosTotales
		dbPersonaje.add(personaje);
	}


	public Personaje buscarPersonaje(int idPersonaje) {
		
		Personaje p = new Personaje();
		
		DataPersonaje dbPersonaje = new DataPersonaje();	
		
		p = dbPersonaje.getById(idPersonaje);
		
		return p;
		
	}
	
	public void modificarPersonaje(Personaje p){
		DataPersonaje dbPersonaje = new DataPersonaje();	
		
		dbPersonaje.update(p);
	}


}
