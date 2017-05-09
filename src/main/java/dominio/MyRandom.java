package dominio;

import static constantes.ConstantesMyRandom.*;

/**
 * Clase que permite obtener un valor pseudoaleatorio que permite modificar
 * atributos en otras clases según corresponda.
 * @see src/main/java/dominio/NonPlayableCharacter.java
 */

public class MyRandom {
    /**
     * @see src/main/java/dominio/NonPlayableCharacter.java método setAtacado()
     * @return valor fijo 0.49
     */
    public static double nextDouble() {
	return VALOR_FIJO;
    }

    /**
     * @param val valor que viene por parametro
     * @return @value - 1
     */
    public static int nextInt(final int val) {
	return val - 1;
    }

}
