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
	private int meetingCount = 0;
	
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
	
	//does it need IAE if contactsRequired is empty? confirm requirements
	public int addFutureMeeting(Set<Contact> contacts, Calendar date){
		if(contacts == null){
			throw new NullPointerException();
		} else if(date == null){
			throw new NullPointerException();
		} else {
			for (Contact contactRequired : contacts){
				System.out.println(" checking match for contact id: " + contactRequired.getId());
				boolean contactKnown = false;
				for(Contact contact : this.contacts){
					System.out.println("checking if this contact matches contact with id: "+ contact.getId());
					if(contact.getId() == contactRequired.getId()){
						contactKnown = true;
					}
				}
				if (contactKnown == false){
					System.out.println("This contact has no matches in contacts");
					throw new IllegalArgumentException();
				}
			}
			meetingCount++;
			Meeting meeting = new FutureMeetingImpl( meetingCount , date , contacts);
			meetings.add(meeting);
			return meeting.getId();
		}
	}
	
	public Set<Meeting> getMeetings(){
		return meetings;
	}
	
	
	
	
	
	
	
	
	
	
}