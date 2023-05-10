package domain;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Let me create the game table.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Table {
	private static int size;
	private static Casillas[][] table;
	private static Table instance;

	private Table(int size) {
		this.size = size;
		table = new Casillas[size][size];
	}

	/**
	 * 
	 * @param percentage
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static void createTable(int percentage)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		int numCasillasEspeciales = percentage / 100;
		Random rand = new Random();
		String[] typesCasillas = { "Mortal", "Saltarinas", "SaltarinaInversa", "Avance", "Retroceso", "Preguntona" };
		int contador = 1;
		for (int i = 0; i < 5; i++) {
			new Escalera(size);
			new Serpiente(size);
		}
		while (contador <= numCasillasEspeciales) {
			String type = typesCasillas[rand.nextInt(typesCasillas.length)];
			Class.forName("Domain." + type).getConstructor().newInstance();
		}
		for (int i = 0; i < size; i++) {
			if (i % 2 != 0) {
				for (int j = 0; j < size; j++) {
					if (table[i][j] == null) {
						table[i][j] = new Casillas(size);
					}
				}
			} else {
				for (int j = size - 1; j >= 0; j--) {
					if (table[i][j] == null) {
						table[i][j] = new Casillas(size);
					}
				}
			}
		}
	}

	/**
	 * Return the game Table.
	 * 
	 * @return A Casillas Matrix.
	 */
	public static Casillas[][] getGameTable() {
		return table;
	}

	/**
	 * Let me verify if exist an instance in this class, in the case, that exists it
	 * doesn't create one.
	 * 
	 * @param percentage
	 * @param size
	 * @return
	 */
	public static Table getInstance(int value) {
		if (instance == null) {
			instance = new Table(value);
		}
		return instance;
	}
}
