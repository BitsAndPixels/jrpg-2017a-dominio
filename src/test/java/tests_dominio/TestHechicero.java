package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestHechicero {

    @Test
    public void testCurar() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+e.getIdPersonaje(), 65);
	atributo.put("energia"+e.getIdPersonaje(), 100);
	e.modificarAtributos(atributo);
	Assert.assertEquals(e.getEnergia(), 100); 
	Assert.assertEquals(e.getSalud(), 65);
	h.habilidadCasta2(e);
	Assert.assertTrue(e.getSalud() > 65);
    }

    @Test
    public void testBolaDeFuego() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
	h.setRandomGenerator(new MyRandomStub());
	e.setRandomGenerator(new MyRandomStub());

	Assert.assertEquals(e.getSalud(), 100);
	Assert.assertTrue(h.habilidadCasta1(e));
	Assert.assertTrue(e.getSalud() < 100);
    }

    @Test
    public void testRobarEnergia_y_Salud() {
	Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
	Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

	Assert.assertTrue(e.getSalud() == 100);
	HashMap<String,Integer> atributo = new HashMap<>();
	atributo.put("salud"+e.getIdPersonaje(), 50);
	atributo.put("energia"+e.getIdPersonaje(), 50);
	e.modificarAtributos(atributo);
	Assert.assertTrue(h.habilidadCasta3(e));
	Assert.assertTrue(e.getSalud() < 100);
	Assert.assertTrue(h.getEnergia() > 50);
	Assert.assertTrue(h.getSalud() > 50);
	
	Assert.assertNotEquals(h.getSalud(),50);
	Assert.assertFalse(h.getEnergia() < 50);
	Assert.assertNotEquals(e.getSalud(), 100);
	
    }
}
