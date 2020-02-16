package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import customExceptions.*;
import model.*;

class MachineTest {
	
	private ArrayList<User> users= new ArrayList<User>();
	private Machine m1 = new Machine();
	
	void setup1() {
		for(int i = 0; i<100; i++) {
		try {
			m1.addUser('c', "12345"+i, "Michael"+i, "pjorn", "");
		} catch (UserAlreadyExistsException e) {
			e.getMessage();
		}
		}
		
		users = m1.getUsers();
	}

	@Test
	void testAddUser(){
		
		try{
		assertTrue(users.isEmpty(), "Users is not empty");
		m1.addUser('c', "123456", "Albert", "Wesker", "");
		users = m1.getUsers();
		assertEquals(users.get(0).getDocument(), "123456", "User was not created correctly");
		m1.addUser('c', "123456", "Albert", "Wesker", "");
		fail("Should've thrown an exception");}
		catch(UserAlreadyExistsException e) {}
		finally {
			assertFalse(users.isEmpty());
			try {
				m1.addUser('i', "12354596", "Marco", "Vazques", "");
				users = m1.getUsers();
				assertEquals(users.get(1).getDocument(), "12354596", "User was not created correctly");
			} catch (UserAlreadyExistsException e) {
				fail("Exception failing");
			}
			users.clear();
		}
	}
	
	@Test
	void searchTest() {
		assertTrue(users.isEmpty(), "ArrayList is not empty");
		try {
			m1.addUser('c', "123456", "Albert", "Wesker", "");
			users = m1.getUsers();
			m1.searchUser("123456");
			users.clear();
		} catch (UserAlreadyExistsException e1) {
			fail("Add method not working properly");
		}catch(UserNotFoundException e) {fail("Search method not working properly");}
		
		setup1();
		String document = "12345";
		for(int i = 0; i<users.size(); i++) {
		try {
			m1.searchUser(document+i);
		} catch (UserNotFoundException e) {
			fail("Search method not working properly");
		}
		}
		
		try {
			m1.searchUser("1564894");
			fail("Exception not working properly");
		} catch (UserNotFoundException e) {}
		
		users.clear();
	}
	
	@Test
	void assignTest() {
		setup1();
		
		try {
			m1.assignTurn("123450");
		} catch (UserNotFoundException | UserAlreadyWithTurnException e) {
			fail(e.getMessage());
		}
		
		try {
			m1.assignTurn("12345");
			fail("Should've thrown an exception");
			} catch(UserNotFoundException | UserAlreadyWithTurnException e) {
				assertTrue(users.get(0).getTurnName().equals("A00"), "Wrong turn number " + users.get(0).getTurn());
			}
	}
	
	@Test
	void advanceTurnTest() {
		assertTrue(m1.getCurrentTurn().equalsIgnoreCase("A00"));
		for(int i = 0; i<3000; i++) {
			if(i == 1) {
				assertTrue(m1.getCurrentTurn().equalsIgnoreCase("A01"), "Turn not advancing properly " + m1.getCurrentTurn());
			}
			
			if(i == 100) {
				assertTrue(m1.getCurrentTurn().equalsIgnoreCase("B00"), "Turn not advancing properly the letter" + m1.getCurrentTurn());
			}
			
			if(i == 400) {
				assertTrue(m1.getCurrentTurn().equalsIgnoreCase("E00"), "Turn not advancing properly the letter" + m1.getCurrentTurn());
			}
			
			if(i == 2600) {
				assertTrue(m1.getCurrentTurn().equalsIgnoreCase("A00"), "Turn not advancing properly the letter" + m1.getCurrentTurn());
			}
			m1.advanceTurn();
		}
	}
	
	@Test
	void attendTest() {
		setup1();
		try {
			m1.assignTurn("123450");
			m1.attend("123450", 'T');
			assertTrue(users.get(0).getTurn() == null);
			
		} catch (UserNotFoundException | UserAlreadyWithTurnException | UserWithoutTurnException e) {
			fail();
		}
	}

}
