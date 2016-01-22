import java.util.Calendar;
import java.util.List;
import java.util.Set;
/**
* A class to manage your contacts and meetings.
*/
public interface ContactManager {
	/**
	* Add a new meeting to be held in the future.
	*
	* An ID is returned when the meeting is put into the system. This
	* ID must be positive and non-zero.
	*
	* @param contacts a list of contacts that will participate in the meeting
	* @param date the date on which the meeting will take place
	* @return the ID for the meeting
	* @throws IllegalArgumentException if the meeting is set for a time
	* in the past, of if any contact is unknown / non-existent.
	* @throws NullPointerException if the meeting or the date are null
	*/
	int addFutureMeeting(Set<Contact> contacts, Calendar date);
}

