package domain;

public class PoobStairsExceptions extends Exception{
    public static final String IS_EMPTY = "No has llenado alguna casiila, por favor llenarlas todas"; 

    public PoobStairsExceptions(String msm){
        super(msm);
    }
}