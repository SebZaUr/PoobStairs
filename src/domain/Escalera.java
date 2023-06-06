package domain;

import java.util.Random;

/**
 * Create differents ladders's types.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public abstract class Escalera {

	protected Random numero = new Random();
	protected int[][] positions = new int[2][2];
	protected NCasilla fin;
	protected NCasilla inicio;

	/**
	 * put the ladder's start in a random position.
	 * 
	 * @param size the table's size.
	 */
	public void putInicio(int size) {
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		boolean confirm = false;
		int x = 0;
		int y = 0;
		while (!confirm) {
			x = numero.nextInt(size);
			y = numero.nextInt(size);
			if (table[x][y].getType().equals("NCasilla") && x > 0) {
				if ((Table.getInstance(size)).getFinalPosE()[x][y] == null) {
					confirm = true;
					int[] startPosition = { x, y };
					positions[0] = startPosition;
					(Table.getInstance(size)).containsBoxE(startPosition, this);
					(Table.getInstance(size)).setStartLadder(table[x][y].getPosition());
					putFinal(size, x);
					(Table.getInstance(size)).setFinal(positions, "Escalera");
				}
			}
		}
	}

	/**
	 * put the ladder's end in a random position.
	 * 
	 * @param size the table's size.
	 */
	public void putFinal(int size, int startX) {
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		boolean colocada = false;
		int x = 0;
		int y = 0;
		while (!colocada) {
			if (startX == 1) {
				x = numero.nextInt(startX);
			} else {
				x = numero.nextInt(startX - 1) + 1;
			}
			y = numero.nextInt(size);
			if (table[x][y].getType().equals("NCasilla")) {
				if ((Table.getInstance(size)).getFinalPosE()[x][y] == null) {
					colocada = true;
					int[] startPosition = { x, y };
					(Table.getInstance(size)).containsBoxE(startPosition, this);
					positions[1] = startPosition;
				}
			}
		}

	}

	/**
	 * Let the player move in the ladder..
	 * 
	 * @param position the player's position.
	 * @return
	 */
	public abstract int movimiento(int position);

	/**
	 * Assign the ladder's start.
	 * 
	 * @param casilla the box.
	 */
	public void putI(NCasilla casilla) {
		inicio = casilla;
	}

	/**
	 * Assign the ladder's end.
	 * 
	 * @param casilla the box.
	 */
	public void putF(NCasilla casilla) {
		fin = casilla;
	}
}
