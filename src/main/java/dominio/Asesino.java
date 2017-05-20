package dominio;

import static constantes.ConstantesAsesino.*;
import static constantes.ConstantesCasta.*;
import static constantes.ConstantesPersonaje.ENERGIA_CONSUMIDA;

/**
 * Class Asesino Extiende a la Class Casta con las habilidades del tipo Asesino:
 * Habilidades: Golpe Critico, Aumentar Evasion y Robar.
 * 
 * @see #habilidad1(Personaje, Peleable)
 * @see #habilidad2(Personaje, Peleable)
 * @see #habilidad3(Personaje, Peleable)
 */
public class Asesino extends Casta {

	/**
	 * @param probCrit
	 *            probabilidad de critico.
	 * @param evasion
	 *            evasion.
	 * @param daño_crit
	 *            valor del da;o critico.
	 */
	public Asesino(final double probCrit, final double evasion, final double daño_crit) {
		super(probCrit, evasion, daño_crit);
		this.nombreCasta = "Asesino";
	}

	/**
	 * Contructor de Asesino.
	 */
	public Asesino() {
		super();
		this.nombreCasta = "Asesino";
		habilidadesCasta = new String[CANTIDAD_HABILIDADES_CASTA];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Habilidad de Asesino "Golpe Crítico". Si la energia del personaje es
	 * mayor a 10, el personaje podrá dar un golpe critico en base a sus puntos
	 * de daño critico:
	 * 
	 * @see Casta.#dañoCritico
	 * @param caster
	 *            personaje que realiza la acción
	 * @param atacado
	 *            personaje que recibe el golpe
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_CONSUMIDA) {
			caster.consumirEnergia(ENERGIA_CONSUMIDA);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Habilidad de Asesino "Aumentar Evasion": Si la energia del personaje es
	 * mayor a 10, el personaje podrá evadir un ataque en base a sus puntos de
	 * evasión.
	 * 
	 * @see Casta.#probabilidadEvitarDaño
	 * @param caster
	 *            personaje que realiza la acción
	 * @param atacado
	 *            personaje que recibe el golpe
	 * @return true si se pudo aplicar la habilidad, false si no se pudo.
	 */
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_CONSUMIDA) {
			caster.consumirEnergia(ENERGIA_CONSUMIDA);
			if (this.getProbabilidadEvitarDaño() + PROB_EVIT_DAÑO_MIN < PROB_EVIT_DAÑO_MAX) {
				this.probabilidadEvitarDaño += PROB_EVIT_DAÑO_MIN;
			} else {
				this.probabilidadEvitarDaño = PROB_EVIT_DAÑO_MAX;
			}
			return true;
		}
		return false;
	}

	/**
	 * Habilidad de Asesino "Robar".
	 * 
	 * @param caster
	 *            personaje que realiza la acción
	 * @param atacado
	 *            personaje que recibe el golpe
	 * @return false
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}

/* (non-Javadoc)
 * @see dominio.Casta#getBonusDestreza()
 */
@Override
	public int getBonusDestreza(){
		return DESTREZA_HABILIDAD_CASTA;
	}
}
