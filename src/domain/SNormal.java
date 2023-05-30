package domain;

public class SNormal extends Serpiente {

	/**
	 *  
	 */
	public SNormal(int size) {
		putInicio(size);
	}

	@Override
	public int movimiento() {
		int start = startPosition();
		int end = endPosition();
		return end - start;
	}

}
