package model;
import java.util.*;

public class Machine {
	
	private String currentTurn;
	private ArrayList<User> users;
	private String turnLett;
	private String leftNum;
	private String rightNum;
	
	public Machine() {
		users = new ArrayList<User>();
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		turnLett = letters[0];
		leftNum = "0";
		rightNum = "0";
		currentTurn = turnLett + leftNum + rightNum;
	}
	
	public void addUser(char type, String document, String name, String lastName, String phone) {
		users.add(new User(type, document, name, lastName, phone));
	}
	
	public String searchUser(String document) throws UserNotFoundException {
		String a = "";
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).equals(document)) {
				a = users.get(i).toString();
			}
		}
		
		if(a.equals("")){throw UserNotFoundException;}
	}
	
	public String assignTurn(String document) throws UserNotFoundException, UserAlreadyWithTurnException {
		searchUser(document);
		Turn a = new Turn(currentTurn, 'a');
		int rNum = Integer.parseInt(rightNum);
		int lNum = Integer.parseInt(leftNum);
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getDocument().equals(document) && users.get(i).getTurn() == null){
				users.get(i).setTurn(a);
			}
			
			else {throw UserAlreadyWithTurnException;}
		}
		
	}
	
	
}
