package customExceptions;

@SuppressWarnings("serial")
public class UserIsSuspendedException extends Exception {

	public UserIsSuspendedException() {
		super("User is suspended from further asking of turns");
	}
}
