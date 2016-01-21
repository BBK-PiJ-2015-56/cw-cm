import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.*;
import static org.junit.Assert.*;

public class TestMeetingImpl{
	Contact cont1;
	Contact cont2;
	Contact cont3;
	Set<Contact> contacts;
	Calendar date;
	Meeting meeting;
	
	@Before
	public void init(){
		cont1 = new ContactImpl(1 , "James");
		cont2 = new ContactImpl(2 , "Jerome");
		cont3 = new ContactImpl(3 , "Joe");
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.add(cont1);
		contacts.add(cont2);
		contacts.add(cont3);
		Calendar date = new GregorianCalendar(2016,0,28,15,0);
		System.out.println(date.getTime());
		meeting = new MeetingImpl(1 , date , contacts);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testsEmptyContactsFails(){
		Set<Contact> contactsEmpty = new HashSet<Contact>();
		System.out.println("The size of this contact set is " + contactsEmpty.size());
		meeting = new MeetingImpl(1 , date , contactsEmpty);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsNegativeOrZeroIdFails(){
		meeting = new MeetingImpl(-1 , date , contacts);
	}
	@Test(expected = NullPointerException.class)
	public void testNullDateFails(){
		date = null;
		meeting = new MeetingImpl(1, date, contacts);
	}
	@Test(expected = NullPointerException.class)
	public void testNullContactsFails(){
		contacts = null;
		meeting = new MeetingImpl(1, date, contacts);
	}
	@Test
	public void testsGetId(){
		int output = meeting.getId();
		int expected = 1;
		assertEquals(expected , output);
	}
	
	
}