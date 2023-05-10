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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.Casillas;
import domain.PoobStairs;
import domain.Table;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
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
    private JLabel dado;
    private DadoGUI imagenDado;
    private JButton btnNewButton;
    private ImageIcon fichaJ1, fichaJ2;
    private String nombre1, nombre2, colorJ1, colorJ2;
    private PoobStairs poobStairs;

    /**
     * Let create the poobStairsGUI.
     */
    public TableGUI(String nombre1, String nombre2, int porcentajeMaquina, int porcentajeBonificador, int size,
            boolean modificar, String colorJ1, String colorJ2) {
        setIconImage(Estilos.icono.getImage());
        setTitle(Estilos.TITULO);
        setSize(width, height);
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.size = size;
        this.porcentajeMaquina = porcentajeMaquina;
        this.porcentajeBonificador = porcentajeBonificador;
        this.colorJ1 = colorJ1;
        this.colorJ2 = colorJ2;
        fichaJ1 = new PlayerGUI(colorJ1).getImage();
        fichaJ1 = new PlayerGUI(colorJ2).getImage();
        poobStairs = PoobStairs.getInstance(this.nombre1, nombre2, colorJ1, colorJ2, size, porcentajeMaquina,
                porcentajeBonificador, modificar);
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
        imagenDado = new DadoGUI();
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
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        fichaJ1 = new ImageIcon("resourses\\Red.png");
        fichaJ2 = new ImageIcon("resourses\\Black.png");

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(fichaJ1);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setIcon(fichaJ2);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Player 1");
        lblNewLabel_3.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_3.setForeground(Estilos.COLOR_LETRAS);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Player 2");
        lblNewLabel_4.setFont(Estilos.FUENTE_TITULO);
        lblNewLabel_4.setForeground(Estilos.COLOR_LETRAS);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_4);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_de.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        dado = new JLabel();
        dado.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(dado);

        // Obtener el ImageIcon original
        ImageIcon iconoOriginal = imagenDado.getImagen();

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

        btnNewButton = new JButton("Lanzar");
        btnNewButton.setFont(Estilos.FUENTE_TITULO);
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setPreferredSize(new Dimension(200, 150));

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
        int ajuste = 9;
        int valor = 0;
        Table.getInstance(size);
        Casillas[][] table = Table.getGameTable();
        juego = new JPanel();
        juego.setLayout(new GridLayout(10, 10));
        botones = new HashMap<>();
        CasillasGUI casilla = null;
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
                casilla = (CasillasGUI) Class.forName("presentation.CasillasGUI")
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
