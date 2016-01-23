import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.*;
import static org.junit.Assert.*;

public class TestContactManagerImpl{

	@Before
	public void setUp(){
		ContactManager cm = new ContactManagerImpl();
	}
	@After
	public void tearDown(){
		cm = null;
	}
	
	@Test
	public void testAddNewContactEmptyNotes(){
		cm.addNewContact("Charlie Parker" , "");
		int output = cm.getContacts().size();
		int expected = 1;
		assertEquals(expected , output);
	} 
	
	

		
		
}