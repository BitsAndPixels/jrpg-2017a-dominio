package dominio;

public abstract class Configuracion{
	
	protected int salud;
	protected int fuerza;
	protected int defensa;
	protected String nombre;
	protected int nivel;

	
	public Configuracion(String nombre, int salud, int fuerza, int nivel){
		
		this.nombre = nombre;
		this.salud = salud;
		this.fuerza = fuerza;
		this.nivel = nivel;
	}
	
	public Configuracion(String nombre, int nivel){
		
		this.nombre = nombre;
		this.nivel = nivel;
	}
	
	/**
	 * Este método permite definir el estado del personaje luego de recibir un ataque
	 * El nivel de saluda decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje atacado
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return daño  -> Daño generado 
	 * 
	 */
	
	public abstract  void despuesDeTurno();
	
	/**
	 * Método que permite al personaje atacar , determinando si el ataque va a ser critico o no basado 
	 * en las probabilidades de critico de su determinada casta .
	 * 
	 * @param atacado -> Peleable q recibe el ataque 
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return atacado.serAtacado(this.golpe_critico()) -> Daño en caso de ser golpe crítico
	 * @return atacado.serAtacado(this.ataque) -> Daño en caso de ser golpe normal
	 * 
	 */
	
	
	/**
	 * Este método permite otorgar experiencia basada en el nivel del personaje 
	 * 
	 * @return this.nivel * 40 -> Cantidad de experiencia entregada 
	 */
	
	public abstract  int otorgarExp();
	
	
	/**
	 * Método que permite determinar si el personaje se encuentra vivo 
	 * 
	 * @return salud > 0 -> Establece si el personaje esta vivo 
	 */ 
	
	public boolean estaVivo(){
		return salud > 0;
	}
	
	public int getDefensa(){
		return nivel;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public  int getAtaque(){
		return fuerza;
	}
	
	public  void  setFuerza(int fuerza){
		this.fuerza = fuerza;
	}
	
	public  int getFuerza(){
		return fuerza;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	
}
