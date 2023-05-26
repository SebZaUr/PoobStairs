package domain;

import java.util.Random;

/**
 * Create the ladder start's box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public class Escalera extends Casillas {
    private Random numero = new Random();
    private int[][] positions = new int[2][2];
    private int finalX = 0;
    private int finalY = 0;

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Escalera(int size, int i) {
        id = i;
        type = "Escalera";
        Table.getInstance(size);
        table = Table.getGameTable();
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(size);
            int y = numero.nextInt(size);
            if (validate(type, x, size, y)) {
                if (table[x][y] == null) {
                    table[x][y] = this;
                    colocada = true;
                }
                startX = x;
                startY = y;
            }
        }
        putFinal(size);
        int[] valoresPosicion = { startX, startY };
        positions[0] = (valoresPosicion);
        int[] finales = { finalX, finalY };
        positions[1] = finales;
        Table.setFinal(positions, "Escalera");
    }

    private void putFinal(int size) {
        boolean colocada = false;
        while (!colocada) {
            int x = numero.nextInt(startX);
            int y = numero.nextInt(size);
            if (table[x][y] == null) {
                table[x][y] = this;
                colocada = true;
                finalX = x;
                finalY = y;
            }
        }
    }

    @Override
    public int enCasilla(int size) throws PoobStairsExceptions {
        int posFinal = 0;
        if (finalY % 2 == 0) {
            posFinal = (size * size) - (finalX * 10) + size - finalY;
        } else {
            posFinal = (size * size) - (finalX * 10) + finalY;
        }
        return posFinal - position;
    }
}