package model;

public class Turn {

	public static final char LOST = 'l';
	public static final char ACTIVE = 'a';
	public static final char ATTENDED = 't';

	private String name;
	private char status;
	private boolean valid;
	
	public Turn(String name, char status) {
		this.name = name;
		this.status = status;
		valid = true;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
