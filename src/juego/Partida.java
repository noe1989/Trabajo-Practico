package juego;

import entidades.Personaje;

public class Partida {
	
    Personaje turno;
    
    ControladorJuego ctrl;
	
	
	public ControladorJuego getCtrl() {
		return ctrl;
	}


	public void setCtrl(ControladorJuego ctrl) {
		this.ctrl = ctrl;
	}


	public Personaje getTurno() {
		return turno;
	}


	public void setTurno(Personaje turno) {
		this.turno = turno;
	}


	
	
	public void atacar(int puntosAtaque){
		
		turno.atacar(puntosAtaque);
		
		if(turno.getIdPersonaje()== ctrl.getJugador1().getIdPersonaje()){
			ctrl.getJugador2().recibirAtaque(puntosAtaque);
		}else{
			ctrl.getJugador1().recibirAtaque(puntosAtaque);
		}
		
		
		
	}
	
		
	
	
}
