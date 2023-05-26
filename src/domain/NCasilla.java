package domain;

public class NCasilla extends Casillas {

    public NCasilla(int size, String type) {
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
        return 0;
    }
}