
import org.junit.*;
import static org.junit.Assert.*;

public class TestContactImpl{
	Contact cont;
	@Before
	public void init(){
		cont = new ContactImpl(1, "James Brown");
	}
	
	@Test
	public void testGetId(){
		int output = cont.getId();
		int expected = 1;
		assertEquals(expected , output);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testsNegativeAndZeroIdsFailFirstConstructor(){
		cont = new ContactImpl( -1 , "Sam Cooke");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testsNegativeAndZeroIdsFailSecondConstructor(){
		cont = new ContactImpl( -1 , "Sam Cooke", "Good contact. ");
	}
	@Test
	public void testGetName(){
		String output = cont.getName();
		String expected = "James Brown";
		assertEquals(expected , output);
	}
	@Test(expected = NullPointerException.class)
	public void testNullNameFailsFirstConstructor(){
		cont = new ContactImpl(1,null);
	}
	@Test(expected = NullPointerException.class)
	public void testNullNameFailsSecondConstructor(){
		cont = new ContactImpl(1,"James Brown" , null);
	}
	
	@Test 
	public void testGetNotesWhenNull(){
		String output = cont.getNotes();
		String expected = "";
		assertEquals(expected, output);
	}
	
	@Test
	public void testsAddNotesWhenNotesNullAndGetNotes(){
		cont.addNotes("Works for Edugood Ltd. ");
		String output = cont.getNotes();
		String expected = "Works for Edugood Ltd. ";
		assertEquals(expected , output);
	}
	
	@Test
	public void testsAddNotesWhenNotesNotNullAndGetNotes(){
		cont.addNotes("Good contact. ");
		cont.addNotes("Works for Edugood Ltd. ");
		String output = cont.getNotes();
		String expected = ("Good contact. Works for Edugood Ltd. ");
		assertEquals(expected , output);
	}
}
