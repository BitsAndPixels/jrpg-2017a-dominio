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
	
	public Inventario() {
	
	}
	
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

	public Item getManoDer() {
		return manoDer;
	}
	
	public Item getManoIzq() {
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
			item.serEquipado();
			this.manoDer=item;
			return true;
		case TiposItem.MANO_IZQUIERDA:
			item.serEquipado();
			this.manoIzq=item;
			return true;
		case TiposItem.PIES:
			item.serEquipado();
			this.pie=item;
			return true;
		case TiposItem.CABEZA:
			item.serEquipado();
			this.cabeza=item;
			return true;
		case TiposItem.PECHO:
			item.serEquipado();
			this.pecho=item;
			return true;
		case TiposItem.ACCESORIO:
			item.serEquipado();
			this.accesorio=item;
			return true;
		}
	return false;
	}
	
	public boolean desequiparItem(Item parteDelCuerpo) {
		if (parteDelCuerpo.getEstado() == "equipado") {
			parteDelCuerpo.serDesequipado();
			//parteDelCuerpo=null;
			return true;
		}
		return false;
	}
	
	public Item obtenerItemEquipado(int tipoItem) {
		Item item = new Item();
		switch (tipoItem) {
		case TiposItem.MANO_DERECHA:
			item = this.getManoDer();
			break;
		case TiposItem.MANO_IZQUIERDA:
			item = this.getManoIzq();
			break;
		case TiposItem.PIES:
			item = this.getPie();
			break;
		case TiposItem.CABEZA:
			item = this.getCabeza();
			break;
		case TiposItem.PECHO:
			item = this.getPecho();
			break;
		case TiposItem.ACCESORIO:
			item = this.getAccesorio();
			break;
		}
		return item;
	}
}
