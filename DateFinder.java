import java.util.Calendar;

/**
* A class for retrieving the current date, including hours and minutes
*/

public interface DateFinder{
	/* 
	* A method for getting the current date and time
	* @return A date object set to the current date and time
	*/
	Calendar getCurrentDate();
}