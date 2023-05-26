package domain;

import java.util.Random;

public class Serpiente extends Casillas {
    private static int startX;
    private Random numero = new Random();
    protected String place;
    private int[][] positions = new int[2][2];
    private int finalX = 0;
    private int finalY = 0;

    /**
     * Create a stair that let it up to a position more advanced.
     * 
     * @param size the table's size.
     */
    public Serpiente(int size, int id) {
        type = "Serpiente";
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
        this.id = id;
        putFinal(size);
        int[] valoresPosicion = { startX, startY };
        positions[0] = (valoresPosicion);
        int[] finales = { finalX, finalY };
        positions[1] = finales;
        Table.setFinal(positions, "Serpientes");
    }

    private void putFinal(int size) {
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

    @Override
    public int enCasilla(int size) throws PoobStairsExceptions {
        int posFinal = 0;
        if (finalY % 2 == 0) {
            posFinal = (size * size) - (finalX * 10) + size - finalY;
        } else {
            posFinal = (size * size) - (finalX * 10) + finalY;
        }
        ;
        return position - posFinal;
    }

    public int getId() {
        return id;
    }
}