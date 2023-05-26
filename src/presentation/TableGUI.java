package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import domain.Casillas;
import domain.Dado;
import domain.PoobStairs;
import domain.Player;
import domain.Table;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clase de Tablero visual
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.7
 */
public class TableGUI extends JFrame {

    private Map<Integer, JPanel> botones;
    private JPanel juego;
    private static final Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
    private final int width = dimensions.width;
    private final int height = dimensions.height;
    private int size, porcentajeBonificador, porcentajeMaquina;
    private JLabel dado, lblNewLabel_5;
    private JButton btnNewButton;
    private ImageIcon fichaJ1, fichaJ2, esca, serp, boni, band, image;
    private String nombre1, nombre2, colorJ1, colorJ2, modoMaquina;
    private PoobStairs poobStairs;
    private PlayerGUI jugador1, jugador2;
    private Icon icon;
    private Dado dice;
    private JLabel escalera1, serpiente1, bonificadores1, posMax1, escalera2, serpiente2, bonificadores2, posMax2;
    private ArrayList<int[][]> finalEscaleras = new ArrayList<>();
    private ArrayList<int[][]> finalSerpiente = new ArrayList<>();
    private Player player1, player2;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem inicio, cargar, salvar, finalizar;
    private JFileChooser selecionarArchivos = new JFileChooser();
    private boolean modificar;

    /**
     * Let create the poobStairsGUI.
     */
    public TableGUI(String nombre1, String nombre2, int porcentajeMaquina, int porcentajeBonificador, int size,
            boolean modificar, String colorJ1, String colorJ2, String modoMaquina) {
        this.size = size;
        try {
            poobStairs = new PoobStairs(this.nombre1, nombre2, colorJ1, colorJ2, size, porcentajeMaquina,
                    porcentajeBonificador, modificar, modoMaquina);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo crear al jugador maquina", "Error Maquina",
                    JOptionPane.ERROR_MESSAGE);
        }
        Player[] aux = poobStairs.getJugadores();
        player1 = aux[0];
        player2 = aux[1];
        finalEscaleras = Table.getFinalLadder();
        finalSerpiente = Table.getFinalSnake();
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        esca = new ImageIcon("resourses\\T_esc.png");
        serp = new ImageIcon("resourses\\T_ser.png");
        boni = new ImageIcon("resourses\\T_power.png");
        band = new ImageIcon("resourses\\T_ban.png");
        dice = Dado.getInstance(porcentajeBonificador);
        this.porcentajeMaquina = porcentajeMaquina;
        this.porcentajeBonificador = porcentajeBonificador;
        this.modoMaquina = modoMaquina;
        this.modificar = modificar;
        this.colorJ1 = colorJ1;
        jugador1 = new PlayerGUI(colorJ1);
        fichaJ1 = jugador1.getImage();
        this.colorJ2 = colorJ2;
        jugador2 = new PlayerGUI(colorJ2);
        fichaJ2 = jugador2.getImage();
        setIconImage(Estilos.icono.getImage());
        setTitle(Estilos.TITULO);
        setSize(width, height);
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Create and configure all visual elements of the table.
     */
    private void prepareElements() {
        JPanel PantallaInicial = Estilos.GradientPanel();
        getContentPane().add(PantallaInicial);
        PantallaInicial.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_iz = new JPanel(new GridBagLayout());
        panel_iz.setOpaque(false);
        PantallaInicial.add(panel_iz);

        prepareElementsMenu();

        // Nuevo JPanel para contener los botones del tablero
        try {
            JPanel panel_tablero = prepareTable();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10); // Margen para separar el panel del borde del panel_iz
            panel_iz.add(panel_tablero, gbc);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JPanel panel_de = new JPanel();
        panel_de.setOpaque(false);
        PantallaInicial.add(panel_de);
        panel_de.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        // Crear el borde con el nuevo estilo y color
        TitledBorder borde = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE), "Jugadores",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
        panel.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde));
        panel_de.add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_7 = new JPanel();
        panel_7.setOpaque(false);
        panel.add(panel_7);
        panel_7.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setOpaque(false);
        panel_7.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(fichaJ1);
        panel_3.add(lblNewLabel);

        String mayus = Character.toUpperCase(nombre1.charAt(0)) + nombre1.substring(1);
        JLabel lblNewLabel_3 = new JLabel(mayus);
        lblNewLabel_3.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_3.setForeground(Estilos.COLOR_LETRAS);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3.add(lblNewLabel_3);

        JPanel panel_5 = new JPanel();
        panel_5.setOpaque(false);
        panel_7.add(panel_5);
        panel_5.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setOpaque(false);
        panel_5.add(panel_6);
        panel_6.setLayout(new GridLayout(0, 2, 0, 0));

        lblNewLabel_5 = new JLabel();
        lblNewLabel_5.setIcon(esca);
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6.add(lblNewLabel_5);

        escalera1 = new JLabel("0");
        escalera1.setFont(Estilos.FUENTE_TITULO);
        escalera1.setForeground(Estilos.COLOR_LETRAS);
        panel_6.add(escalera1);

        JPanel panel_6_1 = new JPanel();
        panel_6_1.setOpaque(false);
        panel_5.add(panel_6_1);
        panel_6_1.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1 = new JLabel();
        lblNewLabel_5_1.setIcon(serp);
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1.add(lblNewLabel_5_1);

        serpiente1 = new JLabel("0");
        serpiente1.setFont(Estilos.FUENTE_TITULO);
        serpiente1.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1.add(serpiente1);

        JPanel panel_5_2 = new JPanel();
        panel_5_2.setOpaque(false);
        panel_7.add(panel_5_2);
        panel_5_2.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_6_3 = new JPanel();
        panel_6_3.setOpaque(false);
        panel_5_2.add(panel_6_3);
        panel_6_3.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_3 = new JLabel();
        lblNewLabel_5_3.setIcon(boni);
        lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_3.add(lblNewLabel_5_3);

        bonificadores1 = new JLabel("0");
        bonificadores1.setFont(Estilos.FUENTE_TITULO);
        bonificadores1.setForeground(Estilos.COLOR_LETRAS);
        panel_6_3.add(bonificadores1);

        JPanel panel_6_1_2 = new JPanel();
        panel_6_1_2.setOpaque(false);
        panel_5_2.add(panel_6_1_2);
        panel_6_1_2.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_2 = new JLabel();
        lblNewLabel_5_1_2.setIcon(band);
        lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_2.add(lblNewLabel_5_1_2);

        posMax1 = new JLabel("0");
        posMax1.setFont(Estilos.FUENTE_TITULO);
        posMax1.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_2.add(posMax1);

        JPanel panel_4 = new JPanel();
        panel_4.setOpaque(false);
        panel_4.setForeground(Color.WHITE);
        panel_4.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.WHITE));
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panel_4_1 = new JPanel();
        panel_4_1.setOpaque(false);
        panel_4.add(panel_4_1);
        panel_4_1.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setIcon(fichaJ2);
        panel_4_1.add(lblNewLabel_2);

        String mayus2 = Character.toUpperCase(nombre2.charAt(0)) + nombre2.substring(1);
        JLabel lblNewLabel_4 = new JLabel(mayus2);
        lblNewLabel_4.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_4.setForeground(Estilos.COLOR_LETRAS);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4_1.add(lblNewLabel_4);

        JPanel panel_5_3 = new JPanel();
        panel_5_3.setOpaque(false);
        panel_4.add(panel_5_3);
        panel_5_3.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_6_4 = new JPanel();
        panel_6_4.setOpaque(false);
        panel_5_3.add(panel_6_4);
        panel_6_4.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_4 = new JLabel();
        lblNewLabel_5_4.setIcon(esca);
        lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_4.add(lblNewLabel_5_4);

        escalera2 = new JLabel("0");
        escalera2.setFont(Estilos.FUENTE_TITULO);
        escalera2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_4.add(escalera2);

        JPanel panel_6_1_3 = new JPanel();
        panel_6_1_3.setOpaque(false);
        panel_5_3.add(panel_6_1_3);
        panel_6_1_3.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_3 = new JLabel();
        lblNewLabel_5_1_3.setIcon(serp);
        lblNewLabel_5_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_3.add(lblNewLabel_5_1_3);

        serpiente2 = new JLabel("0");
        serpiente2.setFont(Estilos.FUENTE_TITULO);
        serpiente2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_3.add(serpiente2);

        JPanel panel_5_1 = new JPanel();
        panel_5_1.setOpaque(false);
        panel_4.add(panel_5_1);
        panel_5_1.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_6_2 = new JPanel();
        panel_6_2.setOpaque(false);
        panel_5_1.add(panel_6_2);
        panel_6_2.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_2 = new JLabel();
        lblNewLabel_5_2.setIcon(boni);
        lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_2.add(lblNewLabel_5_2);

        bonificadores2 = new JLabel("0");
        bonificadores2.setFont(Estilos.FUENTE_TITULO);
        bonificadores2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_2.add(bonificadores2);

        JPanel panel_6_1_1 = new JPanel();
        panel_6_1_1.setOpaque(false);
        panel_5_1.add(panel_6_1_1);
        panel_6_1_1.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_1 = new JLabel();
        lblNewLabel_5_1_1.setIcon(band);
        lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_1.add(lblNewLabel_5_1_1);

        posMax2 = new JLabel("0");
        posMax2.setFont(Estilos.FUENTE_TITULO);
        posMax2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_1.add(posMax2);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_de.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        dado = new JLabel();
        dado.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(dado);

        // Obtener el ImageIcon original
        ImageIcon iconoOriginal = selecImageDice(dice.getValue());

        // Obtener la imagen subyacente y escalarla
        Image imagenOriginal = iconoOriginal.getImage();
        int nuevoAncho = 250; // Modificar según el tamaño deseado
        int nuevoAlto = 250;
        Image imagenEscalada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon a partir de la imagen escalada
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        // Establecer el nuevo ImageIcon como icono del JLabel
        dado.setIcon(iconoEscalado);

        JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        btnNewButton = new JButton("Lanzar");
        btnNewButton.setFont(Estilos.FUENTE_TITULO);
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setForeground(Color.WHITE);

        panel_2.add(btnNewButton);
    }

    /**
     * Create all visual's element on the menu.
     */
    private void prepareElementsMenu() {
        menu = new JMenu("Opciones");
        menuBar = new JMenuBar();
        inicio = new JMenuItem("Nueva Partida");
        cargar = new JMenuItem("Cargar Partida");
        salvar = new JMenuItem("Guardar Partida");
        finalizar = new JMenuItem("Finalizar Partida");
        menu.add(inicio);
        menu.add(cargar);
        menu.add(salvar);
        menu.add(finalizar);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * Configure all the actions that need the game.
     */
    private void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.addWindowListener(Cerrar);
        btnNewButton.addActionListener(e -> jugar());
        prepareActionsMenu();
    }

    /**
     * Configure all menu's actions.
     */
    private void prepareActionsMenu() {
        inicio.addActionListener(e -> nuevoJuego());
        cargar.addActionListener(e -> cargarJuego());
        salvar.addActionListener(e -> salvarJuego());
        finalizar.addActionListener(e -> finalizarJuego());
    }

    /**
     * Let the player create other game.
     */
    private void nuevoJuego() {
        int Confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Quiere guardar la partida antes de iniciar una nueva?");
        if (Confirmacion == JOptionPane.YES_OPTION) {
            salvarJuego();
        } else {
            ConfigurationGUI nueva = new ConfigurationGUI();
            nueva.setVisible(true);
            this.dispose();
        }
    }

    /**
     * Let save the actual state of the game.
     */
    private void cargarJuego() {
        selecionarArchivos.setVisible(true);
        ArrayList<String[]> informacion = new ArrayList<>();
        int action = selecionarArchivos.showOpenDialog(cargar);
        if (action == JFileChooser.APPROVE_OPTION) {
            File archivo = selecionarArchivos.getSelectedFile();
            try {
                informacion = poobStairs.open(archivo.getName());
                String[] infoJ1 = informacion.get(0);
                String[] infoJ2 = informacion.get(1);
                String[] infoVariables = informacion.get(3);
                ArrayList<String[]> escaleras = new ArrayList<>();
                ArrayList<String[]> serpientes = new ArrayList<>();
                ArrayList<String[]> tablero = new ArrayList<>();
                for (int i = 5; i < 10; i++) {
                    escaleras.add(informacion.get(i));
                    serpientes.add(informacion.get(i + 6));
                }
                for (int i = 17; i < informacion.size(); i++) {
                    tablero.add(informacion.get(i));
                }
                String modoMaquina;
                if (infoVariables.length == 4) {
                    modoMaquina = null;
                } else {
                    modoMaquina = infoVariables[4];
                }
                TableGUI nuevo = new TableGUI(infoJ1[0], infoJ2[0], Integer.parseInt(infoVariables[0]),
                        Integer.parseInt(infoVariables[1]), Integer.parseInt(infoVariables[2]),
                        Boolean.valueOf(infoVariables[3]), infoJ1[1], infoJ2[1], modoMaquina);
                nuevo.updateTable(tablero, escaleras, serpientes, informacion.get(2), infoJ1, infoJ2);
                nuevo.setVisible(true);
                this.dispose();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "No se pudo abrir el archivo", "Error Abrir",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void salvarJuego() {
        selecionarArchivos.setVisible(true);
        int action = selecionarArchivos.showOpenDialog(cargar);
        if (action == JFileChooser.APPROVE_OPTION) {
            File archivo = selecionarArchivos.getSelectedFile();
            String informacionJ1 = nombre1 + "," + colorJ1 + "," + escalera1.getText() + "," + serpiente1.getText()
                    + "," + bonificadores1.getText() + "," + posMax1.getText();
            String informacionJ2 = nombre2 + "," + colorJ2 + "," + escalera2.getText() + "," + serpiente2.getText()
                    + "," + bonificadores2.getText() + "," + posMax2.getText();
            try {
                poobStairs.save(archivo, informacionJ1, informacionJ2, Integer.toString(porcentajeMaquina),
                        Integer.toString(porcentajeBonificador), Integer.toString(size), finalEscaleras,
                        finalSerpiente, modoMaquina, modificar);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No se pudo guardar el archivo", "Error Guardar",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * Let exit in an any game's state.
     */
    private void finalizarJuego() {
        int Confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Seguro quieres abandonar tu partida sin guardar?");
        if (Confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            salvarJuego();
            PoobStairsGUI nueva = new PoobStairsGUI();
            nueva.setVisible(true);
            this.dispose();
        }
    }

    /**
     * Create the board to play
     * 
     * @return a panel with the board
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public JPanel prepareTable() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        int contador = 1;
        int ajuste = size - 1;
        int valor = 0;
        Table.getInstance(size);
        Casillas[][] table = Table.getGameTable();
        juego = new JPanel();
        juego.setLayout(new GridLayout(size, size));
        botones = new HashMap<>();
        NCasillaGUI[][] auxSEGUI = snakeAndLadders(size);
        NCasillaGUI casilla = null;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = i + j;
                if (i % 2 != 0) {
                    valor = (size * size + 1) - contador - ajuste;
                    ajuste = ajuste - 2;
                } else {
                    ajuste = size - 1;
                    valor = (size * size + 1) - contador;
                }
                if (auxSEGUI[i][j] != null) {
                    casilla = auxSEGUI[i][j];
                } else {
                    casilla = (NCasillaGUI) Class.forName("presentation." + table[i][j].getType() + "GUI")
                            .getConstructor(String.class, int.class).newInstance(Integer.toString(valor), x);

                }
                botones.put(valor, casilla);
                juego.add(casilla);
                repintar();
                contador++;
            }
        }
        return juego;
    }

    /**
     * The action Listener that the lanzar.
     */
    private void jugar() {
        int valor = dice.getValue();
        poobStairs.mover(valor);
        putDice(valor);
        movement(valor);
        updateInformation();
        repintar();
        validate();
        repaint();
    }

    /**
     * Choose the dice's image.
     * 
     * @param puntos the dice's value.
     * @return the dice's image.
     */
    private ImageIcon selecImageDice(int puntos) {
        ImageIcon imagen = null;
        switch (puntos) {
            case 1:
                imagen = new ImageIcon("resourses\\dado_1.png");
                break;
            case 2:
                imagen = new ImageIcon("resourses\\dado_2.png");
                break;
            case 3:
                imagen = new ImageIcon("resourses\\dado_3.png");
                break;
            case 4:
                imagen = new ImageIcon("resourses\\dado_4.png");
                break;
            case 5:
                imagen = new ImageIcon("resourses\\dado_5.png");
                break;
            case 6:
                imagen = new ImageIcon("resourses\\dado_6.png");
                break;
            default:
                break;
        }
        return imagen;
    }

    /**
     * Make the visual change on the table game.
     */
    private void movement(int valor) {
        if (player1.getTurn()) {
            updatePosition(player1);
        } else {
            updatePosition(player2);
        }
    }

    private void SetImageLabel(JLabel labelName, String root) {
        this.image = new ImageIcon(root);
        this.icon = new ImageIcon(this.image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(),
                Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        labelName.repaint();
    }

    /**
     * Refresh the game table's view.
     */
    private void repintar() {
        juego.validate();
        juego.repaint();
    }

    /**
     * Put the dice's image in each throw.
     * 
     * @param valor
     */
    private void putDice(int valor) {
        ImageIcon iconoOriginal = selecImageDice(valor);
        Image imagenOriginal = iconoOriginal.getImage();
        int nuevoAncho = 250;
        int nuevoAlto = 250;
        Image imagenEscalada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        dado.setIcon(iconoEscalado);
    }

    /**
     * Update the players' information.
     */
    private void updateInformation() {
        escalera1.setText(player1.stairs());
        escalera2.setText(player2.stairs());
        serpiente1.setText(player1.snake());
        serpiente2.setText(player2.snake());
        bonificadores1.setText(player1.getBonificadores());
        bonificadores2.setText(player2.getBonificadores());
        if (Integer.parseInt(posMax1.getText()) < player1.getPosition()) {
            posMax1.setText(Integer.toString(player1.getPosition()));
        }
        if (Integer.parseInt(posMax2.getText()) < player2.getPosition()) {
            posMax2.setText(Integer.toString(player2.getPosition()));
        }
    }

    /**
     * show the piece's movement.
     * 
     * @param player
     */
    private void updatePosition(Player player) {

    }

    /**
     * Create the snakes and ladders visual part.
     * 
     * @param size
     * @return
     */
    private NCasillaGUI[][] snakeAndLadders(int size) {
        NCasillaGUI[][] tablero = new NCasillaGUI[size][size];
        for (int i = 0; i < 5; i++) {
            int[][] positions = finalEscaleras.get(i);
            int x = positions[0][0] + positions[0][1];
            EscaleraGUI casilla = new EscaleraGUI("E" + i, x);
            tablero[positions[0][0]][positions[0][1]] = casilla;
            int y = positions[1][0] + positions[1][1];
            casilla = new EscaleraGUI("EF" + i, y);
            tablero[positions[1][0]][positions[1][1]] = casilla;
        }
        for (int i = 0; i < 5; i++) {
            int[][] positions = finalSerpiente.get(i);
            int x = positions[0][0] + positions[0][1];
            SerpienteGUI casilla = new SerpienteGUI("S" + i, x);
            tablero[positions[0][0]][positions[0][1]] = casilla;
            int y = positions[1][0] + positions[1][1];
            casilla = new SerpienteGUI("SF" + i, y);
            tablero[positions[1][0]][positions[1][1]] = casilla;
        }
        return tablero;
    }

    /**
     * Let me update the table on logic and repaint the table and the other
     * information.
     * 
     * @param tablero
     * @param escaleras
     * @param serpientes
     * @param turno
     */
    private void updateTable(ArrayList<String[]> tablero, ArrayList<String[]> escaleras, ArrayList<String[]> serpientes,
            String[] turno, String[] infoj1, String[] infoj2) {
        // poobStairs.change(tablero,escaleras,serpientes);
        // poobStairs.setTurn(turno);
        juego.removeAll();
        prepareElements();
        escalera1.setText(infoj1[2]);
        escalera2.setText(infoj2[2]);
        serpiente1.setText(infoj1[3]);
        serpiente2.setText(infoj2[3]);
        bonificadores1.setText(infoj1[4]);
        bonificadores2.setText(infoj2[4]);
        posMax1.setText(infoj1[5]);
        posMax2.setText(infoj2[5]);

    }
}
