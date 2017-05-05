package dominio;

public abstract class Avatar{
	/**
     * salud.
     */
	protected int salud;
	/**
     * fuerza.
     */
	protected int fuerza;
	/**
     * defensa.
     */
	protected int defensa;
	/**
     * nombre.
     */
	protected String nombre;
	/**
     * nivel.
     */
	protected int nivel;

	
	public Avatar(String nombre, int salud, int fuerza, int nivel){
		
		this.nombre = nombre;
		this.salud = salud;
		this.fuerza = fuerza;
		this.nivel = nivel;
	}
	
	public Avatar(String nombre, int nivel){
		
		this.nombre = nombre;
		this.nivel = nivel;
	}
	
	public String getNombre() {
	return nombre;
	}
	
	public void setNombre(String nombre){
	this.nombre = nombre;
	}

    public int getSalud() {
	return salud;
    }

    public void setSalud(final int salud) {
	this.salud = salud;
    }
	
    public int getNivel(){
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public  int getFuerza(){
		return fuerza;
	}
	
	public void setFuerza(int fuerza){
		this.fuerza = fuerza;
	}
	
	
	
	/**
	 * Método que permite determinar si el personaje se encuentra vivo 
	 * 
	 * @return salud > 0 -> Establece si el personaje esta vivo 
	 */ 
	
	public boolean estaVivo(){
		return salud > 0;
	}
	
	
}
