package domain;

/**
 * Create a box if falls in move back a random number of squares
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.7
 */
public class SaltarinaInversa extends Casillas {

	/**
	 * create a saltarina Inversa box with a random table.
	 * 
	 * @param size the table's size.
	 */
	public SaltarinaInversa(int size) {
		type = "SaltarinaInversa";
		putCasilla(size);
	}

	/**
	 * create a saltarina inversa box with a specific table.
	 * 
	 * @param x    the x's position of the box
	 * @param y    the y's position of the box
	 * @param size the table's size.
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
