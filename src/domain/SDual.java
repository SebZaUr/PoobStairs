package domain;

public class SDual extends Serpiente {

	private NCasilla derecha;

	private NCasilla izquierda;

	/**
	 *  
	 */
	public SDual(int size, int x, int y, int w, int z) {
		Casillas[][] casillas = (Table.getInstance(size)).getGameTable();
		inicio = (NCasilla) casillas[x][y];
		fin = (NCasilla) casillas[w][z];
	}

	public SDual(int size) {
		putInicio(size);
	}

	@Override
	public int movimiento(int position) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
	}

}
