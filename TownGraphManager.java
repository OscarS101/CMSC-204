package abc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface{
	
	//Map for roads and town
	Map<Road,Town> roads=new HashMap<>();
	Set<String> towns=new HashSet<>();
	
	public TownGraphManager() {
		
	}
	
	/**
	 * Adds a road to graph
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		//Create the road object
		Road newRoad=new Road(new Town(town1),new Town(town2),weight,roadName);
		//Add it to the graph
		roads.put(newRoad, new Town(town1));
		
		return true;
	}
	
	/**
	 * Returns road connecting passed town parameters
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String name=null;
		//Create the towns and search for the road that connects the two
		for(Road road:roads.keySet()) {
			if(road.contains(new Town(town1))&&road.contains(new Town(town2)))
				name=road.getName();
		}
		
		return name;
	}

	/**
	 * Adds a town object to graph
	 */
	@Override
	public boolean addTown(String v) {
		//Add the town to the graph
		towns.add(v);
		return true;
	}

	/**
	 * Returns town object  by name
	 */
	@Override
	public Town getTown(String name) {
		//Go through each town until the names match
		for(String town:towns) {
			if(town.equals(name))
				return new Town(town);
		}
		
		return null;
	}

	/**
	 * Returns true if graph contains name of town, else false
	 */
	@Override
	public boolean containsTown(String v) {
		// check if any names in the graph match
		for(String town:towns) {
			if(town.equals(v))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if the two town names are connected,else false
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		//Check each road until both towns are contained
		for(Road road:roads.keySet()) {
			if(road.contains(new Town(town1))&&road.contains(new Town(town2)))
				return true;
		}
		
		return false;
	}

	/**
	 * Returns an arraylist of type string of all roads
	 */
	@Override
	public ArrayList<String> allRoads() {
		//Create the arraylist
		ArrayList<String> roadNames=new ArrayList<>();
		//Add  each road name to the list
		for(Road r:roads.keySet()) {
			roadNames.add(r.getName());
		}
		roadNames.sort(null);
		return roadNames;
	}

	/**
	 * Returns true if road was deleted, else false
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		//Go through each key checking the town names and road names to delete the right one
		for(Road r:roads.keySet()) {
			if(r.contains(new Town(town1))&&r.contains(new Town(town2))&&r.getName().equals(road)) {
				roads.remove(r);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Returns true if the town was deleted, else false
	 */
	@Override
	public boolean deleteTown(String v) {
		//Remove it from the towns set
		towns.remove(v);
		
		//Check each road and delete the town from the road
		for(Road r:roads.keySet()) {
			
				if(r.end!=null&&r.end.getName().equals(v));
					r.end=null;
				
				if(r.start!=null&&r.start.getName().equals(v))
					r.start=null;
			
		}

		return false;
	}

	/**
	 * Returns an arraylist of string of all town names
	 */
	@Override
	public ArrayList<String> allTowns() {
		//Create the arraylist
		ArrayList<String> list=new ArrayList<>();
		//Add each town name to list
		for(String town:towns) {
			list.add(town);
		}
		list.sort(null);
		return list;
	}

	/**
	 * Returns an arraylist of string of the path from town1 to town2
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Road r=null;
		int min;
		ArrayList<String> path=new ArrayList<>();
		String currentTown=town1;
		Map<Road,Integer> visit;
		Map<Road,Town> copy=new HashMap<>();
		copy=roads;
		
	while(currentTown!=town2) {
		r=null;
		min=99;
		visit=new HashMap<>();
		for(Road road:copy.keySet()) {
			if(road.start.getName().equals(currentTown)||road.end.getName().equals(currentTown));
				visit.put(road, road.cost);
			}
		for(Road road:visit.keySet()) {
				if(visit.get(road)<min) {
					min=visit.get(road);
					r=road;
					
			}
		}
		copy.remove(r);
		if(r==null) {
			path=null;
			return path;
		}
		if(r.end.getName()!=currentTown) {
		path.add(currentTown+" via "+r+" to "+r.end+" "+r.getWeight()+" mi");
		currentTown=r.end.getName();
		}
		else {
			path.add(currentTown+" via "+r+" to "+r.start+" "+r.getWeight()+" mi");
			currentTown=r.start.getName();
		}
	
	}
	System.out.print(path);
	
		
	return path;
	}
	
	/**
	 * 
	 * @param selectedFile-File to read from
	 * NOT IN DOCUMENT BUT IN GUI
	 */
	public void populateTownGraph(File selectedFile)throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
