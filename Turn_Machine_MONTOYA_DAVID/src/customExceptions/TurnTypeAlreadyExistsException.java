package customExceptions;

@SuppressWarnings("serial")
public class TurnTypeAlreadyExistsException extends Exception{

	public TurnTypeAlreadyExistsException() {
		super("The turn type already exists");
	}

}
