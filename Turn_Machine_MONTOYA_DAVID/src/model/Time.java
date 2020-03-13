package model;
import java.util.Calendar;

public class Time {
	
	private int hour;
	private int minute;
	private int seconds;
	
	public Time() {
		Calendar x = Calendar.getInstance();
		this.hour = x.get(Calendar.HOUR);
		this.minute = x.get(Calendar.MINUTE);
		this.seconds = x.get(Calendar.SECOND);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
