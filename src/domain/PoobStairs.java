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

import javax.swing.JOptionPane;

import presentation.PreguntaGUI;

public class PoobStairs {

	private int size;
	private Player Jugador1;
	private Player Jugador2;

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

	public PoobStairs(String jugador1, String jugador2, String colorJ1, String colorJ2, int size, int porCasillas,
			int porModificador, int modificar, String modoMaquina, String[] tablero)
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

	public void mover(int value, boolean guardar, String type) {
		if (Jugador1.getTurn()) {
			movement(Jugador1, value);
			try {
				int add = (Table.getInstance(size)).getBox(Jugador1.getPosition()).enCasilla(size);
				if (add > 0) {
					movement(Jugador1, add);
				}
			} catch (PoobStairsExceptions e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Moriste", JOptionPane.INFORMATION_MESSAGE);
				movement(Jugador1, -Jugador1.getPosition());
			}
			Jugador1.setTurn(false);
			Jugador2.setTurn(true);
			if (guardar) {
				Jugador1.saveModificador(type);
			}
		} else {
			movement(Jugador2, value);
			try {
				int add = (Table.getInstance(size)).getBox(Jugador1.getPosition()).enCasilla(size);
				if (add > 0) {
					movement(Jugador2, add);
				}
			} catch (PoobStairsExceptions e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Moriste", JOptionPane.INFORMATION_MESSAGE);
				movement(Jugador2, -Jugador2.getPosition());
			}
			Jugador2.setTurn(false);
			Jugador1.setTurn(true);
			if (guardar) {
				Jugador2.saveModificador(type);
			}
		}

	}

	public void save(File nombre, String jugador1, String jugador2, String casillasEspeciales, String bonificador,
			String size, ArrayList<int[][]> posEscaleras, ArrayList<int[][]> posSerpientes, String modoMaquina,
			boolean modificar) throws FileNotFoundException {
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

	public int[] getPositions(String nombre) {
		int[] positions = { Jugador1.getPosition(), Jugador2.getPosition() };
		return positions;
	}

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

	public Player[] getJugadores() {
		return new Player[] { Jugador1, Jugador2 };
	}

	public int[] getPositions() {
		int[] positions = { Jugador1.getPosition(), Jugador2.getPosition() };
		return positions;
	}

	private void movement(Player jugador, int value) {
		try {
			question(jugador);
		} catch (PoobStairsExceptions e) {
			if (!e.getMessage().equals(PoobStairsExceptions.WORNG_ANSWER)) {
				jugador.move(value, size);
				jugador.setQuestion(false);
			}
		}
	}

	public void changePosition() {
		int posJ1 = Jugador1.getPosition();
		int posJ2 = Jugador2.getPosition();
		Jugador1.move(posJ2 - posJ1, size);
		Jugador2.move(posJ1 - posJ2, size);
	}

}
