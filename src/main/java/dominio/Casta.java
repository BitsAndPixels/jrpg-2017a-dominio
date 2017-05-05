package dominio;

import java.io.Serializable;

/**
 * Class Casta Una Casta es un gremio al que puede unirse un Personaje. Existen
 * tres tipos: Asesino, Guerrero y Hechicero.
 *  Asesino.
 *  Guerrero.
 *  Hechicero.
 *      Habilidades: Cada gremio tendrá 3 habilidades características que se
 *      definirán en su Class específica.
 *  #habilidad1(Personaje, Peleable)
 *  #habilidad2(Personaje, Peleable)
 *  #habilidad3(Personaje, Peleable)
 */
public abstract class Casta implements Serializable {
    /**
     * PROB_GOLPE_CRITICO.
     */
    protected static final double PROB_GOLPE_CRITICO = 0.2;
    /**
     * PROB_EVITAR_DAÑO.
     */
    protected static final double PROB_EVITAR_DAÑO = 0.2;
    /**
     * DAÑO_CRITICO.
     */
    protected static final double DAÑO_CRITICO = 1.5;
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
	this.probabilidadGolpeCritico = PROB_GOLPE_CRITICO;
	this.probabilidadEvitarDaño = PROB_EVITAR_DAÑO;
	this.dañoCritico = DAÑO_CRITICO;
    }

    /**
     * Constructor parametrizado de Casta utilizado por las Clases
     * especializadas Asesino, Guerrero y Hechicero.
     * @param prob_crit probabilidad critico.
     * @param evasion probabilidad evasion.
     * @param daño_crit daño critico.
     */
    public Casta(final double prob_crit, final double evasion,
	    final double daño_crit) {
	this.probabilidadGolpeCritico = prob_crit;
	this.probabilidadEvitarDaño = evasion;
	this.dañoCritico = daño_crit;
    }

    /**
     * Funciones abstractas que serán definidas en cada
     * especialización de Casta.
     * @param caster caster.
     * @param atacado caster.
     * @return true o false.
     */
    public abstract boolean habilidad1(Personaje caster, Peleable atacado);

    /**
     * @param caster caster.
     * @param atacado caster.
     * @return  true o false.
     */
    public abstract boolean habilidad2(Personaje caster, Peleable atacado);

    /**
     * @param caster caster.
     * @param atacado caster.
     * @return true o false.
     */
    public abstract boolean habilidad3(Personaje caster, Peleable atacado);

    /**
     * @return nombre casta.
     */
    public String getNombreCasta() {
	return this.nombreCasta;
    }

    /**
     * @return array habilidades casta.
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
     * @param probabilidadGolpeCritico probabilidad de golpe critico.
     */
    public void setProbabilidadGolpeCritico(
	    final double probabilidadGolpeCritico) {
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
