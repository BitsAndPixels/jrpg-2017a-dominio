package tests_inventario;

import org.junit.Test;
import org.junit.Assert;

import inventario.*;
import dominio.*;

public class TestInventarioPersonaje {
	@Test
	public void testEquiparItem() {
		Item item1 = new Item(1,2,0,0,0,0,1,"Espada","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,2,"Escudo","desequipado");
		
		Mochila mochila = new Mochila();
		
		Assert.assertTrue(mochila.agregaItem(item1));
		Assert.assertTrue(mochila.agregaItem(item2));
		
		Assert.assertEquals("Espada", mochila.obtenerItem(1).getNombre());
		Assert.assertEquals("Escudo", mochila.obtenerItem(2).getNombre());
		
		Inventario inventario = new Inventario();
		inventario.setIdInventario(1);
		
		Elfo e = new Elfo("Martin", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, inventario, mochila);
		e.setRandomGenerator(new MyRandomStub(0.49));
		
		// Estado inicial de los atributos
		Assert.assertEquals(37, e.getAtaque());
		Assert.assertEquals(20, e.getDefensa());
		
		//Equipo la espada
		Assert.assertTrue(e.equiparItemEnInventario(1));
		Assert.assertEquals(39, e.getAtaque());
		
		//Equipo el escudo
		Assert.assertTrue(e.equiparItemEnInventario(2));
		Assert.assertEquals(22, e.getDefensa());
		
		//Desequipo los items
		Assert.assertTrue(e.desequiparItemDeInventario(e.getInventario().getManoDer()));
		Assert.assertTrue(e.desequiparItemDeInventario(e.getInventario().getManoIzq()));
		
		// Verifico que se hayan quitado los bonus luego de desequipar
		Assert.assertEquals(37, e.getAtaque());
		Assert.assertEquals(20, e.getDefensa());
	}
	

}
