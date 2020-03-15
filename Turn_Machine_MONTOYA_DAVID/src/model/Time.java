package model;
import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Time implements Serializable{
	
	private int hour;
	private int minute;
	private int seconds;
	
	public Time(int hour, int minute, int seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}

	/**
	 * *<b>Name:</b> getAll. <br>
	 * This method gets all the values of Time
	 * @return a String with all the values from Time attributes
	 */
	
	public String getAll() {
		String a = "";
		a = hour + ":" + minute + ":" + seconds;
		return a;
	}
	
	/**
	 * *<b>Name:</b> getHour. <br>
	 * This method gets the hour value of Time
	 * @return Hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * *<b>Name:</b> setHour. <br>
	 * This method sets the current hour value as the difference between an instance of Calendar and the one given by the user
	 * @param hour integer given by the user as hour
	 */
	public void setHour(int hour) {
		Calendar x = Calendar.getInstance(); 
		this.hour = hour - x.get(Calendar.HOUR);
	}

	/**
	 * *<b>Name:</b> getMinute. <br>
	 * This method gets the minute value of Time
	 * @return minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * *<b>Name:</b> setMinute. <br>
	 * This method sets the current minute value as the difference between an instance of Calendar and the one given by the user
	 * @param minute integer given by the user as minute
	 */
	public void setMinute(int minute) {
		Calendar x = Calendar.getInstance(); 
		this.minute = minute - x.get(Calendar.MINUTE);
	}

	/**
	 * *<b>Name:</b> getSeconds. <br>
	 * This method gets the seconds value of Time
	 * @return seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * *<b>Name:</b> setSeconds. <br>
	 * This method sets the current seconds value as the difference between an instance of Calendar and the one given by the user
	 * @param seconds integer given by the user as seconds
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
