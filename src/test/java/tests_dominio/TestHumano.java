package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import inventario.Inventario;
import inventario.Mochila;

public class TestHumano {

    @Test
    public void testIncentivar() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario(), new Mochila());
	h.setRandomGenerator(new MyRandomStub(0.49));
	e.setRandomGenerator(new MyRandomStub(0.49));

	Assert.assertEquals(37, e.getAtaque());
	h.habilidadRaza1(e);
	Assert.assertEquals(82, e.getAtaque());
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+h.getIdPersonaje(), 100);
	atributo.put("energia"+h.getIdPersonaje(), 0);
	h.modificarAtributos(atributo);
	Assert.assertFalse(h.habilidadRaza1(h));
    }

    @Test
    public void testGolpeFatal() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario(), new Mochila());
	h.setRandomGenerator(new MyRandomStub(0.49));
	e.setRandomGenerator(new MyRandomStub(0.49));

	Assert.assertEquals(100, h.getEnergia());
	Assert.assertEquals(100, e.getSalud());
	Assert.assertTrue(h.habilidadRaza2(e));
	Assert.assertEquals(70,e.getSalud());
	Assert.assertEquals(50,h.getEnergia());
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+h.getIdPersonaje(), 100);
	atributo.put("energia"+h.getIdPersonaje(), 0);
	h.modificarAtributos(atributo);
	Assert.assertFalse(h.habilidadRaza2(e));
    }
}
