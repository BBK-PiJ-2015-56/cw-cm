import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.util.Iterator;

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
			contacts.add(new ContactImpl(contactCount, name, notes));
			return contactCount;
		}
	}
	//basic getter for contacts
	public Set<Contact> getContacts(){
		return contacts;
	}
	/**
	* @see ContactManager
	*/
	public Set<Contact> getContacts(String name){
		if(name == null){
			throw new NullPointerException();
		}else{
			Set<Contact> contactsRequired = new HashSet<Contact>();
			Iterator<Contact> iterator = contacts.iterator();
			Contact current;
			while(iterator.hasNext()){
				current = iterator.next();
				if(current.getName() == name){
					contactsRequired.add(current);
				}
			}
			return contactsRequired;
		}
	}
	
}