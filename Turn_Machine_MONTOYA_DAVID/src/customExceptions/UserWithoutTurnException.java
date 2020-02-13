package customExceptions;

@SuppressWarnings("serial")
public class UserWithoutTurnException extends Exception {
	
	public UserWithoutTurnException() {
		super("User does not have a turn");
	}
}
