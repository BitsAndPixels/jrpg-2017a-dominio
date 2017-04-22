package dominio;

/**
* Clase Elfo - extiende de Personaje
* Contiene el contructor parametrizado de la clase.
* Contiene las dos habilidades de raza.
*/
public class Elfo extends Personaje {

	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
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
	* Si el atacante tiene mas de 10 de energia, gasta esa
	* energia y si el atacado es atacado con la fuerza del 
	* atacante mas su nivel por 10 mayor a 0 retorna true. 
	* Sino retorna false.
	*
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0)
				return true;
		}
		return false;
	}

	/**
    * Ataque Bosque - Habilidad de raza 2
	*
	* Si el atacante tiene mas de 10 de energia, gasta esa
	* energia y si el atacado es atacado con la magia del 
	* atacante mayor a 0 retorna true.
	* Sino retorna false.
	*
	* @param Personaje implementando Peleable que es atacado
	* @return boolean
    */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0)
				return true;
		}
		return false;
	}
}
