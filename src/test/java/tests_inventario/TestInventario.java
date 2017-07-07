package tests_inventario;

import org.junit.Test;
import org.junit.Assert;

import inventario.*;

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
		Item item3 = new Item(3,0,2,0,0,0,3,"Botas","desequipado");
		Item item4 = new Item(4,0,2,0,0,0,4,"Casco","desequipado");
		Item item5 = new Item(5,0,2,0,0,0,5,"Armadura","desequipado");
		Item item6 = new Item(6,0,2,0,0,0,6,"Talisman","desequipado");
		
		Mochila mochila = new Mochila();
		
		Assert.assertTrue(mochila.agregaItem(item1));
		Assert.assertTrue(mochila.agregaItem(item2));
		Assert.assertTrue(mochila.agregaItem(item3));
		Assert.assertTrue(mochila.agregaItem(item4));
		Assert.assertTrue(mochila.agregaItem(item5));
		Assert.assertTrue(mochila.agregaItem(item6));
		
		Assert.assertEquals("Espada", mochila.obtenerItem(1).getNombre());
		Assert.assertEquals("Escudo", mochila.obtenerItem(2).getNombre());
		
		Inventario inventario1 = new Inventario();
		inventario1.setIdInventario(1);
		
		Assert.assertEquals("vacio", inventario1.getManoDer().getEstado());
		Assert.assertEquals("vacio", inventario1.getManoIzq().getEstado());
		
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(1)));
		Assert.assertEquals("equipado", inventario1.getManoDer().getEstado());
		Assert.assertTrue(inventario1.desequiparItem(inventario1.getManoDer()));
		Assert.assertEquals("desequipado", inventario1.getManoDer().getEstado());
		
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(2)));
		Assert.assertEquals("equipado", inventario1.getManoIzq().getEstado());
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(3)));
		Assert.assertEquals("equipado", inventario1.getPie().getEstado());
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(4)));
		Assert.assertEquals("equipado", inventario1.getCabeza().getEstado());
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(5)));
		Assert.assertEquals("equipado", inventario1.getPecho().getEstado());
		Assert.assertTrue(inventario1.equiparItem(mochila.obtenerItem(6)));
		Assert.assertEquals("equipado", inventario1.getAccesorio().getEstado());
	} 
	

}
