package presentation;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Clase de la pantalla de inicio del juego PoobStaairs
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.2
 */
public class PoobStairsGUI extends JDialog {

    private JButton play;
    private JButton cargar;
    private JButton salir;

    private static final int width = Estilos.dimensions.width / 4;
    private static final int height = Estilos.dimensions.height / 2;
    private JFileChooser selecArchivo;

    /**
     * Let create the poobStairsGUI.
     */
    public PoobStairsGUI() {

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
     * 
     */
    public void prepareElements() {

        JPanel PantallaInicial = Estilos.GradientPanel();
        PantallaInicial.setOpaque(false);
        PantallaInicial.setLayout(null);

        JLabel chuters = new JLabel("CHUTERS");
        JLabel and = new JLabel("AND");
        JLabel laders = new JLabel("LADDERS");
        chuters.setForeground(Estilos.COLOR_LETRAS);
        chuters.setFont(Estilos.FUENTE_TITULO);

        chuters.setBounds(width / 2 - 100, (int) (height / 4.5) - 60, 200, 50);
        and.setForeground(Estilos.COLOR_LETRAS);
        and.setFont(Estilos.FUENTE_TITULO);
        and.setBounds(width / 2 - 50, (int) (height / 4.5) - 35, 200, 50);
        laders.setForeground(Estilos.COLOR_LETRAS);
        laders.setFont(Estilos.FUENTE_TITULO);
        laders.setBounds(width / 2 - 100, (int) (height / 4.5) - 10, 200, 50);

        play = new JButton("Jugar");
        cargar = new JButton("Cargar");
        salir = new JButton("Salir");

        play.setBounds(width / 2 - 100, (int) (height / 1.5) - 150, 200, 50);
        cargar.setBounds(width / 2 - 100, (int) (height / 1.5) - 100, 200, 50);
        salir.setBounds(width / 2 - 100, (int) (height / 1.5) - 50, 200, 50);

        play.setFont(Estilos.FUENTE_LETRA);
        cargar.setFont(Estilos.FUENTE_LETRA);
        salir.setFont(Estilos.FUENTE_LETRA);

        play.setBackground(Color.WHITE);
        cargar.setBackground(Color.WHITE);
        salir.setBackground(Color.WHITE);

        PantallaInicial.add(chuters);
        PantallaInicial.add(and);
        PantallaInicial.add(laders);
        PantallaInicial.add(play);
        PantallaInicial.add(cargar);
        PantallaInicial.add(salir);

        JLabel imagen = new JLabel("");
        imagen.setIcon(new ImageIcon("resourses\\Snake.png"));
        imagen.setForeground(Color.WHITE);
        imagen.setFont(new Font("Dialog", Font.BOLD, 20));
        imagen.setBounds(-161, 119, 649, 180);
        PantallaInicial.add(imagen);
        add(PantallaInicial);
    }

    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.addWindowListener(Cerrar);

        play.addActionListener(e -> optionPane());
        cargar.addActionListener(e -> searchFile());
        salir.addActionListener(e -> exit());
    }

    /**
     * change to ne next window to configurate the game
     */
    public void optionPane() {
        ConfigurationGUI pantalla = new ConfigurationGUI();
        pantalla.setVisible(true);
        this.dispose();
    }

    /**
     * Me permite cargar una partida que tenia guardadas
     */
    public void searchFile() {
        selecArchivo = new JFileChooser();
        selecArchivo.setVisible(true);
        int action = selecArchivo.showOpenDialog(cargar);
        if (action == JFileChooser.APPROVE_OPTION) {
            File archivo = selecArchivo.getSelectedFile();
            JOptionPane.showMessageDialog(cargar,
                    "El archivo de nombre " + archivo.getName() + " que se trata de abrir en la ruta " + archivo
                            + "\n NO se pudo abrir ya que esta funcion se encuentra en construccion.");
        }
        selecArchivo.setVisible(false);
    }

    /**
     * Me permite salir del juego
     */
    public void exit() {
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PoobStairsGUI window = new PoobStairsGUI();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}