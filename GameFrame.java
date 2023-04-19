import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameFrame extends JFrame {

    public GameFrame(String player1, String player2, String color) {
        int x = 10;
        int y = 10;
        int mSeparacion = 2;
        JButton[][] Tablero;
        int[][] TableroVis = new int[x][y];


        setTitle("Chutes and Ladders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtener las dimensiones de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Establecer la ubicación del JFrame en la mitad de la pantalla
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel Player1 = new JLabel("New label");
        panel.add(Player1, BorderLayout.SOUTH);

        JLabel Player2 = new JLabel("New label");
        panel.add(Player2, BorderLayout.NORTH);

        JLabel dado1 = new JLabel("New label");
        panel.add(dado1);

        JLabel dado2 = new JLabel("New label");
        panel.add(dado2);

        JButton TirarDado = new JButton("Tirar");
        panel.add(TirarDado, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);

        int ancho = panel_1.getSize().width;
        int alto = panel_1.getSize().height;

        int dimensionMenor = Math.min(ancho, alto);

        int tamaAncho = dimensionMenor / x;
        int tamaAlto = dimensionMenor / y;

        int xOffset = (ancho - dimensionMenor) / 2;
        int yOffset = (alto - dimensionMenor) / 2;

        Tablero = new JButton[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                JButton temp = Tablero[i][j];
                temp.setBounds(xOffset + j * tamaAncho, yOffset + i * tamaAlto, tamaAncho - mSeparacion,
                        tamaAlto - mSeparacion);

            }
        }

        // Agregar el panel principal al JFrame
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());

        // Agregar el JLabel con el título centrado al panel principal
        JLabel title = new JLabel("Chutes and Ladders");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Kristen ITC", Font.PLAIN, 11));
        title.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(title, BorderLayout.CENTER);

        // Hacer visible el JFrame
        setVisible(true);

    }
}
