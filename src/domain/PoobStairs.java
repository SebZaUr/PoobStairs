package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PoobStairs {
    private static Dado dice;
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
    public PoobStairs(String jugador1, String jugador2, String color1, String color2, int size, int porCasillas,
            int porBonificador, boolean modificar) {
        try {
            Table.getInstance(size);
            Table.createTable(porCasillas);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.size = size;
        dice = Dado.getInstance(porBonificador);
        Jugador1 = new Player(jugador1, color1, size);
        Jugador2 = new Player(jugador2, color2, size);
        Jugador1.setTurn(true);
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
                jugador.fallsSnakes();
            } else if (e.getMessage().equals(PoobStairsExceptions.LADERS)) {
                Escalera box = (Escalera) casilla;
                int[] positions = box.getFinish();
                valor = jugador.move(positions[0] + positions[1] - position);
                jugador.fallsLadders();
            } else if (e.getMessage().equals(PoobStairsExceptions.MORTAL)) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "MORISTE", JOptionPane.INFORMATION_MESSAGE);
                valor = jugador.move(-jugador.getPosition());
            }
        }
    }

    public Player[] getJugadores() {
        return new Player[] { Jugador1, Jugador2 };
    }

    public int[] getPositions() {
        int[] positions = { Jugador1.getPosition(), Jugador2.getPosition() };
        return positions;
    }

    public void save(File nombre, String jugador1, String jugador2, String casillasEspeciales, String bonificador,
            String size, ArrayList<int[][]> posEscaleras, ArrayList<int[][]> posSerpientes)
            throws FileNotFoundException {
        PrintWriter archivo = new PrintWriter(new FileOutputStream(nombre.getName() + ".txt"));
        archivo.println(jugador1);
        archivo.println(jugador2);
        archivo.println("Jugador en turno:");
        if (Jugador1.getTurn()) {
            archivo.println("Jugador 1");
        } else {
            archivo.println("Jugador 2");
        }
        archivo.println(casillasEspeciales + "," + bonificador + "," + size);
        String[] tablero = copyTable();
        archivo.println("Escaleras: ");
        for (int i = 0; i < 5; i++) {
            String posicion = "{" + Integer.toString(posEscaleras.get(i)[1][0]) + "-"
                    + Integer.toString(posEscaleras.get(i)[1][1]) + "-" + Integer.toString(posEscaleras.get(i)[0][1])
                    + "-" + Integer.toString(posEscaleras.get(i)[0][1]);
            archivo.println(posicion);
        }
        archivo.println("Serpientes: ");
        for (int i = 0; i < 5; i++) {
            String posicion = "{" + Integer.toString(posSerpientes.get(i)[1][0]) + "-"
                    + Integer.toString(posSerpientes.get(i)[1][1]) + "-" + Integer.toString(posSerpientes.get(i)[0][1])
                    + "-" + Integer.toString(posSerpientes.get(i)[0][1]);
            archivo.println(posicion);
        }
        archivo.println("Tablero: ");
        for (String i : tablero) {
            archivo.println(i);
        }
        archivo.close();
    }

    public void open(File nombre) {

    }

    private String[] copyTable() {
        String[] tablero = new String[size];
        Table.getInstance(size);
        Casillas[][] instancia = Table.getGameTable();
        for (int i = 0; i < size; i++) {
            String copia = instancia[i][0].getType();
            for (int j = 1; j < size; j++) {
                copia = copia + "," + instancia[i][j].getType();
                ;
            }
            tablero[i] = copia;
        }
        return tablero;
    }
}