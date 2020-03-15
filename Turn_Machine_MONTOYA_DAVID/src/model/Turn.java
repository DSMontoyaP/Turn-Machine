package model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Turn implements Serializable  {

	/** The Constant LOST. */
	public static final char LOST = 'l';
	
	/** The Constant ACTIVE. */
	public static final char ACTIVE = 'a';
	
	/** The Constant ATTENDED. */
	public static final char ATTENDED = 't';

	/** The name. */
	private String name;
	
	/** The status. */
	private char status;
	
	/** The valid. */
	private boolean valid;
	
	/** The duration. */
	private float duration;
	
	/** The type. */
	
	private TurnType type;
	public Turn(String name, char status, TurnType type) {
		this.name = name;
		this.status = status;
		this.duration = type.getDuration();
		this.type = type;
		valid = true;
	}

	/**
	 * *<b>Name:</b> getDuration. <br>
	 * Gets the duration.
	 * @return duration
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * *<b>Name:</b> setDuration. <br>
	 * Sets the duration.
	 * @param duration
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}

	/**
	 * *<b>Name:</b> getType. <br>
	 * Gets the type.
	 * @return type
	 */
	public TurnType getType() {
		return type;
	}

	/**
	 * *<b>Name:</b> setType. <br>
	 * Sets the type.
	 * @param type the new type
	 */
	public void setType(TurnType type) {
		this.type = type;
	}

	/**
	 * *<b>Name:</b> isValid. <br>
	 * Checks if is valid.
	 * @return valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * *<b>Name:</b> setValid. <br>
	 * Sets the valid value of the turn.
	 * @param valid boolean with the new value
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * *<b>Name:</b> getName. <br>
	 * Gets the name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * *<b>Name:</b> setName. <br>
	 * Sets the name.
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * *<b>Name:</b> getStatus. <br>
	 * Gets the status value of the Turn.
	 * @return status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * *<b>Name:</b> setStatus. <br>
	 * Sets the status.
	 * @param status the new status
	 */
	public void setStatus(char status) {
		this.status = status;
	}

}
