package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create the general knowledge questions
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.7
 */
public class Pregunta {

    private String pregunta;
    private String[] respuestas;
    private String respuestaCorrecta;

    /**
     * Create a list with general knowledge questions.
     * 
     * @param archivo The file's name where save the question.
     */
    public Pregunta(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            if ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                pregunta = datos[0];
                respuestas = new String[4];
                for (int i = 0; i < 4; i++) {
                    respuestas[i] = datos[i + 1];
                }
                respuestaCorrecta = datos[5];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the question.
     * 
     * @return the question
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * the answers to the question
     * 
     * @return a list with all possible's answer
     */
    public String[] getRespuestas() {
        return respuestas;
    }

    /**
     * get the correct option.
     * 
     * @return an answer.
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
