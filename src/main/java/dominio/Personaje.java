package dominio;

import java.io.Serializable; 

/**
 * <p> Contiene la información necesaria para la creación de un personaje :
 * 	 	+ El nivel de salud del personaje
 *  	+ El nivel de energía del personaje
 *  	+ La fuerza del personaje
 *  	+ La destreza del personaje
 *  	+ La inteligencia del personaje
 *  	+ La defensa del personaje (la cual depende de su destreza)
 *  	+ El ataque del personaje(el cual depende de su fuerza)
 * 		+ El nivel de magia del personaje (el cual depende de su inteligencia )
 * 		+ El Nombre del personaje 
 *  	+ La Raza del personaje
 *  	+ La casta del personaje
 *  	+ El nivel del personaje 
 *  	+ La experiencia que tiene el personaje 
 *  	+ La posicion de dicho personaje 
 *  	+ La ID del personaje 
 *  	+ El nombre de la alianza a la que pertenece el personaje 
 *  	+ La tabla de niveles del personaje 
 *  
 *  
 *      
 * 	@see Peleable
 *
 */

public abstract class Personaje implements Peleable, Serializable {

    	protected static final int MAX_SKILL_VALUE = 200;
	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;
	
	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}
	
	/**
	 * Método que carga/inicializa la tabla de niveles del personaje 
	 */
	
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	/**
	 * Método constructor de un personaje nuevo el cual determina los atributos del personaje dependiendo de su casta 
	 * 
	 * 
	 * @param nombre 
	 * @param casta
	 * @param id
	 */
	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	/**
	 * Método constructor de un personaje existente 
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
	
	
	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Método que permite al personaje atacar , determinando si el ataque va a ser critico o no basado 
	 * en las probabilidades de critico de su determinada casta .
	 * 
	 * @param atacado -> Peleable q recibe el ataque 
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return atacado.serAtacado(this.golpe_critico()) -> Daño en caso de ser golpe crítico
	 * @return atacado.serAtacado(this.ataque) -> Daño en caso de ser golpe normal
	 * 
	 */
	
	public int atacar(Peleable atacado) {
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());  //ataque crítico
			} else {
				return atacado.serAtacado(this.ataque);//ataque normal
			}
		}
		return 0;
	}

	/**
	 * Método que permite calcular el daño crítico basado en la casta del personaje
	 * 
	 * @return (int) (this.ataque * this.getCasta().getDañoCritico()) -> Valor del daño crítico realizado por el golpe 
	 */
	
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}

	/**
	 * Método que permite determinar si el personaje puede realizar un ataque basado en si tiene la cantidad 
	 * necesaria de energia
	 * 
	 * @return energia > 10 -> Valor para determinar si posee la energia para realizar un ataque
	 */
	
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * Método que permite determinar la cantidad de puntos de ataque del personaje basando en 
	 * la cantidad de fuerza del mismo
	 * 
	 * @return (int) (this.getFuerza() * 1.5) -> Valor de ataque del personaje 
	 */
	
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	/**
	 * Método que permite determinar la cantidad de puntos de defensa del personaje basando en 
	 * la cantidad de destreza del mismo
	 * 
	 * @return (int) (this.getDestreza()) -> Valor de defensa del personaje 
	 */ 
	
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}
	
	/**
	 * Método que permite determinar la cantidad de puntos de magia del personaje basando en 
	 * la cantidad de inteligencia del mismo
	 * 
	 * @return (int) (this.getInteligencia() * 1.5) -> Valor de magia del personaje 
	 */ 
	
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}
	
	/**
	 * Método que permite restablecer la salud a su valor máximo 
	 */ 
	
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	/**
	 * Método que permite restablecer la energía a su valor máximo 
	 */ 
	
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * Método para calcular los atributos del personaje 
	 */ 
	
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}
	
	/**
	 * Método que permite determinar si el personaje se encuentra vivo 
	 * 
	 * @return salud > 0 -> Establece si el personaje esta vivo 
	 */ 

	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * Este método permite definir el estado del personaje luego de recibir un ataque
	 * El nivel de saluda decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje atacado
	 * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
	 * @return daño  -> Daño generado 
	 * 
	 */
	
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
				}
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquiva el golpe
	}

	/**
	 * Este método permite definir el estado del personaje luego de que le roban salud
	 * El nivel de saluda robada decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje al cual se le roba salud
	 * @return daño  -> Daño generado 
	 * 
	 */ 
	
	
	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;// no le roba salud ya que la defensa fue mayor
		if ((salud - daño) >= 0)
			salud -= daño;
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}


	/**
	 * Este método permite definir el estado del personaje luego de que le roban energía
	 * El nivel de energía robada decrementa en función del nivel de defensa que posea el personaje
	 * 
	 * @param daño 	 -> Cantidad recibida de daño por el personaje al cual se le roba energía
	 * @return daño  -> Daño generado 
	 * 
	 */ 
	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;// no le roba energía ya que la defensa fue mayor
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}


	/**
	 * Este método permite curar al personaje por una determinada cantidad de salud
	 * 
	 * @param salud 	 -> Cantidad de salud por la cual el personaje es curado
	 */ 
	
	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}

	/**
	 * Este método permite energizar al personaje por una determinada cantidad de energía
	 * 
	 * @param energia 	 -> Cantidad de energía por la cual el personaje es energizado
	 */ 
	
	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	/**
	 * Este método permite la creación de una alianza por parte del personaje 
	 * 
	 * @param nombre_alianza
	 */ 
	
	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	/**
	 * Este método permite al personaje salir de su actual alianza
	 * 
	 */
	
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * Este método permite permite aliarte con otra persona 
	 * 
	 * @param nuevo_aliado
	 * @return true/false ->determina si se pudo realizar la alianza
	 */
	public boolean aliar(Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this); // el personaje no dispone de alianza por lo cual se crea una predefinda
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true; // el aliado pudo unirse ya que no pertenecia a ninguna alianza
		} else
			return false;// el aliado no pudo unirse ya que pertenece actualmente a otra alianza
	}

	/**
	 * Este método permite la asignacion de los atributos principales del personaje (fuerza/destreza/inteligencia) 
	 * y luego calcula los que se basan en ellos (defensa/magia/ataque) 
	 * 
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 */
	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= MAX_SKILL_VALUE) {
			this.fuerza += fuerza;
			 }
		if (this.destreza + destreza <= MAX_SKILL_VALUE)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= MAX_SKILL_VALUE)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}
	
	/**
	 * Este método permite subir de nivel al personaje hasta un máximo de 100
	 */
	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}
	
	/**
	 * Este método permite sumarle una determinada cantidad de experiencia al personaje y 
	 * determinar si sube de nivel
	 * 
	 * @param exp
	 * @return true/false -> Determina si subió o no de nivel como resultado de la suma de experiencia
	 */ 
	
	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}
	/**
	 * Este método permite otorgar experiencia basada en el nivel del personaje 
	 * 
	 * @return this.nivel * 40 -> Cantidad de experiencia entregada 
	 */
	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/**
	 * Este método permite calcular los tildes de distancia que hay entre este personaje y otro 
	 * 
	 * @param p -> personaje respecto al cual quiero saber la distancia
	 * @return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2)) -> Cantidad de tildes de 
	 * distancia con respecto al otro personaje 
	 */
	
	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	/**
	 * Este método permite al personaje usar su primera habilidad de casta 
	 * 
	 * @param atacado -> peleable a atacar
	 * @return this.getCasta().habilidad1(this, atacado) -> Determina si se puede o no realizar la habilidad
	 */
	
	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * Este método permite al personaje usar su segunda habilidad de casta 
	 * 
	 * @param atacado -> peleable a atacar
	 * @return this.getCasta().habilidad2(this, atacado) -> Determina si se puede o no realizar la habilidad
	 */
	
	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
	 * Este método permite al personaje usar su tercera habilidad de casta 
	 * 
	 * @param atacado -> peleable a atacar
	 * @return this.getCasta().habilidad3(this, atacado) -> Determina si se puede o no realizar la habilidad
	 */

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * Este método permite al personaje usar su primera habilidad de raza 
	 * 
	 * @param atacado -> peleable a atacar
	 */
	
	public abstract boolean habilidadRaza1(Peleable atacado);
	
	/**
	 * Este método permite al personaje usar su segunda habilidad de raza 
	 * 
	 * @param atacado -> peleable a atacar
	 */
	
	public abstract boolean habilidadRaza2(Peleable atacado);
}
