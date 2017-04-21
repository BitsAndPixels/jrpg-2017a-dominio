package dominio;


/**
 * Class Asesino
 * Extiende a la Class Casta con las habilidades del tipo Asesino:
 * 
 * Habilidades: Golpe Critico, Aumentar Evasion y Robar
 * @see #habilidad1(Personaje, Peleable)
 * @see #habilidad2(Personaje, Peleable)
 * @see #habilidad3(Personaje, Peleable)
 */
public class Asesino extends Casta {

	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	// Golpe Crítico
	/**
	 * Habilidad de Asesino "Golpe Crítico":
	 * Si la energia del personaje es mayor a 10, el personaje podrá dar un golpe critico en base a sus puntos de daño critico:
	 * @see Casta.#dañoCritico
	 * @param caster personaje que realiza la acción
	 * @param atacado personaje que recibe el golpe
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	/**
	 * Habilidad de Asesino "Aumentar Evasion":
	 * Si la energia del personaje es mayor a 10, el personaje podrá evadir un ataque en base a sus puntos de evasión:
	 * @see Casta.#probabilidadEvitarDaño
	 * @param caster personaje que realiza la acción
	 * @param atacado personaje que recibe el golpe
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	// Robar
	/**
	 * Habilidad de Asesino "Robar": 
	 * @param caster personaje que realiza la acción
	 * @param atacado personaje que recibe el golpe
	 * @return false
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
