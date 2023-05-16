package presentation;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class prueba {

	private JFrame frame;
	private JLabel label1, label2;
	private Icon icon;
	private ImageIcon image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba window = new prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 169);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		label1 = new JLabel();
		frame.getContentPane().add(label1);

		label2 = new JLabel();
		frame.getContentPane().add(label2);
		
		frame.setVisible(true); // hace visible el frame
		
		// Obtén el tamaño del label1 y asegúrate de que no sea 0 en ninguna de las dimensiones
		if (label1.getWidth() != 0 && label1.getHeight() != 0) {
			this.SetImageLabel(this.label1, "resourses\\Fin-serpiente.png");
		}
		if (label2.getWidth() != 0 && label2.getHeight() != 0) {
			this.SetImageLabel(this.label2, "resourses\\Fin-serpiente.png");
		}
	}

	private void SetImageLabel(JLabel labelName, String root) {
		this.image = new ImageIcon(root);
		this.icon = new ImageIcon(this.image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		labelName.repaint();
	}
}
