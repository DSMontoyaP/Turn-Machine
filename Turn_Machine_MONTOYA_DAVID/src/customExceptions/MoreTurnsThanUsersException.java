package customExceptions;

@SuppressWarnings("serial")
public class MoreTurnsThanUsersException extends Exception {

	public MoreTurnsThanUsersException() {
		super("There are more turns to be set than users");
	}
}