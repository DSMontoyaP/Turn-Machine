package model;

public class Turn {

	public static final char LOST = 'l';
	public static final char ACTIVE = 'a';
	public static final char ATTENDED = 't';

	private String name;
	private char status;
	private boolean valid;
	private float duration;
	private TurnType type;
	
	public Turn(String name, char status, TurnType type) {
		this.name = name;
		this.status = status;
		this.duration = type.getDuration();
		this.type = type;
		valid = true;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public TurnType getType() {
		return type;
	}

	public void setType(TurnType type) {
		this.type = type;
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
