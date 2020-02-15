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
	
	
	public static void main(String[] args){
	MainControl mc1 = new MainControl();
	user = new Scanner(System.in);
	int userChoice = 0;
	System.out.println("Welcome");
	while(userChoice != 7) {
		switch (userChoice) {
		case 0:
			System.out.println("\n 1. Add a new user \n 2. Search user \n 3. Assign user a turn \n 4. Upcoming turn to attend \n 5. Attend current turn \n 6. Reset turns \n 7. Close");
			userChoice = user.nextInt();
			break;
			
		case 1:
			try {
				mc1.addUser();
			} catch (UserAlreadyExistsException e) {
				e.getMessage();
			}catch(InputMismatchException e) {System.out.println("Invalid input");}
			finally{userChoice = 0;}
			break;
			
		case 2:
			System.out.println(mc1.searchUser());
			userChoice = 0;
			break;	
			
		case 3:
			try {
				System.out.println(mc1.assignTurn());
			} catch (UserNotFoundException | UserAlreadyWithTurnException e) {
				System.out.println(e.getMessage());
			}
			finally{userChoice = 0;}
			break;	
			
		case 4:
			System.out.println(mc1.currentTurn());
			userChoice = 0;
			break;
			
		case 5:
			try {
				System.out.println(mc1.attend());
			} catch (UserWithoutTurnException e) {
				System.out.println(e.getMessage());
			}
			finally{userChoice = 0;}
			break;
			
		case 6:
			mc1.resetTurns();
			userChoice = 0;
			break;
		}
	}
	
	
	} 
	
	
	
	public void addUser() throws UserAlreadyExistsException, InputMismatchException{
		System.out.println("Select document type: \n C. Identification Card \n I. Identity card \n R. Civil registry \n P. Passport \n E. Foreigner ID");
		user = new Scanner(System.in);
		String typeS = user.nextLine();
		typeS.toLowerCase();
		if(typeS.equals("")) {throw new InputMismatchException();}
		char type = typeS.charAt(0);
		System.out.println("Input document number");
		int documentNum = user.nextInt();
		user.nextLine();
		String document = Integer.toString(documentNum);
		System.out.println("Input name");
		String name = user.nextLine();
		if(name.equals("")) {throw new InputMismatchException();}
		System.out.println("Input last name");
		String lastName = user.nextLine();
		if(name.equals("")) {throw new InputMismatchException();}
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
	
	public String assignTurn() throws UserNotFoundException, UserAlreadyWithTurnException {
	user = new Scanner(System.in);
	String a = "";
	System.out.println("Enter the user's document number");
	String document = user.nextLine();
	a = m1.assignTurn(document);
	return a;
	}
	
	public String currentTurn() {
		return m1.currentTurn();
	}
	
	public String attend() throws UserWithoutTurnException {
		user = new Scanner(System.in);
		System.out.println("Enter the user's document to attend");
		String document = user.nextLine();
		System.out.println("T. The user was correctly attended \n L. The user was not present while attending");
		String status = user.nextLine();
		status.toLowerCase();
		char statusC = status.charAt(0);
		return m1.attend(document, statusC);
	}
	
	public void resetTurns() {
		m1.resetTurns();
	}
}

