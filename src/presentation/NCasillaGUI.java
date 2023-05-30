package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

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
    protected String type = "NCasilla";

    /**
     * Constructor of the class NormalGUI
     */
    public NCasillaGUI(String valor, String num, int pos) {
        colocar(valor, num, pos);
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

    public void colocar(String valor, String num, int pos) {
        if (pos % 2 == 0) {
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
    }

    public void putJ2ugador(String pieza1, String pieza2, String num, int pos) {

    }
}
