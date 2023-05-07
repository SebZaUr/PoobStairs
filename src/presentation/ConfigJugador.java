package presentation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import domain.PoobStairsExceptions;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Let me type the player's name and select all the different characteristics of
 * the game.
 * 
 * @author Sebastian Zamora Urrego.
 * @author Johann Amaya Lopez.
 * @version 1.3
 */
public class ConfigJugador extends JDialog {

    private final JButton jugar = new JButton("Empezar a Jugar");
    private JTextField nombreJugador1, nombreJugador2, porcentajeCasillas, porcentajeModificadores, sizeTablero;
    private JRadioButton Rojo1, Negro1, Azul1, Amarillo1, Verde1, Blanco1, Rojo2, Negro2, Azul2, Amarillo2, Verde2,
            Blanco2, cambioT, cambioF;
    private ButtonGroup coloresJ1, coloresJ2, cambio;
    private String modoMaquina, color, color2;
    private final int width = Estilos.dimensions.width / 2;
    private final int heigth = Estilos.dimensions.height / 2;
    private static int porCasillas, porBonificacion;
    private static int size = 10;
    private static boolean cambioES = false;

    /**
     * Constructor de la pantalla de configuracion.
     */
    public ConfigJugador() {
        setIconImage(Estilos.icono.getImage());
        setTitle(Estilos.TITULO);
        setSize(width, heigth);
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Me preparea los elementos de la pantalla de configuracion
     */
    public void prepareElements() {
        JPanel pantallaCarga = new JPanel();

        JPanel Configuracion = new JPanel();
        Configuracion.setLayout(null);
        Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Configuracion")));

        JPanel nombres = new JPanel();
        nombres.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Ingresen Datos")));
        nombres.setLayout(null);
        JLabel jugador = new JLabel("Ingrese Su Nombre Jugador 1:");
        jugador.setBounds(10, 20, 200, 20);
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(width / 4, 30, 100, 20);
        JLabel jugador2 = new JLabel("Ingrese Su Nombre Jugador 2:");
        jugador2.setBounds(10, 60, 200, 20);
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(width / 4, 70, 100, 20);
        nombres.add(jugador);
        nombres.add(jugador2);
        nombres.add(nombreJugador1);
        nombres.add(nombreJugador2);

        JLabel colorJ1 = new JLabel("Color jugador 1:");
        JLabel colorJ2 = new JLabel("Color jugador 2:");
        JPanel color1 = new JPanel();
        JPanel color2 = new JPanel();
        coloresJ1 = new ButtonGroup();
        coloresJ2 = new ButtonGroup();
        colorJ1.setBounds(10, 100, 100, 20);
        colorJ2.setBounds(width / 4, 100, 100, 20);
        Rojo1 = new JRadioButton("Rojo");
        Rojo1.setBounds(10, 150, 60, 30);
        coloresJ1.add(Rojo1);
        Blanco1 = new JRadioButton("Blanco");
        Blanco1.setBounds(10, 180, 60, 30);
        coloresJ1.add(Blanco1);
        Negro1 = new JRadioButton("Negro");
        Negro1.setBounds(10, 210, 60, 30);
        coloresJ1.add(Negro1);
        Verde1 = new JRadioButton("Verde");
        Verde1.setBounds(10, 240, 60, 30);
        coloresJ1.add(Verde1);
        Amarillo1 = new JRadioButton("Amarillo");
        Amarillo1.setBounds(10, 270, 60, 30);
        coloresJ1.add(Amarillo1);
        Azul1 = new JRadioButton("Azul");
        Azul1.setBounds(10, 300, 60, 30);
        coloresJ1.add(Azul1);
        Rojo2 = new JRadioButton("Rojo");
        Rojo2.setBounds(width / 4, 150, 60, 30);
        coloresJ2.add(Rojo2);
        Blanco2 = new JRadioButton("Blanco");
        Blanco2.setBounds(width / 4, 180, 60, 30);
        coloresJ2.add(Blanco2);
        Negro2 = new JRadioButton("Negro");
        Negro2.setBounds(width / 4, 210, 60, 30);
        coloresJ2.add(Negro2);
        Verde2 = new JRadioButton("Verde");
        Verde2.setBounds(width / 4, 240, 60, 30);
        coloresJ2.add(Verde2);
        Amarillo2 = new JRadioButton("Amarillo");
        Amarillo2.setBounds(width / 4, 270, 60, 30);
        coloresJ2.add(Amarillo2);
        Azul2 = new JRadioButton("Azul");
        Azul2.setBounds(width / 4, 300, 60, 30);
        coloresJ2.add(Azul2);
        color1.setBounds(width / 4 - 100, heigth - 100, 50, 50);
        color2.setBounds(width / 4 + 100, heigth - 100, 50, 50);
        color1.setBackground(Color.black);
        color2.setBackground(Color.black);

        nombres.add(Rojo1);
        nombres.add(Rojo2);
        nombres.add(Verde1);
        nombres.add(Verde2);
        nombres.add(Negro1);
        nombres.add(Negro2);
        nombres.add(Amarillo1);
        nombres.add(Amarillo2);
        nombres.add(Blanco1);
        nombres.add(Blanco2);
        nombres.add(Azul1);
        nombres.add(Azul2);
        nombres.add(colorJ1);
        nombres.add(colorJ2);
        nombres.add(color1);
        nombres.add(color2);

        jugar.setBounds(width / 4 - 100, heigth - 100, 200, 50);

        JLabel numCasillas = new JLabel("Ingrese el porcentaje de casillas especiales");
        numCasillas.setBounds(50, 20, 250, 20);
        porcentajeCasillas = new JTextField();
        porcentajeCasillas.setBounds(width / 4 + 100, 20, 50, 20);
        JLabel numBonificadores = new JLabel("Ingrese el porcentaje de bonificadores");
        numBonificadores.setBounds(50, 100, 250, 20);
        porcentajeModificadores = new JTextField();
        porcentajeModificadores.setBounds(width / 4 + 100, 100, 50, 20);
        JLabel size = new JLabel("Ingrese el tamaño del tablero");
        size.setBounds(50, 150, 200, 20);
        sizeTablero = new JTextField();
        sizeTablero.setBounds(width / 4 + 100, 150, 50, 20);
        JLabel cambioEsSer = new JLabel("¿Quiere que las escaleras y serpientes puedan cambiar?");
        cambioEsSer.setBounds(50, 200, 350, 20);
        cambio = new ButtonGroup();
        cambioT = new JRadioButton("Si");
        cambioT.setBounds(width / 4 - 100, 250, 40, 20);
        cambioF = new JRadioButton("No");
        cambioF.setBounds(width / 4 + 100, 250, 40, 20);
        cambio.add(cambioF);
        cambio.add(cambioT);

        Configuracion.add(numCasillas);
        Configuracion.add(numBonificadores);
        Configuracion.add(porcentajeCasillas);
        Configuracion.add(porcentajeModificadores);
        Configuracion.add(cambioT);
        Configuracion.add(cambioF);
        Configuracion.add(cambioEsSer);
        Configuracion.add(jugar);

        pantallaCarga.setLayout(new GridLayout(1, 2));
        pantallaCarga.add(nombres);
        pantallaCarga.add(Configuracion);

        add(pantallaCarga);
    }

    /**
     * Prepare all the button's actions
     */
    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.addWindowListener(Cerrar);
        Rojo1.addActionListener(e -> checkBox());
        Azul1.addActionListener(e -> checkBox());
        Negro1.addActionListener(e -> checkBox());
        Amarillo1.addActionListener(e -> checkBox());
        Blanco1.addActionListener(e -> checkBox());
        Verde1.addActionListener(e -> checkBox());
        Rojo2.addActionListener(e -> checkBox());
        Azul2.addActionListener(e -> checkBox());
        Negro2.addActionListener(e -> checkBox());
        Amarillo2.addActionListener(e -> checkBox());
        Blanco2.addActionListener(e -> checkBox());
        Verde2.addActionListener(e -> checkBox());
        jugar.addActionListener(e -> {
            try {
                empezarJuego();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Verify which of the JRadiumButtons are selected and save its message.
     */
    private void checkBox() {
        if (Azul1.isSelected()) {
            color = "blue";
        }
        if (Blanco1.isSelected()) {
            color = "white";
        }
        if (Amarillo1.isSelected()) {
            color = "yellow";
        }
        if (Verde1.isSelected()) {
            color = "green";
        }
        if (Negro1.isSelected()) {
            color = "black";
        }
        if (Rojo1.isSelected()) {
            color = "red";
        }
        if (Azul2.isSelected()) {
            color2 = "blue";
        }
        if (Blanco2.isSelected()) {
            color2 = "white";
        }
        if (Amarillo2.isSelected()) {
            color2 = "yellow";
        }
        if (Verde2.isSelected()) {
            color2 = "green";
        }
        if (Negro2.isSelected()) {
            color2 = "black";
        }
        if (Rojo2.isSelected()) {
            color2 = "red";
        }
        if (cambioT.isSelected()) {
            cambioES = true;
        } else if (cambioF.isSelected()) {
            cambioES = false;
        }
    }

    /**
     * Let me verify if the user bring the less parameters to start the game.
     * 
     * @throws PoobStairsExceptions If the user put a bad number or doesn't put all
     *                              not filled in the necessary fields.
     */
    private void empezarJuego() throws PoobStairsExceptions {
        if (!nombreJugador1.getText().isEmpty() && !nombreJugador2.getText().isEmpty() && color != null
                && color2 != null) {
            try {
                String nombre = nombreJugador1.getText();
                String nombre2 = nombreJugador2.getText();
                validateInputs();
                TableGUI tablero = new TableGUI(nombre, nombre2, porCasillas, porBonificacion, size, cambioES, color,
                        color2);
                tablero.setVisible(true);
                this.dispose();
            } catch (NumberFormatException e) {
                throw new PoobStairsExceptions(PoobStairsExceptions.BAD_PERCENTAGE);
            }
        } else if (nombreJugador1.getText().isEmpty() || color == null || modoMaquina == null
                || nombreJugador2.getText().isEmpty() || color2 == null) {
            throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
        }
    }

    /**
     * Validate the Inputs that its not necesary.
     * 
     * @throws PoobStairsExceptions if the players choose the same colors.
     * @throws NumberFormatExcetion if the numbers that type the players are wrong.
     */
    private void validateInputs() throws PoobStairsExceptions, NumberFormatException {
        if (color == color2) {
            throw new PoobStairsExceptions(PoobStairsExceptions.SAME_COLOR);
        }
        if (porcentajeCasillas.getText().isEmpty()) {
            porCasillas = 0;
        } else {
            porCasillas = Integer.parseInt(porcentajeCasillas.getText());
        }
        if (porcentajeModificadores.getText().isEmpty()) {
            porBonificacion = 0;
        } else {
            porBonificacion = Integer.parseInt(porcentajeCasillas.getText());
        }
        if (!sizeTablero.getText().isEmpty()) {
            size = Integer.parseInt(porcentajeCasillas.getText());
        }
    }
}
