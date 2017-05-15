package dominio;

import java.util.Random;

/**
 * Clase que permite obtener un valor pseudoaleatorio que permite modificar
 * atributos en otras clases según corresponda.
 * @see RandomGenerator
 */

public class MyRandom extends RandomGenerator{
   
	@Override
    public double nextDouble() {
	return new Random().nextDouble();
    }

    
	@Override
    public int nextInt(final int val) {
	return new Random().nextInt(val);
    }

}
