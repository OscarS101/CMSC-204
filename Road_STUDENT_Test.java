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

public class Road_STUDENT_Test {
	Town t1=new Town("a");
	Town t2=new Town("b");
	Town t3=new Town("c");
	Town t4=new Town("d");
	Town t5=new Town("e");
	Town t6=new Town("f");
	Road r1=new Road(t1,t2,1,"a");
	Road r2=new Road(t3,t4,4,"b");
	Road r3=new Road(t3,t6,4,"c");
	Road r4=new Road(t2,t5,1,"d");

	
	@Before
	public void setUp() {
		
	}
	

	public void tearDown() {
		
	}
	
	@Test
	public void testContains() {
		assertEquals(true,r1.contains(t1));
		
		assertEquals(false,r1.contains(t4));
		
		assertEquals(false,r2.contains(t1));
		assertEquals(true,r2.contains(t4));
	}
	
	@Test
	public void testGetName() {
		assertEquals(r1.getName(),"a");
		assertEquals(r3.getName(),"c");
		assertEquals(r4.getName(),"d");
	}
	
	@Test
	public void testgetSource() {
		assertEquals(t1,r1.getSource());
		assertEquals(t3,r3.getSource());
		assertEquals(t2,r4.getSource());
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(t4,r2.getDestination());
		assertEquals(t6,r3.getDestination());
	}
	
	@Test
	public void testcompareTo() {
		assertEquals(-1,t2.compareTo(t1));
		
		assertEquals(0,t1.compareTo(new Town("a")));
		assertEquals(-1,t3.compareTo(t2));
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(1,r1.getWeight(),.001);
		assertEquals(1,r4.getWeight(),001);
		assertEquals(4,r2.getWeight());
	}
	
	@Test
	public void testHashcode() {
		assertEquals(new Road(t1,t2,1,"a").hashcode(),r1.hashcode());
		assertEquals("b".hashCode(),r2.hashcode());
		assertEquals("d".hashCode(),r4.hashcode());
	}
	
	@Test
	public void testEquals() {
		assertEquals(false,r1.equals(r4));
		assertEquals(true,r1.equals(new Road(t1,t2,1,"a")));
		assertEquals(false,r4.equals(r2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
