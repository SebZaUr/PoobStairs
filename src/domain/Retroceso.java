package domain;

import java.util.ArrayList;

/**
 * Create a box that if the player falls in move back to the nearest ladder.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public class Retroceso extends Casillas {

	private int size;

	/**
	 *  
	 */
	public Retroceso(int size) {
		type = "Retroceso";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public Retroceso(int x, int y, int size) {
		this.type = "Retroceso";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		int salto = 0;
		boolean found = false;
		ArrayList<Integer> startSnake = (Table.getInstance(size)).getStartSnake();
		for (int i = position; i < startSnake.size(); i++) {
			if (startSnake.get(i) < position) {
				found = true;
				salto = startSnake.get(i) - position;
				break;
			}
		}
		if (!found) {
			throw new PoobStairsExceptions(PoobStairsExceptions.NOT_FOUND_LADDER);
		}
		return salto;
	}

}
