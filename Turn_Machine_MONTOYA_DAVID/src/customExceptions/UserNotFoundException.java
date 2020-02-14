package customExceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super("User was not found");
	}
}
