/*
 * @Hechicero.java        1.82 03/05/2017
 * Clase Hechicero.
 * Más información y descripción del Copyright.
 *
 */
package dominio;

/**
 * Clase Hechicero - extiende de la clase abstracta Casta Contiene el contructor
 * por defecto. Contiene el contructor parametrizado de la clase. Contiene las
 * tres habilidades.
 */
public class Hechicero extends Casta {

    public Hechicero(final double prob_crit, final double evasion, final double daño_crit) {
	super(prob_crit, evasion, daño_crit);
	this.nombreCasta = "Hechicero";
    }

    public Hechicero() {
	super();
	this.nombreCasta = "Hechicero";
	habilidadesCasta = new String[CANTIDAD_HABILIDADES_CASTA];
	habilidadesCasta[0] = "Bola de Fuego";
	habilidadesCasta[1] = "Curar Aliado";
	habilidadesCasta[2] = "Robar Energia y Salud";
    }

    /**
     * Bola de Fuego - Habilidad 1
     *
     * Si el caster tiene mas de 10 de energia, gasta esa energia y si el
     * atacado es atacado con los puntos de magia del caster por 1.5 mayor a 0
     * retorna true. Sino retorna false.
     *
     * @param caster
     *            que castea
     * @param atacado
     *            implementando Peleable que es atacado
     * @return boolean
     */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
	if (caster.getEnergia() > ENERGIA_CONSUMIDA) {
	    caster.setEnergia(caster.getEnergia() - ENERGIA_CONSUMIDA);
	    if (atacado.serAtacado((int) (caster.
		    calcularPuntosDeMagia() * 1.5)) > 0) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Curar Aliado - Habilidad 2
     *
     * Si el caster tiene mas de 10 de energia, gasta esa energia y si el aliado
     * es del de la instancia de Personaje, se llama al metodo serCurado y
     * retorna true. Sino retorna false.
     *
     * @param caster
     *            que castea
     * @param aliado
     *            implementando Peleable que es aliado
     * @return boolean
     */
    public boolean habilidad2(final Personaje caster, final Peleable aliado) {
	if (caster.getEnergia() > ENERGIA_CONSUMIDA) {
	    caster.setEnergia(caster.getEnergia() - ENERGIA_CONSUMIDA);
	    if (aliado instanceof Personaje) {
		((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
		return true;
	    }
	}
	return false;
    }

    /**
     * Robar Energia y Salud - Habilidad 3
     *
     * Si el caster tiene mas de 10 de energia, gasta esa energia y si el
     * atacado es del de la instancia de Personaje, se llama al metodo
     * serDesernegizado y al metodo serRobadoSalud, incrementa en esos valores a
     * el caster, retorna true. Sino retorna false.
     *
     * @param caster
     *            que castea
     * @param atacado
     *            implementando Peleable que es atacado
     * @return boolean
     */
    public boolean habilidad3(final Personaje caster, final Peleable atacado) {
	if (caster.getEnergia() > ENERGIA_CONSUMIDA) {
	    caster.setEnergia(caster.getEnergia() - ENERGIA_CONSUMIDA);
	    if (atacado instanceof Personaje) {
		int energiaRobada = ((Personaje) atacado).
			serDesernegizado(caster.calcularPuntosDeMagia());
		int saludRobada = ((Personaje) atacado).
			serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
		caster.serEnergizado(energiaRobada);
		caster.serCurado(saludRobada);
		return true;
	    }

	}
	return false;
    }
    @Override
    public void habilidadCasta(final Personaje personaje) {
      personaje.setInteligencia(personaje.getInteligencia() + 5);
    }
}
