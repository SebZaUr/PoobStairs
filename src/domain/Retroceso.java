package domain;

public class Retroceso extends Casillas {

	private int size;

	/**
	 *  
	 */
	public Retroceso(int size) {
		type = "Retroceso";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public Retroceso(int x, int y) {

	}

	@Override
	public int enCasilla(int size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'enCasilla'");
	}

}
