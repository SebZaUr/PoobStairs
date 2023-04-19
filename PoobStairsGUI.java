import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.io.BufferedReader;

import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PoobStairsGUI {

	private JFrame Snake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoobStairsGUI window = new PoobStairsGUI();
					window.Snake.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PoobStairsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Snake = new JFrame();
		Snake.setTitle("Chutes and Ladders");
		Snake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Obtener las dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		// Establecer la ubicación del JFrame en la mitad de la pantalla
		Snake.setSize(screenWidth / 4, screenHeight / 2);
		Snake.setLocationRelativeTo(null);
		Snake.setResizable(false);

		// Agregar el gradiente como fondo del JFrame
		Snake.setContentPane(new GradientPanel());

		// Agregar el panel principal al JFrame
		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setLayout(new BorderLayout());

		// Agregar el JLabel con el título centrado al panel principal
		JLabel title = new JLabel("Chutes and Ladders");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Kristen ITC", Font.PLAIN, 11));
		title.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(title, BorderLayout.CENTER);

		// Agregar el panel de los botones al panel principal
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false); // quitar el fondo del panel
		buttonsPanel.setLayout(new GridLayout(3, 1, 10, 10)); // GridLayout con 3 filas, 1 columna y espacios de 10
																// píxeles

		// Agregar el botón "Play" al panel de los botones
		JButton button1 = new JButton("Play");
		button1.setBackground(Color.WHITE);
		buttonsPanel.add(button1);

		// Agregar el evento del botón "Play"
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crear el panel de diálogo
				PlayDialogPanel dialogPanel = new PlayDialogPanel();
				// Mostrar el panel de diálogo
				int result = JOptionPane.showConfirmDialog(null,dialogPanel, "Jugar",
						JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					// Obtener los datos ingresados por el usuario
					dialogPanel.getPlayer1Name();
					dialogPanel.getPlayer2Name();
					dialogPanel.getColor();
				}
			}
		});

		// Agregar el botón "Load" al panel de los botones
		JButton button2 = new JButton("Load");
		button2.setBackground(Color.WHITE);
		buttonsPanel.add(button2);

		// Manejar el evento del botón "Load"
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						// Leer el contenido del archivo
						FileReader fileReader = new FileReader(selectedFile);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						while ((bufferedReader.readLine()) != null) {
							// Utilizar el contenido del archivo en la aplicación
							// ...
						}
						bufferedReader.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// Establecer la operación por defecto al cerrar el JFrame
		Snake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Agregar el botón "Exit" al panel de los botones
		JButton button3 = new JButton("Exit");
		button3.setBackground(Color.WHITE);
		buttonsPanel.add(button3);

		// Manejar el evento del botón "Exit"
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerrar el JFrame y finalizar la aplicación
				Snake.dispose();
				System.exit(0);
			}
		});

		// Agregar el panel de los botones al panel principal
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

		// Agregar el panel principal al JFrame
		Snake.getContentPane().add(mainPanel);

		// Hacer visible el JFrame
		Snake.setVisible(true);

	}

}