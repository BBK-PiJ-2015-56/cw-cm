import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
/**
* This class provides an implementation of Meeting so that FutureMeeting and PastMeeting can extend it easily.
* All methods are impemented here. (Note the lack of clarity in the requirements about whether Set<Contact> 
* is supposed to refer solely to people who attended a past meeting, or to people who are expected to attend
* a future meeting. Here, it is taken to mean both future expected attendees (in FutureMeeting class) and 
* past attendees (in PastMeeting class))
*  
* @see Meeting
*/
public abstract class MeetingImpl implements Meeting {
	int id;
	Calendar date;
	Set<Contact> contacts;
	
	public MeetingImpl(int id , Calendar date , Set<Contact> contacts){
		if(id <= 0){
			throw new IllegalArgumentException();
		}
		else if(contacts.size() == 0){
			throw new IllegalArgumentException();
		}
		else{
			this.id = id;
			this.date = date;
			this.contacts = contacts;
		}
	}
	/**
	* @see Meeting
	*/
	public int getId(){
		return id;
	}
	
	/**
	* @see Meeting
	*/
	public Calendar getDate(){
		return date;
	}
	
	/**
	* @see Meeting
	*/
	public Set<Contact> getContacts(){
		return contacts;
	}
		
	
}
	
