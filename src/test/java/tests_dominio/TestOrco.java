package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;
import inventario.Inventario;
import inventario.Mochila;

public class TestOrco {

    @Test
    public void testGolpeDefensivo() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);
	Orco o = new Orco("Hernan", new Guerrero(), 1);
	h.setRandomGenerator(new MyRandomStub(0.49));
	o.setRandomGenerator(new MyRandomStub(0.49));

	Assert.assertEquals(105, h.getSalud());
	Assert.assertTrue(o.habilidadRaza1(h));
	Assert.assertEquals(95,h.getSalud());
	
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+o.getIdPersonaje(), 100);
	atributo.put("energia"+o.getIdPersonaje(), 0);
	o.modificarAtributos(atributo);
	Assert.assertFalse(o.habilidadRaza1(h));	
    }

    @Test
    public void testMordiscoDeVida() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
	h.setRandomGenerator(new MyRandomStub(0.49));
	o.setRandomGenerator(new MyRandomStub(0.49));

	Assert.assertEquals(100, h.getSalud());
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+o.getIdPersonaje(), 100);
	atributo.put("energia"+o.getIdPersonaje(), 100);
	o.modificarAtributos(atributo);
	Assert.assertTrue(o.habilidadRaza2(h));
	Assert.assertEquals(40, h.getSalud());
	Assert.assertEquals(100,o.getSalud());
	
	atributo.put("energia"+o.getIdPersonaje(), 0);
	o.modificarAtributos(atributo);
	Assert.assertFalse(o.habilidadRaza2(h));
    }
}
