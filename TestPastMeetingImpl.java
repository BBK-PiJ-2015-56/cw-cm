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
	Calendar date1;
	Calendar date2;
	PastMeeting meetingWithNotes;
	PastMeeting meetingNoNotes;
	
	@Before
	public void setUp(){
		cont1 = new ContactImpl(1 , "James");
		cont2 = new ContactImpl(2 , "Jerome");
		cont3 = new ContactImpl(3 , "Joe");
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.add(cont1);
		contacts.add(cont2);
		contacts.add(cont3);
		System.out.println("contacts size: " + contacts.size());
		date1 = new GregorianCalendar(2016,0,28,15,0);
		date2 = new GregorianCalendar(2016,0,28,16,0);
		meetingWithNotes = new PastMeetingImpl(1 , date1 , contacts , "All actions agreed. " );
		meetingNoNotes = new PastMeetingImpl(2, date2, contacts);
		
	}
	@After
	public void tearDown(){
		contacts = null;
		date1 = null;
		date2 = null;
		meetingWithNotes = null;
		meetingNoNotes = null;
	}
	
	// no need to test exceptions already tested in MeetingImpl
	@Test
	public void testsGetNotesWhenNull(){
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