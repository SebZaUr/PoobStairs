package domain;

import java.util.Random;

/**
 * Let me create a box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.2
 */
public class Casillas {
    protected Casillas[][] table;
    private Random numero = new Random();
    protected static int startX, startY;
    protected int salto = 0;
    protected String type = "Casillas";

    /**
     * Let me create a box.
     * 
     * @param size the table's size.
     */
    public Casillas(int size) {
        Table.getInstance(size);
        table = Table.getGameTable();
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(size);
            int y = numero.nextInt(size);
            if (table[x][y] == null) {
                table[x][y] = this;
                colocada = true;
            }
            startX = x;
            startY = y;
        }
    }

    /**
     * Do an action when the player falls in.
     * 
     * @return the position's number that the playe has to move.
     * @throws PoobStairsExceptions If its a Mortal box.
     */
    public int enCasilla() throws PoobStairsExceptions {
        return salto;
    };

    /**
     * return the box's type.
     * 
     * @return the box's type
     */
    public String getType() {
        return type;
    }
}
