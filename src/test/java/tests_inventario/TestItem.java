package tests_inventario;

import org.junit.Test;
import org.junit.Assert;

import inventario.Item;
import constantes.TiposItem;



public class TestItem {
	@Test
	public void TestCrearItem() {
		Item item = new Item();
		Assert.assertEquals("vacio", item.getEstado());
		Assert.assertEquals("vacio", item.getNombre());
		Assert.assertEquals(0, item.getBonoAtaque());
		
		Item item2 = new Item(1,2,0,0,0,0,1,"Espada del augurio","desequipado");
		Assert.assertEquals("Espada del augurio", item2.getNombre());
		Assert.assertEquals(TiposItem.MANO_DERECHA, item2.getTipo());
		item2.serEquipado();
		Assert.assertEquals("equipado", item2.getEstado());
		
		Item item3 = item;
		
		Assert.assertEquals(0, item3.getBonoAtaque());
		
		item3 = null;
		
		Assert.assertEquals(0, item.getBonoAtaque());
	}

}
