package model;
import java.util.Calendar;

public class Time {
	
	private int hour;
	private int minute;
	private int seconds;
	
	public Time(int hour, int minute, int seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}

	public String getAll() {
		String a = "";
		a = hour + ":" + minute + ":" + seconds;
		return a;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		Calendar x = Calendar.getInstance(); 
		this.hour = hour - x.get(Calendar.HOUR);
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		Calendar x = Calendar.getInstance(); 
		this.minute = minute - x.get(Calendar.MINUTE);
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
