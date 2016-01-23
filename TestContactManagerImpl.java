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
	public void testAddNewContactEmptyNotes(){
		cm.addNewContact("Charlie Parker" , "");
		int output = ((ContactManagerImpl)cm).getContacts().size();
		int expected = 1;
		assertEquals(expected , output);
	} 
	
	

		
		
}