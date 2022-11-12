/**
 * Author:Oscar Saravia
 * CMSC 204
 * Assignment 5
 * This class was made to test methods for the MorseCodeTree class
 */
package abc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTree_STUDENT_Test {
	MorseCodeTree test1,test2;
	
	@Before
	public void setUp()throws Exception{
		test1=new MorseCodeTree();
		test2=new MorseCodeTree();
	}
	
	@After
	public void tearDown()throws Exception{
		test1=test2=null;
	}
	
	@Test
	public void testSetRoot() {
		TreeNode work=new TreeNode(" ");
		test1.setRoot(work);
		assertEquals(test1.getRoot().data," ");
		
		TreeNode hello=new TreeNode("data");
		test2.setRoot(hello);
		assertEquals(test2.getRoot().data,"data");
	}
	
	@Test
	public void testToArrayList() {
		ArrayList<String> list=new ArrayList<>();
		list=test1.toArrayList();
		assertEquals(list.get(0),"h");
		assertEquals(list.get(list.size()-1),"o");
	}
	
	@Test
	public void testFetch() {
		assertEquals(test1.fetch("---"),"o");
		
		assertEquals(test2.fetch("-.-."),"c");
		
		assertEquals(test1.fetch("-..-"),"x");
		
		assertEquals(test2.fetch("--.."),"z");
	}
}
	