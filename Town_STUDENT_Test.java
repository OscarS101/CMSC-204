package abc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
	Town t1=new Town("hi");
	Town t2=new Town("no");
	Town t3=new Town("bye");
	Town t4=new Town("maybe");
	Town t5=new Town("no");
	Town t6=new Town("yes");
	
	public void setUp() {
		
	}
	
	public void tearDown() {
		
	}
	
	@Test
	public void testgetName() {
		assertEquals("hi",t1.getName());
		assertEquals("yes",t6.getName());
	}
	
	@Test
	public void testcompareTo() {
		assertEquals(0,t4.compareTo(new Town("maybe")));
		
		assertEquals(0,t2.compareTo(t5));
	}
	
	@Test
	public void testEquals() {
		assertEquals(true,t2.equals(t5));
		
		assertEquals(false,t1.equals(t2));
	}
	
	
	@Test
	public void testToString() {
		assertEquals("bye",t3.toString());
		
		assertEquals("maybe",t4.toString());
	}
	
	@Test
	public void testHashcode() {
		String t1="bye";
		String t2="maybe";
		
		assertEquals(t1.hashCode(),t3.hashcode());
		
		assertEquals(t2.hashCode(),t4.hashcode());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
