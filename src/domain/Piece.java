package domain;

public class Piece {
    private int position;
    private String color;

    public Piece(String color) {
        this.color = color;
    }

    public int move(int movement) {
        this.position += movement;
        return this.position;
    }

    public int getPosition() {
        return this.position;
    }
}