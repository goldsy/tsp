import java.util.ArrayList;

/**
 * This class represents the edges between all cities.
 * 
 * @author Jeff
 *
 */
public class Edge {
	// Data members.
	private City vertex1;
	private City vertex2;
    private double dist = -1;
    
    
    /**
     * Class ctor.
     * 
     * @param _vertex1
     * The start city.
     * 
     * @param _vertex2
     * The end city.
     */
    public Edge(City _vertex1, City _vertex2) {
    	vertex1 = _vertex1;
    	vertex2 = _vertex2;
    }
    
    
    /**
     * This method returns the distance/priority of the edge.
     * 
     * @return
     * This method returns the distance between the vertices as a double.
     */
    public double distance() {
    	if (dist == -1) {
    		dist = distance(vertex1, vertex2);
    	}
        
    	return dist;
    }
    
    
    
    /**
     * This method returns the distance between the two specified cities.
     * 
     * @param start
     * The first city.
     * 
     * @param end
     * The end city.
     * 
     * @return
     * This method returns the distance between the two specified cities
     * as a double.
     */
    public static double distance(City start, City end) {
    	double result = Math.sqrt(Math.pow((end.x() - start.x()), 2) +
    			(Math.pow((end.y() - start.y()), 2)));
        
    	return result;
    }
    
    
    /**
     * This method returns the total distance for all edges in the provided
     * list of edges.
     * 
     * @param tree
     * Source tree to calculate the distance for.
     * 
     * @return
     * This method returns the sum of all the distances for the edges in the
     * specified list.
     */
    public static double totalDistance(ArrayList<Edge> tree) {
        double accumDistance = 0;
        
    	for (Edge e : tree) {
    		accumDistance += e.distance();
    	}
        
    	return accumDistance;
    }
    
    
    
    /**
     * This method returns the start city.  Calling it a start city is sort of
     * relative with respect to the MST, but labeling them this way will make
     * it easier to construct the tour later.
     * 
     * @return
     * This method return the first city marking one end of the edge.
     */
    public City getStartCity() {
    	return vertex1;
    }
    
    
    /**
     * This method returns the end city.
     * 
     * @return
     * This method return the first city marking one end of the edge.
     */
    public City getEndCity() {
    	return vertex2;
    }
    
    
    /**
     * This method overrides the base toString implementation to return a
     * formatted version of the edge for printing on the console.
     * 
     * @return
     * This method returns a string representation of the edge.
     */
    public String toString() {
    	return ("From: " + vertex1.minToString() + " To: "
    			+ vertex2.minToString()
    			+ " Distance: " + distance());
    }
}
