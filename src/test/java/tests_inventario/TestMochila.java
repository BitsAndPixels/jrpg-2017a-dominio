package tests_inventario;

import org.junit.Test;

import java.util.HashMap;

import org.junit.Assert;

import inventario.*;


public class TestMochila {
	@Test
	public void testCrearMochila() {
		Item item1 = new Item(1,2,0,0,0,0,1,"Espada","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,2,"Escudo","desequipado");
		
		Mochila mochila = new Mochila();
		
		mochila.agregaItem(item1);
		mochila.agregaItem(item2);
		
		Assert.assertEquals("Espada", mochila.obtenerItem(1).getNombre());
		Assert.assertEquals("Escudo", mochila.obtenerItem(2).getNombre());
	}
	
	@Test
	public void testCrearMochilaParametrizada() {
		Item item1 = new Item(1,2,0,0,0,0,1,"Espada","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,2,"Escudo","desequipado");
		
		HashMap<Integer,Item> items = new HashMap<Integer,Item>();
		items.put(item1.getIdItem(), item1);
		items.put(item2.getIdItem(), item2);
		
		Mochila mochila = new Mochila(1,items);
		mochila.setIdMochila(2);
		
//		mochila.agregaItem(item1);
//		mochila.agregaItem(item2);
		
		Assert.assertEquals("Espada", mochila.obtenerItem(1).getNombre());
		Assert.assertEquals("Escudo", mochila.obtenerItem(2).getNombre());
		Assert.assertEquals(2, mochila.getIdMochila());
	}
}
