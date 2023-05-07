package domain;

/**
 * The exception's PoobStairs class.
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.2
 */
public class PoobStairsExceptions extends Exception {
    public static final String IS_EMPTY = "No has llenado alguna casiila, por favor llenarlas todas.";
    public static final String BAD_PERCENTAGE = "Valor numerico invalido, porfavor vuelva a ingresar.";
    public static final String SAME_COLOR = "Ambos jugadores tienen el mismo color, porfavor alguno cambie.";
    public static final String MORTAL = "!HAS CAIDO EN UNA CASILLA MORTAL!.Inicia denuevo";
    public static final String SNAKE = "CAISTE EN UNA SERPIENTE";
    public static final String PREGUNTA = "CAISTE EN UNA PREGUNTO, Si respondes bien a una pregunta de conocimiento general avanzas una casilla, ingrese un numero del 1 al ";

    /**
     * Create a PoobStairsException.
     * 
     * @param msm The exception's message.
     */
    public PoobStairsExceptions(String msm) {
        super(msm);
    }
}