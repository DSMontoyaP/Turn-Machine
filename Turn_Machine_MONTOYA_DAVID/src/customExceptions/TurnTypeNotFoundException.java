package customExceptions;

@SuppressWarnings("serial")
public class TurnTypeNotFoundException extends Exception{

	public TurnTypeNotFoundException() {
		super("Turn type does not exist, please create one");
	}

}
