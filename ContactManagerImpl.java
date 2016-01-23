import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
* @see ContactManager
*/
public class ContactManagerImpl implements ContactManager{
	Set<Contact> contacts;
	Set<Meeting> meetings;
	
	public ContactManagerImpl(){
		contacts = new HashSet<Contact>();
		meetings = new HashSet<Meeting>();
	}
	public int addNewContact(String name , String notes){
		contacts.add(new ContactImpl(1, name, notes));
		return 10;
	}
	
	public Set<Contact> getContacts(){
		return contacts;
	}
}