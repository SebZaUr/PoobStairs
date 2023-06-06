package domain;

/**
 * Create a ladder that occupies the squares on the sides plus yours
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class EDual extends Escalera {

	private NCasilla derecha;

	private NCasilla izquierda;

	/**
	 * Constructor of the ladder with a random table.
	 * 
	 * @param size the table's size.
	 */
	public EDual(int size) {
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
	public EDual(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int position) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
	}

}
