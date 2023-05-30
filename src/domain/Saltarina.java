package domain;

public class Saltarina extends Casillas {

	/**
	 *  
	 */
	public Saltarina(int size) {
		type = "Saltarina";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public Saltarina(int x, int y, int size) {
		this.type = "Saltarina";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) {
		return numero.nextInt(6) + 1;
	}

}
