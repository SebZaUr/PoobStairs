package presentation;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

public class Estilos {
    public static final String TITULO = "POOBSTAIRS";
    public static final ImageIcon icono = new ImageIcon("./resourses/icono.png");
    public static final Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Font FUENTE_TITULO = new Font("Kristen ITC", Font.BOLD, 30);
    public static final Font FUENTE_LETRA = new Font("Kristen ITC", Font.BOLD, 20);
    public static final Color COLOR_LETRAS = Color.WHITE;
    public static final Color COLOR_FONDO = new Color(34, 49, 63);
    public static final int ANCHO_BOTONES = 200;
    public static final int ALTO_BOTONES = 50;
    public static final Font Numero_casilla = new Font("Cooper Black", Font.PLAIN, 25);

    public static JPanel GradientPanel() {
        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.WHITE));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }
}
