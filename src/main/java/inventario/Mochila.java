package inventario;

import java.util.HashMap;

public class Mochila {
	private int idMochila;
	private HashMap<Integer,Item> items;
	
	/**
	 * Mochila Nueva.
	 * Vacia.
	 */
	public Mochila() {
		this.idMochila = 0;
		this.items = new HashMap<Integer,Item>();
	}
	
	/**
	 * Mochila Parametrizada
	 * @param idMochila
	 * @param items
	 */
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
	
	public Item obtenerItem(int idItem) {
		return this.getItems().get(idItem);
	}
	

}
