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
 *@version 1.3
 */
public class ConfigJugador extends JDialog {

    private final JButton jugar = new JButton("Empezar a Jugar");
    private JTextField nombreJugador1, nombreJugador2,porcentajeCasillas,porcentajeModificadores,sizetablero;
    private JRadioButton Rojo1,Negro1,Azul1,Amarillo1,Verde1,Blanco1,Rojo2,Negro2,Azul2,Amarillo2,Verde2,Blanco2;
    private ButtonGroup coloresJ1,coloresJ2;
    private String tipo,tipoCasilla;
    private final int width = Estilos.dimensions.width/2;
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
        JPanel Datos = new JPanel();
        Datos.setLayout(new GridLayout(1, 2));
        Datos.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Ingresen Datos")));

        JPanel Configuracion = new JPanel();
        Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Configuracion")));
        
        JPanel nombres = new JPanel();
        nombres.setLayout(null);
        JLabel jugador = new JLabel("Ingrese Su Nombre Jugador 1:");
        jugador.setBounds(10, 20, 200, 20);
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(width/4, 30, 100, 20);
        JLabel jugador2 = new JLabel("Ingrese Su Nombre Jugador 2:");
        jugador2.setBounds(10, 60, 200, 20);
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(width/4, 70, 100, 20);
        nombres.add(jugador);
        nombres.add(jugador2);
        nombres.add(nombreJugador1);
        nombres.add(nombreJugador2);


        JLabel colorJ1 = new JLabel("Color jugador 1:");
        JLabel colorJ2 = new JLabel("Color jugador 2:");
        coloresJ1 = new ButtonGroup();
        coloresJ2 = new ButtonGroup();
        colorJ1.setBounds(10,100,100,20);
        colorJ2.setBounds(width/4,100,100,20);
        Rojo1 = new JRadioButton("Rojo");
        Rojo1.setBounds(10, 150, 60, 30);
        coloresJ1.add(Rojo1);
        Blanco1 = new JRadioButton("Blanco");
        Blanco1.setBounds(10, 180, 60, 30);
        coloresJ1.add(Blanco1);
        Negro1 = new JRadioButton("Negro");
        Negro1.setBounds(10, 210, 60, 30);
        coloresJ1.add(Negro1);
        Verde1 = new JRadioButton("Verde");
        Verde1.setBounds(10, 240, 60, 30);
        coloresJ1.add(Verde1);
        Amarillo1 = new JRadioButton("Amarillo");
        Amarillo1.setBounds(10, 270, 60, 30);
        coloresJ1.add(Amarillo1);
        Azul1 = new JRadioButton("Azul");
        Azul1.setBounds(10, 300, 60, 30);
        coloresJ1.add(Azul1);
        Rojo2 = new JRadioButton("Rojo");
        Rojo2.setBounds(width/4, 150, 60, 30);
        coloresJ2.add(Rojo2);
        Blanco2 = new JRadioButton("Blanco");
        Blanco2.setBounds(width/4, 180, 60, 30);
        coloresJ2.add(Blanco2);
        Negro2 = new JRadioButton("Negro");
        Negro2.setBounds(width/4, 210, 60, 30);
        coloresJ2.add(Negro2);
        Verde2 = new JRadioButton("Verde");
        Verde2.setBounds(width/4, 240, 60, 30);
        coloresJ2.add(Verde2);
        Amarillo2 = new JRadioButton("Amarillo");
        Amarillo2.setBounds(width/4, 270, 60, 30);
        coloresJ2.add(Amarillo2);
        Azul2 = new JRadioButton("Azul");
        Azul2.setBounds(width/4, 300, 60, 30);
        coloresJ2.add(Azul2);
    
        nombres.add(Rojo1);
        nombres.add(Rojo2);
        nombres.add(Verde1);
        nombres.add(Verde2);
        nombres.add(Negro1);
        nombres.add(Negro2);
        nombres.add(Amarillo1);
        nombres.add(Amarillo2);
        nombres.add(Blanco1);
        nombres.add(Blanco2);
        nombres.add(Azul1);
        nombres.add(Azul2);
        nombres.add(colorJ1);
        nombres.add(colorJ2);
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

        nombres.add(jugar);
        pantallaCarga.setLayout(new GridLayout(1,1));
        pantallaCarga.add(nombres);

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
        jugar.addActionListener(e -> {
            try {
                empezarJuego();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage());
            }
        });
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
