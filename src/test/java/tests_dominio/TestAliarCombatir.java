package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;

public class TestAliarCombatir {

	@Test
	public void testCrearAlianza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 1);

		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}

	@Test
	public void testDañar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Asesino(), 1);

	h.setRandomGenerator(new MyRandomStub());
	h2.setRandomGenerator(new MyRandomStub());
	
	Assert.assertTrue(h2.getSalud() == 105);
	Assert.assertNotEquals(0, h.atacar(h2));
	Assert.assertTrue(h2.getSalud() < 105);
    }

	@Test
	public void testAliar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 1);
		Alianza a1 = new Alianza("Los CacheFC");

		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h.getClan() == h2.getClan());
	}

	Assert.assertNull(zelda.getClan());
	Assert.assertNull(ganon.getClan());
	link.aliar(zelda);
	link.aliar(ganon);
	Assert.assertEquals(link.getClan(),zelda.getClan());
	Assert.assertEquals(link.getClan(),ganon.getClan());
	ganon.salirDeAlianza();
	Assert.assertNotEquals(link.getClan(),ganon.getClan());
    }

    @Test
    public void testDañarElfo() {
	Elfo h = new Elfo("Legolas", new Guerrero(), 1);
	Elfo h2 = new Elfo("Arwen", new Asesino(), 1);
	
	h.setRandomGenerator(new MyRandomStub());
	h2.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(100,h2.getSalud());
	Assert.assertNotEquals(0, h.atacar(h2));
	Assert.assertTrue(h2.getSalud() < 100);
    }

    @Test
    public void testDañarOrco() {
	Elfo h = new Elfo("Legolas", new Guerrero(), 1);
	Orco h2 = new Orco("Azog", new Asesino(), 1);
	
	h.setRandomGenerator(new MyRandomStub());
	h2.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(110,h2.getSalud());
	Assert.assertNotEquals(0, h.atacar(h2));
	Assert.assertTrue(h2.getSalud() < 110);
    }

		Assert.assertTrue(h2.getSalud() == 100);
		if (h.atacar(h2) != 0)
			Assert.assertTrue(h2.getSalud() < 100);
	}

	@Test
	public void testDañarOrco() {
		Elfo h = new Elfo("Legolas", new Guerrero(), 1);
		Orco h2 = new Orco("Azog", new Asesino(), 1);

		Assert.assertTrue(h2.getSalud() == 110);
		if (h.atacar(h2) != 0)
			Assert.assertTrue(h2.getSalud() < 110);
	}

}
