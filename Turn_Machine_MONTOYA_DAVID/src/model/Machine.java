package model;
import java.util.*;
import customExceptions.*;

public class Machine {

	private String currentTurn;
	private String nextTurn;
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
		nextTurn = turnLett + leftNum + ++rightNum; 
	}
	
	public void addUser(char type, String document, String name, String lastName, String phone) throws UserAlreadyExistsException {
		for(int i = 0; i < users.size(); i++){
			if((users.get(i).getDocument()).equalsIgnoreCase(document)) {
				throw new UserAlreadyExistsException(users.get(i).getName());
			}
		}
		
		users.add(new User(type, document, name, lastName, phone));
	}
	
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
	
	public String assignTurn(String document) throws UserNotFoundException, UserAlreadyWithTurnException {
		searchUser(document);
		Turn a = new Turn(currentTurn, 'a');
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getDocument().equalsIgnoreCase(document) && users.get(i).getTurn() == null){
				users.get(i).setTurn(a);
				advanceTurn();
				break;
			}
			
			else if(users.get(i).getName().equalsIgnoreCase(document) && users.get(i).getTurn() != null){
				throw new UserAlreadyWithTurnException();}
		}
		
		return "Turn " + a.getName() + " has been assigned";
	}	
	
	public String currentTurn() {
		String currNext = currentTurn;
		return currNext;
		
	}


	public String attend(String document, char status) throws UserWithoutTurnException {
		String a = "";
		for(int i = 0; i < users.size(); i++){
			if((users.get(i).getDocument()).equalsIgnoreCase(document) && users.get(i).getTurn() != null) {
				(users.get(i).getTurn()).setValid(false);
				a = "User with " + users.get(i).getDocument() + " document has been attended succesfully";
				break;
			}
			
			else if(users.get(i).getTurn() == null) {throw new UserWithoutTurnException();}
	}
	return a;
}
	
	public void resetTurns() {
		leftNum = 0;
		rightNum = 0;
		turnLett = letters[0];
	}
	
	
	public void advanceTurn() {
		rightNum++;
		if(rightNum >= 9) {
			rightNum = 0;
			 leftNum++;
		}
		
		if(leftNum >= 9) {
			leftNum = 0;
			rightNum = 0;
			currLett++;
		}
		
		setCurrentTurn(leftNum, rightNum, currLett);
	}
	
	
	public void setCurrentTurn(int leftNum, int rightNum, int currLett) {
		currentTurn = letters[currLett] + leftNum + rightNum;
	}

}