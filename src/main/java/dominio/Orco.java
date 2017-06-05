package dominio;

import static constantes.ConstantesOrco.*;
import static constantes.ConstantesPersonaje.*;

import inventario.Inventario;
import inventario.Mochila;

/**
 * <p>
 * Contiene los constructores y las habilidades de la raza Orco.
 * @see Personajes
 */

public class Orco extends Personaje {
    /**
     * Método constructor de un personaje nuevo de raza orco el cual determina
     * los atributos del personaje dependiendo de su casta.
     * @param nombre nombre
     * @param casta casta que pertenece
     * @param id id unico de personanje
     */
    public Orco(final String nombre, final Casta casta, final int id, final Inventario inventario, final Mochila mochila) {
	super(nombre, casta, id, "Orco", SALUD_BONUS, ENERGIA_BONUS,
		"Golpe Defensa", "Mordisco de Vida", inventario, mochila);
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
	    final int idPersonaje, final Inventario inventario, final Mochila mochila) {
	super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
		experiencia, nivel, idPersonaje, "Orco", "Golpe Defensa",
		"Mordisco de Vida", inventario, mochila);
    }
    /**Este método permite al orco usar su primera habilidad de raza "Golpe Defensa"
     * @param atacado
     *            -> peleable a atacar
     * @return true/false -> Determina si se puede o no realizar la habilidad
     */
    public boolean habilidadRaza1(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
		this.consumirEnergia(ENERGIA_CONSUMIDA);
	    if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Este método permite al orco usar su segunda habilidad de raza "Mordisco de vida"
     * @param atacado
     *            -> peleable a atacar
     * @return true/false -> Determina si se puede o no realizar la habilidad
     */
    public boolean habilidadRaza2(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
		this.consumirEnergia(ENERGIA_CONSUMIDA);
	    int dañoCausado = atacado.serAtacado(this.getFuerza());
	    if (dañoCausado > 0) {
		this.serCurado(dañoCausado);
		return true;
	    }
	}
	return false;
    }
}
