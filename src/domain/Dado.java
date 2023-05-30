package domain;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Let me create the dice with a percentage that give some modifies.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Dado {

	private int valor;
	private Random numero = new Random();
	private int percentage;
	private static Dado instance;
	private String[] typesModificadores = { "CambioPosicion", "Bonificacion", "Penalizacion" };

	/**
	 * Create the dice with the bonus's percentage.
	 * 
	 * @param porBonificador
	 */
	public Dado(int porModificador) {
		valor = numero.nextInt(6) + 1;
		percentage = (porModificador * 6) / 100;
	}

	/**
	 * Get the dice's value.
	 * 
	 * @return the dice's value.
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws PoobStairsExceptions
	 */
	public int getValue() {
		valor = numero.nextInt(6) + 1;
		return valor;
	}

	/**
	 * Let me verify if exist an instance in this class, in the case, that exists it
	 * doesn't create one.
	 * 
	 * @param porBonificador the bonus's percentage.
	 * @return the dice.
	 */
	public static Dado getInstance(int porModificador) {
		if (instance == null) {
			instance = new Dado(porModificador);
		}
		return instance;
	}

	public void modificador()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, PoobStairsExceptions {
		int probabilidad = numero.nextInt(6) + 1;
		if (probabilidad < percentage) {
			Modificador modificador = (Modificador) Class
					.forName("domain." + typesModificadores[numero.nextInt(typesModificadores.length)])
					.getConstructor().newInstance();
			modificador.movement();

		}
	}

}
