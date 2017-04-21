package dominio;


/**
 * <p> Contiene la información necesaria para establecer la dicultad de un determinado nivel
 * del juego junto con:
 *  + El nivel de salud de los personajes
 *  + La fuerza de sus ataques
 *  + El nivel de defensa que poseen
 * 	+ Nombre del nivel
 *  + Nivel del juego en que se encuentra el jugador
 *  
 *  En función al nivel del juego en que se encuentra el jugador, se configuran
 *  	+ Fuerza 
 *      + Salud
 *      + Defensa 
 *      
 * 	@see Peleable interfaz perteneciente a este proyecto
 *
 */

public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	private static final int dificultadAleatoria = -1;

	
	
	/**
	 * Metodo constructor que permite inicializar un objeto NonPlayableCharacter definiendo
	 * la dicultad del juego y en función a este parametro 
	 * 	+Fuerza
	 * 	+Salud
	 *  +Defensa
	 *  Determinando estos atributos dependiendo del nivel en el que se encuentra el jugador
	 * 
	 * @param nombre
	 * @param nivel
	 * @param dificultadNPC
	 */
	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;// 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;// 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;
		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	

	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}

	
	/**
	 * Este método permite definir el estdo del personaje luego de recibir un ataque
	 * El nivel de saluda decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje atacado
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return daño  -> Daño generado 
	 * 
	 */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	public void despuesDeTurno() { }

	public void ganarExperiencia(int exp) {

	}

	@Override
	public int getAtaque() {
		return fuerza;
	}

	@Override
	public void setAtaque(int ataque) {
		this.fuerza = ataque;
	}
}
