package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.PoobStairsExceptions;

public class prueba extends JDialog {

	private final JButton jugar = new JButton("Empezar a Jugar");
	private JTextField porcentajeCasillas, porcentajeModificadores, sizeTablero;
	private JRadioButton cambioT, cambioF;
	private ButtonGroup coloresJ1, coloresJ2, cambio;
	private String modoMaquina, color, color2;
	private final int width = Estilos.dimensions.width / 2;
	private final int heigth = Estilos.dimensions.height / 2;
	private static boolean cambioES = false;
	private JPanel Player_2 ;
	private JTextField nombreJugador2;
	private JLabel colorJ2,lblNombre, lblNombre_2;
	private JPanel color2_1;
	private JPanel Player_1;
	private JLabel jugador;
	private JLabel lblNombre_1;
	private JTextField nombreJugador1;
	private JLabel colorJ1;
	private JPanel color1;
	private JPanel Color_1;
	private JRadioButton Rojo1;
	private JRadioButton Negro1;
	private JRadioButton Blanco1;
	private JRadioButton Verde1;
	private JRadioButton Azul1;
	private JRadioButton Amarillo1;
	private JPanel Color_2;
	private JRadioButton Rojo2;
	private JRadioButton Blanco2;
	private JRadioButton Negro2;
	private JRadioButton Verde2;
	private JRadioButton Amarillo2;
	private JRadioButton Azul2;
	private JLabel lblNewLabel, lblNewLabel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba window = new prueba();
					window.setVisible(true);
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
		setIconImage(Estilos.icono.getImage());
		setTitle(Estilos.TITULO);
		setSize(width, heigth);
		
	    prepareElements();
	    prepareActions();
	    
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	public void prepareElements() {

		JPanel pantallaCarga = Estilos.GradientPanel();
		pantallaCarga.setOpaque(false);
		pantallaCarga.setLayout(null);

		JPanel Configuracion = new JPanel();
		Configuracion.setLayout(null);
		Configuracion.setOpaque(false);
		// Crear el borde con el nuevo estilo y color
        TitledBorder borde_1 = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE), "Configuracion",
            TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
            Estilos.FUENTE_LETRA, Estilos.COLOR_LETRAS);
		Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_1));
		Configuracion.setFont(getFont());

		JPanel nombres = new JPanel();
		nombres.setOpaque(false);
		// Crear el borde con el nuevo estilo y color
        TitledBorder borde_2 = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE), "Ingresen Datos",
            TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
            Estilos.FUENTE_TITULO, Estilos.COLOR_LETRAS);
		nombres.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), borde_2));
		nombres.setLayout(new GridLayout(0, 2, 30, 0));
		coloresJ1 = new ButtonGroup();
		coloresJ2 = new ButtonGroup();

		Player_1 = new JPanel();
		Player_1.setOpaque(false);
		nombres.add(Player_1);
		Player_1.setLayout(new GridLayout(0, 1, 0, 20));

		jugador = new JLabel(" JUGADOR 1");
		jugador.setForeground(Estilos.COLOR_LETRAS);
		jugador.setFont(Estilos.FUENTE_LETRA_MENOR);
		Player_1.add(jugador);

		lblNombre_1 = new JLabel(" Nombre");
		lblNombre_1.setForeground(Estilos.COLOR_LETRAS);
		lblNombre_1.setFont(Estilos.FUENTE_LETRA_MENOR);
		Player_1.add(lblNombre_1);

		nombreJugador1 = new JTextField("Nombre Jugador 1");
		Player_1.add(nombreJugador1);

		colorJ1 = new JLabel(" Color");
		colorJ1.setForeground(Estilos.COLOR_LETRAS);
		colorJ1.setFont(Estilos.FUENTE_LETRA_MENOR);
		Player_1.add(colorJ1);

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

		lblNewLabel = new JLabel("Imagen");
		color1.add(lblNewLabel);

		Player_2 = new JPanel();
		Player_2.setOpaque(false);
		nombres.add(Player_2);
		Player_2.setLayout(new GridLayout(0, 1, 0, 20));

		lblNombre = new JLabel(" JUGADOR 2");
		lblNombre.setForeground(Estilos.COLOR_LETRAS);
		lblNombre.setFont(Estilos.FUENTE_LETRA_MENOR);
		Player_2.add(lblNombre);

		lblNombre_2 = new JLabel(" Nombre");
		lblNombre_2.setForeground(Estilos.COLOR_LETRAS);
		lblNombre_2.setFont(Estilos.FUENTE_LETRA_MENOR);
		Player_2.add(lblNombre_2);

		nombreJugador2 = new JTextField("Nombre Jugador 2");
		Player_2.add(nombreJugador2);

		colorJ2 = new JLabel(" Color");
		colorJ2.setForeground(Estilos.COLOR_LETRAS);
		colorJ2.setFont(Estilos.FUENTE_LETRA_MENOR);
		colorJ2.setOpaque(false);
		Player_2.add(colorJ2);

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
		lblNewLabel2 = new JLabel("Imagen");
		color2_1.add(lblNewLabel2);
		Player_2.add(color2_1);
		coloresJ1 = new ButtonGroup();
		coloresJ2 = new ButtonGroup();

		jugar.setBounds(width / 4 - 100, heigth - 100, 200, 50);

		JLabel numCasillas = new JLabel("Ingrese el porcentaje de casillas especiales");
		numCasillas.setBounds(50, 20, 250, 20);
		porcentajeCasillas = new JTextField();
		porcentajeCasillas.setBounds(width / 4 + 100, 20, 50, 20);
		JLabel numBonificadores = new JLabel("Ingrese el porcentaje de bonificadores");
		numBonificadores.setBounds(50, 100, 250, 20);
		porcentajeModificadores = new JTextField();
		porcentajeModificadores.setBounds(width / 4 + 100, 100, 50, 20);
		JLabel size = new JLabel("Ingrese el tamaño del tablero");
		size.setBounds(50, 150, 200, 20);
		sizeTablero = new JTextField();
		sizeTablero.setBounds(width / 4 + 100, 150, 50, 20);
		JLabel cambioEsSer = new JLabel("¿Quiere que las escaleras y serpientes puedan cambiar?");
		cambioEsSer.setBounds(50, 200, 350, 20);
		cambio = new ButtonGroup();
		cambioT = new JRadioButton("Si");
		cambioT.setBounds(width / 4 - 100, 250, 40, 20);
		cambioF = new JRadioButton("No");
		cambioF.setBounds(width / 4 + 100, 250, 40, 20);
		cambio.add(cambioF);
		cambio.add(cambioT);
		
		coloresJ1.add(Verde1);
		coloresJ1.add(Azul1);
		coloresJ1.add(Rojo1);
		coloresJ1.add(Amarillo1);
		coloresJ1.add(Negro1);
		coloresJ1.add(Blanco1);
		
		coloresJ1.add(Verde2);
		coloresJ1.add(Azul2);
		coloresJ1.add(Rojo2);
		coloresJ1.add(Amarillo2);
		coloresJ1.add(Negro2);
		coloresJ1.add(Blanco2);

		Configuracion.add(numCasillas);
		Configuracion.add(numBonificadores);
		Configuracion.add(porcentajeCasillas);
		Configuracion.add(porcentajeModificadores);
		Configuracion.add(cambioT);
		Configuracion.add(cambioF);
		Configuracion.add(cambioEsSer);
		Configuracion.add(jugar);

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
			image= "./resourses/Blue.png"
		} else if (Blanco1.isSelected()) {
			color = "white";
		} else if (Amarillo1.isSelected()) {
			color = "yellow";
		} else if (Verde1.isSelected()) {
			color = "green";
		} else if (Negro1.isSelected()) {
			color = "black";
		} else if (Rojo1.isSelected()) {
			color2 = "red";
		}
		if (Azul2.isSelected()) {
			color2 = "blue";
		} else if (Blanco2.isSelected()) {
			color2 = "white";
		} else if (Amarillo1.isSelected()) {
			color2 = "yellow";
		} else if (Verde1.isSelected()) {
			color2 = "green";
		} else if (Negro1.isSelected()) {
			color2 = "black";
		} else if (Rojo1.isSelected()) {
			color2 = "red";
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
				&& color2 != null && modoMaquina != null) {
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
					size = 0;
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
		} else if (nombreJugador1.getText().isEmpty() || color == null || modoMaquina == null
				|| nombreJugador2.getText().isEmpty() || color2 == null) {
			throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
		}
	}

}
