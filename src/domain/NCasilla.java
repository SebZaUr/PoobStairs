package domain;

import java.util.ArrayList;

public class NCasilla extends Casillas {

	private Serpiente snake;
	private Escalera ladder;
	private boolean put = false;

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

	public void putEscalera(Escalera casilla, String type) {
		if (type.equals("inicio")) {
			ladder = casilla;
			put = true;
		} else if (type.equals("fin")) {
			ladder = casilla;
			put = true;
		}
	}

	public void putSerpiente(Serpiente casilla, String type) {
		put = false;
		if (type.equals("inicio")) {
			snake = casilla;
			put = true;
		} else if (type.equals("fin")) {
			snake = casilla;
			put = true;
		}
	}

	public boolean hasBox() {
		return put;
	}
}
