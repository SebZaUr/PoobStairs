package domain;

/**
 * Create a modifier that go back one position
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Penalizacion extends Modificador {

	/**
	 * Go back one box.
	 * 
	 * @throws PoobStairsExceptions the modifier.
	 */
	public Penalizacion() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.PENALIZACION);
	}

}
