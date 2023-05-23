package domain;

import java.util.Random;

public class Serpiente extends Casillas {
    private static int startX;
    private static int finalX;
    private static int finalY;
    private Random numero = new Random();
    protected String place;

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Serpiente(int size, int id) {
        super(size, "Serpiente");
        this.id = id;
        type = "Serpiente";
    }

    /**
     * Assign the square where the piece goes up when taking a straight.
     * 
     * @param size the game table's size.
     */
    public void putFinal(int size) {
        boolean colocada = false;
        int x, y;
        while (!colocada) {
            if (startX == 0) {
                x = numero.nextInt(size - 1) + 1;
            } else {
                x = numero.nextInt(startX);
            }
            y = numero.nextInt(size);
            if (table[x][y] == null) {
                table[x][y] = this;
                colocada = true;
                finalX = x;
                finalY = y;
                int[][] finals = { { finalX, finalY }, { startX, startY } };
                Table.setFinal(finals, "Serpiente");
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

    public int getId() {
        return id;
    }
}