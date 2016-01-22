import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting{
	String notes;
	public PastMeetingImpl(int id , Calendar date , Set<Contact> contacts, String notes){
		super(id , date , contacts);
		if(notes == null){
			throw new NullPointerException();
		}else{
		this.notes = notes;
		}
	}
	
	/*
	The following second constructor has been removed having read the new requirements 
	online that were not there when i printed them off. I have left it in the code below because
	it will already be on some of the commits.
	 
	 A second constructor for when the user wants to include notes
	
	public PastMeetingImpl(int id , Calendar date , Set<Contact> contacts, String notes){
		super(id , date , contacts);
		this.notes = notes;
	}
	*/
	
	public String getNotes(){
		return notes;
	}
}