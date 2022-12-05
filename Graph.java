package abc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;



import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	//Map for graph
		Map<Road,Town> area=new HashMap<Road, Town>();
		Set<Town> vertex=new HashSet<>();
		/**
		 * Checks for vertices in map and
		 * returns the corresponding edge or null
		 */
		@Override
		public Road getEdge(Town sourceVertex, Town destinationVertex) {
			//Go through each key and check the towns
			for(Road road:area.keySet()) {
				if(road.contains(destinationVertex)&&road.contains(sourceVertex)) {
					return new Road(road.end,road.start,road.cost,road.getName());
				}
				
			}
				
			return null;
		}
		
		/**
		 * Check for the vertices in the graph and adds the edge connecting both
		 */
		@Override
		public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
			//In case of null objects
			if(sourceVertex==null||destinationVertex==null)
				throw new NullPointerException();
			
			//Find vertices in graph
			if(!vertex.contains(sourceVertex)||!vertex.contains(destinationVertex))	
				throw new IllegalArgumentException();
			//Create the object
			Road newRoad=new Road(sourceVertex,destinationVertex,weight,description);
			//Add it to graph
			area.put(newRoad, sourceVertex);

			return newRoad;
		}

		/**
		 * Adds vertex to graph if not duplicate,true if non duplicate
		 * else false			
		 */
		@Override
		public boolean addVertex(Town v) {
			//Object is null
			if(v==null)
				throw new NullPointerException();
			
			//Check for duplicate
			if(vertex.contains(v))
				return false;
			
			vertex.add(v);
			
			return true;				
		}

		/**
		 * Checks the graph is it contains an edge connecting the passed in
		 * towns/If found true, else false			 
		 */
			@Override
		public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
				//Go through each key unitl it matches
			for(Road road:area.keySet()) {
				if(road.contains(destinationVertex)&&road.contains(sourceVertex))
					return true;
			}
				
			return false;
		}

		/**
		 * Checks the graph for the passed in town.True if found
		 * else false
		 */
		@Override
		public boolean containsVertex(Town v) {
			//Go through vertex set until match is found
			for(Town town:vertex) {
				if(town.equals(v))
					return true;
			}
			return false;
			}
		/**
		* Returns a set of roads
		*/
		@Override
		public Set<Road> edgeSet() {
			//Create set of roads
			Set<Road> roads=new HashSet<>();
				
			for(Road road:area.keySet()) {
				roads.add(road);
			}
				
			return roads;
		}

		/**
		* Returns a set of roads that are connected to the passed in town
		*/
		@Override
		public Set<Road> edgesOf(Town vertex) {
			//Create the set of roads
			Set<Road> roads=new HashSet<>();
				
			for(Road road: area.keySet()) {
				if(road.contains(vertex))
					roads.add(road);
			}
				
			return roads;
		}

		/**
		* Returns the road to be removed if found, else null
		*/
		@Override
		public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
			//Create object to compare to
			Road r=new Road(sourceVertex,destinationVertex,weight,description);
			
			//Go through each road object until they are equal
			for(Road road:area.keySet()) {
				if(road.equals(r)) {
					area.remove(road);
					return road;
				}
			}
					
			return null;
		}
			
		/**
		* Removes the vertex if found in the graph
		*/
		@Override
		public boolean removeVertex(Town v) {
			boolean result=false;
			//Go through each keyset and make sure to remove all edges related to the town
			for(Road road:area.keySet()) {
				if(road!=null&&road.contains(v)) {
					road=null;
					result=true;
				}
			}
			//Remove it from the vertex set too
			vertex.remove(v);
				
			return result;
		}

		/**
		 * Returns a set of towns 
		 */
		@Override
		public Set<Town> vertexSet() {
			return vertex;
		}

		@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
			Road r=null;
			int min;
			ArrayList<String> path=new ArrayList<>();
			Town currentTown=sourceVertex;
			Map<Road,Integer> visit;
			Map<Road,Town> copy=new HashMap<>();
			copy=area;
			
		while(currentTown!=destinationVertex) {
			r=null;
			min=99;
			visit=new HashMap<>();
			for(Road road:copy.keySet()) {
				if(road.contains(currentTown))
					visit.put(road, road.cost);
				}
			for(Road road:visit.keySet()) {
					if(visit.get(road)<min) {
						min=visit.get(road);
						r=road;
						
					
				}
			}
			copy.remove(r);
			if(r.end!=currentTown) {
			path.add(currentTown+" via "+r+" to "+r.end+" "+r.getWeight()+" mi");
			currentTown=r.end;
			}
			else {
				path.add(currentTown+" via "+r+" to "+r.start+" "+r.getWeight()+" mi");
				currentTown=r.start;
			}
		
		}
		
			
		return path;
		}

		@Override
		public void dijkstraShortestPath(Town sourceVertex) {
			Road r=null;
			int min;
			ArrayList<String> path=new ArrayList<>();
			Town currentTown=sourceVertex;
			Map<Road,Integer> visit;
			Map<Road,Town> copy=new HashMap<>();
			copy=area;
			
		while(currentTown!=null) {
			r=null;
			min=99;
			visit=new HashMap<>();
			for(Road road:copy.keySet()) {
				if(road.contains(currentTown))
					visit.put(road, road.cost);
				}
			for(Road road:visit.keySet()) {
					if(visit.get(road)<min) {
						min=visit.get(road);
						r=road;
						
					
				}
			}
			copy.remove(r);
			if(r.end!=currentTown) {
			path.add(currentTown+" via "+r+" to "+r.end+" "+r.getWeight()+" mi");
			currentTown=r.end;
			}
			else {
				path.add(currentTown+" via "+r+" to "+r.start+" "+r.getWeight()+" mi");
				currentTown=r.start;
			}
		
		}
		
			System.out.print(path);			
			
		}
			
		
			


		
		

}