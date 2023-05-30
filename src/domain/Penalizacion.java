package domain;

public class Penalizacion extends Modificador {

	public Penalizacion() {
	}

	@Override
	public int movement() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.PENALIZACION);
	}

}
