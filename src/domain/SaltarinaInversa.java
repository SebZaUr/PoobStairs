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
	public SaltarinaInversa(int x, int y, int size) {
		this.type = "SaltarinaInversa";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) {
		return (numero.nextInt(6) + 1) * -1;
	}

}
