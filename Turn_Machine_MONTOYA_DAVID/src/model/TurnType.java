package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TurnType implements Serializable {
	
	/** The name. */
	private String name;
	
	/** The duration. */
	private float duration;

	public TurnType(String name, float duration) {
		this.name = name;
		this.duration = duration;
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
	 * *<b>Name:</b> getDuration. <br>
	 * Gets the duration.
	 * @return duration
	 */
	public float getDuration() {
		return duration;
	}
	
	/**
	 * *<b>Name:</b> getDurationMili. <br>
	 * Gets the duration on milliseconds.
	 * @return durationMili
	 */
	public long getDurationMili() {
		long durationMili = (long)(duration*60000);
		return durationMili;
	}

	/**
	 * *<b>Name:</b> setDuration. <br>
	 * Sets the duration.
	 * @param duration
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}

}
