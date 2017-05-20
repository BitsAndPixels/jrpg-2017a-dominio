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
    public void testIncrementarSalud() {
    Humano h = new Humano("Martin", new Hechicero(), 1);
    //h.setSalud(10);
    h.setSaludTope(20);
    h.restablecerSalud();
    Assert.assertTrue(h.getSalud() == 20); 
    }
    
    @Test
    public void testIncrementarEnergia() {
    Humano h = new Humano("Martin", new Asesino(), 1);
    //h.setEnergia(10);
    h.setEnergiaTope(20);
    h.restablecerEnergia();
    Assert.assertTrue(h.getEnergia() == 20);
    }
    
    @Test
    public void testAtributosDePersonaje() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    //Humano h2 = new Humano("Pepe", new Guerrero(), 1);
    //setter de experiencia
    h.setExperiencia(100);
    Assert.assertTrue(h.getExperiencia()== 100);
    //crear clan
    h.crearAlianza("Clan");
    Assert.assertTrue(h.getClan()!=null);
    //salir de alianza
    h.salirDeAlianza();
    Assert.assertTrue(h.getClan()==null);
    //saber si tener menos de la energia requerida hacer que el personaje no pueda atacar 
    //h.setEnergia(5);
    //Assert.assertFalse(h.puedeAtacar());
    //probar restablecer salud
    //h.setSalud(10);
    h.setSaludTope(20);
    h.restablecerSalud();
    Assert.assertTrue(h.getSalud() == 20);
    //probar restablecer salud
    //h.setEnergia(10);
    h.setEnergiaTope(20);
    h.restablecerEnergia();
    Assert.assertTrue(h.getEnergia() == 20);
    //probar setter y getter de Idpersonaje
    h.setIdPersonaje(10);
    Assert.assertTrue(h.getIdPersonaje() == 10);
    //probar setter y getter de Magia
    h.setMagia(15);
    Assert.assertTrue(h.getMagia() == 15);
    //probar setter y getter de Nivel
    h.setNivel(10);
    Assert.assertTrue(h.getNivel() == 10);
    //probar setter y getter de NombreRaza
    h.setNombreRaza("ELFO");
    Assert.assertTrue(h.getNombreRaza() == "ELFO");
    }
}
