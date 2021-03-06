import java.util.ArrayList;

/**
 * This class is the starting point for the traveling salesman problem.
 * 
 * @author Jeff Goldsworthy
 *
 */
public class EuclideanTSP {
    private City[] cities = null;
    private ArrayList<Edge> mst;
    
    
    /**
     * Class ctor.
     * 
     * @param _cities
     */
    public EuclideanTSP(City[] _cities) {
    	cities = _cities;
    }
    
    
    /**
     * This method solves for the minimum spanning tree.
     * 
     * @return
     * This method returns an array list of edges representing the minimum
     * spanning tree.
     */
    public ArrayList<Edge> solve() {
        // Set a start city.
    	City start = cities[0];
    	
    	// Traverse all other vertices setting the priority and parent.
    	for (int index = 0; index < cities.length; ++index) {
    		City v = cities[index];
    		
    		v.setPriority(Edge.distance(start, v));
    		v.setParent(start);
            
    		// DEBUG
    		//System.out.println("Set priority/parent " + v.toString());
    	}
        
    	mst = new ArrayList<Edge>();
        double minPriority;
        City minVertex;
        
    	for (int index = 0; index < (cities.length - 1); ++index) {
            minPriority = -1;
            minVertex = null;
            
            // DEBUG
            //System.out.println("Index: " + index);
            
            for (int index2 = 0; index2 < cities.length; ++index2) {
                // DEBUG
            	//System.out.println("Index2: " + index2);
            	//System.out.println("Checking city: "
            	//		+ cities[index2].getFullName()
            	//		+ " Priority: " + cities[index2].getPriority());
                
            	// Check if the city has been visited, and whether it is the
            	// minPriority.
                if ((cities[index2].getPriority() > 0)
                		&& ((cities[index2].getPriority() < minPriority)
                				|| (minPriority == -1))) {
                	// Set this one as the min priority and vertex(city).
                    minPriority = cities[index2].getPriority();
                    minVertex = cities[index2];
                    
                    // DEBUG
                    //System.out.println("New min found: " + cities[index2].toString());
                }
            }
            
            // Add the city to the MST and set the priority to zero for this 
            // city so we no longer consider it.
            minVertex.setPriority(0);
            mst.add(new Edge(minVertex.getParent(), minVertex));
            
            // Store the adjacency information in the min vertex and it's parent.
            //minVertex.addAdjacentCity(minVertex.getParent());
            minVertex.getParent().addAdjacentCity(minVertex);
            
            // DEBUG
            //System.out.println("Added vertex to MST:" + minVertex.toString());
            
            // Re-adjust the priorities.
            for (int index3 = 0; index3 < cities.length; ++index3) {
                // Check if the edge from the new minVertex is less than the
            	// one already stored for this vertex(city).
                if (cities[index3].getPriority() 
                		> Edge.distance(cities[index3], minVertex)) {
                    // Update the priority and the parent.
                    cities[index3].setPriority(
                    		Edge.distance(cities[index3], minVertex));
                    cities[index3].setParent(minVertex);
                }
            }
    	}
        
    	return mst;
    }
    
    
    /**
     * This method determines the tour.
     * 
     * @param mst
     * The minimum spanning tree from which to determine the tour.
     * 
     * @return
     * This method returns the tour based on the minimum spanning tree 
     * provided.
     */
    public ArrayList<Edge> getTour(ArrayList<Edge> mst) {
    	ArrayList<Edge> tour = new ArrayList<>();
        
        // DFS Walk of the tree.
    	ArrayList<City> cityTour = new ArrayList<>();
        
        City startCity = mst.get(0).getStartCity();
        startCity.dfs(cityTour);
        
        for (int index = 0; index < cityTour.size(); ++index) {
        	// Create the tour edges.
            if ((index + 1) < cityTour.size()) {
            	tour.add(new Edge(cityTour.get(index), cityTour.get(index + 1)));
            }
            else {
                // We're at the last city, so go back to the start.
            	tour.add(new Edge(cityTour.get(index), cityTour.get(0)));
            }
        }
    	
    	return tour;
    }
}