package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private ImageIcon backgroundImage;
    private Color fond;

    public ImagePanel(String imagePath,Color fond) {
        this.backgroundImage = new ImageIcon(imagePath);
        this.fond=fond;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size = getSize();
        g.setColor(fond);
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