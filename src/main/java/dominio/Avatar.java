package dominio;

import inventario.Inventario;
import inventario.Mochila;

/**
 * @author Administrador
 *
 */
public abstract class Avatar {
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
    
    protected Inventario inventario;
    
    protected Mochila mochila;

    /**
     * @param nombre nombre.
     * @param salud salud.
     * @param fuerza fuerza.
     * @param nivel nivel.
     */
    
    protected RandomGenerator myRandom;
    
    public Avatar(final String nombre, final int salud, final int fuerza, final int nivel, final Inventario inventario, final Mochila mochila) {

	this.nombre = nombre;
	this.salud = salud;
	this.fuerza = fuerza;
	this.nivel = nivel;
	this.inventario = inventario;
	this.mochila = mochila;
	this.myRandom = new MyRandom();
    }

    /**
     * @param nombre nombre.
     * @param nivel nivel.
     */
    public Avatar(final String nombre, final int nivel) {
	this.nombre = nombre;
	this.nivel = nivel;
	this.myRandom = new MyRandom();
    }

    /**
     * @return nombre.
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param nombre nombre.
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    /**
     * @return nivel.
     */
    public int getNivel() {
	return nivel;
    }

    /**
     * @return fuerza.
     */
    public int getFuerza() {
	return fuerza;
    }

    /**
     * Metodo Stub necesario para hacer pruebas de MyRandom
     * Obtiene valores fijos de la Interfaz de constantes de MyRandom
     * @see constantes.ConstantesMyRandom
     * @param randomGenerator
     */
    public void setRandomGenerator(RandomGenerator randomGenerator) {
		this.myRandom = randomGenerator;	
	}
    
    public RandomGenerator getMyRandom(){
    	return this.myRandom;
    }
    
    public Inventario getInventario() {
		return inventario;
	}

	public Mochila getMochila() {
		return mochila;
	}

	//public abstract void equiparItemsInventario();

}
