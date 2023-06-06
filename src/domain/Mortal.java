package domain;

/**
 * Create a box that if falls in have to begin again the game
 * from the beginning
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Mortal extends Casillas {

	/**
	 * create a Mortal box with a random table.
	 * 
	 * @param size the table's size.
	 */
	public Mortal(int size) {
		this.type = "Mortal";
		putCasilla(size);
	}

	/**
	 * create a Mortal box with a specific table.
	 * 
	 * @param x    the x's position of the box
	 * @param y    the y's position of the box
	 * @param size the table's size.
	 */
	public Mortal(int x, int y, int size) {
		this.type = "Mortal";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.MORTAL);
	}

}
