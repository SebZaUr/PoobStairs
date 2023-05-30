package domain;

public class Bonificacion extends Modificador {

	public Bonificacion() {
	}

	@Override
	public int movement() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.BONIFICACION);
	}

}
