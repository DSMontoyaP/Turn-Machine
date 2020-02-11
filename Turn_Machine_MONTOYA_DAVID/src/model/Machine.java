package model;
import java.util.*;

public class Machine {
	
	private Turn currentTurn;
	private ArrayList<User> users;
	
	public Machine() {
		users = new ArrayList<User>();
	}
	
	public void addUser(char type, String document, String name, String lastName, String phone) {
		users.add(new User(type, document, name, lastName, phone));
	}
	
	public String searchUser(String document) {
		String a = "";
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).equals(document)) {
				a = users.get(i).toString();
			}
		}
		
		if(a.equals("")){throw UserNotFoundException;}
	}
	
	
}
