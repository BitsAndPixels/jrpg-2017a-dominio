package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;
import inventario.Inventario;
import inventario.Mochila;

public class TestDaño {

    @Test
    public void testAtaqueComunYLaSaludNoBajeDe0() {
	Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	
	h.setRandomGenerator(new MyRandomStub(0.49));
	o.setRandomGenerator(new MyRandomStub(0.49));
	
	Assert.assertEquals(100, o.getSalud());
	
	while (h.atacar(o) != 0) {
	Assert.assertEquals(0, o.getSalud());
	}
	
//	if (h.atacar(o) != 0) {
//	    Assert.assertTrue(o.getSalud() == 0);
//	    h.atacar(o);
//	    Assert.assertTrue(o.getSalud() == 0);
//	    h.atacar(o);
//	    Assert.assertTrue(o.getSalud() == 0);
//	} else
//	    Assert.assertTrue(o.getSalud() == 0);
    }

    @Test
    public void testLosMuertosNoAtacan() {
	Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1, new Inventario(), new Mochila());

	h.atacar(o);
	h.atacar(o);
	h.atacar(o);
	h.atacar(o);

	o.atacar(h);
	Assert.assertEquals(100, h.getSalud());
    }
}