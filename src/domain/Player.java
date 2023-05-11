package domain;

public class Player {
    private String name;
    private Piece pieza;
    private boolean inTurn = false;

    public Player(String name, String color, int size) {
        this.name = name;
        this.pieza = new Piece(color);
    }

    public boolean getTurn() {
        return inTurn;
    }

    public void setTurn(boolean turn) {
        this.inTurn = turn;
    }

    public int move(int value) {
        return pieza.move(value);
    }

    public int getPosition() {
        return pieza.getPosition();
    }
}