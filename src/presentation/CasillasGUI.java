package presentation;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CasillasGUI extends JPanel {
	private JLabel texto;

	/**
	 * Constructor of the class NormalGUI
	 */
	public CasillasGUI(String valor, int x) {
		setLayout(null);
		texto = new JLabel(valor);
		texto.setBounds(25, 50, 30, 20);
		add(texto);
		if (x % 2 == 0) {
			setBackground(Color.cyan);
		} else {
			setBackground(Color.orange);
		}
	}

}
