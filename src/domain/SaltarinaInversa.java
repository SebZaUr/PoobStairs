package domain;

public class SaltarinaInversa extends Casillas {

	/**
	 *  
	 */
	public SaltarinaInversa(int size) {
		type = "SaltarinaInversa";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public SaltarinaInversa(int x, int y) {

	}

	@Override
	public int enCasilla(int size) {
		return (numero.nextInt(6) + 1) * -1;
	}

}
