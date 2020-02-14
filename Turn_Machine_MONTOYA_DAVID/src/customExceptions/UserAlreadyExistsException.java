package customExceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException(String name) {
		super("User " + name + " already exists, update information");
	}
}
