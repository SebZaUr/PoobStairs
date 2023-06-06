package domain;

/**
 * Create a modifier that advance one box.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Bonificacion extends Modificador {

	/**
	 * Go in one box.
	 * 
	 * @throws PoobStairsExceptions the modifier.
	 */
	public Bonificacion() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.BONIFICACION);
	}

}
