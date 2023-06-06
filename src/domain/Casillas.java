package domain;

import java.util.Random;

/**
 * Create differents box's types.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public abstract class Casillas {

	protected Random numero = new Random();
	protected int startX;
	protected int startY;
	protected String type;
	protected int position;
	protected Casillas[][] table;

	/**
	 * Verify if it has done an action.
	 * 
	 * @param size the table's size.
	 * @return the box's number that the player has to move.
	 * @throws PoobStairsExceptions if its anyone box's type less NCasilla,Avance
	 *                              and Retroceso.
	 */
	public abstract int enCasilla(int size) throws PoobStairsExceptions;

	/**
	 * Verify if the box's type can be in that position.
	 * 
	 * @param type if is a ladder or snake.
	 * @param x    the x's coorden.
	 * @param size the table's size.
	 * @param y    the y's coorden.
	 * @return if the box could be in that position or not.
	 */
	public boolean validate(String type, int x, int size, int y) {
		boolean couldCreate = true;
		if (type.equals("Mortal") && x == size - 1 && y == 0 && size % 2 == 0) {
			couldCreate = false;
		} else if (type.equals("Mortal") && x == size - 1 && y == size - 1 && size % 2 != 0) {
			couldCreate = false;
		}
		if (x == 0 && y == 0) {
			if (!(type.equals("NCasilla") || type.equals("Serpiente"))) {
				couldCreate = false;
			}
		}
		return couldCreate;
	}

	/**
	 * Assign to the box a position.
	 * 
	 * @param value the box's position.
	 */
	public void setPosition(int value) {
		this.position = value;
	}

	/**
	 * return the box's type.
	 * 
	 * @return the box's type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * return the box's position.
	 * 
	 * @return the box's position.
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * put the box in a random position.
	 * 
	 * @param size the table's size.
	 */
	public void putCasilla(int size) {
		table = (Table.getInstance(size)).getGameTable();
		boolean colocada = false;
		while (!colocada) {
			int x = numero.nextInt(size);
			int y = numero.nextInt(size);
			if (table[x][y] == null) {
				table[x][y] = this;
				colocada = true;
			}
			startX = x;
			startY = y;

		}
	}

}
