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
    
    
    public Edge(City _vertex1, City _vertex2) {
    	vertex1 = _vertex1;
    	vertex2 = _vertex2;
    }
    
    
    public double distance() {
    	if (dist == -1) {
    		dist = distance(vertex1, vertex2);
    	}
        
    	return dist;
    }
    
    
    public static double distance(City start, City end) {
    	double result = Math.sqrt(Math.pow((end.x() - start.x()), 2) +
    			(Math.pow((end.y() - start.y()), 2)));
        
    	return result;
    }
}
