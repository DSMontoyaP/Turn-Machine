package model;

public class Turn {

	public static final char INACTIVE = 'i';
	public static final char ACTIVE = 'a';
	public static final char ATTENDED = 't';
	
	private char status;
	
	public Turn(char status) {
		this.status = status;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
