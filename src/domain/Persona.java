package domain;

/**
 * Let me create the Persona Player
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.2
 */
public class Persona extends Player {

	/**
	 * Create the player
	 * 
	 * @param color the player's color
	 */
	public Persona(String color) {
		piece = "resourses\\" + color + ".png";
	}

	@Override
	public void tookDesicion(String desicion) {
	}

}
