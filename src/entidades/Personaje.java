package entidades;

import java.util.Random;

import javax.swing.JOptionPane;

import util.ApplicationException;

public class Personaje {
	
	private int idPersonaje;
	private String nombre;
	
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosTotales;
	
	private int vidaActual;
	private int energiaActual;
	
	
	

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getEnergiaActual() {
		return energiaActual;
	}

	public void setEnergiaActual(int energiaActual) {
		this.energiaActual = energiaActual;
	}

	public Personaje() {

	}
    
	public Personaje(int id, String nomb, int vida, int ener, int def, int ev, int pt){
		
    	this.idPersonaje = id;
		this.nombre = nomb;
		this.vida = vida;
		this.energia = ener;
		this.defensa = def;
		this.evasion = ev;
		this.puntosTotales = pt;
	}
	
	


	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int id) {
		this.idPersonaje = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa){
		try{
			if (defensa >= 0 && defensa <= 20){
				this.defensa = defensa;
			}else{
				throw (new ApplicationException());
			}
		}catch(ApplicationException e){
			e.errorDePuntajes();
			
		}
	}
	
	
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		try{
			if (defensa >= 0 && defensa <= 80){
				this.evasion = evasion;
			}else{
				throw (new ApplicationException());
			}
		}catch(ApplicationException e){
			e.errorDePuntajes();
		}
	}
	
	
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	public void atacar(int pts){
		energiaActual = energiaActual - pts;
	}
	
	public void recibirAtaque(int pts){
		
		Random rand = new Random();
		
		int numAleatorio = rand.nextInt(100)+1; 
		
		if((numAleatorio)>evasion){
			JOptionPane.showMessageDialog(null, "EVADIDO! Great!", "Turn Based Combat", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "NO EVADIDO!", "Turn Based Combat", JOptionPane.INFORMATION_MESSAGE);
			
			vidaActual = vidaActual - pts;
			
		}
		
	}

	public void defensa() {
		
		int energiaARecupearar = energia * defensa / 100;
		int vidaARecuperar = vida * defensa / 250;
		

		if(vida >= (vidaActual + vidaARecuperar)){
			vidaActual = vidaActual + vidaARecuperar;
		}else{
			vidaActual = vida;
		}
			
		if (energia >= (energiaActual + energiaARecupearar)){
			energiaActual =energiaActual + energiaARecupearar;
		}else{
			energiaActual = energia;
		}

		
	}
	
	public void sumarPuntaje(){
		
		puntosTotales += 10;
		
	}

}
