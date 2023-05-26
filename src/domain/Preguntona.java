package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Let me create a box that if the player falls in has to answer a question to
 * could advance.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.0
 */
public class Preguntona extends Casillas {
    private static Map<Integer, Pregunta> preguntas = new HashMap<>();

    /**
     * Let me create a Preguntona's box.
     * 
     * @param size the table's size.
     */
    public Preguntona(int size) {
        type = "Preguntona";
        Table.getInstance(size);
        table = Table.getGameTable();
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(size);
            int y = numero.nextInt(size);
            if (validate(type, x, size, y)) {
                if (table[x][y] == null) {
                    table[x][y] = this;
                    colocada = true;
                }
                startX = x;
                startY = y;
            }
        }
    }

    @Override
    public int enCasilla(int size) throws PoobStairsExceptions {
        throw new PoobStairsExceptions(PoobStairsExceptions.PREGUNTA);
    }

    /**
     * Return the question that the player has to answer.
     * 
     * @param i the question's identifier.
     * @return the question.
     */
    public static Pregunta getPregunta() {
        Random alazar = new Random();
        return preguntas.get(alazar.nextInt(preguntas.size()));
    }
}