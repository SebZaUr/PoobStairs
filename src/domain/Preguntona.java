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
	public Preguntona(int x, int y) {

	}

	public static Pregunta getPregunta() {
		Random numero = new Random();
		return preguntas.get(numero.nextInt(preguntas.size()));
	}

	@Override
	public int enCasilla(int size) throws PoobStairsExceptions {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'enCasilla'");
	}

}
