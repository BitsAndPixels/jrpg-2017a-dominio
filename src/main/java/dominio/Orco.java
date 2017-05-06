package dominio;

/**
 * <p>
 * Contiene los constructores y las habilidades de la raza Orco.
 * @see Personajes
 */

public class Orco extends Personaje {
    /**
     * @param SALUD_BONUS constante de salud a tope.
     */
    protected static final int SALUD_BONUS = 10;
    /**
     * @param ENERGIA_BONUS incremento de energia tope.
     */
    protected static final int ENERGIA_BONUS = 0;
    /**
     * Método constructor de un personaje nuevo de raza orco el cual determina
     * los atributos del personaje dependiendo de su casta.
     * @param nombre nombre
     * @param casta casta que pertenece
     * @param id id unico de personanje
     */
    public Orco(final String nombre, final Casta casta, final int id) {
	super(nombre, casta, id, "Orco", SALUD_BONUS, ENERGIA_BONUS,
		"Golpe Defensa", "Mordisco de Vida");
    }

    /**
     * Método constructor de un personaje existente de raza orco.
     * @param nombre nombre
     * @param salud salud que posee
     * @param energia energia que posee
     * @param fuerza fuerza que posee
     * @param destreza destreza que posee
     * @param inteligencia inteligencia que posee
     * @param casta La clase del personaje
     * @param experiencia experiencia que posee
     * @param nivel que posee, maximo 100
     * @param idPersonaje id unico de personaje
     */
    public Orco(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {
	super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
		experiencia, nivel, idPersonaje, "Orco", "Golpe Defensa",
		"Mordisco de Vida");
    }
    /**Este método permite al orco usar su primera habilidad de raza.
     * @param atacado
     *            -> peleable a atacar
     * @return true/false -> Determina si se puede o no realizar la habilidad
     */
    public boolean habilidadRaza1(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
	    this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	    if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Este método permite al orco usar su segunda habilidad de raza.
     * @param atacado
     *            -> peleable a atacar
     * @return true/false -> Determina si se puede o no realizar la habilidad
     */
    public boolean habilidadRaza2(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
	    this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	    int dañoCausado = atacado.serAtacado(this.getFuerza());
	    if (dañoCausado > 0) {
		this.serCurado(dañoCausado);
		return true;
	    }
	}
	return false;
    }
}
