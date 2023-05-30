package domain;

import java.util.Random;

public class Saltarinas extends Casillas {

    /**
     * Create a Saltarina box.
     * 
     * @param size the table's size.
     */
    public Saltarinas(int size) {
        type = "Saltarinas";
        table = (Table.getInstance(size)).getGameTable();
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
    }

    @Override
    public int enCasilla(int size) throws PoobStairsExceptions {
        Random numero = new Random();
        return numero.nextInt(6) + 1;
    }

}