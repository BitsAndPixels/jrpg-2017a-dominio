package dominio;

import static constantes.ConstantesHumano.*;
import static constantes.ConstantesPersonaje.*;

import inventario.Inventario;
import inventario.Mochila;
/**
 * Class Humano Extiende a la Class Personaje dandole caracteristicas de Humano.
 * Ventajas: salud +5 y energía +5
 * @see #Humano(String, Casta, int) Habilidades: Incentivar y Golpe Fatal
 * @see #habilidadRaza1(Peleable)
 * @see #habilidadRaza2(Peleable)
 */
public class Humano extends Personaje {

    /**
     * @param nombre nombre
     * @param casta casta
     * @param id id unico de personaje
     */
    public Humano(final String nombre, final Casta casta, final int id, final Inventario inventario, final Mochila mochila) {
	super(nombre, casta, id, "Humano", SALUD_BONUS, ENERGIA_BONUS,
		"Incentivar", "Golpe Fatal", inventario, mochila);
    }

    /**
     * Método constructor de un personaje existente de raza humano.
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
    public Humano(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje, final Inventario inventario, final Mochila mochila) {
	super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
		experiencia, nivel, idPersonaje, "Humano", "Incentivar", "Golpe Fatal", inventario, mochila);
    }
    /**
     * Habilidad de Humano "Incentivar": Si la energia del personaje es mayor a
     * 10, brinda a un aliado puntos de magia para sus ataques.
     * @param atacado
     *            aliado que recibe los puntos de magia para sumar a los de su
     *            ataque.
     * @return true si se pudo aplicar la habilidad, false si no se pudo.
     */
    public boolean habilidadRaza1(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
		this.consumirEnergia(ENERGIA_CONSUMIDA);
	    atacado.setAtaque(atacado.getAtaque() + this.getMagia());
	    return true;
	}
	return false;
    }

    /**
     * Habilidad de Humano "Golpe Fatal": Si la energia del personaje es mayor a
     * 10, brinda la posibilidad de un golpe capaz de quitar hasta la mitad de
     * la salud del oponente.
     * @param atacado
     *            personaje que recibe el ataque Golpe Fatal.
     * @return true si se pudo aplicar la habilidad, false si no se pudo.
     */
    public boolean habilidadRaza2(final Peleable atacado) {
	if (this.getEnergia() > ENERGIA_CONSUMIDA) {
	    if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
	    this.consumirEnergia(this.getEnergia()/2);
		return true;
	    }
	}
	//this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	this.consumirEnergia(ENERGIA_CONSUMIDA);
	return false;
    }
}
