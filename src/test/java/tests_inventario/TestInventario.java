package tests_inventario;

import org.junit.Test;
import org.junit.Assert;

import inventario.*;
import constantes.TiposItem;

public class TestInventario {
	@Test
	public void testCrearInventario() {
		Inventario inventario1 = new Inventario(1,new Item(1,2,0,0,0,0,1,"Espada","equipado"),new Item(2,0,2,0,0,0,2,"Escudo","equipado"),null,null,null,null);
		
		Assert.assertEquals("Espada", inventario1.getManoDer().getNombre());
		Assert.assertEquals("Escudo", inventario1.getManoIzq().getNombre());
		
	}
	
	@Test
	public void testEquiparItem() {
		Item item1 = new Item(1,2,0,0,0,0,1,"Espada","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,2,"Escudo","desequipado");
		
		Mochila mochila = new Mochila();
		
		Assert.assertTrue(mochila.agregaItem(item1));
		Assert.assertTrue(mochila.agregaItem(item2));
		
		Assert.assertEquals("Espada", mochila.obtenerItem(1).getNombre());
		Assert.assertEquals("Escudo", mochila.obtenerItem(2).getNombre());
		
		Inventario inventario1 = new Inventario();
		inventario1.setIdInventario(1);
		
		Assert.assertEquals(null, inventario1.getManoDer());
		Assert.assertEquals(null, inventario1.getManoIzq());
		
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(1)));
		Assert.assertEquals("equipado", inventario1.getManoDer().getEstado());
	}

}
