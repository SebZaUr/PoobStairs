package domain;

public class ENormal extends Escalera {

	/**
	 *  
	 */
	public ENormal(int size) {
		putInicio(size);
	}

	@Override
	public int movimiento() {
		int start = startPosition();
		int end = endPosition();
		return start - end;
	}

}
