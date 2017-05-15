package dominio;

public abstract class RandomGenerator {
	/**
	 * Metodo nextDouble retorna un valor fraccionario random entre  0 y 1
	 * @return double random
	 */
	public abstract double nextDouble();
	/**
	 * Metodo netxtInt retorna un valor entero random mayor igual a 0 y menor al parámetro
	 * @param val
	 * @return entero random
	 */
	public abstract int nextInt(final int val);
}
