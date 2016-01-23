import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
* @see ContactManager
*/
public class ContactManagerImpl implements ContactManager{
	private Set<Contact> contacts;
	private Set<Meeting> meetings;
	private int contactCount = 0;
	
	public ContactManagerImpl(){
		contacts = new HashSet<Contact>();
		meetings = new HashSet<Meeting>();
	}
	public int addNewContact(String name , String notes){
		if((name == "") || (notes == "")){
			throw new IllegalArgumentException();
		}else{
			contactCount++;
			contacts.add(new ContactImpl(1, name, notes));
			return contactCount;
			}
	}
	
	public Set<Contact> getContacts(){
		return contacts;
	}
}