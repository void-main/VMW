import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Before
	public void setup() {
		Fixtures.deleteDatabase();
	}

    @Test
    public void fullTest() {
    	Fixtures.loadModels("data.yml");
    	
    	// assert goes here
    	assertEquals(1, Developer.count());
    	assertNotNull(Developer.connect("voidmain1313113@gmail.com", "secret"));
    	assertNull(Developer.connect("voidmain1313113@gmail.com", "bad_password"));
    	assertNull(Developer.connect("noname@gmail.com", "secret"));
    }

}
