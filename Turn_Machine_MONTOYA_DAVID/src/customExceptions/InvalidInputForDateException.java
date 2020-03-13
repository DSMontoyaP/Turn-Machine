package customExceptions;

@SuppressWarnings("serial")
public class InvalidInputForDateException extends Exception {

	public InvalidInputForDateException() {
		super("Date / time written has already passed, cannot input a date previous than actual");
	}
}
