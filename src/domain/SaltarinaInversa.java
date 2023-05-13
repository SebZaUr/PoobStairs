package domain;

public class SaltarinaInversa extends Casillas {

    /**
     * Create a Saltarina box.
     * 
     * @param size the table's size.
     */
    public SaltarinaInversa(int size) {
        super(size, "SaltarinaInversa");
        type = "SaltarinaInversa";
        salto = -5;
    }
}