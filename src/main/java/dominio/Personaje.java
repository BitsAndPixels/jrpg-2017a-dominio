package dominio;

import static constantes.ConstantesPersonaje.*;

import java.io.Serializable;
import java.util.HashMap;


/**
 * @JavaDoc
 *          <p>
 *          Contiene la información necesaria para la creación de un personaje :
 *          + El nivel de salud del personaje + El nivel de energía del
 *          personaje + La fuerza del personaje + La destreza del personaje + La
 *          inteligencia del personaje + La defensa del personaje (la cual
 *          depende de su destreza) + El ataque del personaje(el cual depende de
 *          su fuerza) + El nivel de magia del personaje (el cual depende de su
 *          inteligencia ) + El Nombre del personaje + La Raza del personaje +
 *          La casta del personaje + El nivel del personaje + La experiencia que
 *          tiene el personaje + La posicion de dicho personaje + La ID del
 *          personaje + El nombre de la alianza a la que pertenece el personaje
 *          + La tabla de niveles del personaje.
 * @see Peleable
 * @see all @
 *
 */
/**
 * @author Administrador
 *
 */
public abstract class Personaje extends Avatar implements Peleable,
Serializable {
    /**
     * Energia.
     */
    protected int energia;
    /**
     * Depende de la fuerza.
     */
    protected int ataque;
    /**
     * depende de la inteligencia.
     */
    protected int magia;

    /**
     * nombreRaza.
     */
    protected String nombreRaza;

    /**
     * saludTope.
     */
    protected int saludTope;
    /**
     * energiaTope.
     */
    protected int energiaTope;
    /**
     * destreza.
     */
    protected int destreza;
    /**
     * inteligencia.
     */
    protected int inteligencia;
    /**
     * casta.
     */
    protected Casta casta;
    /**
     * x.
     */
    protected int x;
    /**
     * y.
     */
    protected int y;

    /**
     * experiencia.
     */
    protected int experiencia;
    /**
     * idPersonaje.
     */
    protected int idPersonaje;

    /**
     * clan.
     */
    protected Alianza clan = null;
    /**
     * tablaDeNiveles.
     */
    public static int tablaDeNiveles[];
    /**
     * habilidadesRaza.
     */
    protected String[] habilidadesRaza;

    /**
     * @return habilidadesRaza.
     */
    public String[] getHabilidadesRaza() {
	return habilidadesRaza;
    }

    /**
     * @return habilidades de casta.
     */
    public String[] getHabilidadesCasta() {
	return casta.getHabilidadesCasta();
    }

    /**
     * Método que carga/inicializa la tabla de niveles del personaje.
     */
    public static void cargarTablaNivel() {
	Personaje.tablaDeNiveles = new int[NIVEL_MAX + 1];
	Personaje.tablaDeNiveles[0] = 0;
	Personaje.tablaDeNiveles[1] = 0;
	for (int i = 2; i < NIVEL_MAX + 1; i++) {
	    Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1]
		    + NIVEL_MAX / 2;
	}
    }

    /**
     * Método constructor de un personaje nuevo el cual determina los atributos
     * del personaje dependiendo de su casta.
     *
     * @param nombre nombre
     * @param casta casta.
     * @param id id.
     * @param nombreRaza nombreRaza.
     * @param saludBonus saludBonus.
     * @param energiaBonus energiaBonus.
     * @param habilidadUno habilidadUno.
     * @param habilidadDos habilidadDos.
     */
    public Personaje(final String nombre, final Casta casta, final int id,
	    final String nombreRaza, final int saludBonus,
	    final int energiaBonus,final String habilidadUno,
	    final String habilidadDos) {

	super(nombre, SALUD_TOPE, FUERZA_INICIAL, 1);
	this.casta = casta;
	this.idPersonaje = id;
	experiencia = 0;
	inteligencia = INTELIGENCIA_INICIAL;
	destreza = DESTREZA_INICIAL;
	destreza+=casta.getBonusDestreza();
	inteligencia+=casta.getBonusInteligencia();
	fuerza+=casta.getBonusFuerza();
	x = 0;
	y = 0;
	saludTope = SALUD_TOPE + saludBonus;
	energiaTope = ENERGIA_TOPE + energiaBonus;
	salud = saludTope;
	energia = energiaTope;
	habilidadesRaza = new String[2];
	habilidadesRaza[0] = habilidadUno;
	habilidadesRaza[1] = habilidadDos;
	ataque = this.calcularPuntosDeAtaque();
	defensa = this.calcularPuntosDeDefensa();
	magia = this.calcularPuntosDeMagia();
    }


    /**
     * Método constructor de un personaje existente.
     * @param nombre nombre.
     * @param salud salud.
     * @param energia energia.
     * @param fuerza fuerza.
     * @param destreza destreza.
     * @param inteligencia inteligencia.
     * @param casta casta.
     * @param experiencia experiencia.
     * @param nivel nivel.
     * @param idPersonaje idPersonaje.
     * @param nombreRaza nombreRaza.
     * @param habilidadUno habilidadUno.
     * @param habilidadDos habilidadDos.
     */
    public Personaje(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje, final String nombreRaza, final String habilidadUno,
	    final String habilidadDos) {

	super(nombre, salud, fuerza, nivel);
	this.energia = energia;
	this.destreza = destreza;
	this.inteligencia = inteligencia;
	this.casta = casta;
	this.experiencia = experiencia;
	this.saludTope = this.salud;
	this.energiaTope = this.energia;
	this.idPersonaje = idPersonaje;
	this.nombreRaza = nombreRaza;
	this.habilidadesRaza = new String[2];
	this.habilidadesRaza[0] = habilidadUno;
	this.habilidadesRaza[1] = habilidadDos;
	this.defensa = this.calcularPuntosDeDefensa();
	this.ataque = this.calcularPuntosDeAtaque();
	this.magia = this.calcularPuntosDeMagia();
    }

    /**
     * @return nombreRaza.
     */
    public String getNombreRaza() {
	return nombreRaza;
    }

    /**
     * @param nombreRaza nombreRaza.
     */
    public void setNombreRaza(final String nombreRaza) {
	this.nombreRaza = nombreRaza;
    }

    /* (non-Javadoc)
     * @see dominio.Peleable#getAtaque()
     */
    @Override
    public int getAtaque() {
	return ataque;
    }

    /* (non-Javadoc)
     * @see dominio.Peleable#setAtaque(int)
     */
    @Override
    public void setAtaque(final int ataque) {
	this.ataque = ataque;
    }

    /**
     * @return magia.
     */
    public int getMagia() {
	return magia;
    }

    /**
     * @param magia magia.
     */
    public void setMagia(final int magia) {
	this.magia = magia;
    }

    /**
     * @return clan.
     */
    public Alianza getClan() {
	return clan;
    }

    /**
     * @param clan setea en clan y en el clan del personaje.
     */
    public void setClan(final Alianza clan) {
	this.clan = clan;
	clan.añadirPersonaje(this);
    }

    /* (non-Javadoc)
     * @see dominio.Peleable#getSalud()
     */
    @Override
    public int getSalud() {
	return salud;
    }

    /**
     * @return energia.
     */
    /**
     * @return
     */
    public int getEnergia() {
	return energia;
    }

    /**
     * @return destreza.
     */
    public int getDestreza() {
	return destreza;
    }

    /**
     * @param destreza destreza.
     */
    public void setDestreza(final int destreza) {
	this.destreza = destreza;
    }

    /**
     * @return inteligencia.
     */
    public int getInteligencia() {
	return inteligencia;
    }

    /**
     * @param inteligencia inteligencia.
     */
    public void setInteligencia(final int inteligencia) {
	this.inteligencia = inteligencia;
    }

    /**
     * @return casta.
     */
    public Casta getCasta() {
	return casta;
    }

    /**
     * @param casta casta.
     */
    public void setCasta(final Casta casta) {
	this.casta = casta;
    }

    /**
     * @return experiencia.
     */
    public int getExperiencia() {
	return experiencia;
    }

    /**
     * @param experiencia experiencia.
     */
    public void setExperiencia(final int experiencia) {
	this.experiencia = experiencia;
    }

    /* (non-Javadoc)
     * @see dominio.Avatar#getNivel()
     */
    @Override
    public int getNivel() {
	return nivel;
    }

    /* (non-Javadoc)
     * @see dominio.Avatar#setNivel(int)
     */
    @Override
    public void setNivel(final int nivel) {
	this.nivel = nivel;
    }

    /**
     * @return idPersonaje.
     */
    public int getIdPersonaje() {
	return idPersonaje;
    }

    /**
     * @param idPersonaje idPersonaje.
     */
    public void setIdPersonaje(final int idPersonaje) {
	this.idPersonaje = idPersonaje;
    }

    /**
     * @return .
     */
    public int getDefensa() {
	return defensa;
    }

    /**
     * @return saludTope.
     */
    public int getSaludTope() {
	return saludTope;
    }

    /**
     * @param saludTope saludTope.
     */
    public void setSaludTope(final int saludTope) {
	this.saludTope = saludTope;
    }

    /**
     * @return energiaTope.
     */
    public int getEnergiaTope() {
	return energiaTope;
    }

    /**
     * @param energiaTope energiaTope.
     */
    public void setEnergiaTope(final int energiaTope) {
	this.energiaTope = energiaTope;
    }


    /**
     * Método que permite al personaje atacar , determinando si el ataque va a
     * ser critico o no basado en las probabilidades de critico de su
     * determinada casta.
     *
     * @param atacado
     *            -> Peleable q recibe el ataque
     * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
     * @return atacado.serAtacado(this.golpe_critico()) -> Daño en caso de ser
     *         golpe crítico atacado.serAtacado(this.ataque) -> Daño en caso de
     *         ser golpe normal
     */
    @Override
    public int atacar(final Peleable atacado) {
	
    if (salud == 0) {
	    return 0;
	}
	if (atacado.getSalud() > 0) {
	    if (this.myRandom.nextDouble()
		    <= this.casta.getProbabilidadGolpeCritico()
		    + this.destreza / DIVISOR_GOLPE_CRITICO) {
		return atacado.serAtacado(this.golpeCritico()); // ataque
		// crítico
	    } else {
		return atacado.serAtacado(this.ataque); // ataque normal
	    }
	}
	return 0;
    }

    /**
     * Método que permite calcular el daño crítico basado en la casta del
     * personaje.
     *
     * @return (int) (this.ataque * this.getCasta().getDañoCritico()) -> Valor
     *         del daño crítico realizado por el golpe
     */
    public int golpeCritico() {
	return (int) (this.ataque * this.getCasta().getDañoCritico());
    }

    /**
     * Por estar en la interfaz.
     */
    @Override
    public void despuesDeTurno() {
    }

    /**
     * Método que permite determinar si el personaje puede realizar un ataque
     * basado en si tiene la cantidad necesaria de energia.
     *
     * @return energia > 10 -> Valor para determinar si posee la energia para
     *         realizar un ataque
     */
    public boolean puedeAtacar() {
	return energia > ENERGIA_ATAQUE;
    }

    /**
     * Método que permite determinar la cantidad de puntos de ataque del
     * personaje basando en la cantidad de fuerza del mismo.
     *
     * @return (int) (this.getFuerza() * MUL_PUNTOS_FUERZA)
     * -> Valor de ataque del personaje
     */
    /**
     * @return
     */
    public int calcularPuntosDeAtaque() {
	return (int) (this.getFuerza() * MUL_PUNTOS_FUERZA);
    }

    /**
     * Método que permite determinar la cantidad de puntos de defensa del
     * personaje basando en la cantidad de destreza del mismo.
     *
     * @return (int) (this.getDestreza()) -> Valor de defensa del personaje
     */
    public int calcularPuntosDeDefensa() {
	return (this.getDestreza());
    }

    /**
     * Método que permite determinar la cantidad de puntos de magia del
     * personaje basando en la cantidad de inteligencia del mismo.
     *
     * @return (int) (this.getInteligencia() * MUL_PUNTOS_MAGIA)
     *  -> Valor de magia del personaje
     */
    public int calcularPuntosDeMagia() {
	return (int) (this.getInteligencia() * MUL_PUNTOS_MAGIA);
    }

    /**
     * Método que permite restablecer la salud a su valor máximo.
     */

    public void restablecerSalud() {
	this.salud = this.saludTope;
    }

    /**
     * Método que permite restablecer la energía a su valor máximo.
     */

    public void restablecerEnergia() {
	this.energia = this.energiaTope;
    }

    /**
     * Método para calcular los atributos del personaje.
     */

    public void modificarAtributos() {
	this.ataque = this.calcularPuntosDeAtaque();
	this.defensa = this.calcularPuntosDeDefensa();
	this.magia = this.calcularPuntosDeMagia();
    }

    /**
     * Método que permite determinar si el personaje se encuentra vivo.
     *
     * @return salud > 0 -> Establece si el personaje esta vivo.
     */
    @Override
    public boolean estaVivo() {
	return salud > 0;
    }

    /**
     * Este método permite definir el estado del personaje luego de recibir un
     * ataque El nivel de saluda decrementa en función del nivel de defensa que
     * posea el personaje.
     *
     * @param daño
     *            -> Cantidad recibida de daño por el personaje atacado
     * @see MyRandom -> Clase MyRandom perteneciente a este proyecto
     * @return daño -> Daño generado.
     */

    @Override
    public int serAtacado(int daño) {
    
    if (this.myRandom.nextDouble() >= this.getCasta().
    	getProbabilidadEvitarDaño()) {
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
	    return 0;
	}
	return 0;
    }

    /**
     * Este método permite definir el estado del personaje luego de que le roban
     * salud El nivel de saluda robada decrementa en función del nivel de
     * defensa que posea el personaje.
     *
     * @param daño
     *            -> Cantidad recibida de daño por el personaje al cual se le
     *            roba salud
     * @return daño -> Daño generado.
     */
    public int serRobadoSalud(int daño) {
	daño -= this.defensa;
	if (daño <= 0) {
	    return 0;
	}
	if ((salud - daño) >= 0) {
	    salud -= daño;
	} else {
	    daño = salud;
	    salud = 0;
	}
	return daño;
    }

    /**
     * Este método permite definir el estado del personaje luego de que le roban
     * energía El nivel de energía robada decrementa en función del nivel de
     * defensa que posea el personaje.
     *
     * @param daño
     *            -> Cantidad recibida de daño por el personaje al cual se le
     *            roba energía
     * @return daño -> Daño generado
     */
    public int serDesernegizado(int daño) {
	daño -= this.defensa;
	if (daño <= 0) {
	    return 0;
	}
	if ((energia - daño) >= 0) {
	    energia -= daño;
	} else {
	    daño = energia;
	    energia = 0;
	}
	return daño;
    }

    /**
     * Este método permite curar al personaje por una determinada cantidad de
     * salud.
     *
     * @param salud
     *            -> Cantidad de salud por la cual el personaje es curado
     */
    public void serCurado(final int salud) {
	if ((this.salud + salud) <= this.saludTope) {
	    this.salud += salud;
	} else {
	    this.salud = this.saludTope;
	}
    }

    /**
     * Este método permite energizar al personaje por una determinada cantidad
     * de energía.
     *
     * @param energia energia que recupera
     *            -> Cantidad de energía por la cual el personaje es energizado
     */
    public void serEnergizado(final int energia) {
	if ((this.energia + energia) <= this.energiaTope) {
	    this.energia += energia;
	} else {
	    this.energia = this.energiaTope;
	}
    }

    /**
     * Este método permite la creación de una alianza por parte del personaje.
     *
     * @param nombreAlianza nombre de la alianza
     */
    public void crearAlianza(final String nombreAlianza) {
	this.clan = new Alianza(nombreAlianza);
	this.clan.añadirPersonaje(this);
    }

    /**
     * Este método permite al personaje salir de su actual alianza.
     */
    public void salirDeAlianza() {
	if (this.clan != null) {
	    this.clan.eliminarPersonaje(this);
	    this.clan = null;
	}
    }

    /**
     * Este método permite permite aliarte con otra persona.
     *
     * @param nuevoAliado aliado que se incorpora
     * @return true/false ->determina si se pudo realizar la alianza
     */
    public boolean aliar(final Personaje nuevoAliado) {
	if (this.clan == null) {
	    final Alianza a = new Alianza("Alianza 1");
	    this.clan = a;
	    a.añadirPersonaje(this);
	}

	if (nuevoAliado.clan == null) {
	    nuevoAliado.clan = this.clan;
	    this.clan.añadirPersonaje(nuevoAliado);
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Este método permite la asignacion de los atributos principales del
     * personaje (fuerza/destreza/inteligencia) y luego calcula los que se basan
     * en ellos (defensa/magia/ataque).
     *
     * @param fuerza fuerza
     * @param destreza destreza
     * @param inteligencia inteligencia
     */
    public void AsignarPuntosSkills(final int fuerza, final int destreza,
	    final int inteligencia) {
	if (this.fuerza + fuerza <= MAX_SKILL_VALUE) {
	    this.fuerza += fuerza;
	}
	if (this.destreza + destreza <= MAX_SKILL_VALUE) {
	    this.destreza += destreza;
	}

	if (this.inteligencia + inteligencia <= MAX_SKILL_VALUE) {
	    this.inteligencia += inteligencia;
	}
	this.modificarAtributos();
    }

    /**
     * Este método permite subir de nivel al personaje hasta un máximo de 100.
     */
    public void subirNivel() {

	int acumuladorExperiencia = 0;
	if (this.nivel == NIVEL_MAX) {
	    return;
	}
	while (this.nivel != NIVEL_MAX && (this.experiencia >= Personaje.
		tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
	    acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
	    this.nivel++;
	    this.modificarAtributos();
	    this.saludTope += AUMENTO_SALUD;
	    this.energiaTope += AUMENTO_ENERGIA;
	}
	this.experiencia -= acumuladorExperiencia;
    }

    /**
     * Este método permite sumarle una determinada cantidad de experiencia al
     * personaje y determinar si sube de nivel.
     *
     * @param exp esperiencia
     * @return true/false -> Determina si subió o no de nivel como resultado de
     *         la suma de experiencia
     */
    public boolean ganarExperiencia(final int exp) {
	this.experiencia += exp;

	if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
	    subirNivel();
	    return true;
	}
	return false;
    }

    /**
     * Este método permite otorgar experiencia basada en el nivel del personaje.
     *
     * @return this.nivel * 40 -> Cantidad de experiencia entregada.
     */
    @Override
    public int otorgarExp() {
	return this.nivel * EXPERIENCIA;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
	return super.clone();
    }

    /**
     * Este método permite calcular los tildes de distancia que hay entre este
     * personaje y otro.
     *
     * @param p
     *            -> personaje respecto al cual quiero saber la distancia
     * @return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2))
     *         -> Cantidad de tildes de distancia con respecto al otro personaje
     */

    public double distanciaCon(final Personaje p) {
	return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    /**
     * Este método permite al personaje usar su primera habilidad de casta.
     *
     * @param atacado
     *            -> peleable a atacar
     * @return this.getCasta().habilidad1(this, atacado) -> Determina si se
     *         puede o no realizar la habilidad
     */
    public boolean habilidadCasta1(final Peleable atacado) {
	return this.getCasta().habilidad1(this, atacado);
    }

    /**
     * Este método permite al personaje usar su segunda habilidad de casta.
     *
     * @param atacado
     *            -> peleable a atacar
     * @return this.getCasta().habilidad2(this, atacado) -> Determina si se
     *         puede o no realizar la habilidad
     */
    public boolean habilidadCasta2(final Peleable atacado) {
	return this.getCasta().habilidad2(this, atacado);
    }

    /**
     * Este método permite al personaje usar su tercera habilidad de casta.
     *
     * @param atacado
     *            -> peleable a atacar
     * @return this.getCasta().habilidad3(this, atacado) -> Determina si se
     *         puede o no realizar la habilidad
     */
    public boolean habilidadCasta3(final Peleable atacado) {
	return this.getCasta().habilidad3(this, atacado);
    }

    /**
     * Este método permite al personaje usar su primera habilidad de raza.
     *
     * @param atacado
     *            -> peleable a atacar
     * @return boolean.
     */
    public abstract boolean habilidadRaza1(Peleable atacado);

    /**
     * Este método permite al personaje usar su segunda habilidad de raza.
     *
     * @param atacado
     *            -> peleable a atacar
     * @return boolean.
     */
    public abstract boolean habilidadRaza2(Peleable atacado);
    /**
     * Reemplazo del instance of.
     * @return true
     */
    public boolean esPersonaje() {
	return true;
    }

	public void modificarAtributos(HashMap<String,Integer> atributos) {
	this.salud = atributos.get("salud"+this.getIdPersonaje());
	this.energia = atributos.get("energia"+this.getIdPersonaje());	
	}
	
	public void consumirEnergia(int energiaConsumida) {
	this.energia -= energiaConsumida;
	}
	
	public void modificarDefensa(int valor) {
	this.defensa+=valor;
	}
}
