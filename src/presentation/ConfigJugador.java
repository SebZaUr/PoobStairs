package presentation;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.PoobStairsExceptions;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Me crea la pantalla de configuracion para jugar contra un jugador
 * @author Sebastian Zamora Urrego.
 * @author Johann Amaya Lopez.
 *@version 1.0.
 */
public class ConfigJugador extends JDialog {

    
    private final JRadioButton normal = new JRadioButton("Normal");
    private final JRadioButton quicktime = new JRadioButton("Quicktime");
    private final JRadioButton relampago = new JRadioButton("Relampago");
    private final JRadioButton permanente = new JRadioButton("Permanente");
    private final JButton jugar = new JButton("Empezar a Jugar");
    private JTextField nombreJugador1, nombreJugador2,porcentaje;
    private String tipo,tipoCasilla;
    private final int width = Estilos.dimensions.width/4;
    private final int heigth = Estilos.dimensions.height/2; 
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
        setVisible(true);
    }

    /**
     * Me preparea los elementos de la pantalla de configuracion
     */
    public void prepareElements(){
        JPanel pantallaCarga = new JPanel();
        JPanel ingresarNombre = new JPanel();
        ingresarNombre.setLayout(new GridLayout(1, 2));

        JPanel panelFichas = new JPanel();
        panelFichas.setBorder(
                new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Configuracion")));
        
        JLabel jugador = new JLabel("Ingrese Su Nombre Jugador 1:");
        jugador.setBounds(width/2-170, 20, 200, 50);
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(width/2+10, 30, 180, 30);
        JLabel jugador2 = new JLabel("Ingrese Su Nombre Jugador 2:");
        jugador2.setBounds(width/2-170, 60, 180, 30);
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(width/2+10, 70, 180, 30);
        jugar.setBounds(width/2-100, heigth-100, 200, 50);
        /* 
        JLabel casillas = new JLabel("Visualización de casillas:");
        casillas.setBounds(20, 150, 200, 50);
        permanente.setBounds(50, 175, 100, 50);
        relampago.setBounds(200, 175, 100, 50);
        JLabel modos = new JLabel("Modo de Juego:");
        modos.setBounds(20, 200, 200, 50);
        normal.setBounds(50, 225, 100, 50);
        quicktime.setBounds(200, 225, 100, 50);
        JLabel pregunta = new JLabel("Digite el porcentade de casillas especiales:");
        pregunta.setBounds(20,275,300,50);
        porcentaje = new JTextField();
        porcentaje.setBounds(300,285,40,20);
        jugar.setBounds(75, 350, 200, 50);
        



        
        panelFichas.add(jugador);
        panelFichas.add(nombreJugador1);
        panelFichas.add(casillas);
        panelFichas.add(relampago);
        panelFichas.add(permanente);
        panelFichas.add(jugar);
        panelFichas.add(nombreJugador2);
        panelFichas.add(jugador2);
        panelFichas.add(normal);
        panelFichas.add(quicktime);
        panelFichas.add(modos);
        panelFichas.add(porcentaje);
        panelFichas.add(pregunta);

        ButtonGroup modosJuego = new ButtonGroup();
        modosJuego.add(normal);
        modosJuego.add(quicktime);
        

        ButtonGroup tipoCasillas = new ButtonGroup();
        tipoCasillas.add(permanente);
        tipoCasillas.add(relampago);*/

        panelFichas.setLayout(null);
        panelFichas.add(jugador);
        panelFichas.add(nombreJugador1);
        panelFichas.add(nombreJugador2);
        panelFichas.add(jugador2);
        panelFichas.add(jugar);
        pantallaCarga.setLayout(new GridLayout(1,1));
        pantallaCarga.add(panelFichas);

        add(pantallaCarga);
    }

    /**
     * Me prepara las acciones de la pantalla de configuracion.
     */
    public void prepareActions(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        };
        this.addWindowListener(Cerrar);
        normal.addActionListener(e -> checkBox());
        quicktime.addActionListener(e -> checkBox());
        permanente.addActionListener(e -> checkBox());
        relampago.addActionListener(e -> checkBox());
        jugar.addActionListener(e -> {
            try {
                empezarJuego();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage());
            }
        });
    }

    /**
     * Me atrapa cada click sobre los JRadioButton.
     */
    private void checkBox(){
        if (normal.isSelected()) {
            tipo = "normal";
        }
        if (quicktime.isSelected()) {
            tipo = "quicktime";
        }if (permanente.isSelected()) {
        	tipoCasilla = "permanente";
        }
        if (relampago.isSelected()) {
            tipoCasilla = "relampago";
        }
    }

    /**
     * Me valida que el usuario halla llenado toda la informacion necesaria
     * @throws PoobStairsExceptions
     */
    private void empezarJuego() throws PoobStairsExceptions {
    	if (!nombreJugador2.getText().isEmpty() && !nombreJugador1.getText().isEmpty()){
            try{
                String nombre = nombreJugador1.getText();
                String nombre2 = nombreJugador2.getText();
                TableGUI tablero = new TableGUI(nombre,nombre2);
                tablero.setVisible(true);
                this.dispose();
            }catch(NumberFormatException e){
                //throw new DamasException(DamasException.BAD_PERCENTAGE);
            }
        }else if ( nombreJugador2.getText().isEmpty()  || nombreJugador1.getText().isEmpty() || tipo != null || tipoCasilla != null) {
            throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
        }
    }
}
