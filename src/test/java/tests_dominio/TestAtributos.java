package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAtributos {

    @Test
    public void testIncrementarFuerza() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);

	Assert.assertTrue(h.getAtaque() == 22);
	h.AsignarPuntosSkills(10, 0, 0);
	Assert.assertTrue(h.getAtaque() > 22);
    }

    @Test
    public void testIncrementarDestreza() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);

	Assert.assertTrue(h.getDefensa() == 10);
	h.AsignarPuntosSkills(0, 10, 0);
	Assert.assertTrue(h.getDefensa() > 10);
    }

    @Test
    public void testIncrementarInteligencia() {
	Humano h = new Humano("Nicolas", new Guerrero(), 1);
	Assert.assertTrue(h.getMagia() == 15);
	h.AsignarPuntosSkills(0, 0, 10);
	Assert.assertTrue(h.getMagia() > 15);
    }
    
    @Test
    public void testAtributosDePersonaje() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    //Humano h2 = new Humano("Pepe", new Guerrero(), 1);
    //crear clan
    h.crearAlianza("Clan");
    Assert.assertTrue(h.getClan()!=null);
    //salir de alianza
    h.salirDeAlianza();
    Assert.assertTrue(h.getClan()==null);
    //saber si tener menos de la energia requerida hacer que el personaje no pueda atacar 
    h.setEnergia(5);
    Assert.assertFalse(h.puedeAtacar());
    //probar setter y getter de NombreRaza
    h.setNombreRaza("ELFO");
    Assert.assertTrue(h.getNombreRaza() == "ELFO");
    }
}
