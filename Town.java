/**
 * Author:Oscar Saravia
 * CMSC 204
 * Town class has name of the town and has methods to create and copy town 
 * objects. It also has methods to compare and test other town objects.
 */
package abc;

public class Town implements Comparable<Town>{
	//Variables of the class, the name of the town
	private String name="";
	
	/**
	 * 
	 * @param name-The name of the town object being created
	 */
	public Town(String name) {
		this.name=name;
	}
	
	/**
	 * 
	 * @param town-The town object to be copied
	 */
	public Town(Town town) {
		Town newCopy=new Town(town.name);
	}
	
	/**
	 * 
	 * @return-The name of the town object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * CompareTo method that compares two different town objects
	 */
	@Override
	public int compareTo(Town o) {
		return o.name.compareTo(this.name);

	}
	
	/**
	 * Returns name of the town
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * 
	 * @return-The hashcode of the name of the town
	 */
	public int hashcode() {
		return name.hashCode();
	}
	
	/**
	 * 
	 * @param obj-The object checked to see if is the same
	 * @return-True if the names are the same else false
	 */
	public boolean equals(Town obj) {
		if(obj.name.equals(this.name))
			return true;
		else return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
