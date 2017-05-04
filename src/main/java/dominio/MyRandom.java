package dominio;

/**
 * Clase que permite obtener un valor pseudoaleatorio que permite modificar
 * atributos en otras clases según corresponda.
 * @see src/main/java/dominio/NonPlayableCharacter.java
 */

public class MyRandom {
    /**
     * @param VALOR_FIJO valor fijo.
     */
    protected static final double VALOR_FIJO = 0.49;

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
