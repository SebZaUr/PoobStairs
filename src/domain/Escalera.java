package domain;

import java.util.Random;

public class Escalera extends Casillas {
    private static int startX;
    private static int finalX;
    private static int finalY;
    private Random numero = new Random();

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Escalera(int size) {
        super(size);
        putFinal(size);
        type = "Escalera";
    }

    /**
     * Assign the square where the piece goes up when taking a straight.
     * 
     * @param size the game table's size.
     */
    public void putFinal(int size) {
        int borde = size - startX;
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(borde) + startX + 1;
            int y = numero.nextInt(size);
            if (x < size) {
                if (table[x][y] == null) {
                    table[x][y] = this;
                    colocada = true;
                    finalX = x;
                    finalY = y;
                }
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
        throw new PoobStairsExceptions(PoobStairsExceptions.SNAKE);
    }
}