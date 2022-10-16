package abc;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class BasicDoubleLinkedList_STUDENT_Test<StringComparator> {

	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparatorS;
	
	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Word");
		linkedString.addToEnd("Test");
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(7.0);
		linkedDouble.addToEnd(1.0);
	}

	@After
	public void tearDown() throws Exception {
		linkedString=null;
		linkedDouble=null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Test", linkedString.getLast());
		linkedString.addToEnd("Word");
		assertEquals("Word", linkedString.getLast());
		
	
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Word", linkedString.getFirst());
		linkedString.addToFront("start");
		assertEquals("start", linkedString.getFirst());
		
	
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Word", linkedString.getFirst());
		linkedString.addToFront("hi");
		assertEquals("hi", linkedString.getFirst());
		
		
	}

	@Test
	public void testGetLast() {
		assertEquals("Word", linkedString.getLast());
		linkedString.addToEnd("java");
		assertEquals("java", linkedString.getLast());
	}
	@Test
	public void testToArrayList()
		{
			ArrayList<Double> list;
			linkedDouble.addToFront(9.0);
			linkedDouble.addToEnd(1.0);
			list = linkedDouble.toArrayList();
			assertEquals(9.0,.001,list.get(9));
			assertEquals(7.0,.001,list.get(7));
			assertEquals(1.0,.001,list.get(1));
			assertEquals(9.0,.001,list.get(1));
		}
	
	

}
