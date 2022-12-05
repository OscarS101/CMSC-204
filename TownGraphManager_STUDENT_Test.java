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

public class TownGraphManager_STUDENT_Test {
	TownGraphManager obj=new TownGraphManager();
	
	@Before
	public void setUp() {
		obj.addRoad("hi", "bye", 0, "words");
		obj.addRoad("a", "b", 0, "char");
		obj.addRoad("1", "2", 0, "du");
		obj.addTown("hi");
		obj.addTown("bu");
		obj.addTown("4r");
	}
	
	@Before
	public void tearDown() {
		
	}
	
	@Test
	public void testAllRoads() {
		ArrayList<String> t1=new ArrayList<>();
		t1=obj.allRoads();
		assertEquals(true,t1.contains("words"));
		assertEquals(true,t1.contains("char"));
		assertEquals(false,t1.contains("fail"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> t1=obj.allTowns();
		assertEquals(true,t1.contains("hi"));
		assertEquals(true,t1.contains("bu"));
		assertEquals(true,t1.contains("4r"));
		assertEquals(false,t1.contains("not Found"));
	}
	
	
	@Test
	public void testAddRoad() {
		obj.addRoad("a", "z", 0, "letter");
		assertEquals(true,obj.containsRoadConnection("a", "z"));
		obj.addRoad("bro", "family", 0, "life");
		assertEquals(true,obj.containsRoadConnection("bro","family"));
		assertEquals(false,obj.containsRoadConnection("family", "a"));
	}
	
	@Test
	public void testAddTown() {
		obj.addTown("yes");
		obj.addTown("no");
		obj.addTown("long word");
		assertEquals(true,obj.containsTown("yes"));
		assertEquals(true,obj.containsTown("no"));
		assertEquals(true,obj.containsTown("long word"));
		assertEquals(false,obj.containsTown("nonexistant"));
	}
	
	@Test
	public void testContainsTown() {
		assertEquals(true,obj.containsTown("hi"));
		assertEquals(true,obj.containsTown("bu"));
		assertEquals(false,obj.containsTown("me"));
		assertEquals(true,obj.containsTown("4r"));
	}
	
	@Test
	public void testContainsRoad() {
		assertEquals(true,obj.containsRoadConnection("hi", "bye"));
		assertEquals(true,obj.containsRoadConnection("1", "2"));
		assertEquals(true,obj.containsRoadConnection("a","b"));
		assertEquals(false,obj.containsRoadConnection("a", "2"));
	}
	

	@Test
	public void testDeleteRoad() {
		obj.deleteRoadConnection("hi", "bye", "words");
		assertEquals(true,obj.containsRoadConnection("a", "b"));
		obj.deleteRoadConnection("a", "b", "char");
		obj.deleteRoadConnection("1", "2", "du");
		
		assertEquals(false,obj.containsRoadConnection("hi", "bye"));
		assertEquals(false,obj.containsRoadConnection("1", "2"));
		assertEquals(false,obj.containsRoadConnection("1", "2"));
	}
	
	
	
	@Test
	public void testDeleteTown() {
		obj.deleteTown("1");
		assertEquals(true,obj.containsTown("4r"));
		obj.deleteTown("4r");
		assertEquals(false,obj.containsTown("4r"));
		assertEquals(false,obj.containsTown("1"));
	}
	
	
	
	@Test
	public void testGetRoad() {

		Road r1=new Road(new Town("hi"),new Town("bye"),0,"words");
		Road r2=new Road(new Town("a"),new Town("b"),0,"char");
		assertEquals(r1.getName(), obj.getRoad("hi", "bye"));
		assertEquals(r2.getName(),obj.getRoad("a", "b"));
	}
	
	
	@Test
	public void testGetTown() {
		assertTrue(new Town("hi").equals(obj.getTown("hi")));
		assertTrue(new Town("4r").equals(obj.getTown("4r")));
		assertTrue(new Town("bu").equals(obj.getTown("bu")));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
