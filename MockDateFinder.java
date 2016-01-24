import java.util.Calendar;
import java.util.GregorianCalendar;

public class MockDateFinder implements DateFinder {
	
	public Calendar getCurrentDate(){
		return new GregorianCalendar(2016,0,1,15,0);
	}
}