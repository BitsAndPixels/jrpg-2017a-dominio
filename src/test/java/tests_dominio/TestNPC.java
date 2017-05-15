package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;

public class TestNPC {

    @Test
    public void testOtorgarExp() {
	NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 2);
	Assert.assertEquals(30,npc.otorgarExp());
	Assert.assertEquals("Gigante", npc.getNombre());
	Assert.assertEquals(false, npc.esPersonaje());
    }
    
    @Test
    public void crearNPC() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Blob", 1, 1);
    
    Assert.assertEquals(1,npc.getNivel());
    Assert.assertEquals(20, npc.getFuerza());
    Assert.assertEquals(40, npc.getSalud());
    Assert.assertEquals(5, npc.getDefensa());

    }
    
    @Test
    public void atacarNPC() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Blob", 1, 1);
    Humano h = new Humano("Martin", new Hechicero(), 1);
    npc.setRandomGenerator(new MyRandomStub());
    h.setRandomGenerator(new MyRandomStub());
    
    Assert.assertTrue(h.atacar(npc) > 0);
    Assert.assertTrue(npc.atacar(h) > 0);
    }
    
    @Test
    public void atacaNPC() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Goblin", 1, 0);
    Humano h = new Humano("Ruperto", new Hechicero(), 1);
    npc.setRandomGenerator(new MyRandomStub());
    h.setRandomGenerator(new MyRandomStub());
    
    Assert.assertEquals(0,npc.atacar(h));
    }
}
