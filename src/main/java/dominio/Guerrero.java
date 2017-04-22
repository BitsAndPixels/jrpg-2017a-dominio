package dominio;

/**
* Clase Guerrero - extiende de la clase abstracta Casta
* Contiene el contructor por defecto.
* Contiene el contructor parametrizado de la clase.
* Contiene las tres habilidades.
*/
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
    * Ataque Doble - Habilidad 1
	*
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y si el atacado es atacado con el ataque del 
	* caster por dos mayor a 0 retorna true. 
	* Sino retorna false.
	*
	* @param Personaje que castea
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	/**
    * Aumentar Defensa - Habilidad 2
	*
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y caster aumenta su defensa como magia
	* tenga el caster, retorna true. 
	* Sino retorna false.
	*
	* @param Personaje que castea
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	/**
    * Ignorar Defensa - Habilidad 3
	*
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y  si el atacado es del de la instancia de Personaje,
	* se modifica la defensa del atacado.
	* Sino retorna false.
	*
	* @param Personaje que castea
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
