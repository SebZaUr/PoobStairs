package domain;

public class Pregunta {
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