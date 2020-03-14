package ui;
import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


import customExceptions.*;

public class MainControl {
	private static Scanner user;
	private Machine m1;
	private String filename = "data/saved data.txt";
	
	public MainControl() {
		m1 = new Machine();
	}
	
	
	public static void main(String[] args){
	MainControl mc1 = new MainControl();
	user = new Scanner(System.in);
	int userChoice = 0;
	System.out.println("Welcome \n ");
	while(userChoice != 14) {
		switch (userChoice) {
		case 0:
			System.out.println(mc1.getSystemTime());
			System.out.println("\n 1. Add a new user \n 2. Search user \n 3. Assign user a turn \n 4. Upcoming turn to attend \n 5. Attend current turn \n 6. System time \n 7. Set system time \n 8. Create turn type \n 10. Get turns that have been repeated \n 11. Generate random users \n 12. Generate random turns \n 13. Save data \n 14. Close");
			userChoice = user.nextInt();
			break;
			
		case 1:
			long start = System.currentTimeMillis();
			try {
				mc1.addUser();
			} catch (UserAlreadyExistsException e) {
				e.getMessage();
			}catch(InputMismatchException e) {System.out.println("Invalid input");}
			finally{userChoice = 0;}
			long finish = System.currentTimeMillis() - start;
			System.out.println(finish);
			break;
			
		case 2:
			start = System.currentTimeMillis();
			System.out.println(mc1.searchUser());
			userChoice = 0;
			finish = System.currentTimeMillis() - start;
			System.out.println(finish);
			break;	
			
		case 3:
			start = System.currentTimeMillis();
			try {
				System.out.println(mc1.assignTurn());
			} catch (UserNotFoundException | UserAlreadyWithTurnException | TurnTypeNotFoundException | UserIsSuspendedException e) {
				System.out.println(e.getMessage());
			}
			finally{userChoice = 0;
			finish = System.currentTimeMillis() - start;
			System.out.println(finish);}
			break;	
			
		case 4:
			start = System.currentTimeMillis();
			System.out.println(mc1.currentTurn());
			userChoice = 0;
			finish = System.currentTimeMillis() - start;
			
			break;
			
		case 5:
			start = System.currentTimeMillis();
			System.out.println(mc1.attend());
			userChoice = 0;
			finish = System.currentTimeMillis() - start;
			System.out.println(finish);
			break;
			
		case 6:
			userChoice = 0;
			break;
			
		case 7:
			try {
				System.out.println(mc1.setSystemTime());
			} catch (InvalidInputForDateException e) {
				System.out.println(e.getMessage());
			}
			userChoice = 0;
			break;
			
			
		case 8:
			start = System.currentTimeMillis();
			try {
				user.nextLine();
				System.out.println(mc1.createTurnType());
			} catch (TurnTypeAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
			
		case 9:
			start = System.currentTimeMillis();
			try {
				mc1.generateReport();
			} catch(FileNotFoundException e){
					System.out.println(e.getMessage());}
			
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
		
		
		case 10:
			start = System.currentTimeMillis();
			user.nextLine();
			System.out.println(mc1.repeatedTurn());
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
		
		case 11:
			start = System.currentTimeMillis();
			try {
				mc1.populate();
			} catch (IOException | UserAlreadyExistsException e) {
				e.getMessage();
			}
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
			
		case 12:
			start = System.currentTimeMillis();
			try {
				mc1.randomTurns();
			} catch (MoreTurnsThanUsersException | UserNotFoundException | UserAlreadyWithTurnException
					| TurnTypeNotFoundException | UserIsSuspendedException e) {
				e.getMessage();
			}
		
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
		
		
		case 13:
			start = System.currentTimeMillis();
			try {
				mc1.saveData();
			} catch (IOException e) {
				e.getMessage();
			}
			
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
			
			
		case 14:
			start = System.currentTimeMillis();
			try {
				mc1.loadData();
			} catch (IOException | ClassNotFoundException e) {
				e.getMessage();
			}
			
			finish = System.currentTimeMillis() - start;
			userChoice = 0;
			break;
		}		
	}
	
	
	} 
	
	public void saveData() throws IOException {
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream e = new ObjectOutputStream(file);
		e.writeObject(m1);
		e.close();
		file.close();
	}
	

	
	public void loadData() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream e = new ObjectInputStream(file);
		Machine m = (Machine)e.readObject();
		m1 = m;
		e.close();
		file.close();
		
	}
	
	public void randomTurns() throws MoreTurnsThanUsersException, UserNotFoundException, UserAlreadyWithTurnException, TurnTypeNotFoundException, UserIsSuspendedException {
		System.out.println("Enter the amount of turns to be generated");
		int amount = user.nextInt();
		m1.generateRandomTurns(amount);
	}
	
	public void populate() throws FileNotFoundException, IOException, UserAlreadyExistsException {
		System.out.println("Enter the amount of users to be added");
		int cant = user.nextInt();
		m1.populate(cant);
	}
	
	public String repeatedTurn() {
		System.out.println("Write the letter and turn number that is being checked");
		String turnNumber = user.nextLine();
		return m1.reportSameTurn(turnNumber);
	}
	
	public String setSystemTime() throws InvalidInputForDateException {
	
		String a= "";
		boolean choice = user.nextBoolean();
		if(choice == false) {
		System.out.println("Please enter the year");
		int year = user.nextInt();
		System.out.println("Please enter the month");
		int month = user.nextInt();
		System.out.println("Please enter the day");
		int day = user.nextInt();
		System.out.println("Please enter the hour");
		int hour = user.nextInt();
		System.out.println("Please enter the minute");
		int minute = user.nextInt();
		System.out.println("Please enter the seconds");
		int seconds = user.nextInt();
		a = m1.setSystemTime(year, month, day, hour, minute, seconds);}
		
		else {
			a = m1.setSystemTime(choice);
		}
		
		
		return a;
	}


	public String  getSystemTime() {
		return m1.getSystemTime();
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
	
	public String assignTurn() throws UserNotFoundException, UserAlreadyWithTurnException, TurnTypeNotFoundException, UserIsSuspendedException {
	user = new Scanner(System.in);
	String a = "";
	System.out.println("Enter the user's document number");
	String document = user.nextLine();
	System.out.println("Enter turn type");
	TurnType b = m1.searchTurnType(user.nextLine());
	a = m1.assignTurn(document, b);
	return a;
	}
	
	public String currentTurn() {
		return m1.currentTurn();
	}
	
	public String attend(){
		return m1.attend();
	}
	
	public String createTurnType() throws TurnTypeAlreadyExistsException {
		System.out.println("Enter the turn type name");
		String name = user.nextLine();
		System.out.println("Enter the duration of the turn in minutes");
		float duration = user.nextFloat();
		return m1.createTurnType(name, duration);
	} 
	
	public String generateReport() throws FileNotFoundException {
		System.out.println("Enter user's document number");
		String document = user.nextLine();
		System.out.println("Do you want the report to be saved in reports file? (True/False)");
		boolean choice = user.nextBoolean();
		return m1.reportAttendedTurns(document, choice);
	}
}

