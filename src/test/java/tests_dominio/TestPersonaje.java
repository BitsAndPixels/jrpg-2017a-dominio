package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

    @Test
    public void testHumano() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);
	Assert.assertEquals(h.getSalud(), 105);
	Assert.assertEquals(h.getEnergia(), 105);
	Assert.assertEquals(h.getFuerza(), 15);
	Assert.assertEquals(h.getDestreza(), 10);
	Assert.assertEquals(h.getInteligencia(), 10);

	Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
	Assert.assertEquals(h2.getSalud(), 105);
	Assert.assertEquals(h2.getEnergia(), 105);
	Assert.assertEquals(h2.getFuerza(), 10);
	Assert.assertEquals(h2.getDestreza(), 10);
	Assert.assertEquals(h2.getInteligencia(), 15);

	Humano h3 = new Humano("Hernan", new Asesino(), 3);
	Assert.assertEquals(h3.getSalud(), 105);
	Assert.assertEquals(h3.getEnergia(), 105);
	Assert.assertEquals(h3.getFuerza(), 10);
	Assert.assertEquals(h3.getDestreza(), 15);
	Assert.assertEquals(h3.getInteligencia(), 10);
    }

    @Test
    public void testElfo() {
	Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
	Assert.assertEquals(e.getSalud(), 100);
	Assert.assertEquals(e.getEnergia(), 110);
	Assert.assertEquals(e.getFuerza(), 15);
	Assert.assertEquals(e.getDestreza(), 10);
	Assert.assertEquals(e.getInteligencia(), 10);

	Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
	Assert.assertEquals(e2.getSalud(), 100);
	Assert.assertEquals(e2.getEnergia(), 110);
	Assert.assertEquals(e2.getFuerza(), 10);
	Assert.assertEquals(e2.getDestreza(), 10);
	Assert.assertEquals(e2.getInteligencia(), 15);

	Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
	Assert.assertEquals(e3.getSalud(), 100);
	Assert.assertEquals(e3.getEnergia(), 110);
	Assert.assertEquals(e3.getFuerza(), 10);
	Assert.assertEquals(e3.getDestreza(), 15);
	Assert.assertEquals(e3.getInteligencia(), 10);
    }

    @Test
    public void testOrco() {
	Orco o = new Orco("Nicolas", new Guerrero(), 1);
	Assert.assertEquals(o.getSalud(), 110);
	Assert.assertEquals(o.getEnergia(), 100);
	Assert.assertEquals(o.getFuerza(), 15);
	Assert.assertEquals(o.getDestreza(), 10);
	Assert.assertEquals(o.getInteligencia(), 10);

	Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
	Assert.assertEquals(o2.getSalud(), 110);
	Assert.assertEquals(o2.getEnergia(), 100);
	Assert.assertEquals(o2.getFuerza(), 10);
	Assert.assertEquals(o2.getDestreza(), 10);
	Assert.assertEquals(o2.getInteligencia(), 15);

	Orco o3 = new Orco("Hernan", new Asesino(), 3);
	Assert.assertEquals(o3.getSalud(), 110);
	Assert.assertEquals(o3.getEnergia(), 100);
	Assert.assertEquals(o3.getFuerza(), 10);
	Assert.assertEquals(o3.getDestreza(), 15);
	Assert.assertEquals(o3.getInteligencia(), 10);
    }
}
