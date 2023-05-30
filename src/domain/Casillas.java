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

	public abstract int enCasilla(int size) throws PoobStairsExceptions;

	/**
	 *  
	 */
	public boolean validate(String type, int x, int size, int y) {
		boolean couldCreate = true;
		if (type.equals("Mortal") && x == size - 1 && y == 0 && size % 2 == 0) {
			couldCreate = false;
		} else if (type.equals("Mortal") && x == size - 1 && y == size - 1 && size % 2 != 0) {
			couldCreate = false;
		}
		if (x == 0 && y == 0) {
			if (!(type.equals("NCasilla") || type.equals("Escalera"))) {
				couldCreate = false;
			}
		}
		return couldCreate;
	}

	/**
	 *  
	 */
	public void setPosition(int value) {
		this.position = value;
	}

	public String getType() {
		return type;
	}

	public int getPosition() {
		return position;
	}

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
