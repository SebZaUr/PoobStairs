package domain;

import java.util.Random;

public abstract class Escalera {

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
			if (table[x][y].getType().equals("NCasilla") && x > 0) {
				inicio = (NCasilla) table[x][y];
				confirm = true;
				inicio.putEscalera(this, "Inicio");
				int[] startPosition = { x, y };
				positions[0] = startPosition;
				putFinal(size, x);
				(Table.getInstance(size)).setFinal(positions, "Escalera");
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
			if (startX == 1) {
				x = numero.nextInt(startX);
			} else {
				x = numero.nextInt(startX - 1) + 1;
			}
			y = numero.nextInt(size);
			if (table[x][y].getType().equals("NCasilla")) {
				fin = (NCasilla) table[x][y];
				colocada = true;
				fin.putEscalera(this, "Fin");
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
