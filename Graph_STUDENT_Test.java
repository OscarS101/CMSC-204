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

public class Graph_STUDENT_Test {
	Graph g;
	Town[] test;{
	test=new Town[10];
	g=new Graph();
	
	for(int i=0;i<10;i++) {
		test[i]=new Town("town "+i);
		g.addVertex(test[i]);
	}

	}
	@Before
	public void setUp() {
		
	}
	
	@Before
	public void tearDown() {
		
	}
	
	@Test
	public void testContainsVertex() {
		assertEquals(true,g.containsVertex(test[4]));
		assertEquals(false,g.containsVertex(new Town("town #12")));
		assertEquals(true,g.containsVertex(test[6]));
	}
	
	
	@Test
	public void testContainsEdge() {
		g.addEdge(test[1], test[4], 0, "a");
		assertEquals(true,g.containsEdge(test[1], test[4]));
		g.addEdge(test[8], test[3], 0, "b");
		assertEquals(true,g.containsEdge(test[8], test[3]));
	}
	
	@Test
	public void testAddVertex() {
		g.addVertex(new Town("found"));
		assertEquals(true,g.containsVertex(new Town("found")));
		
		g.addVertex(new Town("hello"));
		assertEquals(true,g.containsVertex(new Town("hello")));
	}
	
	
	@Test
	public void testAddEdge() {
		g.addEdge(test[1], test[2], 0, "aaa");
		assertEquals(true,g.containsEdge(test[1], test[2]));
		g.addEdge(test[5], test[8], 0, "b");
		assertEquals(true,g.containsEdge(test[5], test[8]));
		assertEquals(false,g.containsEdge(test[7], test[3]));
		
	}
	
	@Test
	public void testEdgeSet() {
		Road r1=g.addEdge(test[8], test[7], 0, "a");
		Road r2=g.addEdge(test[8], test[1], 0, "b");
		Road r3=g.addEdge(test[9], test[1], 0, "c");
		Set<Road> t1=g.edgeSet();
		assertEquals(true,t1.contains(r3));
		assertEquals(true,t1.contains(r1));
		assertEquals(true,t1.contains(r2));
		assertEquals(false,t1.contains(new Road(test[1],test[2],0,"a")));
		
	}
	
	@Test
	public void testEdgesOf() {
		Road r1=g.addEdge(test[8], test[7], 0, "a");
		Road r2=g.addEdge(test[8], test[1], 0, "b");
		Road r3=g.addEdge(test[9], test[1], 0, "c");
		Set<Road> t1=g.edgesOf(test[8]);
		assertEquals(true,t1.contains(r1));
		assertEquals(true,t1.contains(r2));
		assertEquals(false,t1.contains(r3));
		
	}
	
	@Test
	public void testRemoveEdge() {
		Road r1=g.addEdge(test[8], test[7], 0, "a");

		assertEquals(true,g.containsEdge(test[8], test[7]));
		g.removeEdge(test[8], test[7], 0, "a");
		assertEquals(false,g.containsEdge(test[8],test[7]));
		
	}
	
	@Test
	public void testRemoveVertex(){
		assertEquals(true,g.containsVertex(test[4]));
		g.removeVertex(test[4]);
		assertEquals(false,g.containsVertex(test[4]));
		
		assertEquals(true,g.containsVertex(test[5]));
		g.removeVertex(test[5]);
		assertEquals(false,g.containsVertex(test[5]));
		
		
	}
	
	@Test
	public void testVertexSet() {
		Set<Town> t1=g.vertexSet();
		assertEquals(true,t1.contains(test[4]));
		assertEquals(true,t1.contains(test[7]));
		assertEquals(false,t1.contains(new Town("town #13")));
		
	}
	
	
	@Test
	public void testGetEdge() {
		Road r1=g.addEdge(test[8], test[7], 0, "a");
		Road r2=g.addEdge(test[8], test[1], 0, "b");
		Road r3=g.addEdge(test[9], test[1], 0, "c");
		assertEquals(r1,g.getEdge(test[8], test[7]));
		assertEquals(r2,g.getEdge(test[8], test[1]));
		assertEquals(r3,g.getEdge(test[9],test[1]));
	}
	
	
	@Test
	public void testShortPath() {
		Road r1=g.addEdge(test[1], test[7], 5, "a");
		Road r2=g.addEdge(test[8], test[1], 2, "b");
		Road r3=g.addEdge(test[7], test[9], 3, "c");
		ArrayList<String> bb=g.shortestPath(test[8], test[1]);
		assertEquals("town 8 via b to town 1 2 mi",bb.get(0).trim());
		bb=g.shortestPath(test[1], test[9]);
		assertEquals("town 1 via a to town 7 5 mi",bb.get(0).trim());
		assertEquals("town 7 via c to town 9 3 mi",bb.get(1).trim());
	}
	
	
	
	
	
	
	
	
	
	
}
