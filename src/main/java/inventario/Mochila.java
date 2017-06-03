package inventario;

public class Mochila {
	private int idMochila;
	private int[] items;
	
	public Mochila(int idMochila, int[] items) {
	super();
	this.idMochila = idMochila;
	this.items = items;
	}

	public int getIdMochila() {
		return idMochila;
	}

	public int[] getItems() {
		return items;
	}
	
	

}
