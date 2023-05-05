package domain;

public class PoobStairsExceptions extends Exception{
    public static final String IS_EMPTY = "No has llenado alguna casiila, por favor llenarlas todas.";
    public static final String BAD_PERCENTAGE = "Valor numerico invalido, porfavor vuelva a ingresar.";

    public PoobStairsExceptions(String msm){
        super(msm);
    }
}