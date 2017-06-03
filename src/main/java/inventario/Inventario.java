package inventario;

public class Inventario {
	private int idInventario;
	private int manoDer;
	private int manoIzq;
	private int pie;
	private int cabeza;
	private int pecho;
	private int accesorio;
	
	public Inventario(int idInventario, int manos1, int manos2, int pie, int cabeza, int pecho, int accesorio) {
	this.idInventario=idInventario;
	this.manoDer = manos1;
	this.manoIzq = manos2;
	this.pie = pie;
	this.cabeza = cabeza;
	this.pecho = pecho;
	this.accesorio = accesorio;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getManosDer() {
		return manoDer;
	}
	
	public int getManosIzq() {
		return manoIzq;
	}

	public void setManoDer(int itemManos1) {
		this.manoDer = itemManos1;
	}
	
	public void setManoIzq(int itemManos2) {
		this.manoIzq = itemManos2;
	}

	public int getPie() {
		return pie;
	}

	public void setPie(int pie) {
		this.pie = pie;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}

	public int getPecho() {
		return pecho;
	}

	public void setPecho(int pecho) {
		this.pecho = pecho;
	}

	public int getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(int accesorio) {
		this.accesorio = accesorio;
	}

}
