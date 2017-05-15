package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestAsesino {

    @Test
    public void testCritico() {
	Humano h = new Humano("Nicolas", new Asesino(), 1);
	Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
	h.setRandomGenerator(new MyRandomStub());
	h2.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(105, h2.getSalud());
	Assert.assertTrue(h.habilidadCasta1(h2));
	Assert.assertEquals(93, h2.getSalud());
	//Assert.assertNotEquals(105, h2.getSalud()); 
    }

    @Test
    public void testProbEvasion() {
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

	Assert.assertEquals(0.3, h.getCasta().getProbabilidadEvitarDaño(), 1E-10);
	h.habilidadCasta2(null);
	Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
	h.habilidadCasta2(null);
	Assert.assertEquals(0.5, h.getCasta().getProbabilidadEvitarDaño(), 1E-10);
    }
    
    @Test
    public void testRobar() {
    Humano h = new Humano("Rupert", new Asesino(), 1);
    Humano h2 = new Humano("Gandalf", new Hechicero(), 2);

   	Assert.assertFalse(h.habilidadCasta3(h2));
    }
}
