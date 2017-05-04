package dominio;

import java.io.Serializable;

/**
 * Class Casta Una Casta es un gremio al que puede unirse un Personaje. Existen
 * tres tipos: Asesino, Guerrero y Hechicero.
 * 
 * @See Asesino
 * @see Guerrero
 * @see Hechicero
 * 
 *      Habilidades: Cada gremio tendrá 3 habilidades características que se
 *      definirán en su Class específica.
 * @see #habilidad1(Personaje, Peleable)
 * @see #habilidad2(Personaje, Peleable)
 * @see #habilidad3(Personaje, Peleable)
 */
public abstract class Casta implements Serializable {
    /**
     * ENERGIA_CONSUMIDA.
     */
    protected static final int ENERGIA_CONSUMIDA = 10;
    /**
     * CANTIDAD_HABILIDADES_CASTA.
     */
    protected static final int CANTIDAD_HABILIDADES_CASTA = 3;
    /**
     * probabilidadGolpeCritico.
     */
    protected double probabilidadGolpeCritico;
    /**
     * probabilidadEvitarDaño.
     */
    protected double probabilidadEvitarDaño;
    /**
     * dañoCritico.
     */
    protected double dañoCritico;
    /**
     * nombreCasta.
     */
    protected String nombreCasta;

    /**
     * habilidadesCasta.
     */
    protected String[] habilidadesCasta;

    /**
     * Constructor por defecto de Casta utilizado por las Clases especializadas
     * Asesino, Guerrero y Hechicero.
     */
    public Casta() {
	this.probabilidadGolpeCritico = 0.2;
	this.probabilidadEvitarDaño = 0.2;
	this.dañoCritico = 1.5;
    }

    /**
     * Constructor parametrizado de Casta utilizado por las Clases
     * especializadas Asesino, Guerrero y Hechicero.
     * 
     * @param prob_crit
     * @param evasion
     * @param daño_crit
     */
    public Casta(double prob_crit, double evasion, double daño_crit) {
	this.probabilidadGolpeCritico = prob_crit;
	this.probabilidadEvitarDaño = evasion;
	this.dañoCritico = daño_crit;
    }

    /**
     * Funciones abstractas que serán definidas en cada especialización de Casta
     * 
     * @param caster
     * @param atacado
     * @return true o false
     */
    public abstract boolean habilidad1(Personaje caster, Peleable atacado);

    public abstract boolean habilidad2(Personaje caster, Peleable atacado);

    /**
     * @param caster
     * @param atacado
     * @return
     */
    public abstract boolean habilidad3(Personaje caster, Peleable atacado);

    /**
     * @return
     */
    public String getNombreCasta() {
	return this.nombreCasta;
    }

    /**
     * @return
     */
    public String[] getHabilidadesCasta() {
	return habilidadesCasta;
    }

    /**
     * @return probabilidadGolpeCritico.
     */
    public double getProbabilidadGolpeCritico() {
	return probabilidadGolpeCritico;
    }

    /**
     * @param probabilidadGolpeCritico.
     */
    public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
	this.probabilidadGolpeCritico = probabilidadGolpeCritico;
    }

    /**
     * @return probabilidadEvitarDaño prob evitar daño.
     */
    public double getProbabilidadEvitarDaño() {
	return probabilidadEvitarDaño;
    }

    /**
     * @param probabilidadEvitarDaño prob evitar daño.
     */
    public void setProbabilidadEvitarDaño(final double probabilidadEvitarDaño) {
	this.probabilidadEvitarDaño = probabilidadEvitarDaño;
    }

    /**
     * @return daño critico.
     */
    public double getDañoCritico() {
	return dañoCritico;
    }

    /**
     * @param dañoCritico daño critico.
     */
    public void setDañoCritico(final double dañoCritico) {
	this.dañoCritico = dañoCritico;
    }

    /**
     * @param personaje personaje.
     */
    public void habilidadCasta(final Personaje personaje) {
    }
}
