package domain;

public class EDual extends Escalera {

	private NCasilla derecha;

	private NCasilla izquierda;

	/**
	 *  
	 */
	public EDual(int size) {
		putInicio(size);
	}

	public EDual(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int position) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
	}

}
