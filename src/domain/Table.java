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
	private ArrayList<Integer> posStartEscalera = new ArrayList<>();
	private ArrayList<Integer> posStartSerpiente = new ArrayList<>();
	private Escalera[][] posicionesE;
	private Serpiente[][] posicionesS;
	private static Table instance;
	private Casillas[][] table;
	private HashMap<Integer, Casillas> mapTable = new HashMap<>();

	/**
	 * Create a new table.
	 * 
	 * @param the table's size.
	 */
	public Table(int size) {
		this.size = size;
		table = new Casillas[size][size];
		posicionesS = new Serpiente[size][size];
		posicionesE = new Escalera[size][size];
		mapTable = new HashMap<>();
	}

	/**
	 * Create all table
	 * 
	 * @param percentage the special box's percentage.
	 * @throws InstantiationException    if the class can not be instance.
	 * @throws IllegalAccessException    if the method cannot be
	 * @throws IllegalArgumentException  if a method has been passed an illegal or
	 *                                   inappropriate argument.
	 * @throws InvocationTargetException if an exception that wraps an exception
	 *                                   thrown by an invoked method or constructor.
	 * @throws NoSuchMethodException     if the method can not be found.
	 * @throws SecurityException         Thrown by the security manager to indicate
	 *                                   a security violation.
	 * @throws ClassNotFoundException    if the class not found.
	 */
	public void createTable(int percentage, int snakeAndLadder, boolean modificar)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		int numCasillasEspeciales = (percentage * size * size) / 100;
		Random rand = new Random();
		String[] typesCasillas = { "Mortal", "Saltarina", "SaltarinaInversa", "Avance", "Retroceso" };
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
		for (int i = 0; i < 5; i++) {
			Serpiente nueva = new SNormal(size);
			colocarSerpiente(nueva, i);
			Escalera esca = new ENormal(size);
			colocarEscalera(esca, i);
		}
		ordenar();
	}

	/**
	 * put the ladder on the table.
	 * 
	 * @param nueva the ladder.
	 * @param i     the ladder's id.
	 */
	private void colocarEscalera(Escalera nueva, int i) {
		int[][] posiciones = posFinalEscalera.get(i);
		NCasilla val = (NCasilla) table[posiciones[0][0]][posiciones[0][1]];
		NCasilla val2 = (NCasilla) table[posiciones[1][0]][posiciones[1][1]];
		nueva.putI(val);
		nueva.putF(val2);
	}

	/**
	 * put the ladder on the table.
	 * 
	 * @param nueva the ladder.
	 * @param i     the ladder's id.
	 */
	private void colocarSerpiente(Serpiente nueva, int i) {
		int[][] posiciones = posFinalSerpiente.get(i);
		NCasilla val = (NCasilla) table[posiciones[0][0]][posiciones[0][1]];
		NCasilla val2 = (NCasilla) table[posiciones[1][0]][posiciones[1][1]];
		nueva.putI(val);
		nueva.putF(val2);
	}

	/**
	 * put the ladder on the table.
	 * 
	 * @param nueva the ladder.
	 * @param i     the ladder's id.
	 * @throws InstantiationException    if the class can not be instance.
	 * @throws IllegalAccessException    if the method cannot be
	 * @throws IllegalArgumentException  if a method has been passed an illegal or
	 *                                   inappropriate argument.
	 * @throws InvocationTargetException if an exception that wraps an exception
	 *                                   thrown by an invoked method or constructor.
	 * @throws NoSuchMethodException     if the method can not be found.
	 * @throws SecurityException         Thrown by the security manager to indicate
	 *                                   a security violation.
	 * @throws ClassNotFoundException    if the class not found.
	 */
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

	/**
	 * put the snake on the table.
	 * 
	 * @param casilla the list with snake's position.
	 * @param cas     the snake.
	 */
	public void containsBoxS(int[] casilla, Serpiente cas) {
		posicionesS[casilla[0]][casilla[1]] = cas;
	}

	/**
	 * put the ladder on the table.
	 * 
	 * @param casilla the list with ladder's position.
	 * @param cas     the snake.
	 */
	public void containsBoxE(int[] casilla, Escalera cas) {
		posicionesE[casilla[0]][casilla[1]] = cas;
	}

	/**
	 * Create the snakes and ladder with a specific table
	 * 
	 * @param typesE a list with all ladders's positions.
	 * @param typesS a list with all snake's positions.
	 * @throws InstantiationException    if the class can not be instance.
	 * @throws IllegalAccessException    if the method cannot be
	 * @throws IllegalArgumentException  if a method has been passed an illegal or
	 *                                   inappropriate argument.
	 * @throws InvocationTargetException if an exception that wraps an exception
	 *                                   thrown by an invoked method or constructor.
	 * @throws NoSuchMethodException     if the method can not be found.
	 * @throws SecurityException         Thrown by the security manager to indicate
	 *                                   a security violation.
	 * @throws ClassNotFoundException    if the class not found.
	 */
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

	/**
	 * get the list of snakes.
	 * 
	 * @return a list.
	 */
	public Serpiente[][] getFinalPosS() {
		return posicionesS;
	}

	/**
	 * get the list of ladders.
	 * 
	 * @return a list.
	 */
	public Escalera[][] getFinalPosE() {
		return posicionesE;
	}

	/**
	 * get the list of ladders.
	 * 
	 * @param the box's position.
	 */
	public void setStartLadder(int valor) {
		posStartEscalera.add(valor);
	}

	/**
	 * get the list of ladders.
	 * 
	 * @param the box's position.
	 */
	public void setStartSnake(int valor) {
		posStartSerpiente.add(valor);
	}

	/**
	 * get the list of ladders.
	 * 
	 * @return a list.
	 */
	public ArrayList<Integer> getStartLadder() {
		return posStartEscalera;
	}

	/**
	 * get the list of ladders.
	 * 
	 * @return a list.
	 */
	public ArrayList<Integer> getStartSnake() {
		return posStartSerpiente;
	}
}
