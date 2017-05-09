package dominio;

import static constantes.ConstantesNonPlayableCharacter.*;

/**
 * <p>
 * Contiene la información necesaria para establecer la dicultad de un
 * determinado nivel del juego junto con: + El nivel de salud de los personajes
 * + La fuerza de sus ataques + El nivel de defensa que poseen + Nombre del
 * nivel + Nivel del juego en que se encuentra el jugador.
 * En función al nivel del juego en que se encuentra el jugador, se configuran +
 * Fuerza + Salud + Defensa.
 * @see Peleable interfaz perteneciente a este proyecto
 */
public class NonPlayableCharacter extends Avatar implements Peleable {
    /**
     * Metodo constructor que permite inicializar un objeto NonPlayableCharacter
     * definiendo la dicultad del juego y en función a este parametro +Fuerza
     * +Salud +Defensa Determinando estos atributos dependiendo del nivel en el
     * que se encuentra el jugador.
     * @param nombre nombre
     * @param nivel actual
     * @param dificultadNPC dificultad
     */

    
    public NonPlayableCharacter(final String nombre, final int nivel,
	    final int dificultadNPC) {
    super(nombre, nivel);
	int dificultad;
	if (dificultadNPC == DIFICULTAD_ALEATORIA) {
	    dificultad = MyRandom.nextInt(CIFRAS_DIFICULTAD);
	}
	else {
	    dificultad = dificultadNPC;
	}
	switch (dificultad) {
	case 0:
	    this.fuerza = FUERZA_DIFICULTAD_0 + (nivel - 1)
	    * MULT_FUERZA_DIFICULTAD_0;
	    this.salud = SALUD_DIFICULTAD_0 + (nivel - 1)
		    * MULT_SALUD_DIFICULTAD_0;
	    this.defensa = DEFENSA_DIFICULTAD_0 + (nivel - 1)
		    * MULT_DEFENSA_DIFICULTAD_0;
	    break;
	case 1:
	    this.fuerza = FUERZA_DIFICULTAD_1 + (nivel - 1)
	    * MULT_FUERZA_DIFICULTAD_1;
	    this.salud = SALUD_DIFICULTAD_1 + (nivel - 1)
		    * MULT_SALUD_DIFICULTAD_1;
	    this.defensa = DEFENSA_DIFICULTAD_1 + (nivel - 1)
		    * MULT_DEFENSA_DIFICULTAD_1;
	    break;
	case 2:
	    this.fuerza = FUERZA_DIFICULTAD_2 + (nivel - 1)
	    * MULT_FUERZA_DIFICULTAD_2;
	    this.salud = SALUD_DIFICULTAD_2 + (nivel - 1)
		    * MULT_SALUD_DIFICULTAD_2;
	    this.defensa = DEFENSA_DIFICULTAD_2 + (nivel - 1)
		    * MULT_DEFENSA_DIFICULTAD_2;
	    break;
	default:
	    break;
	}
    }

	
    /**
     * @return nivel.
     */
    public int otorgarExp() {
	return this.nivel * EXPERIENCIA;
    }

    /**
     * @return fuerza.
     */
    public int getFuerza() {
	return fuerza;
    }

    /**
     * @param fuerza fuerza del personaje.
     */
    public void setFuerza(final int fuerza) {
	this.fuerza = fuerza;
    }

    /**
     * @return nombre retorna nombre.
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param nombre setea nombre.
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    /**
     * @return nivel retorna nivel.
     */
    public int getNivel() {
	return nivel;
    }

    /**
     * @param nivel setea nivel.
     */
    public void setNivel(final int nivel) {
	this.nivel = nivel;
    }

    /**
     * @return si esta vivo o no.
     */
    public boolean estaVivo() {
	return salud > 0;
    }

    /**
     * @return defensa.
     */
    public int getDefensa() {
	return defensa;
    }

    /**
     * @param defensa setea defensa.
     */
    public void setDefensa(final int defensa) {
	this.defensa = defensa;
    }

    /**
     * @return salud retorna salud.
     */
    public int getSalud() {
	return salud;
    }

    /**
     * @param salud setea salud.
     */
    public void setSalud(final int salud) {
	this.salud = salud;
    }

    /**
     * @param atacado implementa Peleable.
     * @return valor del ataque.
     */
    public int atacar(final Peleable atacado) {
	if (MyRandom.nextDouble() <= SUERTE_MULTIPLICADOR_ATAQUE) {
	    return atacado.serAtacado((int) (this.getAtaque()
		    * MULTIPLICADOR_ATAQUE));
	}
	else {
	    return atacado.serAtacado(this.getAtaque());
	}
    }
//	public int getSalud() {
//		return salud;
//	}

    /**Este método permite definir el estdo del personaje luego de recibir un
     * ataque El nivel de saluda decrementa en función del nivel de defensa que
     * posea el personaje.
     * @param daño
     *            -> Cantidad recibida de daño por el personaje atacado
     * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
     * @return daño -> Daño generado
     */
    public int serAtacado(int daño) {
	if (MyRandom.nextDouble() >= SUERTE_MULTIPLICADOR_ATAQUE) {
	    daño -= this.getDefensa() / 2;
	    if (daño > 0) {
		salud -= daño;
		return daño;
	    }
	    return 0; // no le hace daño ya que la defensa fue mayor
	}
	return 0; // esquivo el golpe
    }

    /**
     * Implementada en interfaz.
     */
    public void despuesDeTurno() {
    }

    /**
     * @param exp Implementada en interfaz.
     */
    public void ganarExperiencia(final int exp) {

    }

    /* (non-Javadoc)
     * @see dominio.Peleable#getAtaque()
     */
    @Override
    public int getAtaque() {
	return fuerza;
    }

    /* (non-Javadoc)
     * @see dominio.Peleable#setAtaque(int)
     */
    @Override
    public void setAtaque(final int ataque) {
	this.fuerza = ataque;
    }
    /**
     * Reemplazo del instance of.
     * @return false
     */
    public boolean esPersonaje() {
	return false;
    }
}
