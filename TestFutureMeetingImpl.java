import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFutureMeetingImpl {
	
	Contact cont1;
	Contact cont2;
	Contact cont3;
	Set<Contact> contacts;
	Calendar date;
	Meeting meeting;
	
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
		System.out.println(date.getTime());
		meeting = new FutureMeetingImpl(1 , date , contacts);
	}
	@After
	public void tearDown(){
		contacts = null;
		date = null;
		meeting = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsEmptyContactsFails(){
		System.out.println("date: " + date.getTime());
		Set<Contact> contactsEmpty = new HashSet<Contact>();
		System.out.println("The size of this contact set is " + contactsEmpty.size());
		meeting = new FutureMeetingImpl(1 , date , contactsEmpty);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsNegativeOrZeroIdFails(){
		System.out.println("date: " + date.getTime());
		meeting = new FutureMeetingImpl(-1 , date , contacts);
	}
	@Test(expected = NullPointerException.class)
	public void testNullDateFails(){
		System.out.println("date: " + date.getTime()); 
		date = null;
		meeting = new FutureMeetingImpl(1, date, contacts);
	}
	@Test(expected = NullPointerException.class)
	public void testNullContactsFails(){
		System.out.println("date: " + date.getTime());
		contacts = null;
		meeting = new FutureMeetingImpl(1, date, contacts);
	}
	@Test
	public void testsGetId(){
		System.out.println("date: " + date.getTime());
		int output = meeting.getId();
		int expected = 1;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetDate(){
	    System.out.println("date: " + date.getTime());
		Calendar output = meeting.getDate();
		Calendar expected = date;
		assertEquals(expected , output);
	}
	
	@Test
	public void testsGetContacts(){
		Set<Contact> output = meeting.getContacts();
		Set<Contact> expected = contacts;
		assertEquals(expected , output);
	} 	
	
}