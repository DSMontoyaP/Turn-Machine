package model;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Date implements Serializable  {
	
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * *<b>Name:</b> getAll. <br>
	 * This method gets all the values of Date
	 * @return a String with all the values from Date's attributes
	 */
	public String getAll() {
		String a = "";
		a = year + "/" + month + "/" + day;
		return a;
	}

	/**
	 * *<b>Name:</b> getYear. <br>
	 * This method gets the year value of Date
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * *<b>Name:</b> setYear. <br>
	 * This method sets the current year value as the difference between an instance of Calendar and the one given by the user
	 * @param year integer given by the user as year
	 */
	public void setYear(int year) {
		Calendar x = Calendar.getInstance(); 
		this.year = year - x.get(Calendar.YEAR);
	}

	/**
	 * *<b>Name:</b> getMonth. <br>
	 * This method gets the month value of Date
	 * @return currentTurn
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * *<b>Name:</b> setMonth. <br>
	 * This method sets the current month value as the difference between an instance of Calendar and the one given by the user
	 * @param month integer given by the user as month
	 */
	public void setMonth(int month) {
		Calendar x = Calendar.getInstance(); 
		this.month = month - x.get(Calendar.MONTH);
	}

	/**
	 * *<b>Name:</b> getMonth. <br>
	 * This method gets the day value of Date
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * *<b>Name:</b> setDay. <br>
	 * This method sets the current day value as the difference between an instance of Calendar and the one given by the user
	 * @param day integer given by the user as date
	 */
	public void setDay(int day) {
		Calendar x = Calendar.getInstance(); 
		this.day = day - x.get(Calendar.DATE);
	}

}
