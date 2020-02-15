package customExceptions;
import model.*;

@SuppressWarnings("serial")
public class UserAlreadyWithTurnException extends Exception {
	private Turn turn;
	public UserAlreadyWithTurnException(Turn turn) {
		super("User already has a turn " + turn.getName() );
		this.setTurn(turn);
	}
	public Turn getTurn() {
		return turn;
	}
	public void setTurn(Turn turn) {
		this.turn = turn;
	}
}
