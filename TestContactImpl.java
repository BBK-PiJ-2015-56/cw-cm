
import org.junit.*;
import static org.junit.Assert.*;

public class TestContactImpl{
	Contact cont;
	@Before
	public void init(){
		cont = new ContactImpl();
	}
	
	@Test
	public void testGetId(){
		int output = cont.getId();
		int expected = 1;
		assertEquals(expected , output);
	}
}
