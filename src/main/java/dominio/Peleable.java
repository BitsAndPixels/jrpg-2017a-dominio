package dominio;
/**
 * Clase interfaz Peleable con los siguientes metodos:
 */
public interface Peleable {
	
	/**
	 * Este método permite definir el estado del personaje luego de recibir un ataque
	 * El nivel de saluda decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje atacado
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return daño  -> Daño generado 
	 * 
	 */
	
	public int serAtacado(int daño);
	public int getSalud();
	
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
	
	
	public int atacar(Peleable atacado);
	
	/**
	 * Este método permite otorgar experiencia basada en el nivel del personaje 
	 * 
	 * @return this.nivel * 40 -> Cantidad de experiencia entregada 
	 */
	
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
	 * Este método permite otorgar experiencia basada en el nivel del personaje 
	 * 
	 * @return this.nivel * 40 -> Cantidad de experiencia entregada 
	 */
	
	public abstract  int otorgarExp();
	
	public int getAtaque();
	public void setAtaque(int ataque);
	
	
}
