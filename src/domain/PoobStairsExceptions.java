package domain;

public class PoobStairsExceptions extends Exception {
    public static final String IS_EMPTY = "No has llenado alguna casiila, por favor llenarlas todas.";
    public static final String BAD_PERCENTAGE = "Valor numerico invalido, porfavor vuelva a ingresar.";
    public static final String SAME_COLOR = "Ambos jugadores tienen el mismo color, porfavor alguno cambie.";

    public PoobStairsExceptions(String msm) {
        super(msm);
    }
}