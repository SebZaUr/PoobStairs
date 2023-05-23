package presentation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import domain.PoobStairsExceptions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Let me type my name and select all the different characteristics of the game.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.7
 *
 */
public class ConfigMaquina extends JDialog {
    private JTextField nombreJugador1, porcentajeCasillas, porcentajeModificadores, sizeTablero;
    private JRadioButton Rojo1, Negro1, Azul1, Amarillo1, Verde1, Blanco1, cambioT, cambioF, principiante, aprendiz;
    private ButtonGroup coloresJ1, cambio, maquina;
    private JPanel panel_5, panel_31, panel_3, panel_21, panel, panel_1, Configuracion, panel_4_1, panel_4, panel_2,
            pantallaCarga, ingresarNombre;
    private JLabel lblNewLabel, jugador, cambioEsSer, numBonificadores_1, numBonificadores, numCasillas;
    private final int width = Estilos.dimensions.width / 2;
    private final int heigth = Estilos.dimensions.height / 2;
    private ImageIcon imagenRojo, imagenNegro, imagenBlanco, imagenVerde, imagenAzul, imagenAmarillo;

    private final JButton jugar = new JButton("Empezar a Jugar");
    private String modoMaquina, color, color2;
    private boolean cambioES = false;

    public ConfigMaquina() {
        setIconImage(Estilos.icono.getImage());
        setTitle(Estilos.TITULO);
        setSize(width, heigth);
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Create all visuas elements
     */
    public void prepareElements() {

        pantallaCarga = Estilos.GradientPanel();
        pantallaCarga.setOpaque(false);
        pantallaCarga.setLayout(null);

        ingresarNombre = new JPanel();
        ingresarNombre.setLayout(null);
        ingresarNombre.setOpaque(false);

        // Crear el borde con el nuevo estilo y color
        TitledBorder borde_2 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE), "Ingresen Datos",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
        ingresarNombre.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_2));
        ingresarNombre.setLayout(new GridLayout(0, 1, 40, 0));

        panel = new JPanel();
        panel.setOpaque(false);
        ingresarNombre.add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jugador = new JLabel("  Nombre");
        jugador.setFont(Estilos.FUENTE_LETRA_MENOR);
        jugador.setForeground(Estilos.COLOR_LETRAS);

        panel_1.add(jugador);

        nombreJugador1 = new JTextField();
        nombreJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJugador1.setPreferredSize(new Dimension(175, 50));
        panel_1.add(nombreJugador1);

        panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel.add(panel_2);
        // Crear el borde con el nuevo estilo y color
        TitledBorder borde_3 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE), "Color",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                Estilos.FUENTE_LETRA, Estilos.COLOR_LETRAS);
        panel_2.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_3));
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        panel_5 = new JPanel();
        panel_5.setOpaque(false);
        panel_2.add(panel_5);

        Azul1 = new JRadioButton("Azul");
        Azul1.setForeground(Estilos.COLOR_LETRAS);
        Azul1.setOpaque(false);
        panel_5.add(Azul1);

        Rojo1 = new JRadioButton("Rojo");
        Rojo1.setForeground(Estilos.COLOR_LETRAS);
        Rojo1.setOpaque(false);
        panel_5.add(Rojo1);

        Negro1 = new JRadioButton("Negro");
        Negro1.setForeground(Estilos.COLOR_LETRAS);
        Negro1.setOpaque(false);
        panel_5.add(Negro1);

        Blanco1 = new JRadioButton("Blanco");
        Blanco1.setForeground(Estilos.COLOR_LETRAS);
        Blanco1.setOpaque(false);
        panel_5.add(Blanco1);

        Verde1 = new JRadioButton("Verde");
        Verde1.setForeground(Estilos.COLOR_LETRAS);
        Verde1.setOpaque(false);
        panel_5.add(Verde1);

        Amarillo1 = new JRadioButton("Amarillo");
        Amarillo1.setForeground(Estilos.COLOR_LETRAS);
        Amarillo1.setOpaque(false);
        panel_5.add(Amarillo1);

        imagenRojo = new ImageIcon("resourses\\Red.png");
        imagenNegro = new ImageIcon("resourses\\Black.png");
        imagenBlanco = new ImageIcon("resourses\\White.png");
        imagenVerde = new ImageIcon("resourses\\Green.png");
        imagenAzul = new ImageIcon("resourses\\Blue.png");
        imagenAmarillo = new ImageIcon("resourses\\Yellow.png");

        lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setPreferredSize(new Dimension(100, 10));

        panel.add(lblNewLabel);

        coloresJ1 = new ButtonGroup();
        coloresJ1.add(Verde1);
        coloresJ1.add(Azul1);
        coloresJ1.add(Rojo1);
        coloresJ1.add(Amarillo1);
        coloresJ1.add(Negro1);
        coloresJ1.add(Blanco1);

        panel_31 = new JPanel();
        panel.add(panel_31);
        panel_31.setOpaque(false);
        panel_31.setLayout(new GridLayout(1, 0, 0, 0));

        // Crear el borde con el nuevo estilo y color
        TitledBorder borde_4 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK), "Dificultad",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                Estilos.FUENTE_LETRA, Estilos.COLOR_LETRAS);
        panel_31.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_4));

        maquina = new ButtonGroup();

        aprendiz = new JRadioButton("Aprendiz");
        aprendiz.setFont(Estilos.FUENTE_LETRA_MENOR);
        aprendiz.setOpaque(false);
        panel_31.add(aprendiz);

        principiante = new JRadioButton("Principiante");
        principiante.setFont(Estilos.FUENTE_LETRA_MENOR);
        principiante.setOpaque(false);
        panel_31.add(principiante);

        maquina.add(aprendiz);
        maquina.add(principiante);

        Configuracion = new JPanel();
        Configuracion.setLayout(null);
        Configuracion.setOpaque(false);
        // Crear el borde con el nuevo estilo y color
        TitledBorder borde_1 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE), "Configuracion",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
        Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_1));
        cambio = new ButtonGroup();

        Configuracion.setLayout(new GridLayout(0, 1, 0, 0));
        panel_21 = new JPanel();
        panel_21.setOpaque(false);
        Configuracion.add(panel_21);
        panel_21.setLayout(new GridLayout(0, 2, 0, 20));

        numCasillas = new JLabel(" Porcentaje Casillas Especiales");
        numCasillas.setFont(Estilos.FUENTE_LETRA_MENOR_2);
        numCasillas.setForeground(Estilos.COLOR_LETRAS);
        panel_21.add(numCasillas);
        porcentajeCasillas = new JTextField();
        porcentajeCasillas.setHorizontalAlignment(SwingConstants.CENTER);
        porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
        panel_21.add(porcentajeCasillas);

        numBonificadores = new JLabel(" Porcentaje Bonificadores");
        numBonificadores.setFont(Estilos.FUENTE_LETRA_MENOR_1);
        numBonificadores.setForeground(Estilos.COLOR_LETRAS);
        panel_21.add(numBonificadores);
        porcentajeModificadores = new JTextField();
        porcentajeModificadores.setHorizontalAlignment(SwingConstants.CENTER);
        porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
        panel_21.add(porcentajeModificadores);

        numBonificadores_1 = new JLabel(" Tamaño Tablero");
        numBonificadores_1.setFont(Estilos.FUENTE_LETRA_MENOR);
        numBonificadores_1.setForeground(Estilos.COLOR_LETRAS);
        panel_21.add(numBonificadores_1);
        sizeTablero = new JTextField();
        sizeTablero.setHorizontalAlignment(SwingConstants.CENTER);
        porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
        panel_21.add(sizeTablero);

        panel_3 = new JPanel();
        panel_3.setOpaque(false);
        Configuracion.add(panel_3);

        pantallaCarga.setLayout(new GridLayout(1, 2));
        pantallaCarga.add(ingresarNombre);
        pantallaCarga.add(Configuracion);

        getContentPane().add(pantallaCarga);
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
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));

        panel_4 = new JPanel();
        panel_4.setOpaque(false);
        panel_3.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 1, 0, 0));
        cambioEsSer = new JLabel("¿Quiere que las escaleras y serpientes puedan cambiar?");
        cambioEsSer.setHorizontalAlignment(SwingConstants.CENTER);
        cambioEsSer.setFont(Estilos.FUENTE_LETRA_MENOR_1);
        panel_4.add(cambioEsSer);

        panel_4_1 = new JPanel();
        panel_4_1.setOpaque(false);
        panel_4.add(panel_4_1);
        cambioT = new JRadioButton("Si");
        cambioT.setFont(Estilos.FUENTE_LETRA_MENOR);
        cambioT.setOpaque(false);
        panel_4_1.add(cambioT);
        cambio.add(cambioT);
        cambioF = new JRadioButton("No");
        cambioF.setFont(Estilos.FUENTE_LETRA_MENOR);
        cambioF.setOpaque(false);
        panel_4_1.add(cambioF);
        cambio.add(cambioF);

        Amarillo1.addActionListener(e -> checkBox());
        Azul1.addActionListener(e -> checkBox());
        Blanco1.addActionListener(e -> checkBox());
        Negro1.addActionListener(e -> checkBox());
        Rojo1.addActionListener(e -> checkBox());
        Verde1.addActionListener(e -> checkBox());

        panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel_3.add(panel_2);
        jugar.setFont(Estilos.FUENTE_LETRA);
        jugar.setBackground(Color.WHITE);
        panel_2.add(jugar);
        jugar.addActionListener(e -> {
            try {
                empezarJuego();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
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
        if (principiante.isSelected()) {
            modoMaquina = "principiante";
        } else if (aprendiz.isSelected()) {
            modoMaquina = "aprendiz";
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
        if (!nombreJugador1.getText().isEmpty() && color != null && modoMaquina != null) {
            try {
                String nombre = nombreJugador1.getText();
                String maquina = "DaPooInteligancia01";
                int porCasillas, porBonificacion, size;
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
                if (sizeTablero.getText().isEmpty()) {
                    size = 10;
                } else {
                    size = Integer.parseInt(sizeTablero.getText());
                }
                if (color.equals("black")) {
                    color2 = "blue";
                } else {
                    color2 = "black";
                }
                TableGUI tablero = new TableGUI(nombre, maquina, porCasillas, porBonificacion, size, cambioES, color,
                        color2);
                tablero.setVisible(true);
                this.dispose();
            } catch (NumberFormatException e) {
                throw new PoobStairsExceptions(PoobStairsExceptions.BAD_PERCENTAGE);
            }
        } else if (nombreJugador1.getText().isEmpty() || color == null || modoMaquina == null) {
            throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
        }
    }
}
