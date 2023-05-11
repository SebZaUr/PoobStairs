package domain;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
	private static HashMap<Integer, Casillas> mapTable;

	private Table(int size) {
		this.size = size;
		table = new Casillas[size][size];
		mapTable = new HashMap<>();
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
		int numCasillasEspeciales = (percentage * size * size) / 100;
		Random rand = new Random();
		String[] typesCasillas = { "Mortal", "Saltarinas", "SaltarinaInversa", "Avance", "Retroceso", "Preguntona" };
		int contador = 1;
		for (int i = 0; i < 5; i++) {
			new Escalera(size);
			new Serpiente(size);
		}
		while (contador <= numCasillasEspeciales) {
			String type = typesCasillas[rand.nextInt(typesCasillas.length)];
			Class.forName("domain." + type).getConstructor(int.class).newInstance(size);
			contador++;
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (table[i][j] == null) {
					table[i][j] = new Casillas(size);
				}
			}
		}
		ordenar();
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

	private static void ordenar() {
		int valor = 0;
		int contador = 1;
		int ajuste = size - 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i % 2 != 0) {
					valor = (size * size + 1) - contador - ajuste;
					ajuste = ajuste - 2;
				} else {
					ajuste = size - 1;
					valor = (size * size + 1) - contador;
				}
				mapTable.put(valor, table[i][j]);
				contador++;
			}
		}
		System.out.println(mapTable.size());
	}

	public Casillas getBox(int key) {
		return mapTable.get(key);
	}
}
