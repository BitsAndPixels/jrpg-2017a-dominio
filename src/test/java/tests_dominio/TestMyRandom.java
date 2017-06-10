package tests_dominio;

import org.junit.Assert;

import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import inventario.Inventario;
import inventario.Mochila;
import constantes.ConstantesMyRandom;

public class TestMyRandom {
	@Test
	public void queGeneraDoubleRandom(){
		Humano h = new Humano("Martin", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
		//Assert.assertNotEquals(0.49, h.getMyRandom().nextDouble()); // ESTA NO ES VALIDA PORQUE SE BASA EN LA ALEATORIEDAD
		h.setRandomGenerator(new MyRandomStub(0.49));
		Assert.assertEquals(0.49,h.getMyRandom().nextDouble(),1E-10);
	}
	@Test
	public void queGeneraIntRandom(){
		Humano h = new Humano("Martin", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario(), new Mochila());
		//Assert.assertNotEquals(6, h.getMyRandom().nextInt(7)); // ESTA NO ES VALIDA PORQUE SE BASA EN LA ALEATORIEDAD
		h.setRandomGenerator(new MyRandomStub(6));
		Assert.assertEquals(6, h.getMyRandom().nextInt(7));
	}
}
