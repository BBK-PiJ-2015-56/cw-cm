import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.*;
import static org.junit.Assert.*;

public class TestPastMeetingImpl{
	
	Contact cont1;
	Contact cont2;
	Contact cont3;
	Set<Contact> contacts;
	Calendar date;
	PastMeeting meetingWithNotes;
	
	@Before
	public void setUp(){
		cont1 = new ContactImpl(1 , "James");
		cont2 = new ContactImpl(2 , "Jerome");
		cont3 = new ContactImpl(3 , "Joe");
		contacts = new HashSet<Contact>();
		contacts.add(cont1);
		contacts.add(cont2);
		contacts.add(cont3);
		System.out.println("contacts size: " + contacts.size());
		date = new GregorianCalendar(2016,0,28,15,0);
		meetingWithNotes = new PastMeetingImpl(1 , date , contacts , "All actions agreed. " );
		
	}
	@After
	public void tearDown(){
		contacts = null;
		date = null;
		meetingWithNotes = null;
	}
	@Test(expected = NullPointerException.class)
	public void testsNullNotesFailsConstructor(){
		meetingWithNotes = new PastMeetingImpl(1 , date , contacts , null);
	}

	@Test
	public void testsGetNotesWhenNoNotes(){
		PastMeeting meetingNoNotes = new PastMeetingImpl(1 , date , contacts , "");
		String output = meetingNoNotes.getNotes();
		String expected = "";
		assertEquals(expected , output);
	}
	@Test
	public void testsGetNotesWhenNotNull(){
		String output = meetingWithNotes.getNotes();
		String expected = "All actions agreed. ";
		assertEquals(expected , output);
	}
}