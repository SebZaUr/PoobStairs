package domain;

public class EDebil extends Escalera {

	/**
	 *  
	 */
	public EDebil(int size) {
		putInicio(size);
	}

	public EDebil(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int position) {
		return 0;

	}

}
