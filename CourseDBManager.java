/**
 * Author:Oscar Saravia
 * CDBM class is responsible for managing CBS methods and for
 * reading data from files
 * 
 * Asignment 4
 * CMSC 204
 */
package abc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager  implements CourseDBManagerInterface {
	//Make the CBS with default size
	CourseDBStructure data=new CourseDBStructure(29);	
	
	/**
	 * Make CDBE object and add it to table
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		//Make the object
		CourseDBElement course=new CourseDBElement(id,crn,credits,roomNum,instructor);
		
		//Add object to table
		data.add(course);
	}

	/**
	 * Call DBS get method and return result
	 */
	public CourseDBElement get(int crn) {
		//Declare variable used to store CDBE object
		CourseDBElement result=null;
		
		//Catch error and set it to result
		try {
			result=data.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param input-The file from which information is
	 * taken from
	 * @FileNotFoundException-thrown when file is not found
	 */
	public void readFile(File input) throws FileNotFoundException {
		
		if(!input.exists())
			throw new FileNotFoundException();
		
		Scanner read=new Scanner(input);
		while(read.hasNext()) {
		CourseDBElement file=new CourseDBElement(read.next(),read.nextInt(),read.nextInt(),read.next(),read.next());
		data.add(file);
		read.nextLine();
		}
		
		
		
		
		
	}
	
	/**
	 * Use DBS object and return arraylist from DBS
	 */
	public ArrayList<String> showAll() {
		
		return data.showAll();
	}

}
