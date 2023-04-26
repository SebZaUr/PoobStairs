package presentation;

import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
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
    	setTitle(Estilos.TITULO);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = Estilos.GradientPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        jugador = new JButton();
        maquina = new JButton();

        jugador.setBounds(width/2 - 105,height/8,100,100);
        maquina.setBounds(width/2 + 5,height/8,100,100);
        ImageIcon vsJugador = new ImageIcon("./resourses/personas.png");
        ImageIcon vsMaquina = new ImageIcon("./resourses/robot.png");
        jugador.setIcon(vsJugador);
        maquina.setIcon(vsMaquina);
        
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

    public void dosJugadores(){
        ConfigJugador pantalla = new ConfigJugador();
        pantalla.setVisible(true);
        this.dispose();
    }

    public void maquinaConfig(){
        ConfigMaquina pantalla = new ConfigMaquina();
        pantalla.setVisible(true);
        this.dispose();
    }

}
