package domain;

import java.util.Random;

public class Serpiente extends Casillas {
    private static int startX;
    private static int finalX;
    private static int finalY;
    private Random numero = new Random();

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Serpiente(int size) {
        super(size);
        putFinal(size);
        type = "Serpiente";
    }

    /**
     * Assign the square where the piece goes up when taking a straight.
     * 
     * @param size the game table's size.
     */
    public void putFinal(int size) {
        boolean colocada = false;
        int x,y;
        while (!colocada) {
            if(startX == 0){
                x =  numero.nextInt(size)+1;
            }else{
                x = numero.nextInt(startX)+1;
            }
            y = numero.nextInt(size);
            if(x < size){
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