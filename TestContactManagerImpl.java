import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.*;
import static org.junit.Assert.*;

public class TestContactManagerImpl{
	ContactManager cm;
	@Before
	public void setUp(){
		cm = new ContactManagerImpl();
	}
	@After
	public void tearDown(){
		cm = null;
	}
	
	@Test
	public void testAddNewContactToEmptySet(){
		cm.addNewContact("Charlie Parker" , "Great on sax.");
		int output = ((ContactManagerImpl)cm).getContacts().size();
		int expected = 1;
		assertEquals(expected , output);
	} 
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewContactEmptyNotes(){
		cm.addNewContact("Charlie Parker" , "");
		
	} 
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewContactEmptyName(){
		cm.addNewContact("" , "Great on sax");
	
	}
	@Test(expected = NullPointerException.class)
	public void testAddNewContactNullNotes(){
		cm.addNewContact("Charlie Parker" , null);
	}
	@Test(expected = NullPointerException.class)
	public void testAddNewContactNullName(){
		cm.addNewContact(null , "Great on sax");
	}
	@Test
	public void testsAddNewContactGivesUniqueID(){
		int id1 = cm.addNewContact("Charlie Parker" , "Great on sax");
		int id2 = cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		int id3 = cm.addNewContact("Nat King Cole" , "fantastic voice");
		assertEquals(1 , id1);
		assertEquals(2 , id2);
		assertEquals(3 , id3);
	}
	@Test
	public void testsGetContactsStringArgOneNameMatch(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int output = cm.getContacts("Charlie Parker").size();
		int expected = 1;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetContactsStringArgWithTwoContactsSameName(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		cm.addNewContact("Charlie Parker" , "Great on sax");
		int output = cm.getContacts("Charlie Parker").size();
		int expected = 2;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetContactsStringArgWithNoNameMatch(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		cm.addNewContact("Charlie Parker" , "Great on sax");
		int output = cm.getContacts("Ella Fitzgerald").size();
		int expected = 0;
		assertEquals(expected , output);
	}
	@Test(expected = NullPointerException.class)
	public void testsGetContactsStringArgNull(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int output = cm.getContacts(null).size();
		int expected = 0;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetContactsStringArgEmpty(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int output = cm.getContacts("").size();
		int expected = 3;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetContactsIntArrayOneIdMatches(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int[] idsRequired = { 1 , 3}
		int firstoutput = cm.getContacts(idsRequired).size();
		int firstexpected = 2;
		assertEquals(expected , output);
		
		int[] idsRequiredAgain = {3}
		int secondoutput = cm.getContacts(idsRequiredAgain).size();
		int secondexpected = 1;
		assertEquals(expected , output);
	}
		
	
	
	
	
	
	
		
}