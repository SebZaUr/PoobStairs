package domain;

import java.util.ArrayList;

public class NCasilla extends Casillas {

	private Serpiente snake;
	private Escalera ladder;

	/**
	 *  
	 */
	public NCasilla(int size) {
		this.type = "NCasilla";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public NCasilla(int x, int y, int size) {
		this.type = "NCasilla";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) {
		int valor = 0;
		if (ladder != null) {
			valor = ladder.movimiento();
		} else if (snake != null) {
			valor = snake.movimiento();
		}
		return valor;
	}

	public boolean putEscalera(Escalera casilla, String type) {
		boolean put = false;
		if (type.equals("inicio")) {
			ladder = casilla;
			put = true;
		} else if (type.equals("fin")) {
			ladder = casilla;
			put = true;
		}
		return put;
	}

	public boolean putSerpiente(Serpiente casilla, String type) {
		boolean put = false;
		if (type.equals("inicio")) {
			snake = casilla;
			put = true;
		} else if (type.equals("fin")) {
			snake = casilla;
			put = true;
		}
		return put;
	}

	public boolean hasBox() {
		boolean isIn = false;
		if (snake == null && ladder == null) {
			isIn = true;
		}
		return isIn;
	}
}
