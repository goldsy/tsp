import java.util.ArrayList;

/**
 * This class is the starting point for the traveling salesman problem.
 * 
 * @author Jeff
 *
 */
public class EuclideanTSP {
    private City[] cities = null;
    private int cityCount = 0;
    private ArrayList<City> mst;
    
    public EuclideanTSP(City[] _cities, int _cityCount) {
    	cities = _cities;
    	cityCount = _cityCount;
    }
    
    
    public void solve() {
    	City start = cities[0];
    	
    	// Traverse all other vertices setting the priority and parent.
    	for (int index = 1; index < cityCount; ++index) {
    		City v = cities[index];
    		
    		v.setPriority(Edge.distance(start, v));
    		v.setParent(start);
    	}
        
    	mst = new ArrayList<City>();
        int minPriority;
        City minVertex;
        
    	for (int index = 1; index < cityCount; ++index) {
            minPriority = -1;
            minVertex = null;
            
            for (int index2 = 0; index2 < cityCount; ++index2) {
                // TODO
            }
    	}
    }
}