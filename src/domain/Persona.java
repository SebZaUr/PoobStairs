package domain;

public class Persona extends Player {

	public Persona(String color) {
		piece = "resourses\\" + color + ".png";
	}

	@Override
	public void tookDesicion(String desicion) {
		throw new UnsupportedOperationException("Unimplemented method 'tookDesicion'");
	}

}
