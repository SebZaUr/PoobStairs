package domain;

/**
 * Create a box that if the player falls in goes back one box.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 2.0
 */
public class Retroceso extends Casillas {
    private int size;

    /**
     * Create a Retroceso box.
     * 
     * @param size the table's size.
     */
    public Retroceso(int size) {
        type = "Retroceso";
        this.size = size;
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
    }

    @Override
    public int enCasilla(int c) throws PoobStairsExceptions {
        boolean found = false;
        for (int i = position; i >= 0; i--) {
            if (Table.getInstance(size).getBox(i).getType().equals("Serpiente")) {
                found = true;
                salto = i;
                break;
            }
        }
        if (!found) {
            throw new PoobStairsExceptions(PoobStairsExceptions.NOT_FOUND_SNAKE);
        }
        return salto;
    }
}