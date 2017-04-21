package dominio;
/**
 * Class Humano
 * Extiende a la Class Personaje dandole caracteristicas de Humano:
 * Ventajas: salud +5 y energía +5
 * @see #Humano(String, Casta, int)
 * Habilidades: Incentivar y Golpe Fatal
 * @see #habilidadRaza1(Peleable)
 * @see #habilidadRaza2(Peleable)
 */
public class Humano extends Personaje {

	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	// Incentivar
	/**
	 * Habilidad de Humano "Incentivar":
	 * Si la energia del personaje es mayor a 10, brinda a un aliado puntos de magia para sus ataques.
	 * @param atacado aliado que recibe los puntos de magia para sumar a los de su ataque.
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	// Golpe Fatal
	/**
	 * Habilidad de Humano "Golpe Fatal":
	 * Si la energia del personaje es mayor a 10, brinda la posibilidad de un golpe capaz de quitar hasta la mitad de la salud del oponente.
	 * @param atacado personaje que recibe el ataque Golpe Fatal.
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
