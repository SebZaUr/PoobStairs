package domain;

public class Mortal extends Casillas {

	/**
	 *  
	 */
	public Mortal(int size) {
		this.type = "Mortal";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public Mortal(int x, int y, int size) {
		this.type = "Mortal";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.MORTAL);
	}

}
