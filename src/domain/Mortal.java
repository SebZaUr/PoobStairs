package domain;

public class Mortal extends Casillas {

    /**
     * Let me create a Mortal box.
     * 
     * @param size the table's size.
     */
    public Mortal(int size) {
        type = "Mortal";
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
    public int enCasilla(int size) throws PoobStairsExceptions {
        throw new PoobStairsExceptions(PoobStairsExceptions.MORTAL);
    }
}