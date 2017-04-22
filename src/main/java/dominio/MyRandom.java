package dominio;

/**
 * Clase que permite obtener un valor pseudoaleatorio que permite modificar atributos 
 * en otras clases según corresponda.
 * 
 * @see src/main/java/dominio/NonPlayableCharacter.java
 */

public class MyRandom {
	/**
	 * @see src/main/java/dominio/NonPlayableCharacter.java método setAtacado()
	 * @return valor fijo 0.49
	 */
	public static double nextDouble() {
		return 0.49; 
	}
	
	/**
	 * @param val
	 * @return val - 1
	 */
	public static int nextInt(int val) {
		return val - 1;
	}
	
}
