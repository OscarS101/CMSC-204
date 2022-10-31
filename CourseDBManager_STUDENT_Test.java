package abc;



import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {

	private CourseDBManagerInterface test = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		test = new CourseDBManager();
	}

	/**
	 * Set test reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		test = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			test.add("Mat123",28109,3,"BC210","Random Guy");
			test.add("tst587", 10148, 1, "Hi481", "test oeson");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		test.add("Engl128",30559,5,"CFS220","Jane Lock");
		test.add("Math123",30504,2,"RC130","Keith Scott");
		ArrayList<String> list = test.showAll();
		assertEquals(list.get(0),"\nCourse:Engl128 CRN:30559 Credits:5 Instructor:Jane Lock Room:CFS220");
		assertEquals(list.get(1),"\nCourse:Math123 CRN:30504 Credits:2 Instructor:Keith Scott Room:RC130");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File info = new File("Test1.txt");
			PrintWriter file = new PrintWriter(info);
			file.println("Psych101 00001 2 RC111 Jane Don");
			file.print("Engl200 00002 1 MCD000 MC chckn");
			
			file.close();
			test.readFile(info);
			assertEquals(2,test.get(00001).numCredits);
			assertEquals("Psych101",test.get(00001).getID());
			assertEquals("MCD000",test.get(00002).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
