package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NCasillaGUI extends JPanel {
    private JLabel texto;
    private String valor;
    private Color fond;
    private ImageIcon image;
    private ImageIcon icon;
    private ImagePanel imagePanel;
    protected String type;

    /**
     * Constructor of the class NormalGUI
     */
    public NCasillaGUI(String valor, String num, int x) {
        if (x % 2 == 0) {
            fond = Color.CYAN;
        } else {
            fond = Color.ORANGE;
        }
        imagePanel = new ImagePanel(valor, fond);
        add(imagePanel, BorderLayout.CENTER);
        this.valor = valor;
        setLayout(new GridLayout(0, 1, 0, 0)); // Usar GridLayout en lugar de null
        texto = new JLabel();
        texto.setForeground(new Color(255, 0, 255));
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setText(num);
        imagePanel.add(texto);
        type = "casillas";
    }

    public void fondo(String valor) {
        setLayout(new GridLayout(0, 1, 0, 0));
        JButton btnNewButton = new JButton(valor);
        btnNewButton.setFont(Estilos.FUENTE_TITULO);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setOpaque(false);
        btnNewButton.setIcon(new ImageIcon("resourses\\Black.png"));
        add(btnNewButton);
    }

    public String getType() {
        return type;
    }

}
