package presentation;

import java.awt.Color;

import javax.swing.JLabel;

public class NormalGUI extends CasillasGUI {
	/**
	 * Constructor of the class NormalGUI
	 */
	public NormalGUI(String valor,String x) {
		setLayout(null);
		texto = new JLabel(valor);
		texto.setBounds(25, 50, 30,20);
		add(texto);
		if(Integer.parseInt(x) % 2 == 0) {
			setBackground(Color.cyan);
		}else {
			setBackground(Color.orange);
		}
	}
}
