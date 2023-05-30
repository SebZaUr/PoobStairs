package domain;

public class ENormal extends Escalera {

	/**
	 *  
	 */
	public ENormal(int size) {
		putInicio(size);
	}

	public ENormal(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int position) {
		int start = inicio.getPosition();
		int valor = 0;
		if (start == position) {
			int end = fin.getPosition();
			valor = end - start;
		}
		return valor;
	}

}
