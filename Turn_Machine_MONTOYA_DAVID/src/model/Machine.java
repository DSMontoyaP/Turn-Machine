package model;
import java.util.*;
import customExceptions.*;

public class Machine {

	private String currentTurn;
	private ArrayList<User> users;
	private String turnLett;
	private int leftNum;
	private int rightNum;
	private int currLett;
	private String[] letters;
	
	public Machine() {
		users = new ArrayList<User>();
		currLett = 0;
		letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		turnLett = letters[currLett];
		leftNum = 0;
		rightNum = 0;
		currentTurn = turnLett + leftNum + rightNum;
		}
	
	/**
	*<b>Name:</b> addUser.<br>
	*This method adds an user to the ArrayList.<br>
	*@param type the document type. <br>
	*@param document the document number.<br>
	*@param name the name of the new user<br>
	*@param lastName the last name of the new user.<br>
	*@param phone the phone of the user.<br>
	*@throws UserAlreadyExistsException if an user exists already in the ArrayList<br> 
	*/
	public void addUser(char type, String document, String name, String lastName, String phone) throws UserAlreadyExistsException {
		for(int i = 0; i < users.size(); i++){
			if((users.get(i).getDocument()).equalsIgnoreCase(document)) {
				throw new UserAlreadyExistsException(users.get(i).getName());
			}
		}
		
		users.add(new User(type, document, name, lastName, phone));
	}

	/**
	*<b>Name:</b> searchUser.<br>
	*This method searches an user on the ArrayList.<br>
	*@param document the document number.<br>
	*@throws UserNotFoundException if the user does not exist in the ArrayList
	*@return a toString method of user with all the given information at the time of creation<br>
	*/	
	public String searchUser(String document) throws UserNotFoundException {
		String a = "";
		for(int i = 0; i < users.size(); i++){
			if((users.get(i).getDocument()).equalsIgnoreCase(document)) {
				a = users.get(i).toString();
			}
		}
		
		if(a.equals("")){throw new UserNotFoundException();}
		return a;
	}
	

	/**
	*<b>Name:</b> assignTurn.<br>
	*This method assigns a turn to an already existing user.<br>
	*@param document the document number.<br>
	*@throws UserNotFoundException if the user does not exist in the ArrayList
	*@throws UserAlreadyWithTurnException if the user already has a turn assigned
	*@return b message showing what turn was assigned<br>
	*/
	public String assignTurn(String document) throws UserNotFoundException, UserAlreadyWithTurnException {
		searchUser(document);
		String b = "";
		Turn a = new Turn(currentTurn, 'a');
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getDocument().equalsIgnoreCase(document) && users.get(i).getTurn() == null){
				users.get(i).setTurn(a);
				b = "Turn " + a.getName() + " has been assigned";
				break;
			}
			
			else if(users.get(i).getName().equalsIgnoreCase(document) && users.get(i).getTurn() != null){
				throw new UserAlreadyWithTurnException(users.get(i).getTurn());}
		}
		
		return b;
	}	
	
	/**
	*<b>Name:</b> attend.<br>
	*This method attends a turn of an already existing user.<br>
	*@param document the document number.<br>
	*@param status the status the attendant gave to the turn
	*@throws UserWithoutTurnException if the user does not have a turn
	*@return a message showing the document of the user that was attended<br>
	*/
	public String attend(String document, char status) throws UserWithoutTurnException {
		String a = "";
		for(int i = 0; i < users.size(); i++){
			if((users.get(i).getDocument()).equalsIgnoreCase(document) && users.get(i).getTurn() != null) {
				users.get(i).setTurn(null);
				a = "User with " + users.get(i).getDocument() + " document has been attended succesfully";
				advanceTurn();
				break;
			}
			
			else if(users.get(i).getTurn() == null) {throw new UserWithoutTurnException();}
		}
		return a;
	}
	
	
	/**
	*<b>Name:</b> resetTurns.<br>
	*This method resets turns.<br>
	*/
	public void resetTurns() {
		leftNum = 0;
		rightNum = 0;
		turnLett = letters[0];
	}
	
	
	
	/**
	*<b>Name:</b> advanceTurns.<br>
	*This method advances turns.<br>
	*/
	public void advanceTurn() {
		rightNum++;
		
		if(rightNum > 9) {
			rightNum = 0;
			 leftNum++;
		}
		
		if(leftNum > 9) {
			leftNum = 0;
			currLett++;
		}
		
		if(currLett > letters.length-1) {
			currLett = 0;
		}

		setCurrentTurn(leftNum, rightNum, currLett);
	}
	
	
	
	
	public void setCurrentTurn(int leftNum, int rightNum, int currLett) {
		currentTurn = letters[currLett] + leftNum + rightNum;
	}
	
	
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	
		
	public String getCurrentTurn() {
		return currentTurn;
	}
	
	public String currentTurn() {
		String currNext = currentTurn;
		return currNext;
		
	}

}