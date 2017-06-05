package inventario;

public class Item {
	protected int idItem;
	protected int bonoAtaque;
	protected int bonoDefensa;
	protected int bonoMagia;
	protected int bonoSalud;
	protected int bonoEnergia;
	protected int fuerzaRequerida;
	protected int inteligenciaRequerida;
	protected int tipo;
	protected String nombre;
	protected String estado;
	
	
	public Item(int idItem, int bonoAtaque, int bonoDefensa, int bonoMagia, int bonoSalud, int bonoEnergia,
			int fuerzaRequerida, int inteligenciaRequerida, int tipo, String nombre, String estado) {
	super();
	this.idItem = idItem;
	this.bonoAtaque = bonoAtaque;
	this.bonoDefensa = bonoDefensa;
	this.bonoMagia = bonoMagia;
	this.bonoSalud = bonoSalud;
	this.bonoEnergia = bonoEnergia;
	this.fuerzaRequerida = fuerzaRequerida;
	this.inteligenciaRequerida = inteligenciaRequerida;
	this.tipo = tipo;
	this.nombre = nombre;
	this.estado = estado;
	}


	public int getIdItem() {
		return idItem;
	}


	public int getBonoAtaque() {
		return bonoAtaque;
	}


	public int getBonoDefensa() {
		return bonoDefensa;
	}


	public int getBonoMagia() {
		return bonoMagia;
	}


	public int getBonoSalud() {
		return bonoSalud;
	}


	public int getBonoEnergia() {
		return bonoEnergia;
	}


	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}


	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}


	public int getTipo() {
		return tipo;
	}


	public String getNombre() {
		return nombre;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
