package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Let me create a box that if the player falls in has to answer a question to
 * could advance.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.0
 */
public class Preguntona extends Casillas {
    private Map<Integer, Pregunta> preguntas = new HashMap<>();

    /**
     * Let me create a Preguntona's box.
     * 
     * @param size the table's size.
     */
    public Preguntona(int size) {
        super(size);
        type = "Preguntona";
    }

    @Override
    public int enCasilla() throws PoobStairsExceptions {
        throw new PoobStairsExceptions(PoobStairsExceptions.PREGUNTA);
    }

    /**
     * Return the question that the player has to answer.
     * 
     * @param i the question's identifier.
     * @return the question.
     */
    public Pregunta getPregunta(int i) {
        return preguntas.get(i);
    }
}

class Pregunta {
    private String pregunta;
    private String respuesta;

    /**
     * Create a question with the answer.
     * 
     * @param pregunta  the question's statement.
     * @param respuesta the question's answer.
     */
    public Pregunta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    /**
     * Return the question's statement.
     * 
     * @return a String with the question's statement.
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Return the question's answer.
     * 
     * @return a String with the question's answer
     */
    public String getRespuesta() {
        return respuesta;
    }
}