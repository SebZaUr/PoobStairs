package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.PoobStairsExceptions;

/**
 * Let me type the player's name and select all the different characteristics of
 * the game.
 * 
 * @author Sebastian Zamora Urrego.
 * @author Johann Amaya Lopez.
 * @version 1.7
 */
public class ConfigJugador extends JDialog {

	private final JButton jugar = new JButton("Empezar a Jugar");
	private JTextField nombreJugador1, nombreJugador2, porcentajeCasillas, porcentajeModificadores, sizeTablero;
	private JRadioButton cambioT, cambioF, Rojo1, Negro1, Blanco1, Verde1, Azul1, Amarillo1, Rojo2, Blanco2, Negro2,
			Verde2, Amarillo2, Azul2;
	private ButtonGroup coloresJ1, coloresJ2, cambio;
	private String modoMaquina, color, color2;
	private final int width = Estilos.dimensions.width / 2;
	private final int heigth = Estilos.dimensions.height / 2;
	private ImageIcon imagenRojo, imagenNegro, imagenBlanco, imagenVerde, imagenAzul, imagenAmarillo;
	private static boolean cambioES = false;
	private JPanel pantallaCarga, nombres, Configuracion, panel_4, panel_2, panel_4_1, color2_1, Player_2, Player_1,
			color1, Color_1, Color_2, panel, panel_1, panel_3;
	private JLabel numCasillas, numBonificadores, numBonificadores_1, cambioEsSer, lblNewLabel_1, lblNewLabel_2,
			imagenColor1, imagenColor2;

	/**
	 * Constructor de la pantalla de configuracion.
	 */
	public ConfigJugador() {
		setIconImage(Estilos.icono.getImage());
		setTitle(Estilos.TITULO);
		setSize(width, heigth);

		prepareElements();
		prepareActions();

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void prepareElements() {

		pantallaCarga = Estilos.GradientPanel();
		pantallaCarga.setOpaque(false);
		pantallaCarga.setLayout(null);

		nombres = new JPanel();
		nombres.setLayout(null);
		nombres.setOpaque(false);
		// Crear el borde con el nuevo estilo y color
		TitledBorder borde_2 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.WHITE), "Ingresen Datos",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
		nombres.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_2));
		nombres.setLayout(new GridLayout(0, 2, 40, 0));

		Player_1 = new JPanel();
		Player_1.setOpaque(false);
		nombres.add(Player_1);
		Player_1.setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		panel.setOpaque(false);
		Player_1.add(panel);

		lblNewLabel_1 = new JLabel("Player 1");
		lblNewLabel_1.setFont(Estilos.FUENTE_LETRA_MENOR);
		lblNewLabel_1.setForeground(Estilos.COLOR_LETRAS);
		panel.add(lblNewLabel_1);

		nombreJugador1 = new JTextField();
		nombreJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador1.setPreferredSize(new Dimension(175, 50));
		panel.add(nombreJugador1);

		Color_1 = new JPanel();
		Color_1.setOpaque(false);
		Player_1.add(Color_1);
		Color_1.setLayout(new GridLayout(0, 3, 0, 0));

		Rojo1 = new JRadioButton("Rojo");
		Rojo1.setOpaque(false);
		Color_1.add(Rojo1);

		Negro1 = new JRadioButton("Negro");
		Negro1.setOpaque(false);
		Color_1.add(Negro1);

		Blanco1 = new JRadioButton("Blanco");
		Blanco1.setOpaque(false);
		Color_1.add(Blanco1);

		Verde1 = new JRadioButton("Verde");
		Verde1.setOpaque(false);
		Color_1.add(Verde1);

		Azul1 = new JRadioButton("Azul");
		Azul1.setOpaque(false);
		Color_1.add(Azul1);

		Amarillo1 = new JRadioButton("Amarillo");
		Amarillo1.setOpaque(false);
		Color_1.add(Amarillo1);

		color1 = new JPanel();
		color1.setOpaque(false);
		Player_1.add(color1);

		imagenColor1 = new JLabel();
		imagenColor1.setPreferredSize(new Dimension(120, 120));

		imagenColor2 = new JLabel();
		imagenColor2.setPreferredSize(new Dimension(120, 120));

		imagenRojo = new ImageIcon("resourses\\Red.png");
		imagenNegro = new ImageIcon("resourses\\Black.png");
		imagenBlanco = new ImageIcon("resourses\\White.png");
		imagenVerde = new ImageIcon("resourses\\Green.png");
		imagenAzul = new ImageIcon("resourses\\Blue.png");
		imagenAmarillo = new ImageIcon("resourses\\Yellow.png");

		color1.add(imagenColor1);

		Player_2 = new JPanel();
		Player_2.setOpaque(false);
		nombres.add(Player_2);
		Player_2.setLayout(new GridLayout(0, 1, 0, 0));

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		Player_2.add(panel_1);

		lblNewLabel_2 = new JLabel("Player 2");
		lblNewLabel_2.setFont(Estilos.FUENTE_LETRA_MENOR);
		lblNewLabel_2.setForeground(Estilos.COLOR_LETRAS);
		panel_1.add(lblNewLabel_2);

		nombreJugador2 = new JTextField();
		nombreJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador2.setPreferredSize(new Dimension(175, 50));

		panel_1.add(nombreJugador2, BorderLayout.CENTER);

		Color_2 = new JPanel();
		Color_2.setOpaque(false);
		Player_2.add(Color_2);
		Color_2.setLayout(new GridLayout(0, 3, 0, 0));

		Rojo2 = new JRadioButton("Rojo");
		Rojo2.setOpaque(false);
		Color_2.add(Rojo2);

		Blanco2 = new JRadioButton("Blanco");
		Blanco2.setOpaque(false);
		Color_2.add(Blanco2);

		Negro2 = new JRadioButton("Negro");
		Negro2.setOpaque(false);
		Color_2.add(Negro2);

		Verde2 = new JRadioButton("Verde");
		Verde2.setOpaque(false);
		Color_2.add(Verde2);

		Amarillo2 = new JRadioButton("Amarillo");
		Amarillo2.setOpaque(false);
		Color_2.add(Amarillo2);

		Azul2 = new JRadioButton("Azul");
		Azul2.setOpaque(false);
		Color_2.add(Azul2);

		color2_1 = new JPanel();
		color2_1.setOpaque(false);
		color2_1.add(imagenColor2);
		Player_2.add(color2_1);
		coloresJ1 = new ButtonGroup();
		coloresJ2 = new ButtonGroup();

		coloresJ1.add(Verde1);
		coloresJ1.add(Azul1);
		coloresJ1.add(Rojo1);
		coloresJ1.add(Amarillo1);
		coloresJ1.add(Negro1);
		coloresJ1.add(Blanco1);

		coloresJ2.add(Verde2);
		coloresJ2.add(Azul2);
		coloresJ2.add(Rojo2);
		coloresJ2.add(Amarillo2);
		coloresJ2.add(Negro2);
		coloresJ2.add(Blanco2);

		Configuracion = new JPanel();
		Configuracion.setOpaque(false);
		// Crear el borde con el nuevo estilo y color
		TitledBorder borde_1 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.WHITE), "Configuracion",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
		Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_1));
		cambio = new ButtonGroup();

		Configuracion.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		Configuracion.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 20));

		numCasillas = new JLabel(" Porcentaje Casillas Especiales");
		numCasillas.setFont(Estilos.FUENTE_LETRA_MENOR_2);
		numCasillas.setForeground(Estilos.COLOR_LETRAS);
		panel_2.add(numCasillas);
		porcentajeCasillas = new JTextField();
		porcentajeCasillas.setHorizontalAlignment(SwingConstants.CENTER);
		porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
		panel_2.add(porcentajeCasillas);

		numBonificadores = new JLabel(" Porcentaje Bonificadores");
		numBonificadores.setFont(Estilos.FUENTE_LETRA_MENOR_1);
		numBonificadores.setForeground(Estilos.COLOR_LETRAS);
		panel_2.add(numBonificadores);
		porcentajeModificadores = new JTextField();
		porcentajeModificadores.setHorizontalAlignment(SwingConstants.CENTER);
		porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
		panel_2.add(porcentajeModificadores);

		numBonificadores_1 = new JLabel(" Tamaño Tablero");
		numBonificadores_1.setFont(Estilos.FUENTE_LETRA_MENOR);
		numBonificadores_1.setForeground(Estilos.COLOR_LETRAS);
		panel_2.add(numBonificadores_1);
		sizeTablero = new JTextField();
		sizeTablero.setHorizontalAlignment(SwingConstants.CENTER);
		porcentajeCasillas.setPreferredSize(new Dimension(175, 50));
		panel_2.add(sizeTablero);

		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		Configuracion.add(panel_3);

		pantallaCarga.setLayout(new GridLayout(1, 2));
		pantallaCarga.add(nombres);
		pantallaCarga.add(Configuracion);

		getContentPane().add(pantallaCarga);
	}

	/**
	 * Prepare all the button's actions
	 */
	public void prepareActions() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener Cerrar = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(Cerrar);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		cambioEsSer = new JLabel("¿Quiere que las escaleras y serpientes puedan cambiar?");
		cambioEsSer.setHorizontalAlignment(SwingConstants.CENTER);
		cambioEsSer.setFont(Estilos.FUENTE_LETRA_MENOR_1);
		panel_4.add(cambioEsSer);

		panel_4_1 = new JPanel();
		panel_4_1.setOpaque(false);
		panel_4.add(panel_4_1);
		cambioT = new JRadioButton("Si");
		cambioT.setFont(Estilos.FUENTE_LETRA_MENOR);
		cambioT.setOpaque(false);
		panel_4_1.add(cambioT);
		cambio.add(cambioT);
		cambioF = new JRadioButton("No");
		cambioF.setFont(Estilos.FUENTE_LETRA_MENOR);
		cambioF.setOpaque(false);
		panel_4_1.add(cambioF);
		cambio.add(cambioF);

		Amarillo1.addActionListener(e -> checkBox());
		Azul1.addActionListener(e -> checkBox());
		Blanco1.addActionListener(e -> checkBox());
		Negro1.addActionListener(e -> checkBox());
		Rojo1.addActionListener(e -> checkBox());
		Verde1.addActionListener(e -> checkBox());
		Amarillo2.addActionListener(e -> checkBox());
		Azul2.addActionListener(e -> checkBox());
		Blanco2.addActionListener(e -> checkBox());
		Negro2.addActionListener(e -> checkBox());
		Rojo2.addActionListener(e -> checkBox());
		Verde2.addActionListener(e -> checkBox());

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_3.add(panel_2);
		jugar.setFont(Estilos.FUENTE_LETRA);
		jugar.setBackground(Color.WHITE);
		panel_2.add(jugar);
		jugar.addActionListener(e -> {
			try {
				empezarJuego();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		});
	}

	/**
	 * Verify which of the JRadiumButtons are selected and save its message.
	 */
	private void checkBox() {
		if (Azul1.isSelected()) {
			color = "blue";
			Azul2.setEnabled(false);
			Amarillo2.setEnabled(true);
			Negro2.setEnabled(true);
			Blanco2.setEnabled(true);
			Rojo2.setEnabled(true);
			Verde2.setEnabled(true);
			imagenColor1.setIcon(imagenAzul);
		}
		if (Blanco1.isSelected()) {
			color = "white";
			Azul2.setEnabled(true);
			Amarillo2.setEnabled(true);
			Negro2.setEnabled(true);
			Blanco2.setEnabled(false);
			Rojo2.setEnabled(true);
			Verde2.setEnabled(true);
			imagenColor1.setIcon(imagenBlanco);
		}
		if (Amarillo1.isSelected()) {
			color = "yellow";
			Azul2.setEnabled(true);
			Amarillo2.setEnabled(false);
			Negro2.setEnabled(true);
			Blanco2.setEnabled(true);
			Rojo2.setEnabled(true);
			Verde2.setEnabled(true);
			imagenColor1.setIcon(imagenAmarillo);
		}
		if (Verde1.isSelected()) {
			color = "green";
			Azul2.setEnabled(true);
			Amarillo2.setEnabled(true);
			Negro2.setEnabled(true);
			Blanco2.setEnabled(true);
			Rojo2.setEnabled(true);
			Verde2.setEnabled(false);
			imagenColor1.setIcon(imagenVerde);
		}
		if (Negro1.isSelected()) {
			color = "black";
			Azul2.setEnabled(true);
			Amarillo2.setEnabled(true);
			Negro2.setEnabled(false);
			Blanco2.setEnabled(true);
			Rojo2.setEnabled(true);
			Verde2.setEnabled(true);
			imagenColor1.setIcon(imagenNegro);
		}
		if (Rojo1.isSelected()) {
			color2 = "red";
			Azul2.setEnabled(true);
			Amarillo2.setEnabled(true);
			Negro2.setEnabled(true);
			Blanco2.setEnabled(true);
			Rojo2.setEnabled(false);
			Verde2.setEnabled(true);
			imagenColor1.setIcon(imagenRojo);
		}
		if (Azul2.isSelected()) {
			color2 = "blue";
			Azul1.setEnabled(false);
			Amarillo1.setEnabled(true);
			Negro1.setEnabled(true);
			Blanco1.setEnabled(true);
			Rojo1.setEnabled(true);
			Verde1.setEnabled(true);
			imagenColor2.setIcon(imagenAzul);
		}
		if (Blanco2.isSelected()) {
			color2 = "white";
			Azul1.setEnabled(true);
			Amarillo1.setEnabled(true);
			Negro1.setEnabled(true);
			Blanco1.setEnabled(false);
			Rojo1.setEnabled(true);
			Verde1.setEnabled(true);
			imagenColor2.setIcon(imagenBlanco);
		}
		if (Amarillo2.isSelected()) {
			color2 = "yellow";
			Azul1.setEnabled(true);
			Amarillo1.setEnabled(false);
			Negro1.setEnabled(true);
			Blanco1.setEnabled(true);
			Rojo1.setEnabled(true);
			Verde1.setEnabled(true);
			imagenColor2.setIcon(imagenAmarillo);
		}
		if (Verde2.isSelected()) {
			color2 = "green";
			Azul1.setEnabled(true);
			Amarillo1.setEnabled(true);
			Negro1.setEnabled(true);
			Blanco1.setEnabled(true);
			Rojo1.setEnabled(true);
			Verde1.setEnabled(false);
			imagenColor2.setIcon(imagenVerde);
		}
		if (Negro2.isSelected()) {
			color2 = "black";
			Azul1.setEnabled(true);
			Amarillo1.setEnabled(true);
			Negro1.setEnabled(false);
			Blanco1.setEnabled(true);
			Rojo1.setEnabled(true);
			Verde1.setEnabled(true);
			imagenColor2.setIcon(imagenNegro);
		}
		if (Rojo2.isSelected()) {
			color2 = "red";
			Azul1.setEnabled(true);
			Amarillo1.setEnabled(true);
			Negro1.setEnabled(true);
			Blanco1.setEnabled(true);
			Rojo1.setEnabled(false);
			Verde1.setEnabled(true);
			imagenColor2.setIcon(imagenRojo);

		}
		if (cambioT.isSelected()) {
			cambioES = true;
		} else if (cambioF.isSelected()) {
			cambioES = false;
		}
	}

	/**
	 * Let me verify if the user bring the less parameters to start the game.
	 * 
	 * @throws PoobStairsExceptions If the user put a bad number or doesn't put all
	 *                              not filled in the necessary fields.
	 */
	private void empezarJuego() throws PoobStairsExceptions {
		if (!nombreJugador1.getText().isEmpty() && !nombreJugador2.getText().isEmpty() && color != null
				&& color2 != null) {
			try {
				String nombre = nombreJugador1.getText();
				String maquina = "DaPooInteligancia01";
				int porCasillas, porBonificacion, size;
				if (porcentajeCasillas.getText().isEmpty()) {
					porCasillas = 0;
				} else {
					porCasillas = Integer.parseInt(porcentajeCasillas.getText());
				}
				if (porcentajeModificadores.getText().isEmpty()) {
					porBonificacion = 0;
				} else {
					porBonificacion = Integer.parseInt(porcentajeCasillas.getText());
				}
				if (sizeTablero.getText().isEmpty()) {
					size = 10;
				} else {
					size = Integer.parseInt(porcentajeCasillas.getText());
				}
				TableGUI tablero = new TableGUI(nombre, maquina, porCasillas, porBonificacion, size, cambioES, color,
						color2);
				tablero.setVisible(true);
				this.dispose();
			} catch (NumberFormatException e) {
				throw new PoobStairsExceptions(PoobStairsExceptions.BAD_PERCENTAGE);
			}
		} else if (nombreJugador1.getText().isEmpty() || color == null || nombreJugador2.getText().isEmpty()
				|| color2 == null) {
			throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
		}
	}
}
