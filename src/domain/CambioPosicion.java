package domain;

/**
 * Create a modifier that change the players's positions between them.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class CambioPosicion extends Modificador {

	/**
	 * Change the player's positions between them.
	 * 
	 * @throws PoobStairsExceptions the modifier.
	 */
	public CambioPosicion() throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.CAMBIO_POSICION);
	}

}
