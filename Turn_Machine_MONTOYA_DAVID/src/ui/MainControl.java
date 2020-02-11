package ui;
import model.*;
import java.util.*;

public class MainControl {
	private static Scanner user = new Scanner(System.in);
	private Machine m1;
	
	public MainControl() {
		m1 = new Machine();
	}
	
	
	public static void main(String[] args) {
	user = new Scanner(System.in);
	MainControl mc1 = new MainControl();
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
			mc1.searchUser();
			userChoice = 0;
			break;	
			
		case 3:
			mc1.assignTurn();
			userChoice = 0;
			break;	
			
		case 4:
			mc1.upcomingTurn();
			userChoice = 0;
			break;
			
		case 5:
			mc1.attend();
			userChoice = 0;
			break;
		}
	}
	
	
	} 
	
	
	
	public void addUser(){
		System.out.println("Select document type: \n C. Identification Card \n I. Identity card \n R. Civil registry \n P. Passport \n E. Foreigner ID");
	
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
		System.out.println("Input the user document number to search");
		String document = user.nextLine();
		String a = m1.searchUser(document);
		return a;
		
	}
	
}
