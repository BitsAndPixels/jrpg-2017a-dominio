package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Hechicero;
import dominio.Humano;
import dominio.NonPlayableCharacter;

public class TestNPC {

    @Test
    public void testOtorgarExp() {
	NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
	Assert.assertEquals(30,npc.otorgarExp());
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
    
    Assert.assertTrue(h.atacar(npc) > 0);
    Assert.assertTrue(npc.atacar(h) > 0);
    }
}
