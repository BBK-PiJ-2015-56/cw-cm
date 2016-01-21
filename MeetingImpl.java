import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
/**
* @see Meeting
*/
public class MeetingImpl implements Meeting {
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
	
}
	
