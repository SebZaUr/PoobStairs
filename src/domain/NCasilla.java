package domain;

/**
 * Create a normal box
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.7
 */
public class NCasilla extends Casillas {

	/**
	 * create a normal box with a random table.
	 * 
	 * @param size the table's size.
	 */
	public NCasilla(int size) {
		this.type = "NCasilla";
		putCasilla(size);
	}

	/**
	 * create a normal box with a specific table.
	 * 
	 * @param x    the x's position of the box
	 * @param y    the y's position of the box
	 * @param size the table's size.
	 */
	public NCasilla(int x, int y, int size) {
		this.type = "NCasilla";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) {
		int valor = 0;
		Serpiente[][] serpientes = (Table.getInstance(size)).getFinalPosS();
		Escalera[][] escaleras = (Table.getInstance(size)).getFinalPosE();
		if (escaleras[startX][startY] != null) {
			valor = escaleras[startX][startY].movimiento(position);
		} else if (serpientes[startX][startY] != null) {
			valor = serpientes[startX][startY].movimiento(position);
		}
		return valor;
	}

}
