package presentation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class prueba {

    private JFrame frame;
    private ImagePanel imagePanel;

    public static void main(String[] args) {
        prueba window = new prueba();
        window.frame.setVisible(true);
    }

    public prueba() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 150, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagePanel = new ImagePanel("F:\\GitHub\\PoobStairs\\resourses\\icono.png");
        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("New label");
        imagePanel.setLayout(null); // Usar un LayoutManager nulo para controlar la posición del JLabel
        lblNewLabel.setBounds(0, 0, imagePanel.getWidth(), imagePanel.getHeight()); // Establecer los límites del JLabel
        imagePanel.add(lblNewLabel);

        frame.setVisible(true);
    }

    private class ImagePanel extends JPanel {

        private ImageIcon backgroundImage;

        public ImagePanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension size = getSize();
            // Establecer el color de fondo del panel
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, size.width, size.height);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage.getImage(), 0, 0, size.width, size.height, this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        }
    }
}
