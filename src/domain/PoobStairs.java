package domain;

import java.lang.reflect.InvocationTargetException;

public class PoobStairs {
    private static Dado dice;
    private static PoobStairs instance;

    private PoobStairs(String jugador1, String jugador2, String color1, String color2, int size, int porCasillas,
            int porBonificador, boolean modificar) {
        try {
            Table.getInstance(10);
            Table.createTable(porCasillas);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dice = new Dado(porBonificador);
    }

    public static PoobStairs getInstance(String jugador1, String jugador2, String color1, String color2, int size,
            int porCasillas, int porBonificador, boolean modificar) {
        if (instance == null) {
            instance = new PoobStairs(jugador1, jugador2, color1, color2, size, porCasillas, porBonificador, modificar);
        }
        return instance;
    }
}