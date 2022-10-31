/**
 * Author:Oscar Saravia
 * 
 * CDBE class is responsible for the fields in which the elements 
 * have. It has a constructor and get methods that work according
 * to the documentation
 * 
 * Assignment 4
 * CMSC 204
 */
package abc;

public class CourseDBElement implements Comparable {

	//Attributes used in the constructor set to default values
	String courseID="";
	int CRN=0;
	int numCredits=0;
	String roomNum="";
	String name="";
	
	/**
	 * 
	 * @param courseID-The name of the course as a string
	 * @param CRN-The crn number of the class as a int
	 * @param numCredits-The # of credits the class is worth as an int
	 * @param roomNum-The number of the room as a string
	 * @param name-The name of the teacher as a string
	 */
	public CourseDBElement(String courseID, int CRN, int numCredits, String roomNum, String name) {
		this.courseID=courseID;
		this.CRN=CRN;
		this.numCredits=numCredits;
		this.roomNum=roomNum;
		this.name=name;
		
	}

	/**
	 * Default constructor to set fields to default
	 */
	public CourseDBElement() {
		courseID=null;
		CRN=0;
		numCredits=0;
		roomNum=null;
		name=null;
	}

	/**
	 * Getter for crn
	 * @return-the crn
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * Getter for courseID
	 * @return-The courseID
	 */
	public String getID() {
		return courseID;
	}

	/**
	 * 
	 * @return-The roomNum as a String
	 */
	public String getRoomNum() {
		return roomNum;
	}
	
	/**
	 * 
	 * @param parseInt-The integer to set the CRN to
	 */
	public void setCRN(int parseInt) {
		CRN=parseInt;
	}

	@Override
	public int compareTo(Object o) {
		CourseDBElement copy=(CourseDBElement)o;
		
		return 0;
	}
	
	
	
	
	
	
}
