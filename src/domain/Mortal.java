package domain;

public class Mortal extends Casillas {

    /**
     * Let me create a Mortal box.
     * 
     * @param size the table's size.
     */
    public Mortal(int size) {
        super(size);
        type = "Mortal";
    }

    @Override
    public int enCasilla() throws PoobStairsExceptions {
        throw new PoobStairsExceptions(PoobStairsExceptions.MORTAL);
    }
}