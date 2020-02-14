package customExceptions;

@SuppressWarnings("serial")
public class UserAlreadyWithTurnException extends Exception {
	
	public UserAlreadyWithTurnException() {
		super("User already has a turn");
	}
}
