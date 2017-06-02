package inventario;

public class Inventario {
	private int idInventario;
	private int[] manos;
	private int pie;
	private int cabeza;
	private int pecho;
	private int accesorio;
	
	public Inventario(int idInventario, int manos1, int manos2, int pie, int cabeza, int pecho, int accesorio) {
	this.idInventario=idInventario;
	this.manos = new int[2];
	this.manos[0] = manos1;
	this.manos[1] = manos2;
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

	public int[] getManos() {
		int[] manosCopy = new int[2];
		manosCopy[0]=this.manos[0];
		manosCopy[1]=this.manos[1];
		return manosCopy;
	}

	public void setManos(int[] manos) {
		this.manos = manos;
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
