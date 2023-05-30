package domain;

import java.util.HashMap;
import java.util.Random;

public class Preguntona extends Casillas {

	private static HashMap<Integer, Pregunta> preguntas = new HashMap<>();

	private Pregunta pregunta;

	/**
	 *  
	 */
	public Preguntona(int size) {
		type = "Preguntona";
		putCasilla(size);
	}

	/**
	 *  
	 */
	public Preguntona(int x, int y, int size) {
		this.type = "Preguntona";
		Casillas[][] table = (Table.getInstance(size)).getGameTable();
		table[x][y] = this;
	}

	public static Pregunta getPregunta() {
		Random numero = new Random();
		return preguntas.get(numero.nextInt(preguntas.size()));
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		throw new PoobStairsExceptions(PoobStairsExceptions.QUESTION);
	}

}
