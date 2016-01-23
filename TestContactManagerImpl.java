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
		
}