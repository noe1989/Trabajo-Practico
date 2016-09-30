package juego;

import entidades.Personaje;

public class Partida {
	
    Personaje turno;
    
    ControladorJuego ctrl;
	
     private int energiaOriginal1,energiaOriginal2,  vidaOriginal1,vidaOriginal2;
    
	
	public int getEnergiaOriginal1() {
		return energiaOriginal1;
	}


	public void setEnergiaOriginal1(int energiaOriginal1) {
		this.energiaOriginal1 = energiaOriginal1;
	}


	public int getEnergiaOriginal2() {
		return energiaOriginal2;
	}


	public void setEnergiaOriginal2(int energiaOriginal2) {
		this.energiaOriginal2 = energiaOriginal2;
	}


	public int getVidaOriginal1() {
		return vidaOriginal1;
	}


	public void setVidaOriginal1(int vidaOriginal1) {
		this.vidaOriginal1 = vidaOriginal1;
	}


	public int getVidaOriginal2() {
		return vidaOriginal2;
	}


	public void setVidaOriginal2(int vidaOriginal2) {
		this.vidaOriginal2 = vidaOriginal2;
	}


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

	public void inicializar(){
		
		energiaOriginal1 = ctrl.getJugador1().getEnergia();
		vidaOriginal1 = ctrl.getJugador1().getVida();
		
		energiaOriginal2 = ctrl.getJugador2().getEnergia();
		vidaOriginal2 = ctrl.getJugador2().getVida();
	}
	
	
	public void atacar(int puntosAtaque){
		
		turno.atacar(puntosAtaque);
		
		if(turno.getIdPersonaje()== ctrl.getJugador1().getIdPersonaje()){
			ctrl.getJugador2().recibirAtaque(puntosAtaque);
		}else{
			ctrl.getJugador1().recibirAtaque(puntosAtaque);
		}
		
		
		
	}
	
	


	public void defender(){
		
		int energiaARecupearar;
		int vidaARecuperar;
		
		if(turno.getIdPersonaje()== ctrl.getJugador1().getIdPersonaje()){
			
			energiaARecupearar = energiaOriginal1 * turno.getDefensa() / 100;
			vidaARecuperar = vidaOriginal1 * turno.getDefensa() / 250;
		}else{
			energiaARecupearar = energiaOriginal2 * turno.getDefensa() / 100;
			vidaARecuperar = vidaOriginal2 * turno.getDefensa() / 250;
		}
				
		turno.defensa(energiaARecupearar, vidaARecuperar);
		
		
	}
	
	
}
