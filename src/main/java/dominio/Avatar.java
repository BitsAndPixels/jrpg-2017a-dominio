package dominio;

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

    /**
     * @param nombre nombre.
     * @param salud salud.
     * @param fuerza fuerza.
     * @param nivel nivel.
     */
    public Avatar(final String nombre, final int salud, final int fuerza, final int nivel) {

	this.nombre = nombre;
	this.salud = salud;
	this.fuerza = fuerza;
	this.nivel = nivel;
    }

    /**
     * @param nombre nombre.
     * @param nivel nivel.
     */
    public Avatar(final String nombre, final int nivel) {
	this.nombre = nombre;
	this.nivel = nivel;
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
     * @param salud salud.
     */
    public void setSalud(final int salud) {
	this.salud = salud;
    }

    /**
     * @return nivel.
     */
    public int getNivel() {
	return nivel;
    }

    /**
     * @param nivel nivel.
     */
    public void setNivel(final int nivel) {
	this.nivel = nivel;
    }

    /**
     * @return fuerza.
     */
    public int getFuerza() {
	return fuerza;
    }

    /**
     * @param fuerza fuerza.
     */
    public void setFuerza(final int fuerza) {
	this.fuerza = fuerza;
    }

}
