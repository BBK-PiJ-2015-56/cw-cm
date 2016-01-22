import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

/**
* This class allows for the instantiation of MeetingImpl objects.
* When a meeting is created that has not happened yet, it can be of type FutureMeetingImpl
* This class can also be used to test methods in MeetingImpl
*
*/

public class FutureMeetingImpl extends MeetingImpl{
	public FutureMeetingImpl(int id , Calendar date , Set<Contact> contacts){
		super(id , date , contacts);
	}
}