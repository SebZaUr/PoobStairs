package presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NCasillaGUI extends JPanel {
	private JLabel texto;
	protected String type;

	/**
	 * Constructor of the class NormalGUI
	 */
	public NCasillaGUI(String valor, int x) {
		setLayout(null);
		texto = new JLabel(valor);
		texto.setBounds(20, 20, 50, 50);
		add(texto);
		if (x % 2 == 0) {
			setBackground(Color.cyan);
		} else {
			setBackground(Color.orange);
		}
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
