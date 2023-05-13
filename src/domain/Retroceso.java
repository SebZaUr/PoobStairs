package domain;

/**
 * Create a box that if the player falls in goes back one box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.0
 */
public class Retroceso extends Casillas {

    /**
     * Create a Retroceso box.
     * 
     * @param size the table's size.
     */
    public Retroceso(int size) {
        super(size, "Retroceso");
        type = "Retroceso";
    }
}