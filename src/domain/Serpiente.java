package domain;

import java.util.Random;

/**
 * Create diferents types of snake.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public abstract class Serpiente {

	protected Random numero = new Random();
	protected int[][] positions = new int[2][2];
	protected NCasilla fin;
	protected NCasilla inicio;

	/**
	 * put the snake's start in a random position.
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
			if (table[x][y].getType().equals("NCasilla") && x < size - 1 && x != 0 && y != 0) {
				if ((Table.getInstance(size)).getFinalPosS()[x][y] == null) {
					confirm = true;
					int[] startPosition = { x, y };
					positions[0] = startPosition;
					(Table.getInstance(size)).containsBoxS(startPosition, this);
					(Table.getInstance(size)).setStartSnake(table[x][y].getPosition());
					putFinal(size, x);
					(Table.getInstance(size)).setFinal(positions, "Serpiente");
				}

			}
		}

	}

	/**
	 * put the snake's end in a random position.
	 * 
	 * @param size the table's size.
	 */
	public void putFinal(int size, int startX) {
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		boolean colocada = false;
		int x = 0;
		int y = 0;
		while (!colocada) {
			if (startX == 0) {
				x = numero.nextInt(size - 1) + 1;
			} else {
				while (x <= startX) {
					x = numero.nextInt(size);
				}
			}
			y = numero.nextInt(size);
			if (table[x][y].getType().equals("NCasilla")) {
				if ((Table.getInstance(size)).getFinalPosS()[x][y] == null) {
					colocada = true;
					int[] startPosition = { x, y };
					(Table.getInstance(size)).containsBoxS(startPosition, this);
					positions[1] = startPosition;
				}

			}
		}

	}

	/**
	 * Let the snake move in the ladder..
	 * 
	 * @param position the player's position.
	 * @return
	 */
	public abstract int movimiento(int position);

	/**
	 * Assign the snake's start.
	 * 
	 * @param casilla the box.
	 */
	public void putI(NCasilla casilla) {
		inicio = casilla;
	}

	/**
	 * Assign the snake's end.
	 * 
	 * @param casilla the box.
	 */
	public void putF(NCasilla casilla) {
		fin = casilla;
	}
}
