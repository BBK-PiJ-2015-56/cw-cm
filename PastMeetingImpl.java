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
	
	
	 Note that there appears to me to be a contradiction in the latest requiremnets on moodle,
	 in that it says there must only one constructoe and that if notes is null then a NPE
	 must be thrown, but on the other hand the getNotes method allows for teh notes being null.
	 I have gone with the second option, providing the user with a choice of whether to 
	 include notes or not with 2 constructors. The original requirements that I had
	 does not specify that 2 constructors are not allowed.
	public PastMeetingImpl(int id , Calendar date , Set<Contact> contacts, String notes){
		super(id , date , contacts);
		this.notes = notes;
	}
	*/
	
	public String getNotes(){
		return notes;
	}
}