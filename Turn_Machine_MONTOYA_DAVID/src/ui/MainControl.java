package ui;
import model.*;
import java.util.*;

import customExceptions.*;

public class MainControl {
	private static Scanner user;
	private Machine m1;
	
	public MainControl() {
		m1 = new Machine();
	}
	
	
	public static void main(String[] args) {
	MainControl mc1 = new MainControl();
	user = new Scanner(System.in);
	int userChoice = 0;
	while(userChoice != 6) {
		switch (userChoice) {
		case 0:
			System.out.println("Welcome \n 1. Add a new user \n 2. Search user \n 3. Assign user a turn \n 4. Upcoming turn to attend \n 5. Attend current turn \n 6. Close");
			userChoice = user.nextInt();
			break;
			
		case 1:
			mc1.addUser();
			userChoice = 0;
			break;
			
		case 2:
			System.out.println(mc1.searchUser());
			userChoice = 0;
			break;	
			
		case 3:
			System.out.println(mc1.assignTurn());
			userChoice = 0;
			break;	
			
		case 4:
			System.out.println(mc1.currentTurn());
			userChoice = 0;
			break;
			
		case 5:
			System.out.println(mc1.attend());
			userChoice = 0;
			break;
		}
	}
	
	
	} 
	
	
	
	public void addUser(){
		System.out.println("Select document type: \n C. Identification Card \n I. Identity card \n R. Civil registry \n P. Passport \n E. Foreigner ID");
		user = new Scanner(System.in);
		String typeS = user.nextLine();
		typeS.toLowerCase();
		char type = typeS.charAt(0);
		System.out.println("Input document number");
		String document = user.nextLine();
		System.out.println("Input name and then last name");
		String name = user.nextLine();
		String lastName = user.nextLine();
		System.out.println("Input phone number");
		String phone = user.nextLine();	
		m1.addUser(type, document, name, lastName, phone);
		System.out.println("User added");

	}
	
	public String searchUser() {
		user = new Scanner(System.in);
		String a = "";
		try{System.out.println("Input the user document number to search");
		String document = user.nextLine();
		a = m1.searchUser(document);
		return a;
		} 
		
		catch(UserNotFoundException e) {a = e.getMessage(); return a;}
	}
	
	public String assignTurn() {
	user = new Scanner(System.in);
	String a = "";
	System.out.println("Enter the user's document number");
	String document = user.nextLine();
	m1.assignTurn(document);
	return a;
	}
	
	public String currentTurn() {
		return m1.currentTurn();
	}
	
	public String attend() {
		user = new Scanner(System.in);
		System.out.println("Enter the user's document to attend");
		String document = user.nextLine();
		System.out.println("T. The user was correctly attended \n  L. The user was not present while attending");
		String status = user.nextLine();
		status.toLowerCase();
		char statusC = status.charAt(0);
		return m1.attend(document, statusC);
	}
}

