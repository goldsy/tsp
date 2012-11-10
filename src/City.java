import java.util.ArrayList;


/**
 * This class represents a city which in Euclidean space is a vertex.
 * 
 * @author Jeff
 *
 */
public class City {
	// Data members.
	private String name;
	private double xCoordinate;
	private double yCoordinate;
	private double currPriority = -1;
	private City parent = null;
    private ArrayList<City> adjacentCities = new ArrayList<>();
    
	
	
    /**
     * Class ctor.
     * 
     * @param _name
     * The name of the city/vertex.
     * 
     * @param xCoord
     * The x coordinate of the city.
     * 
     * @param yCoord
     * The y coordinate of the city.
     */
	public City(String _name, double xCoord, double yCoord) {
		name = _name;
		xCoordinate = xCoord;
		yCoordinate = yCoord;
	}
	
	
    /**
     * This method gets the x coordinate of this city.
     * 
     * @return
     * This method returns a double representing the x coordinate of this city.
     */
	public double x() {
		return xCoordinate;
	}
	
	
    /**
     * This method gets the y coordinate of this city.
     * 
     * @return
     * This method returns a double representing the y coordinate of this city.
     */
	public double y() {
		return yCoordinate;
	}
	
	
    /**
     * This method sets the priority for this city.
     * 
     * @param source
     * The source priority to set this city to.
     */
	public void setPriority(double source) {
		currPriority = source;
	}
	
	
    /**
     * This method gets the priority for this city.
     * 
     * @return
     * This method returns a double representing the priority of this city.
     */
	public double getPriority() {
		return currPriority;
	}
	
	
    /**
     * This method gets the parent city. The parent city is the city in which
     * this city is connected in the MST, or at least is currently connected
     * most closely to until a closer one is found.
     * 
     * @return
     * This method returns a reference to the parent city.
     */
	public City getParent() {
		return parent;
	}
    
	
    /**
     * This method adds an adjacent city to this cities adjacent city list.
     * 
     * @param neighbor
     * This is the city to add to the adjacent cities list.
     */
	public void addAdjacentCity(City neighbor) {
		adjacentCities.add(neighbor);
	}
    
	
    /**
     * This method gets the list of adjacent cities. The adjacent cities are
     * those cities connected to this city and this city is the parent of those
     * cities.
     * 
     * @return
     * This method returns a reference to the list of adjacent cities.
     */
	public ArrayList<City> getAdjacentCities() {
		return adjacentCities;
	}
    
	
    /**
     * This method is used to recursively build a depth first search traversal
     * of the minimum spanning tree.
     * 
     * @param target
     * This is the target array list in which the DFS of the cities is to be
     * stored.
     */
	public void dfs(ArrayList<City> target) {
        target.add(this);
        
		for (City c : adjacentCities) {
			c.dfs(target);
		}
	}
    
	
    /**
     * This method gets the parent city's name.
     * 
     * @return
     * This method returns the name of the parent city.
     */
	public String getParentName() {
        String temp = "";
        
		if (parent != null) {
			temp = parent.getName();
		}
        
		return temp;
	}
	
	
    /**
     * This method sets the parent city.
     * 
     * @param newParent
     * The source city to use as the new parent city for this city.
     */
	public void setParent(City newParent) {
		parent = newParent;
	}
	
	
    /**
     * This method gets the name of this city.
     * 
     * @return
     * This method returns the name of this city.
     */
	public String getName() {
		return name;
	}
    
	
    /**
     * This method overrides the base class implementation of the toString()
     * method.  It provides a description of this city... name, (x, y)
     * location, priority and parent name.
     * 
     * @return
     * This method returns a string representation of this city.
     */
	public String toString() {
        String temp;
        
        temp = "\n-------------------------------------\n";
        temp += "City name: " + name + "\n";
        temp += "Location: (" + xCoordinate + ", " + yCoordinate + ")\n";
        temp += "Priority: " + getPriority() + "\n";
        temp += "Parent: " + getParentName() + "\n";
        temp += "-------------------------------------\n";
        
		return temp;
	}
    
	
	/**
	 * This method is another to string that provides a minimal amount of
	 * information about the city. Just name and location.
     * 
	 * @return
     * This method returns a smaller string representation of this city.
	 */
	public String minToString() {
		//return ("City name: " + name + "(" + xCoordinate + ", " + yCoordinate + ")");
		return ("City name: " + name);
	}
}
