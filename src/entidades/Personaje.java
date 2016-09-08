package entidades;

public class Personaje {
	
	private int idPersonaje;
	private String nombre;
	
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosTotales;
	
	
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
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	
	
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	

}
