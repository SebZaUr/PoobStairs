package domain;

/**
 * The exception's PoobStairs class.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.5
 */
public class PoobStairsExceptions extends Exception {
    public static final String IS_EMPTY = "No has llenado alguna casiila, por favor llenarlas todas.";
    public static final String BAD_PERCENTAGE = "Valor numerico invalido, porfavor vuelva a ingresar.";
    public static final String SAME_COLOR = "Ambos jugadores tienen el mismo color, porfavor alguno cambie.";
    public static final String MORTAL = "!HAS CAIDO EN UNA CASILLA MORTAL!.Inicia denuevo";
    public static final String SNAKE = "MUEVETE AL FINAL DE LA SERPIENTE";
    public static final String LADERS = "MUEVETE AL FINAL DE LA ESCALERA";
    public static final String PREGUNTA = "CAISTE EN UNA PREGUNTO, Si respondes bien a una pregunta de conocimiento general avanzas una casilla, ingrese un numero del 1 al ";
    public static final String NOT_FOUND_LADDER = "No se encontraron escaleras por delante, te quedas en la misma casilla.";
    public static final String NOT_FOUND_SNAKE = "No se encontraron serpientes por detras, te quedas en la misma casilla.";
    public static final String CORRECT_ANSWER = "!RESPUESTA CORRECTA¡";
    public static final String WORNG_ANSWER = "!RESPUESTA INCORRECTA¡, pierde turno";
    public static final String NOT_QUESTION = "No hay pregunta";

    /**
     * Create a PoobStairsException.
     * 
     * @param msm The exception's message.
     */
    public PoobStairsExceptions(String msm) {
        super(msm);
    }
}