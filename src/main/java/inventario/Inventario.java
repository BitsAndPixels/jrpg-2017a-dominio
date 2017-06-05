package inventario;

import constantes.TiposItem;

public class Inventario {
	private int idInventario;
	private Item manoDer;
	private Item manoIzq;
	private Item pie;
	private Item cabeza;
	private Item pecho;
	private Item accesorio;
	
	public Inventario(int idInventario, Item manos1, Item manos2, Item pie, Item cabeza, Item pecho, Item accesorio) {
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

	public Item getManosDer() {
		return manoDer;
	}
	
	public Item getManosIzq() {
		return manoIzq;
	}

	public void setManoDer(Item itemManos1) {
		this.manoDer = itemManos1;
	}
	
	public void setManoIzq(Item itemManos2) {
		this.manoIzq = itemManos2;
	}

	public Item getPie() {
		return pie;
	}

	public void setPie(Item pie) {
		this.pie = pie;
	}

	public Item getCabeza() {
		return cabeza;
	}

	public void setCabeza(Item cabeza) {
		this.cabeza = cabeza;
	}

	public Item getPecho() {
		return pecho;
	}

	public void setPecho(Item pecho) {
		this.pecho = pecho;
	}

	public Item getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(Item accesorio) {
		this.accesorio = accesorio;
	}

	public boolean equiparItem(Item item) {
		switch (item.getTipo()) {
		case TiposItem.MANO_DERECHA:
			this.setManoDer(item);
			return true;
		case TiposItem.MANO_IZQUIERDA:
			this.setManoIzq(item);
			return true;
		case TiposItem.PIES:
			this.setPie(item);
			return true;
		case TiposItem.CABEZA:
			this.setCabeza(item);
			return true;
		case TiposItem.PECHO:
			this.setPecho(item);
			return true;
		case TiposItem.ACCESORIO:
			this.setAccesorio(item);
			return true;
		}
	return false;
	}
}
