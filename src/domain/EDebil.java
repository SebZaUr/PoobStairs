package domain;

/**
 * Create a ladder that with each use is cut in half
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class EDebil extends Escalera {

	/**
	 * Constructor of the ladder with a random table.
	 * 
	 * @param size the table's size.
	 */
	public EDebil(int size) {
		putInicio(size);
	}

	/**
	 * Constructor of the ladder with a specific tale.
	 * 
	 * @param size the table's size.
	 * @param x    the x position of the start of the stair.
	 * @param y    the y position of the start of the stair
	 * @param w    the x position of the end of the stair
	 * @param z    the y position of the end of the stair
	 */
	public EDebil(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int position) {
		return 0;

	}

}
