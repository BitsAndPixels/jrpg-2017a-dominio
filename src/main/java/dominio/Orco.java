package dominio;
/**
 * <p> Contiene los constructores y las habilidades de la raza Orco
 *      
 * 	@see Personajes
 *
 */
public class Orco extends Personaje {

	/**
	 * Método constructor de un personaje nuevo de raza orco el cual determina los atributos del
	 *  personaje dependiendo de su casta
	 * 
	 * @param nombre 
	 * @param casta
	 * @param id
	 */
	
	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Método constructor de un personaje existente de raza orco 
	 * 
	 * 
	 * @param nombre 
	 * @param salud
	 * @param energia 
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta -> La clase del personaje 
	 * @param experiencia
	 * @param nivel 
	 * @param idPersonaje
	 */
	
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Este método permite al orco usar su primera habilidad de raza 
	 * 
	 * @param atacado -> peleable a atacar
	 * @return true/false -> Determina si se puede o no realizar la habilidad
	 */
	
	// Golpe Defensa
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Este método permite al orco usar su segunda habilidad de raza 
	 * 
	 * @param atacado -> peleable a atacar
	 * @return true/false -> Determina si se puede o no realizar la habilidad
	 */
	
	// Mordisco de Vida
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
}
