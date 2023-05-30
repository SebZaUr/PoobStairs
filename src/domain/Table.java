package domain;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Let me create the game table with special and normal box apart of the snake
 * and ladders.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.3
 */
public class Table {

	private int size;
	private ArrayList<int[][]> posFinalEscalera = new ArrayList<>();
	private ArrayList<int[][]> posFinalSerpiente = new ArrayList<>();
	private ArrayList<Integer> startEscalera = new ArrayList<>();
	private ArrayList<Integer> startSerpiente = new ArrayList<>();
	private static Table instance;
	private static Casillas[][] table;
	private HashMap<Integer, Casillas> mapTable = new HashMap<>();
	private ArrayList<int[]> escalerasSerpientes = new ArrayList<>();

	/**
	 * Create a new table.
	 * 
	 * @param the table's size.
	 */
	public Table(int size) {
		this.size = size;
		table = new Casillas[size][size];
		mapTable = new HashMap<>();
	}

	/**
	 * Let pass a table's name to a table
	 * 
	 * @param tablero a List with all box's types in orden to build the table.
	 */
	public Table(String[] tablero) {

	}

	/**
	 * Create all table
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
	public void createTable(int percentage, int snakeAndLadder, boolean modificar)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		int numCasillasEspeciales = (percentage * size * size) / 100;
		Random rand = new Random();
		String[] typesCasillas = { "Mortal", "Saltarina", "SaltarinaInversa", "Avance", "Retroceso", "Preguntona" };
		int contador = 1;
		while (contador <= numCasillasEspeciales) {
			String type = typesCasillas[rand.nextInt(typesCasillas.length)];
			Class.forName("domain." + type).getConstructor(int.class).newInstance(size);
			contador++;
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (table[i][j] == null) {
					table[i][j] = new NCasilla(size);
				}
			}
		}
		ordenar();
		for (int i = 0; i < snakeAndLadder; i++) {
			new SNormal(size);
			new ENormal(size);
		}
	}

	public void createTable(ArrayList<String[]> tablero)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		for (int i = 0; i < tablero.size(); i++) {
			for (int j = 0; j < tablero.size(); j++) {
				String type = tablero.get(i)[j];
				Class.forName("domain." + type).getConstructor(int.class, int.class, int.class).newInstance(i, j, size);
			}
		}

	}

	/**
	 * Return the game Table.
	 * 
	 * @return A Casillas Matrix.
	 */
	public Casillas[][] getGameTable() {
		return table;
	}

	/**
	 * Let me put all table on a hashmap.
	 */
	private void ordenar() {
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
				table[i][j].setPosition(valor);
				contador++;
			}
		}
	}

	/**
	 * Return the box on the hashmap
	 * 
	 * @param key the box's number.
	 * @return the box.
	 */
	public Casillas getBox(int key) {
		return mapTable.get(key);
	}

	/**
	 * Let´s save the final ladder or snake position.
	 * 
	 * @param posicion a matrix with the stard and end positios.
	 * @param type     if is a ladder or snake.
	 */
	public void setFinal(int[][] posicion, String type) {
		if (type.equals("Serpiente")) {
			posFinalSerpiente.add(posicion);
		} else {
			posFinalEscalera.add(posicion);
		}
	}

	/**
	 * Return the matrix with the stard and end ladder's positions.
	 */
	public ArrayList<int[][]> getFinalLadder() {
		return posFinalEscalera;
	}

	/**
	 * Return the matrix with the stard and end snake's positions.
	 */
	public ArrayList<int[][]> getFinalSnake() {
		return posFinalSerpiente;
	}

	public static Table getInstance(int size) {
		if (instance == null) {
			instance = new Table(size);
		}
		return instance;
	}

	public static Table getInstance(String[] tablero) {
		if (instance == null) {
			instance = new Table(tablero);
		}
		return instance;
	}

	public ArrayList<Integer> getStartLadder() {
		return startEscalera;
	}

	public ArrayList<Integer> getStartSnake() {
		return startSerpiente;
	}

	public boolean containsBox(int[] casilla) {
		return escalerasSerpientes.contains(casilla);
	}

	public void add(int posi, String type) {
		if (type.equals("serpiente")) {
			startSerpiente.add(posi);
		} else {
			startEscalera.add(posi);
		}
	}

	public void putSE(String[] typesE, String[] typesS)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		int contador = 0;
		for (int[][] i : posFinalEscalera) {
			Class.forName("domain." + typesE[contador])
					.getConstructor(int.class, int.class, int.class, int.class, int.class)
					.newInstance(size, i[0][0], i[0][0], i[0][0], i[0][0]);
		}

		for (int[][] i : posFinalSerpiente) {
			Class.forName("domain." + typesS[contador])
					.getConstructor(int.class, int.class, int.class, int.class, int.class)
					.newInstance(size, i[0][0], i[0][0], i[0][0], i[0][0]);

		}
	}
}
