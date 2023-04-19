import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(String player1, String player2, String color) {
        // Configura la ventana
        setTitle("Juego");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agrega los componentes necesarios
        JLabel player1Label = new JLabel("Player 1: " + player1);
        JLabel player2Label = new JLabel("Player 2: " + player2);
        JLabel colorLabel = new JLabel("Color: " + color);

        JPanel panel = new JPanel();
        panel.add(player1Label);
        panel.add(player2Label);
        panel.add(colorLabel);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
