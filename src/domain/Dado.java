package domain;

import java.util.Random;

public class Dado {

    private static int valor;
    private static Random numero = new Random();
    private int percentage;
    private static Dado instance;

    /**
     * Create the dice with the bonus's percentage.
     * 
     * @param porBonificador
     */
    private Dado(int porBonificador) {
        Dado.valor = numero.nextInt(6) + 1;
        percentage = porBonificador / 100;
    }

    /**
     * Get the dice's value.
     * 
     * @return the dice's value.
     */
    public int getValue() {
        valor = numero.nextInt(6) + 1;
        return valor;
    }

    /**
     * Let me verify if exist an instance in this class, in the case, that exists it
     * doesn't create one.
     * 
     * @param porBonificador the bonus's percentage.
     * @return the dice.
     */
    public static Dado getInstance(int porBonificador) {
        if (instance == null) {
            instance = new Dado(porBonificador);
        }
        return instance;
    }
}