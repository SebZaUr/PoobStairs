package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pregunta {

    private String pregunta;
    private String[] respuestas;
    private String respuestaCorrecta;

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

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
