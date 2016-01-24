import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.*;
import static org.junit.Assert.*;

public class TestContactManagerImpl{
	private ContactManager cm;
	private Contact cont1;
	private Contact cont2;
	private Contact cont3;
	private Calendar date;
	private Set<Contact> contactsRequired;
	
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
		String name = null;
		int output = cm.getContacts(name).size();
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
	public void testsGetContactsArrayIdMatches(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int[] idsRequired = { 1 , 15 ,  3 , 10};
		System.out.println(" array length "  + idsRequired.length);
		int output = cm.getContacts(idsRequired).size();
		int expected = 2;
		assertEquals(expected , output);
	}
	
	@Test
	public void testsGetContactsArrayNoMatch(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		int[] idsRequired = { 5 , 6 , 10};
		System.out.println(" array length "  + idsRequired.length);
		int output = cm.getContacts(idsRequired).size();
		int expected = 0;
		assertEquals(expected , output);
	}
	@Test
	public void testsGetContactsIntArg(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		int output = cm.getContacts(2).size();
		int expected = 1;
		assertEquals(expected , output);
		
		int secondoutput = cm.getContacts(5).size();
		int secondexpected = 0;
		assertEquals(expected , output);
	}
	@Test
	public void testsAddFutureMeetingAndMeetingsGetter(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(2 , "Louis Armstrong");
		cont3 = new ContactImpl(3 , "Nat King Cole");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		System.out.println("The number of contacts required is: " + contactsRequired.size());
		
		date = new GregorianCalendar(2016,0,28,15,0);
		int returnOutput =  cm.addFutureMeeting(contactsRequired , date);
		int returnExpected = 1;
		assertEquals(returnExpected , returnOutput);
		
		int output = ((ContactManagerImpl)cm).getMeetings().size();
		int expected = 1;
		assertEquals(expected , output);
	}
	
	@Test
	public void testsAddFutureMeetingNoTimeCheckIdsUnique(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(2 , "Louis Armstrong");
		cont3 = new ContactImpl(3 , "Nat King Cole");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		Calendar date1 = new GregorianCalendar(2016,0,28,15,0);
		Calendar date2 = new GregorianCalendar(2016,0,29,15,0);
		Calendar date3 = new GregorianCalendar(2016,0,30,15,0);
		int id1 =  cm.addFutureMeeting(contactsRequired , date1);
		int id2 =  cm.addFutureMeeting(contactsRequired , date2);
		int id3 =  cm.addFutureMeeting(contactsRequired , date3);
		
		assertEquals(1 , id1);
		assertEquals(2 , id2);
		assertEquals(3 , id3);
	}
	
	@Test(expected = NullPointerException.class)
	public void testsAddFutureMeetingCNullArg(){
		Calendar date = new GregorianCalendar(2016,0,28,15,0);
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(2 , "Louis Armstrong");
		cont3 = new ContactImpl(3 , "Nat King Cole");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		
		date = null;
		cm.addFutureMeeting(contactsRequired , date);
		
		contactsRequired = null;
		cm.addFutureMeeting(contactsRequired , date);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingContactUnknown(){
		Calendar date = new GregorianCalendar(2016,0,28,15,0);
		
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(50 , "Stuff Smith");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		
		cm.addFutureMeeting(contactsRequired , date);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingTimeInPast(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(2 , "Louis Armstrong");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		
		Calendar date = new GregorianCalendar(2015,0,28,15,0);
		cm.addFutureMeeting(contactsRequired , date);
	}	
	
	@Test
	public void testAddFutureMeetingTimeEqualsCurrentTimeOrSameDay(){
		cm.addNewContact("Charlie Parker" , "Great on sax");
		cm.addNewContact("Louis Armstrong" , "Great on trumpet");
		cm.addNewContact("Nat King Cole" , "fantastic voice");
		
		cont1 = new ContactImpl(1 , "Charlie Parker");
		cont2 = new ContactImpl(2 , "Louis Armstrong");
		contactsRequired = new HashSet<Contact>();
		contactsRequired.add(cont1);
		contactsRequired.add(cont2);
		
		Calendar date = new GregorianCalendar(2016,0,1,15,0);
		cm.addFutureMeeting(contactsRequired , date);
		Calendar date2 = new GregorianCalendar(2016,0,1,15,30);
		cm.addFutureMeeting(contactsRequired , date2);
		Calendar date3 = new GregorianCalendar(2016,0,1,17,0);
		cm.addFutureMeeting(contactsRequired , date);
		
		int output = ((ContactManagerImpl)cm).getMeetings().size();
		int expected = 3;
		assertEquals(expected , output);
	}
	
}