package presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import domain.Table;
import domain.Casillas;

/**
 * Create and configure the game table's graphics elements
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.2
 *
 */
public class TableGUI extends JDialog {

    private Map<Integer, JPanel> botones;
    private JPanel juego;
    private static final Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
    private final int width = dimensions.width;
    private final int height = dimensions.height;
    private static int size, porcentajeBonificador, porcentajeMaquina;
    private JLabel dado;
    private DadoGUI imagenDado;
    private JButton btnNewButton;
    private static ImageIcon fichaJ1, fichaJ2;
    private static String nombre1, nombre2, colorJ1, colorJ2;
    public static final String[] typesModificadores = { "Nulo", "Bonificacion", "Penalizacion", "CambioPosicion",
            "Pregunta" };

    /**
     * Let create the poobStairsGUI.
     */
    public TableGUI(String nombre1, String nombre2, int porcentajeMaquina, int porcentajeBonificador, int size,
            boolean modificar, String colorJ1, String colorJ2) {
        setIconImage(Estilos.icono.getImage());
        setTitle("POOBSTAIRS");
        setSize(width, height);
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.size = size;
        this.porcentajeMaquina = porcentajeMaquina;
        this.porcentajeBonificador = porcentajeBonificador;
        this.colorJ1 = colorJ1;
        this.colorJ2 = colorJ2;
        fichaJ1 = new PlayerGUI(colorJ1).getImage();
        fichaJ1 = new PlayerGUI(colorJ2).getImage();
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * 
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
        panel_de.setLayout(new GridLayout(4, 3, 4, 4));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("resourses\\hoimbre.png"));
        panel_de.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("resourses\\mujer.png"));
        panel_de.add(lblNewLabel_2);

        JLabel lblNewLabel_4 = new JLabel("Player 1");
        panel_de.add(lblNewLabel_4);

        JLabel lblNewLabel_3 = new JLabel("Playe 2");
        panel_de.add(lblNewLabel_3);

        dado = new JLabel();
        imagenDado = new DadoGUI();
        dado.setIcon(imagenDado.getImagen());
        panel_de.add(dado);

        btnNewButton = new JButton("Lanzar");
        panel_de.add(btnNewButton);
    }

    /**
     * Active all the action Listener for all the buttons.
     */
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
        int ajuste = 9;
        int valor = 0;
        Table.getInstance(size);
        Casillas[][] table = Table.getGameTable();
        Table.createTable(porcentajeMaquina);
        juego = new JPanel();
        juego.setLayout(new GridLayout(10, 10));
        botones = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String x = Integer.toString(i + j);
                if (i % 2 != 0) {
                    valor = 101 - contador - ajuste;
                    ajuste = ajuste - 2;
                } else {
                    ajuste = 9;
                    valor = 101 - contador;
                }
                String clase = table[i][j].getType();
                CasillasGUI casilla = (CasillasGUI) Class.forName("presentation." + clase + "GUI")
                        .getConstructor(String.class, String.class).newInstance(Integer.toString(valor), x);
                botones.put(valor, casilla);
                juego.add(casilla);
                juego.validate();
                juego.repaint();
                contador++;
            }
        }
        return juego;
    }

    private void jugar() {
        DadoGUI lanzar = new DadoGUI();
        dado.setIcon(lanzar.getImagen());
        validate();
        repaint();
    }
}
