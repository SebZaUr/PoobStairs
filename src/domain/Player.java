package domain;

public class Player {
    private Piece pieza;
    private int positions, lastPosition;
    private int fallSnake = 0;
    private int fallStairs = 0;
    private int bonificadores = 0;
    private boolean inTurn = false;
    private boolean question = false;

    public Player(String color, int size) {
        this.pieza = new Piece(color);
    }

    public boolean getTurn() {
        return inTurn;
    }

    public void setTurn(boolean turn) {
        this.inTurn = turn;
    }

    public int move(int value, int size) {
        if (lastPosition + positions > (size * size)) {
            value = 0;
        } else {
            lastPosition += positions;
            positions += value;
        }
        return pieza.move(value);
    }

    public int getPosition() {
        return pieza.getPosition();
    }

    public void fallsLadders() {
        fallStairs++;
    }

    public void fallsSnakes() {
        fallSnake++;
    }

    public String snake() {
        return Integer.toString(fallSnake);
    }

    public String stairs() {
        return Integer.toString(fallStairs);
    }

    public void setBonificadores() {
        bonificadores++;
    }

    public String getBonificadores() {
        return Integer.toString(bonificadores);
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public void setQuestion(boolean value) {
        this.question = value;
    }

    public boolean hasQuestion() {
        return question;
    }
}