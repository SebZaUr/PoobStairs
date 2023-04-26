package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TableGUI extends JDialog{

    private JButton[][] botones;
    private static final Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int width = dimensions.width ;
    private static final int height = dimensions.height ;

    /**
     * Let create the poobStairsGUI.
     */
    public TableGUI() {
        setTitle("POOBSTAIRS");
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
        JPanel PantallaInicial = new GradientPanel();
        getContentPane().add(PantallaInicial);
        PantallaInicial.setLayout(new GridLayout(1, 0, 0, 0));
        
        JPanel panel_iz = new JPanel(new GridBagLayout());
        panel_iz.setOpaque(false);
        PantallaInicial.add(panel_iz);
        
        // Nuevo JPanel para contener los botones del tablero
        JPanel panel_tablero = new JPanel(new GridLayout(10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10); // Margen para separar el panel del borde del panel_iz
        panel_iz.add(panel_tablero, gbc);
        
        // Cree los botones y agréguelos al panel del tablero
        botones = new JButton[10][10];
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(50, 50)); // Tamaño cuadrado
                botones[i][j].setText("(" + i + ", " + j + ")"); // Posiciones del tablero
                botones[i][j].setEnabled(false); // Deshabilitar los botones
                if ((i + j) % 2 == 0) {
                    botones[i][j].setBackground(Color.GREEN); // Fondo verde para posiciones impares
                }
                panel_tablero.add(botones[i][j]);
            }
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
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("resourses\\dado.png"));
        panel_de.add(lblNewLabel);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("resourses\\dado.png"));
        panel_de.add(lblNewLabel_6);
        
        JButton btnNewButton = new JButton("Lanzar");
        panel_de.add(btnNewButton);
    }
    public void prepareActions() {
        
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	TableGUI window = new TableGUI();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
