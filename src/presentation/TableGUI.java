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
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import domain.Casillas;
import domain.Dado;
import domain.Escalera;
import domain.PoobStairs;
import domain.Player;
import domain.Table;
import javax.swing.JLabel;
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
    private JLabel dado,lblNewLabel_5;
    private JButton btnNewButton;
    private ImageIcon fichaJ1, fichaJ2, esca, serp, boni, band;
    private String nombre1, nombre2, colorJ1, colorJ2;
    private PoobStairs poobStairs;
    private PlayerGUI jugador1, jugador2;
    private Icon icon;
	private ImageIcon image;
    private Dado dice;
    private int[][] endEscalera = { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };
    private int[][] endSerpiente = { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };

    /**
     * Let create the poobStairsGUI.
     */
    public TableGUI(String nombre1, String nombre2, int porcentajeMaquina, int porcentajeBonificador, int size,
            boolean modificar, String colorJ1, String colorJ2) {
        this.size = size;
        poobStairs = PoobStairs.getInstance(this.nombre1, nombre2, colorJ1, colorJ2, size, porcentajeMaquina,
                porcentajeBonificador, modificar);

        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        esca = new ImageIcon("resourses\\T_esc.png");
        serp = new ImageIcon("resourses\\T_ser.png");
        boni = new ImageIcon("resourses\\T_power.png");
        band = new ImageIcon("resourses\\T_ban.png");
        dice = Dado.getInstance(porcentajeBonificador);
        this.porcentajeMaquina = porcentajeMaquina;
        this.porcentajeBonificador = porcentajeBonificador;
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
    public void prepareElements() {
        JPanel PantallaInicial = Estilos.GradientPanel();
        getContentPane().add(PantallaInicial);
        PantallaInicial.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_iz = new JPanel(new GridBagLayout());
        panel_iz.setOpaque(false);
        PantallaInicial.add(panel_iz);

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


        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6.setForeground(Estilos.COLOR_LETRAS);
        panel_6.add(lblNewLabel_6);

        JPanel panel_6_1 = new JPanel();
        panel_6_1.setOpaque(false);
        panel_5.add(panel_6_1);
        panel_6_1.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1 = new JLabel();
        lblNewLabel_5_1.setIcon(serp);
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1.add(lblNewLabel_5_1);

        JLabel lblNewLabel_6_1 = new JLabel("New label");
        lblNewLabel_6_1.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_1.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1.add(lblNewLabel_6_1);

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

        JLabel lblNewLabel_6_3 = new JLabel("New label");
        lblNewLabel_6_3.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_3.setForeground(Estilos.COLOR_LETRAS);
        panel_6_3.add(lblNewLabel_6_3);

        JPanel panel_6_1_2 = new JPanel();
        panel_6_1_2.setOpaque(false);
        panel_5_2.add(panel_6_1_2);
        panel_6_1_2.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_2 = new JLabel();
        lblNewLabel_5_1_2.setIcon(band);
        lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_2.add(lblNewLabel_5_1_2);

        JLabel lblNewLabel_6_1_2 = new JLabel("New label");
        lblNewLabel_6_1_2.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_1_2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_2.add(lblNewLabel_6_1_2);

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

        JLabel lblNewLabel_6_4 = new JLabel("New label");
        lblNewLabel_6_4.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_4.setForeground(Estilos.COLOR_LETRAS);
        panel_6_4.add(lblNewLabel_6_4);

        JPanel panel_6_1_3 = new JPanel();
        panel_6_1_3.setOpaque(false);
        panel_5_3.add(panel_6_1_3);
        panel_6_1_3.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_3 = new JLabel();
        lblNewLabel_5_1_3.setIcon(serp);
        lblNewLabel_5_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_3.add(lblNewLabel_5_1_3);

        JLabel lblNewLabel_6_1_3 = new JLabel("New label");
        lblNewLabel_6_1_3.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_1_3.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_3.add(lblNewLabel_6_1_3);

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

        JLabel lblNewLabel_6_2 = new JLabel("New label");
        lblNewLabel_6_2.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_2.setForeground(Estilos.COLOR_LETRAS);
        panel_6_2.add(lblNewLabel_6_2);

        JPanel panel_6_1_1 = new JPanel();
        panel_6_1_1.setOpaque(false);
        panel_5_1.add(panel_6_1_1);
        panel_6_1_1.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_5_1_1 = new JLabel();
        lblNewLabel_5_1_1.setIcon(band);
        lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_6_1_1.add(lblNewLabel_5_1_1);

        JLabel lblNewLabel_6_1_1 = new JLabel("New label");
        lblNewLabel_6_1_1.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_6_1_1.setForeground(Estilos.COLOR_LETRAS);
        panel_6_1_1.add(lblNewLabel_6_1_1);

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

    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.addWindowListener(Cerrar);
        btnNewButton.addActionListener(e -> jugar());
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
        CasillasGUI casilla = null;
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
                if (table[i][j].getType().equals("Escalera")) {
                    casilla = putFinalEscalera(table[i][j], i, j, x);
                } else if (table[i][j].getType().equals("Serpiente")) {
                    casilla = new SerpienteGUI("Serpiente", x);
                } else {
                    casilla = (CasillasGUI) Class.forName("presentation." + table[i][j].getType() + "GUI")
                            .getConstructor(String.class, int.class).newInstance(Integer.toString(valor), x);
                }
                botones.put(valor, casilla);
                juego.add(casilla);
                juego.validate();
                juego.repaint();
                contador++;
            }
        }
        return juego;
    }

    /**
     * The action Listener that the lanzar.
     */
    private void jugar() {
        int valor = poobStairs.mover();
        ImageIcon iconoOriginal = selecImageDice(valor);
        Image imagenOriginal = iconoOriginal.getImage();
        int nuevoAncho = 250;
        int nuevoAlto = 250;
        Image imagenEscalada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        dado.setIcon(iconoEscalado);
        validate();
        repaint();
        movement();
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

    private void movement() {
        Player[] jugadores = poobStairs.getJugadores();
    }

    public CasillasGUI putFinalEscalera(Casillas box, int i, int j, int x) {
        Escalera aux = (Escalera) box;
        endEscalera[aux.getId()] = aux.getFinish();
        CasillasGUI casilla = null;
        boolean put = false;
        for (int[] w : endEscalera) {
            if (w[0] == i && w[1] == j) {
                casilla = new CasillasGUI("EF" + Integer.toString(aux.getId()), x);
                put = true;
                System.out.println(Integer.toString(w[0]) + "-" + Integer.toString(w[1]));
            }
        }
        if (!put) {
            casilla = new CasillasGUI("E" + Integer.toString(aux.getId()), x);
        }
        return casilla;
    }

    private void SetImageLabel(JLabel labelName, String root) {
		this.image = new ImageIcon(root);
		this.icon = new ImageIcon(this.image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		labelName.repaint();
	}
}
