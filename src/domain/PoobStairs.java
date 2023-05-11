package domain;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

public class PoobStairs {
    private static Dado dice;
    private static PoobStairs instance;
    private int size;
    private Player Jugador1;
    private Player Jugador2;

    /**
     * The constructor the main domain class.
     * 
     * @param jugador1       the name's player first.
     * @param jugador2       the name's player second.
     * @param color1         the piece's color of the player first.
     * @param color2         the piece's color of the player second.
     * @param size           the table's size.
     * @param porCasillas    the box special's percentage.
     * @param porBonificador the bonification's percentage.
     * @param modificar      if the snakes and laders could modify.
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
        Jugador1 = new Player(jugador1, color1, size);
        Jugador2 = new Player(jugador2, color2, size);
        Jugador1.setTurn(true);
    }

    /**
     * Let me verify if exist an instance in this class, in the case, that exists it
     * doesn't create one.
     * 
     * @param jugador1       the name's player first.
     * @param jugador2       the name's player second.
     * @param color1         the piece's color of the player first.
     * @param color2         the piece's color of the player second.
     * @param size           the table's size.
     * @param porCasillas    the box special's percentage.
     * @param porBonificador the bonification's percentage.
     * @param modificar      if the snakes and laders could modidy.
     * @return the PoobStairs instance.
     */
    public static PoobStairs getInstance(String jugador1, String jugador2, String color1, String color2, int size,
            int porCasillas, int porBonificador, boolean modificar) {
        if (instance == null) {
            instance = new PoobStairs(jugador1, jugador2, color1, color2, size, porCasillas, porBonificador, modificar);
        }
        return instance;
    }

    public int mover() {
        int value = dice.getValue();
        if (Jugador1.getTurn()) {
            movement(Jugador1, value);
            Jugador1.setTurn(false);
            Jugador2.setTurn(true);
        } else {
            movement(Jugador2, value);
            Jugador2.setTurn(false);
            Jugador1.setTurn(true);
        }
        return value;
    }

    private void movement(Player jugador, int valor) {
        int position = Jugador1.move(valor);
        Casillas casilla = Table.getInstance(size).getBox(position);
        try {
            int moveAfter = casilla.enCasilla();
            valor = jugador.move(moveAfter);
        } catch (PoobStairsExceptions e) {
            if (e.getMessage().equals(PoobStairsExceptions.SNAKE)) {
                Serpiente box = (Serpiente) casilla;
                int[] positions = box.getFinish();
                valor = jugador.move(positions[0] + positions[1] - position);
            } else if (e.getMessage().equals(PoobStairsExceptions.LADERS)) {
                Escalera box = (Escalera) casilla;
                int[] positions = box.getFinish();
                valor = jugador.move(positions[0] + positions[1] - position);
            } else if (e.getMessage().equals(PoobStairsExceptions.MORTAL)) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "MORISTE", JOptionPane.INFORMATION_MESSAGE);
                valor = jugador.move(-jugador.getPosition());
            }
        }
    }

    public Player[] getJugadores() {
        return new Player[] { Jugador1, Jugador2 };
    }

    public int[] getPositions(){
        int[] positions = {Jugador1.getPosition(),Jugador2.getPosition()};
        return positions;
    }
}