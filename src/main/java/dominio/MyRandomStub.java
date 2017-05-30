package dominio;

public class MyRandomStub extends RandomGenerator {
	
	private double valor;
	
	public MyRandomStub(double valor) {
		this.valor=valor;
	}
	
    /**
     * @see src/main/java/dominio/NonPlayableCharacter.java método setAtacado()
     * @return valor fijo 0.49
     */
	@Override
    public double nextDouble() {
	return this.valor;
    }

    /**
     * @param val valor que viene por parametro
     * @return @value - 1
     */
	@Override
    public int nextInt(final int val) {
	return val - 1;
    }

}
