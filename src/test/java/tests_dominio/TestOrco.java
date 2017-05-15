package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestOrco {

    @Test
    public void testGolpeDefensivo() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);
	Orco o = new Orco("Hernan", new Guerrero(), 1);
	h.setRandomGenerator(new MyRandomStub());
	o.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(105, h.getSalud());
	Assert.assertTrue(o.habilidadRaza1(h));
	Assert.assertEquals(95,h.getSalud());
	
	o.setEnergia(0);
	Assert.assertFalse(o.habilidadRaza1(h));	
    }

    @Test
    public void testMordiscoDeVida() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
	Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
	h.setRandomGenerator(new MyRandomStub());
	o.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(100, h.getSalud());
	o.setSalud(100);
	Assert.assertTrue(o.habilidadRaza2(h));
	Assert.assertEquals(40, h.getSalud());
	Assert.assertEquals(100,o.getSalud());
	
	o.setEnergia(0);
	Assert.assertFalse(o.habilidadRaza2(h));
    }
}
