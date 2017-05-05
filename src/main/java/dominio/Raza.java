package dominio;

public abstract class Raza extends Personaje {
	
	public Raza(String nombre, Casta casta, int id, int saludTope, int energiaTope, String nombreRaza) {
		super(nombre, casta, id);
		
		this.salud = saludTope;
		this.energia = energiaTope;
		this.nombreRaza = nombreRaza;

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	    }
	
	public Raza(final String nombre, final Casta casta, final int id, int salud) {
	super(nombre, casta, id);
	
	}

}
