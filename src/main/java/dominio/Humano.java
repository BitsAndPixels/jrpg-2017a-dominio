package dominio;

/**
 * Class Humano Extiende a la Class Personaje dandole caracteristicas de Humano.
 * Ventajas: salud +5 y energía +5
 * @see #Humano(String, Casta, int) Habilidades: Incentivar y Golpe Fatal
 * @see #habilidadRaza1(Peleable)
 * @see #habilidadRaza2(Peleable)
 */
public class Humano extends Personaje {
    /**
     * @param SALUD_TOPE incremento de salud tope.
     */
    protected static final int SALUD_BONUS = 5;
    /**
     * @param ENERGIA_BONUS incremento de energia tope.
     */
    protected static final int ENERGIA_BONUS = 5;
    
    /**
     * @param nombre nombre
     * @param casta casta
     * @param id id unico de personaje
     */
    public Humano(final String nombre, final Casta casta, final int id) {
    super(nombre, casta, id,"Humano", SALUD_BONUS, ENERGIA_BONUS, "Incentivar", "Golpe Fatal");
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
    	    final int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
    	experiencia, nivel, idPersonaje, "Humano", "Incentivar", "Golpe Fatal");
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
	    this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	    atacado.setAtaque(atacado.getAtaque() + this.getMagia());
	    return true;
	}
	return false;
    }

    // Golpe Fatal
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
		this.setEnergia(this.getEnergia() / 2);
		return true;
	    }
	}
	this.setEnergia(this.getEnergia() - ENERGIA_CONSUMIDA);
	return false;
    }
}
