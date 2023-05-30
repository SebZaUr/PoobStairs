package domain;

public abstract class Player {

	protected int position = 0;
	protected int lastPosition = 0;
	protected int fallSnake = 0;
	protected int fallLadders = 0;
	protected int modificadores = 0;
	protected boolean inTurn = false;
	protected boolean question = false;
	protected boolean answer = false;
	protected int bonificacion, penalizacion, cambio;
	protected String piece;

	public boolean getTurn() {
		return inTurn;
	}

	public void setTurn(boolean turn) {
		this.inTurn = turn;
	}

	public int move(int value, int size) {
		if (lastPosition + position > (size * size) || lastPosition + position < 0) {
			value = 0;
		} else {
			lastPosition += position;
			position += value;
		}
		return position;
	}

	public abstract void tookDesicion(String desicion);

	public int getPosition() {
		return position;
	}

	public void fallsLadders() {
		fallLadders++;
	}

	public void fallsSnakes() {
		fallSnake++;
	}

	public String snake() {
		return Integer.toString(fallSnake);
	}

	public String stairs() {
		return Integer.toString(fallLadders);
	}

	public void setBonificadores() {
		modificadores++;
	}

	public String getBonificadores() {
		return Integer.toString(fallLadders);
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

	public void setAnswer(boolean state) {
		answer = state;
	}

	public boolean getAnswer() {
		return answer;
	}

	public void saveModificador(String type) {
		if (type.equals("Binificacion")) {
			bonificacion++;
		} else if (type.equals("Binificacion")) {
			penalizacion++;
		} else if (type.equals("Binificacion")) {
			cambio++;
		}
	}

	public String getPiece() {
		return piece;
	}
}
