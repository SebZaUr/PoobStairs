package domain;

import java.util.Random;

public class Escalera extends Casillas {
    private static int finalX;
    private static int finalY;
    private Random numero = new Random();

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Escalera(int size, int i) {
        super(size, "Escalera");
        putFinal(size);
        id = i;
        type = "Escalera";
    }

    /**
     * Assign the square where the piece goes up when taking a straight.
     * 
     * @param size the game table's size.
     */
    public void putFinal(int size) {
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(startX);
            int y = numero.nextInt(size);
            if (table[x][y] == null) {
                table[x][y] = this;
                colocada = true;
                finalX = x;
                finalY = y;
                int[][] finals = { { finalX, finalY }, { startX, startY } };
                Table.setFinal(finals, "Escalera");
            }
        }
    }

    /**
     * Returns the position of the end of the stair.
     * 
     * @return An int array with the coordinates of the end of the stairs.
     */
    public int[] getFinish() {
        return new int[] { finalX, finalY };
    }

    @Override
    public int enCasilla() throws PoobStairsExceptions {
        throw new PoobStairsExceptions(PoobStairsExceptions.LADERS);
    }

    public int getId() {
        return id;
    }
}