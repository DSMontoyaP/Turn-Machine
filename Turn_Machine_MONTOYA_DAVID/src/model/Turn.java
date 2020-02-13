package model;

public class Turn {

	public static final char LOST = 'l';
	public static final char ACTIVE = 'a';
	public static final char ATTENDED = 't';

	private String name;
	private char status;
	
	public Turn(String name, char status) {
		this.name = name;
		this.status = status;
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
