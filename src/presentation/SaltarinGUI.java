package presentation;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SaltarinGUI extends CasillasGUI{
	/**
	 * Constructor of the class NormalGUI
	 */
	public SaltarinGUI(String valor,String x) {
		setLayout(null);
		JLabel saltarin = new JLabel();
		saltarin.setIcon(new ImageIcon("resourses\\trampolin.png"));
		saltarin.setBounds(20,10,60,50);
		add(saltarin);
		if(Integer.parseInt(x) % 2 == 0) {
			setBackground(Color.cyan);
		}else {
			setBackground(Color.orange);
		}
	}
}
