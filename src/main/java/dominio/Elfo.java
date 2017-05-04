package dominio;

/**
 * Clase Elfo - extiende de Personaje Contiene el contructor parametrizado de la
 * clase. Contiene las dos habilidades de raza.
 */
public class Elfo extends Personaje {

    /**
     * ENERGIA_TOPE.
     */
    protected static final int ENERGIA_TOPE = 10;

    /**
     * MULTILICADOR_NIVEL.
     */
    protected static final int MULTILICADOR_NIVEL = 10;
    /**
     * @param nombre nombre.
     * @param casta casta.
     * @param id identificador unico.
     */
    public Elfo(final String nombre, final Casta casta, final int id) {
	super(nombre, casta, id);
	energiaTope += ENERGIA_TOPE;
	salud = saludTope;
	energia = energiaTope;
	nombreRaza = "Elfo";

	habilidadesRaza = new String[2];
	habilidadesRaza[0] = "Golpe Level";
	habilidadesRaza[1] = "Ataque Bosque";
    }

    /**
     * Método constructor de un personaje existente de raza elfo.
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
    public Elfo(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {
	super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
		experiencia, nivel, idPersonaje);
	nombreRaza = "Elfo";

	habilidadesRaza = new String[2];
	habilidadesRaza[0] = "Golpe Level";
	habilidadesRaza[1] = "Ataque Bosque";
    }

    /**
     * Golpe Level - Habilidad de raza 1
     *
     * Si el atacante tiene mas de 10 de energia, gasta esa energia y si el
     * atacado es atacado con la fuerza del atacante mas su nivel por 10 mayor a
     * 0 retorna true. Sino retorna false.
     * @param atacado implementando Peleable que es atacado
     * @return boolean
     */
    public boolean habilidadRaza1(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
	    this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	    if (atacado.serAtacado(this.getFuerza()
		    + this.getNivel() * MULTILICADOR_NIVEL) > 0) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Ataque Bosque - Habilidad de raza 2
     *
     * Si el atacante tiene mas de 10 de energia, gasta esa energia y si el
     * atacado es atacado con la magia del atacante mayor a 0 retorna true. Sino
     * retorna false. implementando Peleable que es atacado.
     * @param atacado implementando Peleable que es atacado
     * @return boolean
     */
    public boolean habilidadRaza2(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
	    this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	    if (atacado.serAtacado((int) (this.magia)) > 0) {
		return true;
	    }
	}
	return false;
    }
}
