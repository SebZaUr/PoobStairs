package domain;

public class CambioPosicion extends Modificador {

	public CambioPosicion() {
	}

	@Override
	public int movement() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.CAMBIO_POSICION);
	}

}
