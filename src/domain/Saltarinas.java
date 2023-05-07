package domain;

public class Saltarinas extends Casillas {

    /**
     * Create a Saltarina box.
     * 
     * @param size the table's size.
     */
    public Saltarinas(int size) {
        super(size);
        type = "Saltarinas";
        salto = 5;
    }

}