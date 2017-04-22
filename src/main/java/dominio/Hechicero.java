package dominio;

/**
* Clase Hechicero - extiende de la clase abstracta Casta
* Contiene el contructor por defecto.
* Contiene el contructor parametrizado de la clase.
* Contiene las tres habilidades.
*/
public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}
	
	/**
    * Bola de Fuego - Habilidad 1
	*
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y si el atacado es atacado con los puntos de
	* magia del caster por 1.5 mayor a 0 retorna true. 
	* Sino retorna false.
	*
	* @param Personaje que castea
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	/**
    * Curar Aliado - Habilidad 2
	*
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y si el aliado es del de la instancia de Personaje,
	* se llama al metodo serCurado y retorna true. 
	* Sino retorna false.
	*
	* @param Personaje que castea
	* @param Personaje implementando Peleable que es aliado
	* @return boolean
    */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
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
	* Si el caster tiene mas de 10 de energia, gasta esa
	* energia y  si el atacado es del de la instancia de Personaje,
	* se llama al metodo serDesernegizado y al metodo serRobadoSalud,
	* incrementa en esos valores a el caster, retorna true.
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
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
