package domain;

import java.util.Random;

/**
 * Let me create a box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public abstract class Casillas {
    protected Casillas[][] table;
    protected Random numero = new Random();
    protected static int startX, startY;
    protected int id;
    protected int salto = 0;
    protected String type = "NCasilla";
    protected int position;

    /**
     * Do an action when the player falls in.
     * 
     * @return the position's number that the playe has to move.
     * @throws PoobStairsExceptions If its a Mortal,Ladder or Snake box.
     */
    public abstract int enCasilla(int size) throws PoobStairsExceptions;

    /**
     * return the box's type.
     * 
     * @return the box's type
     */
    public String getType() {
        return type;
    }

    /**
     * Verify if in that position could create this box's type.
     * 
     * @param type the box's type.
     * @param x    the x's coorden
     * @param size the table's size.
     * @param y    the y's coorden.
     * @return if can create the box or not.
     */
    protected boolean validate(String type, int x, int size, int y) {
        boolean couldCreate = true;
        if (type.equals("Serpientes") && x == size - 1) {
            couldCreate = false;
        }
        if (type.equals("Escalera") && x == 0) {
            couldCreate = false;
        }
        if (type.equals("Mortal") && x == size - 1 && y == 0 && size % 2 == 0) {
            couldCreate = false;
        } else if (type.equals("Mortal") && x == size - 1 && y == size - 1 && size % 2 != 0) {
            couldCreate = false;
        }
        if (x == 0 && y == 0) {
            if (!(type.equals("NCasilla") || type.equals("Escalera"))) {
                couldCreate = false;
            }
        }
        return couldCreate;
    }

    /**
     * Assign the table's position.
     * 
     * @param value the position.
     */
    public void setPosition(int value) {
        position = value;
    }

    /**
     * return the box's position.
     * 
     * @return the position.
     */
    public int getPosition() {
        return position;
    }
}
