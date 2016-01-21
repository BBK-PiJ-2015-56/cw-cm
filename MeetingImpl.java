import java.util.Calendar;
import java.util.Set;
/**
* @see Meeting
*/
public class MeetingImpl implements Meeting {
	int id;
	Calendar date;
	Set<Contact> contacts;
	
	public MeetingImpl(int id , Calendar date , Set<Contact> contacts){
		this.id = id;
		this.date = date;
		this.contacts = contacts;
	}
	
	/**
	* @see Meeting
	*/
	//public int getId(){
		
	//}
}
	
