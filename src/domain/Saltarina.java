package domain;

/**
 * Create a box if falls in advance a random number of squares
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.7
 */
public class Saltarina extends Casillas {

	/**
	 * create a saltarina box with a random table.
	 * 
	 * @param size the table's size.
	 */
	public Saltarina(int size) {
		type = "Saltarina";
		putCasilla(size);
	}

	/**
	 * create a saltarina box with a specific table.
	 * 
	 * @param x    the x's position of the box
	 * @param y    the y's position of the box
	 * @param size the table's size.
	 */
	public Saltarina(int x, int y, int size) {
		this.type = "Saltarina";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) {
		return numero.nextInt(6) + 1;
	}

}
