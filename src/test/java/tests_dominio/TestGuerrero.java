package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestGuerrero {

    @Test
    public void testDobleGolpe() {
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
	h.setRandomGenerator(new MyRandomStub(0.49));
	e.setRandomGenerator(new MyRandomStub(0.49));
	
	Assert.assertEquals(e.getSalud(), 100);
	Assert.assertTrue(h.habilidadCasta1(e));
	Assert.assertTrue(e.getSalud() < 100);
    }

    @Test
    public void testAutoDefensa() {
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);

	Assert.assertEquals(h.getDefensa(), 20);
	Assert.assertTrue(h.habilidadCasta2(null));
	Assert.assertEquals(h.getDefensa(), 65);
    }

    @Test
    public void testIgnoraDefensa() {
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
	h.setRandomGenerator(new MyRandomStub(0.49));
	e.setRandomGenerator(new MyRandomStub(0.49));

	Assert.assertEquals(e.getSalud(), 100);
	Assert.assertTrue(h.habilidadCasta3(e));
	Assert.assertTrue(e.getSalud() < 100);
    }

}
