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
 * Let me type my name and select all the different characteristics of the game. 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.2
 *
 */
public class ConfigMaquina extends JDialog {
    private JTextField nombreJugador1,porcentajeCasillas,porcentajeModificadores,sizeTablero;
    private JRadioButton Rojo1,Negro1,Azul1,Amarillo1,Verde1,Blanco1,cambioT,cambioF,principiante,aprendiz;
    private ButtonGroup coloresJ1,cambio,maquina;
    private final int width = Estilos.dimensions.width/2;
    private final int heigth = Estilos.dimensions.height/2; 

    private final JButton jugar = new JButton("Empezar a Jugar");
    private String modoMaquina,color,color2;
    private boolean cambioES = false;

    public ConfigMaquina(){
    	setIconImage(Estilos.icono.getImage());
    	setTitle(Estilos.TITULO);
        setSize(width,heigth);
        prepareElements();
        prepareActions();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Create all visuas elements
     */
    public void prepareElements(){
        JPanel pantallaCarga = new JPanel();
        JPanel ingresarNombre = new JPanel();
        ingresarNombre.setLayout(null);
        ingresarNombre.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Ingresar Datos")));


        JPanel Configuracion = new JPanel();
        Configuracion.setLayout(null);
        Configuracion.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Configuracion")));

       
        JLabel jugador = new JLabel("Ingrese Su Nombre:");
        jugador.setBounds(50, 40, 150, 50);
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(width/4, 50, 180, 30);

        JLabel colorJ1 = new JLabel("Color jugador 1:");
        coloresJ1 = new ButtonGroup();
        colorJ1.setBounds(10,100,100,20);
        Rojo1 = new JRadioButton("Rojo");
        Rojo1.setBounds(50, 150, 60, 30);
        coloresJ1.add(Rojo1);
        Blanco1 = new JRadioButton("Blanco");
        Blanco1.setBounds(width/4-50, 150, 100, 30);
        coloresJ1.add(Blanco1);
        Negro1 = new JRadioButton("Negro");
        Negro1.setBounds(50, 210, 60, 30);
        coloresJ1.add(Negro1);
        Verde1 = new JRadioButton("Verde");
        Verde1.setBounds(width/4+150, 150, 60, 30);
        coloresJ1.add(Verde1);
        Amarillo1 = new JRadioButton("Amarillo");
        Amarillo1.setBounds(width/4 -50, 210, 60, 30);
        coloresJ1.add(Amarillo1);
        Azul1 = new JRadioButton("Azul");
        Azul1.setBounds(width/4 +150, 210, 60, 30);
        coloresJ1.add(Azul1);
        JPanel color1 = new JPanel();
        color1.setBounds(width/4-200, heigth/2, 50, 50);
        JLabel tiposMaquina = new JLabel("Escoja la dificultad de la maquina");
        tiposMaquina.setBounds(50, heigth/2,200, 20);
        maquina = new ButtonGroup();
        principiante = new JRadioButton("Principiante");
        principiante.setBounds(width/4 -100, heigth/2 +50,100,20);
        aprendiz = new JRadioButton("Aprendiz");
        aprendiz.setBounds(width/4 +100, heigth/2 +50,100,20);
        maquina.add(aprendiz);
        maquina.add(principiante);
        ingresarNombre.add(colorJ1);
        ingresarNombre.add(Rojo1);
        ingresarNombre.add(Azul1);
        ingresarNombre.add(Blanco1);
        ingresarNombre.add(Verde1);
        ingresarNombre.add(Negro1);
        ingresarNombre.add(Amarillo1);
        ingresarNombre.add(tiposMaquina);
        ingresarNombre.add(principiante);
        ingresarNombre.add(aprendiz);
        
        JLabel numCasillas = new JLabel("Ingrese el porcentaje de casillas especiales");
        numCasillas.setBounds(50,20,250,20);
        porcentajeCasillas = new JTextField();
        porcentajeCasillas.setBounds(width/4 +100, 20, 50, 20);
        JLabel numBonificadores = new JLabel("Ingrese el porcentaje de bonificadores");
        numBonificadores.setBounds(50,100,250,20);
        porcentajeModificadores = new JTextField();
        porcentajeModificadores.setBounds(width/4 + 100, 100, 50, 20);
        JLabel size = new JLabel("Ingrese el tamaño del tablero");
        size.setBounds(50, 150, 200, 20);
        sizeTablero = new JTextField();
        sizeTablero.setBounds(width/4 + 100, 150,50,20);
        JLabel cambioEsSer = new JLabel("¿Quiere que las escaleras y serpientes puedan cambiar?");
        cambioEsSer.setBounds(50,200,350,20);
        cambio = new ButtonGroup();
        cambioT = new JRadioButton("Si");
        cambioT.setBounds(width/4-100, 250, 40, 20);
        cambioF = new JRadioButton("No");
        cambioF.setBounds(width/4+100, 250, 40, 20);
        cambio.add(cambioF);
        cambio.add(cambioT);
        jugar.setBounds(width/4-100, heigth-100, 200, 50);

        Configuracion.add(numCasillas);
        Configuracion.add(numBonificadores);
        Configuracion.add(porcentajeCasillas);
        Configuracion.add(porcentajeModificadores);
        Configuracion.add(cambioT);
        Configuracion.add(cambioF);
        Configuracion.add(cambioEsSer);
        Configuracion.add(jugar);

        ingresarNombre.setLayout(null);
        ingresarNombre.add(jugador);
        ingresarNombre.add(nombreJugador1);
        pantallaCarga.setLayout(new GridLayout(1, 2));
        pantallaCarga.add(ingresarNombre);
        pantallaCarga.add(Configuracion);

        add(pantallaCarga);
    }

    /**
     * Prepare all the button's actions
     */
    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        };
        this.addWindowListener(Cerrar);
        principiante.addActionListener(e -> checkBox());
        aprendiz.addActionListener(e -> checkBox());
        Rojo1.addActionListener(e -> checkBox());
        Azul1.addActionListener(e -> checkBox());
        Negro1.addActionListener(e -> checkBox());
        Amarillo1.addActionListener(e -> checkBox());
        Blanco1.addActionListener(e -> checkBox());
        Verde1.addActionListener(e -> checkBox());
        jugar.addActionListener(e -> {
            try {
                empezarJuego();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage());
            }
        });
    }

    /**
     * Verify which of the JRadiumButtons are selected and save its message.
     */
    private void checkBox(){
        if(Azul1.isSelected()){
            color = "blue";
        }
        else if(Blanco1.isSelected()){
            color = "white";
        }
        else if(Amarillo1.isSelected()){
            color = "yellow";
        }
        else if(Verde1.isSelected()){
            color = "green";
        }
        else if(Negro1.isSelected()){
            color = "black";
        }
        else if(Rojo1.isSelected()){
            color = "red";
        }
        if(principiante.isSelected()){
            modoMaquina = "principiante";
        }
        else if(aprendiz.isSelected()){
            modoMaquina = "aprendiz";
        }
        if(cambioT.isSelected()){
            cambioES = true;
        }
        else if(cambioF.isSelected()){
            cambioES = false;
        }
    }

    /**
     * Let me verify if the user bring the less parameters to start the game.
     * @throws PoobStairsExceptions	If the user put a bad number or doesn't put all not filled in the necessary fields.
     */
    private void empezarJuego() throws PoobStairsExceptions {
        if (!nombreJugador1.getText().isEmpty() && color != null && modoMaquina != null){
            try{
                String nombre = nombreJugador1.getText();
                String maquina = "DaPooInteligancia01";
                int porCasillas,porBonificacion,size;
                if(porcentajeCasillas.getText().isEmpty()){
                    porCasillas =0;
                }else{
                    porCasillas =Integer.parseInt(porcentajeCasillas.getText()) ;
                }
                if(porcentajeModificadores.getText().isEmpty()){
                    porBonificacion =0;
                }else{
                    porBonificacion =Integer.parseInt(porcentajeCasillas.getText()) ;
                }
                if(sizeTablero.getText().isEmpty()){
                    size =0;
                }else{
                    size =Integer.parseInt(porcentajeCasillas.getText()) ;
                }
                if(color != "negro") {
                	color2 = "blue";
                }else {
                	color2 = "black";
                }
                TableGUI tablero = new TableGUI(nombre,maquina,porCasillas,porBonificacion,size,cambioES,color,color2);
                tablero.setVisible(true);
                this.dispose();
            }catch(NumberFormatException e){
                throw new PoobStairsExceptions(PoobStairsExceptions.BAD_PERCENTAGE);
            }
        }else if ( nombreJugador1.getText().isEmpty() || color == null || modoMaquina == null) {
            throw new PoobStairsExceptions(PoobStairsExceptions.IS_EMPTY);
        }
    }
}
