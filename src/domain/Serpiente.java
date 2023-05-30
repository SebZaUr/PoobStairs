package domain;

import java.util.Random;

/**
 * Create diferents types of ladders.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public abstract class Serpiente {

	protected Random numero = new Random();
	protected int[][] positions = new int[2][2];
	private NCasilla fin;
	private NCasilla inicio;

	/**
	 *  
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
				inicio = (NCasilla) table[x][y];
				confirm = true;
				inicio.putSerpiente(this, "Inicio");
				int[] startPosition = { x, y };
				positions[0] = startPosition;
				putFinal(size, x);
				(Table.getInstance(size)).setFinal(positions, "Serpiente");

			}
		}

	}

	/**
	 *  
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
				fin = (NCasilla) table[x][y];
				colocada = true;
				fin.putSerpiente(this, "Fin");
				int[] startPosition = { x, y };
				positions[1] = startPosition;
			}
		}

	}

	public abstract int movimiento();

	protected int startPosition() {
		return inicio.getPosition();
	}

	protected int endPosition() {
		return fin.getPosition();
	}
}
