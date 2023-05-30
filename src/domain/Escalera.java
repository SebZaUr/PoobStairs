package domain;

import java.util.Random;

public abstract class Escalera {

	protected Random numero = new Random();
	protected int[][] positions = new int[2][2];
	protected NCasilla fin;
	protected NCasilla inicio;

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
				if (!inicio.hasBox()) {
					confirm = true;
					inicio.putEscalera(this, "inicio");
					(Table.getInstance(size)).add(inicio.getPosition(), "escalera");
					int[] startPosition = { x, y };
					positions[0] = startPosition;
					putFinal(size, x);
					(Table.getInstance(size)).setFinal(positions, "Escalera");
				}
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
				if (!fin.hasBox()) {
					colocada = true;
					fin.putEscalera(this, "fin");
					int[] startPosition = { x, y };
					positions[1] = startPosition;
				}
			}
		}

	}

	public abstract int movimiento(int position);
}
