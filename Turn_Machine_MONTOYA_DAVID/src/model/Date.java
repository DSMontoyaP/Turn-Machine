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
	
	public String getAll() {
		String a = "";
		a = year + "/" + month + "/" + day;
		return a;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		Calendar x = Calendar.getInstance(); 
		this.year = year - x.get(Calendar.YEAR);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		Calendar x = Calendar.getInstance(); 
		this.month = month - x.get(Calendar.MONTH);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		Calendar x = Calendar.getInstance(); 
		this.day = day - x.get(Calendar.DATE);
	}

}
