package domain;

/**
 * Create a box that if the player falls in advance one box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.0
 */
public class Avance extends Casillas {

    /**
     * Create an Avance's Box.
     * 
     * @param size the table's size.
     */
    public Avance(int size) {
        super(size);
        type = "Avance";
        salto = 1;
    }
}