package domain;

public class ESuper extends Escalera {

	/**
	 *  
	 */
	public ESuper(int size) {
		putInicio(size);
	}

	public ESuper(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	@Override
	public int movimiento(int posicion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
	}

}
