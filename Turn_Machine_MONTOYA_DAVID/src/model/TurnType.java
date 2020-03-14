package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TurnType implements Serializable {
	
	private String name;
	private float duration;

	public TurnType(String name, float duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDuration() {
		return duration;
	}
	
	public long getDurationMili() {
		long durationMili = (long)(duration*60000);
		return durationMili;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

}
