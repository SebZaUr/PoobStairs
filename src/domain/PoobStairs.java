package domain;

import java.lang.reflect.InvocationTargetException;

public class PoobStairs {
    private static Dado dice;
    private static PoobStairs instance;

    /**
     * The constructor the main domain class.
     * @param jugador1  the name's player first.
     * @param jugador2  the name's player second.
     * @param color1    the piece's color of the player first.
     * @param color2    the piece's color of the player second.
     * @param size  the table's size.
     * @param porCasillas   the box special's percentage.
     * @param porBonificador    the bonification's percentage.
     * @param modificar if the snakes and laders could modify.
     */
    private PoobStairs(String jugador1, String jugador2, String color1, String color2, int size, int porCasillas,
            int porBonificador, boolean modificar) {
        try {
            Table.getInstance(size);
            Table.createTable(porCasillas);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dice = Dado.getInstance(porBonificador);
    }

    /**
     * Let me verify if exist an instance in this class, in the case, that exists it doesn't create one.
     * @param jugador1  the name's player first.
     * @param jugador2  the name's player second.
     * @param color1    the piece's color of the player first.
     * @param color2    the piece's color of the player second.
     * @param size  the table's size.
     * @param porCasillas   the box special's percentage.
     * @param porBonificador    the bonification's percentage.
     * @param modificar if the snakes and laders could modidy.
     * @return  the PoobStairs instance.
     */
    public static PoobStairs getInstance(String jugador1, String jugador2, String color1, String color2, int size,
            int porCasillas, int porBonificador, boolean modificar) {
        if (instance == null) {
            instance = new PoobStairs(jugador1, jugador2, color1, color2, size, porCasillas, porBonificador, modificar);
        }
        return instance;
    }
}