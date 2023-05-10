package domain;

import java.util.Random;

public class Dado {

    private static int valor;
    private static Random numero = new Random();
    private int percentage;

    public Dado(int porBonificador) {
        this.valor = numero.nextInt(6) + 1;
        percentage = porBonificador / 100;
    }

    public int getValue() {
        valor = numero.nextInt(6) + 1;
        return valor;
    }
}