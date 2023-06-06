package domain;

/**
 * Let me create all player's types.
 * 
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.2
 */
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

	/**
	 * Return the player's turn.
	 * 
	 * @return if the player is in turn or not.
	 */
	public boolean getTurn() {
		return inTurn;
	}

	/**
	 * update the turn.
	 * 
	 * @param turn if is in turn or not.
	 */
	public void setTurn(boolean turn) {
		this.inTurn = turn;
	}

	/**
	 * move the player.
	 * 
	 * @param value the box´s number.
	 * @param size  the table's size.
	 * @param extra if has a modifier.
	 * @return
	 */
	public int move(int value, int size, boolean extra) {
		if (position + value <= (size * size) && position + value > 0) {
			if (extra) {
				lastPosition = position;
			}
			position += value;
		}
		return position;
	}

	/**
	 * If the robot want use the modifier.
	 * 
	 * @param desicion if it use it or not.
	 */
	public abstract void tookDesicion(String desicion);

	/**
	 * the player's position.
	 * 
	 * @return the player's position.
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * if fall in a ladder.
	 */
	public void fallsLadders() {
		fallLadders++;
	}

	/**
	 * if fall in a snake.
	 */
	public void fallsSnakes() {
		fallSnake++;
	}

	/**
	 * The snakes's number that the player falled in.
	 * 
	 * @return the snake's number.
	 */
	public String snake() {
		return Integer.toString(fallSnake);
	}

	/**
	 * The ladders's number that the player fall in.
	 * 
	 * @return the ladder's number.
	 */
	public String stairs() {
		return Integer.toString(fallLadders);
	}

	/**
	 * if the player set a modifier.
	 */
	public void setBonificadores() {
		modificadores++;
	}

	/**
	 * the modifiers's number that took it.
	 * 
	 * @return the modifier's number.
	 */
	public String getBonificadores() {
		return Integer.toString(fallLadders);
	}

	/**
	 * Return the player's position before moving it.
	 * 
	 * @return the player's position.
	 */
	public int getLastPosition() {
		return lastPosition;
	}

	/**
	 * assing a question for the player.
	 * 
	 * @param value if the player has a question or not.
	 */
	public void setQuestion(boolean value) {
		this.question = value;
	}

	/**
	 * Verify if the player has a question.
	 * 
	 * @return if the player has or not a question.
	 */
	public boolean hasQuestion() {
		return question;
	}

	/**
	 * put the answer of the question;
	 * 
	 * @param state the answer.
	 */
	public void setAnswer(boolean state) {
		answer = state;
	}

	/**
	 * Returns the answer of the question.
	 * 
	 * @return the answer
	 */
	public boolean getAnswer() {
		return answer;
	}

	/**
	 * Save the modifier if the player want.
	 * 
	 * @param type the modifier's type.
	 */
	public void saveModificador(String type) {
		if (type.equals("Binificacion")) {
			bonificacion++;
		} else if (type.equals("Binificacion")) {
			penalizacion++;
		} else if (type.equals("Binificacion")) {
			cambio++;
		}
	}

	/**
	 * Return the player's piece.
	 * 
	 * @return the player's piece.
	 */
	public String getPiece() {
		return piece;
	}

}
