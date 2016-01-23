import java.util.Calendar;
import java.util.List;
import java.util.Set;
/**
* A class to manage your contacts and meetings.
*/
public interface ContactManager {
	/**
	* Create a new contact with the specified name and notes. 
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @return the ID for the new contact
	* @throws IllegalArgumentException if the name or the notes are empty strings
	* @throws NullPointerException if the name or the notes are null 
	*/
	int addNewContact(String name, String notes);
}
