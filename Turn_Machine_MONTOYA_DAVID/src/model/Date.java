package model;

import java.util.Calendar;

public class Date {
	
	private int year;
	private int month;
	private int day;
	
	public Date() {
		Calendar x = Calendar.getInstance();
		this.setYear(x.get(Calendar.YEAR));
		this.setMonth(x.get(Calendar.MONTH));
		this.setDay(x.get(Calendar.DATE));
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
