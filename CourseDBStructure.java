/**
 * Author:Oscar Saravia
 * CDBS class that is the structure for the database that uses a hashtable
 * The class finds the 4k+3 number and sets the tablesize to that.
 * This class is also responsible for adding CDBE to the table and making sure to
 * not add duplicates. When retrieving said elements it will handle the situation 
 * accordingly
 * 
 * Assignment 4
 * CMSC 204
 */
package abc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	//Declare the array of linked lists and the variable used for the size of the 
	//hashtable
	LinkedList table[];
	int space;
	
	//Given method used to determines the 4k+3 number for tablesize
	static boolean isPrime(int n) {         // Corner case         
		if (n <= 1)             
			return false;
		// Check from 2 to square_root(n)
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true; 
	}
	
	
	/**
	 * 
	 * @param i-int that decides size of hashtable with 4k+3
	 */
	public CourseDBStructure(int i) {
		//Determine the space for the table
		space=(int) (i/1.5+6);
		
		//Make sure the space is the next prime number
		while(isPrime(space)==false) {
			space++;
		}
		
		//Make the array with new prime number
		table=new LinkedList[space];
	}

	/**
	 * 
	 * @param Testing-String for testing purposes
	 * @param i-int for testing purposes
	 */
	public CourseDBStructure(String Testing, int i) {
		//Set table to passed int
		space=i;
		table=new LinkedList[i];
	}

	/**
	 * 
	 * @param cde1-CDE element that will allow us to add the class
	 */
	public void add(CourseDBElement cde1) {
		//The index the object will go to this variable
		int code=String.valueOf(cde1.CRN).hashCode()%space;
		
		//Create the linked list at the area of the key
		table[code]=new LinkedList<CourseDBElement>();
		
		//Make sure the linkedlist exists and that the added element
		//isn't a duplicate
		if(table[code]!=null&&table[code].contains(cde1)==false) {
			table[code].add(cde1);
		}
	}
	
	/**
	 * 
	 * @return-An array list of string that shows all info 
	 * relevant to the class
	 */
	public ArrayList<String> showAll() {
		//Create the arraylist to be returned
		ArrayList<String> result=new ArrayList<>(space);
		CourseDBElement copy;
		
		//Start the loop to go through each bucket
		for(int i=0;i<table.length;i++) {
			//Make sure to only check buckets that are not null
			if(table[i]!=null) {
				//Go through each entry in the bucket
				for(int n=0;n<table[i].size();n++) {
					//Make a copy to access data
					copy=(CourseDBElement) table[i].get(n);
					//Add data to arraylist
					result.add("\nCourse:"+copy.courseID+
								" CRN:"+copy.CRN+
								" Credits:"+copy.numCredits+
								" Instructor:"+copy.name+
								" Room:"+copy.roomNum);
				
			
				}
				
			}
			
		}
		return result;
	}
	
	/**
	 * 
	 * @param crn-The key assoicated with the cde to be returned
	 * @return-The cde
	 * @throws IOException-Throws excpetion of cde not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		//Find the area in which the CDBE is located
		int index=String.valueOf(crn).hashCode()%space;
		
		//Condition to check for exception
		boolean result=false;
		
		//If the location doesn't exist throw exception
		if(table[index]==null)
			throw new IOException();
		
		//Go through each entry in the bucket
		for(int i=0;i<table[index].size();i++) {
			
			//Make a copy to check for the crn
			CourseDBElement copy=(CourseDBElement) table[index].get(i);
			
			//If the crn # matches return the CBDE
			if(copy.CRN==crn) {
				return copy;
			}
			
		}
		//If its not found in the bucket throw the error
		throw new IOException();
	}



	/**
	 * 
	 * @return-int showing the size of the hastable
	 */
	public int getTableSize() {
		//Returning tablesize 
		return space;
	}

}
