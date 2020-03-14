package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User implements Serializable{

	public static final char CEDULAC = 'c';
	public static final char TARJETAI = 'i';
	public static final char REGISTROC = 'r';
	public static final char PASAPORTE = 'p';
	public static final char CEDULAE= 'e';
	
	private char type;
	private ArrayList<Turn> attendedTurns;
	private String document;
	private String name;
	private String lastName;
	private String phone;
	private String address;
	private Turn turn;
	private boolean suspended;
	
	public User(char type, String document, String name, String lastName, String phone) {
		this.type = type;
		this.document = document;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.suspended = false;
		this.attendedTurns = new ArrayList<Turn>();
	}

	public String getAttendedTurns() {
		String a = "";
		for(int i = 0; i < attendedTurns.size(); i++) {
			
			if(attendedTurns.get(i).getStatus() != Turn.ACTIVE) {
			a += attendedTurns.get(i).getName() + " Status: " + attendedTurns.get(i).getStatus();
			}
		}
		
		return a;
	}
	
	public String getRepeatedAttendedTurns(String name) {
		String a = "";
		for(int i = 0; i < attendedTurns.size(); i++) {
			if(attendedTurns.get(i).getName().equals(name)) {
				a += getName();
			}
		}
		
		return a;
	}

	public void addAttendedTurn() {
		attendedTurns.add(turn);
	}

	public Turn getTurn() {
		return turn;
	}
	
	public String getTurnName() {
		return turn.getName();
	}

	@Override
	public String toString() {
		
		String a = "type=" + type + ", document=" + document + ", name=" + name + ", lastName=" + lastName
				+ ", phone=" + phone;
		if(address != null) {
			a+= ", address=" + address;
		}
		
		
		if(turn != null && turn.isValid() == true) {
			a+= ", Turn " + turn.getName();
		}
		
		return a;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended() {
		int cont = 0;
		
		for(int i = 0; i < attendedTurns.size(); i++) {
			
			if(attendedTurns.get(i).getStatus() == Turn.LOST && attendedTurns.get(i++).getStatus() == Turn.LOST) {
				cont++;
				break;
				}
			}
		
		if(cont>=1) {
			suspended = true;
		}
	}

}
