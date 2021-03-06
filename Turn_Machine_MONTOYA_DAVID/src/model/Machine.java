package model;
import java.util.*;
import customExceptions.*;
import java.io.*;

public class Machine {

	private String currentTurn;
	private ArrayList<User> users;
	private String turnLett;
	private int leftNum;
	private int rightNum;
	private int currLett;
	private String[] letters;
	private ArrayList<TurnType> turnTypes;
	private Date systemDate;
	private Time systemTime;
	private boolean hourChanged;
	private Calendar time;
	

	public Machine() {
		users = new ArrayList<User>();
		currLett = 0;
		letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		turnLett = letters[currLett];
		leftNum = 0;
		rightNum = 0;
		currentTurn = turnLett + leftNum + rightNum;
		turnTypes = new ArrayList<TurnType>();
		Calendar time = Calendar.getInstance();
		systemDate = new Date(time.get(Calendar.YEAR), time.get(Calendar.MONTH), time.get(Calendar.DATE));
		systemTime = new Time(time.get(Calendar.HOUR), time.get(Calendar.MINUTE), time.get(Calendar.SECOND));
		hourChanged = false;
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
	 *@param turnType the type of the turn to assign
	 *@throws UserNotFoundException if the user does not exist in the ArrayList
	 *@throws UserAlreadyWithTurnException if the user already has a turn assigned
	 *@throws TurnTypeNotFoundException 
	 *@return b message showing what turn was assigned<br>
	 *@throws UserIsSuspendedException When the user has been suspended for not arriving to two dates
	 */
	public String assignTurn(String document, TurnType z) throws UserNotFoundException, UserAlreadyWithTurnException, TurnTypeNotFoundException, UserIsSuspendedException {
		searchUser(document);
		
		if(z == null) {throw new TurnTypeNotFoundException();}
		Turn a = new Turn(currentTurn, 'a', z);
		
		String b = "";
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getDocument().equalsIgnoreCase(document) && users.get(i).getTurn() == null){
				users.get(i).setSuspended();
				if(users.get(i).isSuspended() != true) {
				users.get(i).setTurn(a);
				advanceTurn();
				b = "Turn " + a.getName() + " has been assigned";}
				
				else if(users.get(i).isSuspended() == true) {
					throw new UserIsSuspendedException();
				}
				break;
			}

			else if(users.get(i).getName().equalsIgnoreCase(document) && users.get(i).getTurn() != null){
				throw new UserAlreadyWithTurnException(users.get(i).getTurn());}
		}

		return b;
	}	

	/**
	 *<b>Name:</b> searchTurnType.<br>
	 *This method searches if the given type of a turn exists.<br>
	 *@param type the type of the turn.<br>
	 *@return a memory value of the instance of TurnType if found, null if not<br>
	 */
	public TurnType searchTurnType(String type) {
		TurnType a = null;
		for(int i = 0; i < turnTypes.size(); i++) {
			if(turnTypes.get(i).getName().equalsIgnoreCase(type)) {
				a = turnTypes.get(i);
			}
		}
		
		Comparator<TurnType> z = new CompareTurnTypesByDuration(); 
		Collections.sort(turnTypes, z);
		Collections.reverse(turnTypes);
		return a;
	}

	/**
	 *<b>Name:</b> createTurnType.<br>
	 *This method creates a new turn type.<br>
	 *@param name the name of the turn type.<br>
	 *@param duration the duration of the turn
	 *@throws TurnTypeAlreadyExistsException
	 *@return "Turn type " name " has been created"
	 */

	public String createTurnType(String name, float duration) throws TurnTypeAlreadyExistsException{
		if(searchTurnType(name) != null) {
			throw new TurnTypeAlreadyExistsException();
		}
		turnTypes.add(new TurnType(name, duration));
		return "Turn type " + name + " has been created";
		
	}


	/**
	 *<b>Name:</b> createTurnType.<br>
	 *This method creates a new turn type.<br>
	 *@param name the name of the turn type.<br>
	 *@param duration the duration of the turn
	 *@throws TurnTypeAlreadyExistsException
	 */
	
	public void populate(int cant) throws FileNotFoundException, IOException, UserAlreadyExistsException {

		char[] documentType = new char[]{'c','i','r','p','e'};		
		Random z = new Random();
		String document = "";
		for(int i =0; i < cant; i++) {
			BufferedReader readerNames = new BufferedReader(new FileReader("data/names.txt"));
			BufferedReader readerLastNames = new BufferedReader(new FileReader("data/last names.txt"));
			String name = "";
			Random names = new Random();
			int w = names.nextInt(995);
			for(int j = 0; j < w; j++) {
			name = readerNames.readLine();
			}
			
			String lastName = "";
			Random lastNames = new Random();
			int l = lastNames.nextInt(995);
			for(int b = 0; b<l; b++) {
			lastName = readerLastNames.readLine();
			
			}
			
			char documentTypeI = documentType[z.nextInt(5)];
			for(int j = 0; j<10; j++) {
				document += Integer.toString(z.nextInt(9)+1);
			}
			addUser(documentTypeI, document, name, lastName, "");
			document = "";
			readerNames.close();
			readerLastNames.close();
		}

	}
	
	
	/**
	 *<b>Name:</b> attend.<br>
	 *This method attends users that have asked for a turn in a given time frame, meaning, if the system's date is able to fit in the time for them to be attended it does so 
	 *@return a message showing the name of the turn that was attended<br>
	 */
	public String attend(){
		
		String a = "";
		Calendar start = Calendar.getInstance();

		for (int i = 0; i<users.size(); i++) {
			long difference = time.getTimeInMillis() - start.getTimeInMillis();
			
			if(users.get(i).getTurn() != null && hourChanged == true && difference > 15000) {
				System.out.println("Time " + time.getTimeInMillis());
				System.out.println("Start " + start.getTimeInMillis());	
				
				Random e = new Random();
					int rand = e.nextInt(2)+1;
					
					
					if(rand == 1) {
					a +=  "Turn " + users.get(i).getTurn().getName() + " was attended";
					start.setTimeInMillis(users.get(i).getTurn().getType().getDurationMili()+start.getTimeInMillis()+15000);
					users.get(i).getTurn().setStatus('t');
					users.get(i).setTurn(null);
					}
					
					else if(rand == 2) {
					a +=  "Turn " + users.get(i).getTurn().getName() + " was attended";
					start.setTimeInMillis(users.get(i).getTurn().getType().getDurationMili()+start.getTimeInMillis()+15000);
					users.get(i).getTurn().setStatus('l');
					users.get(i).setTurn(null);
					}
					

					
				}
				
			}	
		return a;
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



	/**
	 *<b>Name:</b> setCurrentTurn.<br>
	 *This method sets the current turn with help of advance turn, its a auxiliary method.<br>
	 *@param leftNum the left number in the turn's name
	 *@param rightNum the right number in the turn's name
	 *@param currLett the current letter to be assigned to the turn's name
	 */

	public void setCurrentTurn(int leftNum, int rightNum, int currLett) {
		currentTurn = letters[currLett] + leftNum + rightNum;
	}


	/**
	 *<b>Name:</b> getUsers.<br>
	 *This method fetches the current users ArrayList.<br>
	 *@return users ArrayList of users
	 */
	
	public ArrayList<User> getUsers() {
		return users;
	}


	/**
	 *<b>Name:</b> getCurrentTurn.<br>
	 *This method fetches the current turn in the program.<br>
	 *@return currentTurn
	 */
	public String getCurrentTurn() {
		return currentTurn;
	}


	/**
	 *<b>Name:</b> getSystemTime.<br>
	 *This method fetches the current time on the system, the one given by the user if he changed the hour, or the real time given by calendar.<br>
	 *@return a system's time
	 */
	public String getSystemTime() {
		String a = "";

		if(hourChanged == false) {
			time = Calendar.getInstance();
			a = time.get(Calendar.YEAR) + "/" + time.get(Calendar.MONTH+1) + "/" + time.get(Calendar.DATE) + "   " + time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE) + ":" + time.get(Calendar.SECOND);
		}
		else {
			time = Calendar.getInstance();
			time.add(Calendar.YEAR, systemDate.getYear());
			time.add(Calendar.MONTH, systemDate.getMonth());
			time.add(Calendar.DATE, systemDate.getDay());
			time.add(Calendar.HOUR, systemTime.getHour());
			time.add(Calendar.MINUTE, systemTime.getMinute());
			time.add(Calendar.SECOND, systemTime.getSeconds());

			a = Integer.toString((time.get(Calendar.YEAR))) + "/";
			a += Integer.toString((time.get(Calendar.MONTH+1))) + "/";
			a += Integer.toString((time.get(Calendar.DATE))) + "  ";
			a += Integer.toString((time.get(Calendar.HOUR_OF_DAY))) + ":";
			a += Integer.toString((time.get(Calendar.MINUTE))) + ":";
			a += Integer.toString((time.get(Calendar.SECOND)));
		}
		return a;
	}


	/**
	 *<b>Name:</b> setSystemTime.<br>
	 *This method sets the time on the program to one given by the user.<br>
	 *@param year integer with the year to be set
	 *@param month integer with the month to be set
	 *@param day integer with the day to be set
	 *@param hour integer with the hour to be set
	 *@param minute integer with the minute to be set
	 *@param seconds integer with the seconds to be set
	 *@return a system time as given by the method "getSystemTime"
	 */
	public String setSystemTime(int year, int month, int day, int hour, int minute, int seconds){
		String a = "";
		systemDate.setYear(year);
		systemDate.setMonth(month);
		systemDate.setDay(day);
		systemTime.setHour(hour);
		systemTime.setMinute(minute);
		systemTime.setSeconds(seconds);
		hourChanged = true;
		a = getSystemTime();
		attend();
		return a;
	}

	/**
	 *<b>Name:</b> setSystemTime.<br>
	 *This method sets the time on the program to the computer's.<br>
	 *@param currentDate a boolean signaling that the user wants for the date to be the same as the computer's
	 *@return a system's time as given by the method "getSystemTime"
	 */
	public String setSystemTime(boolean currentDate) {

		Calendar b = Calendar.getInstance();
		systemDate = new Date(b.get(Calendar.YEAR), b.get(Calendar.MONTH), b.get(Calendar.DATE));
		systemTime = new Time(b.get(Calendar.HOUR), b.get(Calendar.MINUTE), b.get(Calendar.SECOND));
		hourChanged = false;

		return getSystemTime();
	}
	
	/**
	 *<b>Name:</b> reportAttendedTurns.<br>
	 *This method writes a report about the turns that have been attended, saving them in a file if the user chooses to.<br>
	 *@param document the number of the document of the user
	 *@param choice the choice value of the user when asked if they want to save the data in a file
	 *@return a attended turns of the given user
	 */
	public String reportAttendedTurns(String document, boolean choice) throws FileNotFoundException {
		String a = "";
		for(int i = 0; i < users.size(); i++) {
			if((users.get(i).getDocument()).equals(document)) {
				a = users.get(i).getAttendedTurns();
			}
		}
		
		if(a != "" && choice == true) {
			PrintWriter out = new PrintWriter("Reports.txt");
			out.println(a);
			out.close();
		}
		
		return a;
	}
	
	/**
	 *<b>Name:</b> reportSameTurn.<br>
	 *This method reports the turns that have been repeated by several users.<br>
	 *@param turnNumber the turn number to be searched
	 *@return a either the name of the users that have had the same turn or a String saying that no user was found with that turn (or has been attended yet)
	 */
	public String reportSameTurn(String turnNumber) {
		String a = "";
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getRepeatedAttendedTurns(turnNumber).equals(turnNumber)) {
				a += users.get(i).getName();
			}
		}
		
		if(a.equals("")) {
			a = "No user with given turn where found or they have not been attended yet";
		}
		return a;
	}
	
	
	/**
	 *<b>Name:</b> generateRandomTurns.<br>
	 *This method generates random turns to the users in the ArrayList.<br>
	 *@param turnAmount the amount of turns to be created, cannot exceed the amount of users currently registered
	 *@throws MoreTurnsThanUsersException
	 *@throws UserNotFoundException
	 *@throws UserAlreadyWithTurnException
	 *@throws TurnTypeNotFoundException
	 *@throws UserIsSuspendedException
	 */
	public void generateRandomTurns(int turnAmount) throws MoreTurnsThanUsersException, UserNotFoundException, UserAlreadyWithTurnException, TurnTypeNotFoundException, UserIsSuspendedException {
		
		if(turnAmount>users.size()) {
			throw new MoreTurnsThanUsersException();
		}
		
		Random userNumber = new Random();
		Random turnTypeNumber = new Random();
		
		for(int i = 0; i < turnAmount; i++) {
			int a = userNumber.nextInt(turnAmount);
			if(users.get(a).getTurn() == null) {
				assignTurn(users.get(a).getDocument(), turnTypes.get(turnTypeNumber.nextInt(turnTypes.size())));
			}
		}
	}
	
	/**
	 * *<b>Name:</b> currentTurn. <br>
	 * This method gets the current turn
	 * @return currentTurn
	 */
	public String currentTurn() {
		return currentTurn;
	}

}