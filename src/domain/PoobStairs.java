package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import presentation.PreguntaGUI;

/**
 * The poobStairs's main class.
 */
public class PoobStairs {

	private int size;
	private Player Jugador1;
	private Player Jugador2;

	/**
	 * Can create the game without specific table.
	 * 
	 * @param jugador1       the first player's name.
	 * @param jugador2       the second player's name.
	 * @param colorJ1        the first player's color piece.
	 * @param colorJ2        the second player's color piece.
	 * @param size           the game table's size.
	 * @param porCasillas    the percentage of special box.
	 * @param porModificador the percentage of modifies.
	 * @param modificar      if the snakes and ladders can change between them.
	 * @param modoMaquina    if the second player is a bot.
	 * @param numSE          the snakes and ladders's number.
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
	public PoobStairs(String jugador1, String jugador2, String colorJ1, String colorJ2, int size, int porCasillas,
			int porModificador, boolean modificar, String modoMaquina, int numSE)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		(Table.getInstance(size)).createTable(porCasillas, numSE, modificar);
		this.size = size;
		Jugador1 = new Persona(colorJ1);
		if (modoMaquina != null) {
			Jugador2 = (Player) Class.forName("domain." + modoMaquina)
					.getConstructor(String.class, int.class).newInstance(colorJ2, size);
		} else {
			Jugador2 = new Persona(colorJ2);
		}
		Jugador1.setTurn(true);
		Dado.getInstance(porModificador);

	}

	/**
	 * Can create the game with specific table.
	 * 
	 * @param jugador1       the first player's name.
	 * @param jugador2       the second player's name.
	 * @param colorJ1        the first player's color piece.
	 * @param colorJ2        the second player's color piece.
	 * @param size           the game table's size.
	 * @param porCasillas    the percentage of special box.
	 * @param porModificador the percentage of modifies.
	 * @param modificar      if the snakes and ladders can change between them.
	 * @param modoMaquina    if the second player is a bot.
	 * @param numSE          the snakes and ladders's number.
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
	public PoobStairs(String jugador1, String jugador2, String colorJ1, String colorJ2, int size, int porCasillas,
			int porModificador, boolean modificar, String modoMaquina, int numSE, ArrayList<String[]> tablero)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		(Table.getInstance(size)).createTable(tablero);
		this.size = size;
		Jugador1 = new Persona(colorJ1);
		if (modoMaquina != null) {
			Jugador2 = (Player) Class.forName("domain." + modoMaquina)
					.getConstructor(String.class, int.class).newInstance(colorJ2, size);
		} else {
			Jugador2 = new Persona(colorJ2);
		}
		Jugador1.setTurn(true);
		Dado.getInstance(porModificador);
	}

	/**
	 * Can move the piece in the table's borders.
	 * 
	 * @param value   the dice's value.
	 * @param guardar if the modifier can save.
	 * @param type    the modifier's type.
	 * @throws PoobStairsExceptions if a player win.
	 */
	public void mover(int value, boolean guardar, String type) throws PoobStairsExceptions {
		Random numero = new Random();
		if (Jugador1.getTurn()) {
			movement(Jugador1, value, true, "");
			try {
				String SE = "";
				int add = (Table.getInstance(size)).getBox(Jugador1.getPosition()).enCasilla(size);
				if (add != 0) {
					if (add > 0) {
						SE = "Escalera";
					} else if (add < 0) {
						SE = "Serpiente";
					}
					movement(Jugador1, add, false, SE);
				}
			} catch (PoobStairsExceptions e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Moriste", JOptionPane.INFORMATION_MESSAGE);
				if (e.getMessage().equals(PoobStairsExceptions.MORTAL)) {
					movement(Jugador1, -Jugador1.getPosition() + 1, false, "");
				} else if (e.getMessage().equals(PoobStairsExceptions.QUESTION)) {
					Jugador1.setQuestion(true);
				} else if (e.getMessage().equals(PoobStairsExceptions.SALTARINA)) {
					movement(Jugador1, numero.nextInt(6) + 1, false, "");
				} else if (e.getMessage().equals(PoobStairsExceptions.SALTARINAI)) {
					movement(Jugador1, (numero.nextInt(6) + 1) * -1, false, "");
				}

			}
			win(Jugador1);
			Jugador1.setTurn(false);
			Jugador2.setTurn(true);
			if (guardar) {
				Jugador1.saveModificador(type);
			}
		} else {
			movement(Jugador2, value, true, "");
			try {
				String SE = "";
				int add = (Table.getInstance(size)).getBox(Jugador2.getPosition()).enCasilla(size);
				if (add != 0) {
					if (add > 0) {
						SE = "Escalera";
					} else if (add < 0) {
						SE = "Serpiente";
					}
					movement(Jugador2, add, false, SE);
				}
			} catch (PoobStairsExceptions e) {
				if (e.getMessage().equals(PoobStairsExceptions.MORTAL)) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Moriste", JOptionPane.INFORMATION_MESSAGE);
					movement(Jugador2, -Jugador2.getPosition() + 1, false, "");
				} else if (e.getMessage().equals(PoobStairsExceptions.QUESTION)) {
					Jugador2.setQuestion(true);
				} else if (e.getMessage().equals(PoobStairsExceptions.SALTARINA)) {
					movement(Jugador2, numero.nextInt(6) + 1, false, "");
				} else if (e.getMessage().equals(PoobStairsExceptions.SALTARINAI)) {
					movement(Jugador2, (numero.nextInt(6) + 1) * -1, false, "");
				}
			}
			win(Jugador2);
			Jugador2.setTurn(false);
			Jugador1.setTurn(true);
			if (guardar) {
				Jugador2.saveModificador(type);
			}
		}

	}

	/**
	 * Can create the game without specific table.
	 * 
	 * @param nombre             the file in witch I save the game.
	 * @param jugador1           the first player's information.
	 * @param jugador2           the second player's information.
	 * @param size               the game table's size.
	 * @param casillasEspeciales the percentage of special box.
	 * @param bonificador        the percentage of modifies.
	 * @param posEscaleras       all laders's positions.
	 * @param posSerpientes      all snakes's positions.
	 * @param modoMaquina        if the second player is a bot.
	 * @param modificar          if the snakes and ladders can change between them.
	 * @param numSE              the snakes and ladders's number.
	 * @throws FileNotFoundException
	 */
	public void save(File nombre, String jugador1, String jugador2, String casillasEspeciales, String bonificador,
			String size, ArrayList<int[][]> posEscaleras, ArrayList<int[][]> posSerpientes, String modoMaquina,
			boolean modificar, int numSE) throws FileNotFoundException {
		PrintWriter archivo = new PrintWriter(new FileOutputStream(nombre.getName() + ".txt"));
		archivo.println(jugador1);
		archivo.println(jugador2);
		if (Jugador1.getTurn()) {
			archivo.println("Jugador 1");
		} else {
			archivo.println("Jugador 2");
		}
		if (modoMaquina != null) {
			archivo.println(casillasEspeciales + "," + bonificador + "," + size + "," + modificar + "," + modoMaquina);
		} else {
			archivo.println(casillasEspeciales + "," + bonificador + "," + size + "," + modificar);
		}
		String[] tablero = copyTable();
		archivo.println("Escaleras: ");
		for (int i = 0; i < 5; i++) {
			String posicion = Integer.toString(posEscaleras.get(i)[0][0]) + "-"
					+ Integer.toString(posEscaleras.get(i)[0][1]) + "-" + Integer.toString(posEscaleras.get(i)[1][0])
					+ "-" + Integer.toString(posEscaleras.get(i)[1][1]);
			archivo.println(posicion);
		}
		archivo.println("Serpientes: ");
		for (int i = 0; i < 5; i++) {
			String posicion = Integer.toString(posSerpientes.get(i)[0][0]) + "-"
					+ Integer.toString(posSerpientes.get(i)[0][1]) + "-" + Integer.toString(posSerpientes.get(i)[1][0])
					+ "-" + Integer.toString(posSerpientes.get(i)[1][1]);
			archivo.println(posicion);
		}
		archivo.println("Tablero: ");
		for (String i : tablero) {
			archivo.println(i);
		}
		archivo.close();
	}

	/**
	 * Open a file that save an instance of a game.
	 * 
	 * @param nombre the file that has the game saved.
	 * @throws IOException
	 */
	public ArrayList<String[]> open(String nombre) throws IOException {
		BufferedReader archivo = new BufferedReader(new FileReader(nombre));
		ArrayList<String[]> informacion = new ArrayList<>();
		String escribir = archivo.readLine();
		while (escribir != null) {
			informacion.add(escribir.trim().split(","));
			escribir = archivo.readLine();
		}
		archivo.close();
		return informacion;
	}

	/**
	 * get the players's positions.
	 * 
	 * @return a list with player's positions.
	 */
	public int[] getPositions() {
		int[] positions = { Jugador1.getPosition(), Jugador2.getPosition() };
		return positions;
	}

	/**
	 * Let save the table.
	 * 
	 * @return A string list with all table's type.
	 */
	private String[] copyTable() {
		String[] tablero = new String[size];
		Casillas[][] instancia = (Table.getInstance(size)).getGameTable();
		for (int i = 0; i < size; i++) {
			String copia = instancia[i][0].getType();
			for (int j = 1; j < size; j++) {
				copia = copia + "," + instancia[i][j].getType();
				;
			}
			tablero[i] = copia;
		}
		return tablero;
	}

	/**
	 * Make a question to the player.
	 * 
	 * @param jugador the player that has to answer.
	 * @throws PoobStairsExceptions If the player answers or if not has a question.
	 */
	private void question(Player jugador) throws PoobStairsExceptions {
		if (jugador.hasQuestion()) {
			Pregunta question = Preguntona.getPregunta();
			PreguntaGUI pregunta = new PreguntaGUI(question);
			pregunta.setVisible(true);
			if (jugador.getAnswer()) {
				throw new PoobStairsExceptions(PoobStairsExceptions.CORRECT_ANSWER);
			} else {
				throw new PoobStairsExceptions(PoobStairsExceptions.WORNG_ANSWER);
			}
		} else {
			throw new PoobStairsExceptions(PoobStairsExceptions.NOT_QUESTION);
		}

	}

	/**
	 * Return the player.
	 * 
	 * @return a list with the players.
	 */
	public Player[] getJugadores() {
		return new Player[] { Jugador1, Jugador2 };
	}

	/**
	 * check if the player has or not a question to answer.
	 * 
	 * @param jugador the player on turn.
	 * @param value   the dice's value.
	 * @param extra   if the player has a extra movement.
	 */
	private void movement(Player jugador, int value, boolean extra, String type) {
		try {
			question(jugador);
		} catch (PoobStairsExceptions e) {
			if (!e.getMessage().equals(PoobStairsExceptions.WORNG_ANSWER)) {
				jugador.move(value, size, extra);
				jugador.setQuestion(false);
				if (type.equals("Escalera")) {
					jugador.fallsLadders();
				} else if (type.equals("Serpiente")) {
					jugador.fallsSnakes();
				}
			}
		}
	}

	/**
	 * change the player's positions between them if one has this modifier.
	 */
	public void changePosition() {
		int posJ1 = Jugador1.getPosition();
		int posJ2 = Jugador2.getPosition();
		Jugador1.move(posJ2 - posJ1, size, true);
		Jugador2.move(posJ1 - posJ2, size, true);
	}

	/**
	 * Verify if the player won.
	 * 
	 * @param jugador the player in turn.
	 * @throws PoobStairsExceptions if the player won.
	 */
	public void win(Player jugador) throws PoobStairsExceptions {
		if (jugador.getPosition() == size * size) {
			throw new PoobStairsExceptions(PoobStairsExceptions.WIN);
		}
	}

}
