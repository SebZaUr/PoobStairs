package domain;

/**
 * Create a normal snake
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class SNormal extends Serpiente {

	/**
	 * Constructor of the ladder with a random table.
	 * 
	 * @param size the table's size.
	 */
	public SNormal(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	/**
	 * Constructor of the ladder with a specific tale.
	 * 
	 * @param size the table's size.
	 * @param x    the x position of the start of the snake.
	 * @param y    the y position of the start of the snake.
	 * @param w    the x position of the end of the snake.
	 * @param z    the y position of the end of the snake.
	 */
	public SNormal(int size) {
		putInicio(size);
	}

	@Override
	public int movimiento(int position) {
		int start = inicio.getPosition();
		int valor = 0;
		if (start == position) {
			int end = fin.getPosition();
			valor = end - start;
		}
		return valor;
	}

}
