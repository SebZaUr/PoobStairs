package presentation;

import javax.swing.ImageIcon;

/**
 * Let me choose the right piece to the player
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.0
 *
 */
public class PlayerGUI {
    private static ImageIcon imagen;

    /**
     * Let me choose the piece to play.
     * 
     * @param color the piece's color.
     */
    public PlayerGUI(String color) {
        switch (color) {
            case "blue":
                imagen = new ImageIcon("resourses\\Blue.png");
                break;
            case "black":
                imagen = new ImageIcon("resourses\\Black.png");
                break;
            case "white":
                imagen = new ImageIcon("resourses\\White.png");
                break;
            case "green":
                imagen = new ImageIcon("resourses\\Green.png");
                break;
            case "yellow":
                imagen = new ImageIcon("resourses\\Yellow.png");
                break;
            case "red":
                imagen = new ImageIcon("resourses\\Red.png");
                break;
            default:
                break;
        }
    }

    /**
     * Return the image of the piece.
     * 
     * @return the piece.
     */
    public ImageIcon getImage() {
        return imagen;
    }
}
