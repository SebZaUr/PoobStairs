package presentation;

import javax.swing.ImageIcon;
import java.util.Random;

public class DadoGUI {
    private ImageIcon imagen;
    private int puntos;

    public DadoGUI() {
        Random num = new Random();
        puntos = num.nextInt(6) + 1;
        chooseImage(puntos);
    }

    private void chooseImage(int puntos) {
        switch (puntos) {
            case 1:
                imagen = new ImageIcon("resourses\\dado_1.png");
                break;
            case 2:
                imagen = new ImageIcon("resourses\\dado_2.png");
                break;
            case 3:
                imagen = new ImageIcon("resourses\\dado_3.png");
                break;
            case 4:
                imagen = new ImageIcon("resourses\\dado_4.png");
                break;
            case 5:
                imagen = new ImageIcon("resourses\\dado_5.png");
                break;
            case 6:
                imagen = new ImageIcon("resourses\\dado_6.png");
                break;
            default:
                break;
        }
    }

    public ImageIcon getImagen(){
        return imagen;
    }
    public int getPoints(){
        return puntos;
    }
}