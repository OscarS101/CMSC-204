/**
 * Author:Oscar Saravia
 * CMSC 204
 * Road Class
 * The road class 
 */
package abc;

public class Road implements Comparable<Road>{
	
	//Variables used for the class, the start and end vertices as town objects
	//The cost to take a path and the name of the road
	Town start,end;
	int cost;
	String road;
	
	/**
	 * 
	 * @param source-The start of the road
	 * @param destination-The end of the road
	 * @param degrees-The cost to take the road
	 * @param name-The name of the road
	 */
	public Road(Town source,Town destination,int degrees,String name) {
		start=source;
		end=destination;
		cost=degrees;
		this.road=name;
	}
	
	/**
	 * Presets the cost to 1
	 * @param source-The start of the road
	 * @param destination-The end of the road
	 * @param name-The name of the road
	 */
	public Road(Town source,Town destination,String name) {
		start=source;
		end=destination;
		cost=1;
		road=name;
	}
	
	/**
	 * 
	 * @param town-The object to check for connection to
	 * @return-True if the road contains it, else false
	 */
	public boolean contains(Town town) {
		boolean result=false;
		if(this.start.equals(town))
			result=true;
		
		if(this.end.equals(town))
			result=true;
		
		return result;
	}
	
	/**
	 * 
	 * @return-The name of the road
	 */
	public String getName() {
		return road;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return getName();
	}
	
	/**
	 * 
	 * @return-The town objects where the road ends
	 */
	public Town getDestination() {
		return end;
	}
	
	/**
	 * 
	 * @return-The town object where the road starts
	 */
	public Town getSource() {
		return start;
	}
	
	/**
	 * Returns 0 if road names are equals else -1 or 1
	 */
	public int compareTo(Road o) {
		if(this.getName().equals(o.getName()))
			return 0;
		else return -1;
		
	}
	
	/**
	 * 
	 * @return-The cost to cross the road
	 */
	public int getWeight() {
		return cost;
	}
	
	/**
	 * 
	 * @param i-The road object to be checked for equality
	 * @return-True if the endpoints are the same, else false
	 */
	public boolean equals(Object i) {
		Road i1=(Road)i;
		if(this.end.equals(i1.end)&&this.start.equals(i1.start))
			return true;
		
		else if(this.end.equals(i1.start)&&this.start.equals(i1.end))
			return true;
		
		return false;
	}
	
	public void setDestination(Town town) {
		end=town;
	}
	
	public void setSource(Town town) {
		start=town;
	}
	
	public int hashcode() {
		return road.hashCode();
	}
}
