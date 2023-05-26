package presentation;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class ConfigurationGUI extends JDialog {

    private static final int width = Estilos.dimensions.width / 4;
    private static final int height = Estilos.dimensions.height / 4;
    private JButton jugador;
    private JButton maquina;

    public ConfigurationGUI() {
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        setIconImage(Estilos.icono.getImage());
        setTitle(Estilos.TITULO);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = Estilos.GradientPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        jugador = new JButton();
        maquina = new JButton();

        jugador.setBounds(width / 2 - 105, height / 8, 100, 100);
        maquina.setBounds(width / 2 + 5, height / 8, 100, 100);
        jugador.setBackground(Color.WHITE);
        maquina.setBackground(Color.WHITE);

        ImageIcon vsJugadorIcon = new ImageIcon("./resourses/amistads.gif");
        ImageIcon vsMaquina = new ImageIcon("./resourses/cyborg.gif");

        Image vsJugadorImage = vsJugadorIcon.getImage();
        Image vsMaquinaImage = vsMaquina.getImage();

        Image resizedImage = vsJugadorImage.getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        Image resizedRImage = vsMaquinaImage.getScaledInstance(90, 90, Image.SCALE_DEFAULT);

        ImageIcon vsJugadorResizedIcon = new ImageIcon(resizedImage);
        ImageIcon vsJugadorResizedIconR = new ImageIcon(resizedRImage);

        jugador.setIcon(vsJugadorResizedIcon);
        maquina.setIcon(vsJugadorResizedIconR);

        panel.add(jugador);
        panel.add(maquina);
        add(panel);
    }

    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.addWindowListener(Cerrar);
        jugador.addActionListener(e -> dosJugadores());
        maquina.addActionListener(e -> maquinaConfig());
    }

    public void dosJugadores() {
        ConfigJugador pantalla = new ConfigJugador();
        pantalla.setVisible(true);
        this.dispose();
    }

    public void maquinaConfig() {
        ConfigMaquina pantalla = new ConfigMaquina();
        pantalla.setVisible(true);
        this.dispose();
    }

}
