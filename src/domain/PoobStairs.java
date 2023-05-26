package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import presentation.PreguntaGUI;

public class PoobStairs {
    private int size;
    private Player Jugador1;
    private Player Jugador2;
    private boolean answer;

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
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public PoobStairs(String jugador1, String jugador2, String color1, String color2, int size, int porCasillas,
            int porBonificador, boolean modificar, String modoMaquina)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            Table.getInstance(size);
            Table.createTable(porCasillas);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.size = size;
        Jugador1 = new Player(color1, size);
        if (modoMaquina != null) {
            Jugador2 = (Player) Class.forName("domain." + modoMaquina)
                    .getConstructor(String.class, int.class).newInstance(color2, size);
        } else {
            Jugador2 = new Player(color2, size);
        }
        Jugador1.setTurn(true);
    }

    /**
     * Move the player's piece.
     * 
     * @param value the dice's value.
     */
    public void mover(int value) {
        if (Jugador1.getTurn()) {
            try {
                question(Jugador1);
            } catch (PoobStairsExceptions e) {
                if (!e.getMessage().equals(PoobStairsExceptions.WORNG_ANSWER)) {
                    movement(Jugador1, value);
                    Jugador1.setTurn(false);
                    Jugador2.setTurn(true);
                    Jugador1.setQuestion(false);
                }

            }
        } else {
            try {
                question(Jugador2);
            } catch (PoobStairsExceptions e) {
                if (!e.getMessage().equals(PoobStairsExceptions.WORNG_ANSWER)) {
                    movement(Jugador2, value);
                    Jugador2.setTurn(false);
                    Jugador1.setTurn(true);
                    Jugador2.setQuestion(false);
                }

            }

        }
    }

    /**
     * Move the player's piece.
     * 
     * @param jugador the player on turn.
     * @param valor   the dice's value.
     */
    private void movement(Player jugador, int valor) {
        if (jugador.getPosition() + valor > 0 && jugador.getPosition() + valor < size * size) {
            int position = jugador.move(valor, size);
            Casillas casilla = Table.getInstance(size).getBox(position);
            try {
                int moveAfter = casilla.enCasilla(size);
                valor = jugador.move(moveAfter, size);
            } catch (PoobStairsExceptions e) {
                if (e.getMessage().equals(PoobStairsExceptions.MORTAL)) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "MORISTE", JOptionPane.INFORMATION_MESSAGE);
                    valor = jugador.move(-jugador.getPosition(), size);
                } else if (e.getMessage().equals(PoobStairsExceptions.PREGUNTA)) {
                    jugador.setQuestion(true);
                }
            }
        }

    }

    /**
     * Return the players that play.
     */
    public Player[] getJugadores() {
        return new Player[] { Jugador1, Jugador2 };
    }

    /**
     * Get the positions of both players.
     * 
     * @return
     */
    public int[] getPositions() {
        int[] positions = { Jugador1.getPosition(), Jugador2.getPosition() };
        return positions;
    }

    /**
     * Can save the actual state of the game.
     * 
     * @param nombre             the file that if save.
     * @param jugador1           the player 1 information.
     * @param jugador2           the player 2 information.
     * @param casillasEspeciales the specials boxs's percentage.
     * @param bonificador        the percentage of modifiers.
     * @param size               the table's size.
     * @param posEscaleras       A list of staircase ends
     * @param posSerpientes      A list of snake ends
     * @throws FileNotFoundException if the file not exit.
     */
    public void save(File nombre, String jugador1, String jugador2, String casillasEspeciales, String bonificador,
            String size, ArrayList<int[][]> posEscaleras, ArrayList<int[][]> posSerpientes, String modoMaquina,
            boolean modificar)
            throws FileNotFoundException {
        PrintWriter archivo = new PrintWriter(new FileOutputStream(nombre.getName() + ".txt"));
        archivo.println(jugador1);
        archivo.println(jugador2);
        if (Jugador1.getTurn()) {
            archivo.println("Jugador 1");
        } else {
            archivo.println("Jugador 2");
        }
        if (modoMaquina != null) {
            archivo.println(casillasEspeciales + "," + bonificador + "," + size + "," + modificar + "," + modoMaquina);
        } else {
            archivo.println(casillasEspeciales + "," + bonificador + "," + size + "," + modificar);
        }
        String[] tablero = copyTable();
        archivo.println("Escaleras: ");
        for (int i = 0; i < 5; i++) {
            String posicion = Integer.toString(posEscaleras.get(i)[0][0]) + "-"
                    + Integer.toString(posEscaleras.get(i)[0][1]) + "-" + Integer.toString(posEscaleras.get(i)[1][0])
                    + "-" + Integer.toString(posEscaleras.get(i)[1][1]);
            archivo.println(posicion);
        }
        archivo.println("Serpientes: ");
        for (int i = 0; i < 5; i++) {
            String posicion = Integer.toString(posSerpientes.get(i)[0][0]) + "-"
                    + Integer.toString(posSerpientes.get(i)[0][1]) + "-" + Integer.toString(posSerpientes.get(i)[1][0])
                    + "-" + Integer.toString(posSerpientes.get(i)[1][1]);
            archivo.println(posicion);
        }
        archivo.println("Tablero: ");
        for (String i : tablero) {
            archivo.println(i);
        }
        archivo.close();
    }

    /**
     * Open a file that save an instance of a game.
     * 
     * @param nombre the file that has the game saved.
     * @throws IOException
     */
    public ArrayList<String[]> open(String nombre) throws IOException {
        BufferedReader archivo = new BufferedReader(new FileReader(nombre));
        ArrayList<String[]> informacion = new ArrayList<>();
        String escribir = archivo.readLine();
        while (escribir != null) {
            informacion.add(escribir.trim().split(","));
            escribir = archivo.readLine();
        }
        archivo.close();
        return informacion;
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

    /**
     * Do the action if the player fall in a Preguntona box.
     * 
     * @param jugador
     * @throws PoobStairsExceptions
     */
    private void question(Player jugador) throws PoobStairsExceptions {
        if (jugador.hasQuestion()) {
            Pregunta question = Preguntona.getPregunta();
            PreguntaGUI pregunta = new PreguntaGUI(question);
            pregunta.setVisible(true);
            if (answer) {
                throw new PoobStairsExceptions(PoobStairsExceptions.CORRECT_ANSWER);
            } else {
                throw new PoobStairsExceptions(PoobStairsExceptions.WORNG_ANSWER);
            }
        } else {
            throw new PoobStairsExceptions(PoobStairsExceptions.NOT_QUESTION);
        }

    }

    /**
     * Assign if the question is answered correct or wrong.
     * 
     * @param answer if question's answer.
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    /*
     * public void change(ArrayList<String[]> tablero,ArrayList<String[]>
     * escaleras,ArrayList<String[]> serpientes){
     * for(int i=0;i<5;i++) {
     * EscaleraFinal escFinal = new EscaleraFinal() {}
     * }
     * }
     */
}