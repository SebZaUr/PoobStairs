package domain;

import java.util.ArrayList;

/**
 * Create a box that if the player falls in advance to the nearest ladder.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public class Avance extends Casillas {

	/**
	 * Create an Avance's Box with a random table.
	 * 
	 * @param size the table's size.
	 */
	public Avance(int size) {
		this.type = "Avance";
		putCasilla(size);
	}

	/**
	 * create an avance box with a specific table.
	 * 
	 * @param x    the x's position of the box
	 * @param y    the y's position of the box
	 * @param size the table's size.
	 */
	public Avance(int x, int y, int size) {
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		int salto = 0;
		boolean found = false;
		ArrayList<Integer> startLadder = (Table.getInstance(size)).getStartLadder();
		for (int i = position; i < startLadder.size(); i++) {
			if (startLadder.get(i) > position) {
				found = true;
				salto = startLadder.get(i) - position;
				break;
			}
		}
		if (!found) {
			throw new PoobStairsExceptions(PoobStairsExceptions.NOT_FOUND_LADDER);
		}
		return salto;
	}

}
