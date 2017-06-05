package inventario;

import java.util.HashMap;

public class Mochila {
	private int idMochila;
	private HashMap<Integer,Item> items;
	
	public Mochila(int idMochila, HashMap<Integer,Item> items) {
		super();
		this.idMochila = idMochila;
		this.items = items;
	}

	public int getIdMochila() {
		return idMochila;
	}

	public HashMap<Integer,Item> getItems() {
		return items;
	}
	
	public boolean agregaItem(Item item) {
		if (items.size() < 20) {
			items.put(item.getIdItem(), item);
			return true;
		}
		return false;
	}
	

}
