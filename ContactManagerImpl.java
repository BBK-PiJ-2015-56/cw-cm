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
		}else if (name == ""){
			return contacts;
			} else {
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
	
	/**
	* @see ContactManager
	*/
	public Set<Contact> getContacts(int... ids){
		if(ids == null){
			throw new NullPointerException();
		} else {
				Set<Contact> contactsRequired = new HashSet<Contact>();
				Iterator<Contact> iterator = contacts.iterator();
				Contact current;
				while(iterator.hasNext()){
					current = iterator.next();
					for(int count = 0; count < ids.length; count++){
						if(current.getId() == ids[count]){
							contactsRequired.add(current);
							break; 
						}
					}
				}
				return contactsRequired;
			}
	}
	/**
	* @see ContactManager
	*/
	public int addFutureMeeting(Set<Contact> contacts, Calendar date){
		Meeting meeting = new FutureMeetingImpl( 10 , date , contacts);
		meetings.add(meeting);
		return meeting.getId();
	}
	
	public Set<Meeting> getMeetings(){
		return meetings;
	}
	
	
	
	
	
	
	
	
	
	
}