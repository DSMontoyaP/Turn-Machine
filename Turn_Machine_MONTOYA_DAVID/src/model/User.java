package model;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@SuppressWarnings("serial")
public class User implements Serializable{

	/** The Constant CEDULAC. */
	public static final char CEDULAC = 'c';
	
	/** The Constant TARJETAI. */
	public static final char TARJETAI = 'i';
	
	/** The Constant REGISTROC. */
	public static final char REGISTROC = 'r';
	
	/** The Constant PASAPORTE. */
	public static final char PASAPORTE = 'p';
	
	/** The Constant CEDULAE. */
	public static final char CEDULAE= 'e';
	
	/** The type. */
	private char type;
	
	/** The attended turns. */
	private ArrayList<Turn> attendedTurns;
	
	/** The document. */
	private String document;
	
	/** The name. */
	private String name;
	
	/** The last name. */
	private String lastName;
	
	/** The phone. */
	private String phone;
	
	/** The address. */
	private String address;
	
	/** The turn. */
	private Turn turn;
	
	/** The suspended value. */
	private boolean suspended;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param type the type
	 * @param document the document
	 * @param name the name
	 * @param lastName the last name
	 * @param phone the phone
	 */
	public User(char type, String document, String name, String lastName, String phone) {
		this.type = type;
		this.document = document;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.suspended = false;
		this.attendedTurns = new ArrayList<Turn>();
	}

	/**
	 * *<b>Name:</b> getAttendedTurns. <br>
	 * Gets the attended turns.
	 * @return a the attended turns
	 */
	public String getAttendedTurns() {
		String a = "";
		for(int i = 0; i < attendedTurns.size(); i++) {
			
			if(attendedTurns.get(i).getStatus() != Turn.ACTIVE) {
			a += attendedTurns.get(i).getName() + " Status: " + attendedTurns.get(i).getStatus();
			}
		}
		
		return a;
	}
	
	/**
	 * *<b>Name:</b> getRepeatedAttendedTurns. <br>
	 * Gets the attended turns that are asked by the user.
	 * @param name name of the turn
	 * @return a the attended turns that were asked by the user
	 */
	
	public String getRepeatedAttendedTurns(String name) {
		String a = "";
		for(int i = 0; i < attendedTurns.size(); i++) {
			if(attendedTurns.get(i).getName().equals(name)) {
				a += getName();
			}
		}
		
		return a;
	}

	/**
	 * *<b>Name:</b> addAttendedTurn. <br>
	 * Adds the attended turn.
	 */
	public void addAttendedTurn() {
		attendedTurns.add(turn);
	}

	/**
	 * *<b>Name:</b> getTurn. <br>
	 * Gets the turn.
	 * @return turn
	 */
	public Turn getTurn() {
		return turn;
	}
	
	/**
	 *  *<b>Name:</b> getTurnName. <br>
	 * Gets the turn name.
	 * @return the turn name
	 */
	public String getTurnName() {
		return turn.getName();
	}

	/**
	 *  *<b>Name:</b> toString. <br>
	 * To string with all the data from the user.
	 * @return a the string with the values
	 */
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

	/**
	 *  *<b>Name:</b> setTurn. <br>
	 * Sets the turn.
	 * @param turn the new turn
	 */
	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	/**
	 *  *<b>Name:</b> getType. <br>
	 * Gets the type.
	 * @return type
	 */
	public char getType() {
		return type;
	}

	/**
	 *  *<b>Name:</b> setType. <br>
	 * Sets the type.
	 * @param type the new type
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 *  *<b>Name:</b> getDocument. <br>
	 * Gets the document.
	 * @return document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 *  *<b>Name:</b> setDocument. <br>
	 * Sets the document.
	 * @param document the new document
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 *  *<b>Name:</b> getName. <br>
	 * Gets the name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 *  *<b>Name:</b> setName. <br>
	 * Sets the name.
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  *<b>Name:</b> getLastName. <br>
	 * Gets the last name.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *  *<b>Name:</b> setLastName. <br>
	 * Sets the last name.
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *  *<b>Name:</b> getPhone. <br>
	 * Gets the phone number.
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 *  *<b>Name:</b> setPhone. <br>
	 * Sets the phone.
	 * @param phone the new phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 *  *<b>Name:</b> getAddress. <br>
	 * Gets the address.
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 *  *<b>Name:</b> setAddress. <br>
	 * Sets the address.
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 *  *<b>Name:</b> isSuspended. <br>
	 * Checks if is suspended.
	 * @return true, if is suspended
	 */
	public boolean isSuspended() {
		return suspended;
	}

	/**
	 *  *<b>Name:</b> setSuspended. <br>
	 * Sets if it is suspended.
	 */
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
