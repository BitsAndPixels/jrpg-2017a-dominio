package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestElfo {

    @Test
    public void testGolpeLevel() {
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 2);
	e.setRandomGenerator(new MyRandomStub());
	h.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(100, h.getSalud());
	Assert.assertTrue(e.habilidadRaza1(h));
	Assert.assertTrue(h.getSalud() < 100);
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("energia"+e.getIdPersonaje(), 0);
	atributo.put("salud"+e.getIdPersonaje(), 100);
	e.modificarAtributos(atributo);
	Assert.assertFalse(e.habilidadRaza1(h));
    }

    @Test
    public void testAtaqueBosque() {
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 2);
	e.setRandomGenerator(new MyRandomStub());
	h.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(100, h.getSalud());
	Assert.assertTrue(e.habilidadRaza2(h));
	Assert.assertTrue(h.getSalud() < 100);
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("energia"+e.getIdPersonaje(), 0);
	atributo.put("salud"+e.getIdPersonaje(), 100);
	e.modificarAtributos(atributo);
	Assert.assertFalse(e.habilidadRaza2(h));
    }
}
