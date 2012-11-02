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
    
	
	
	public City(String _name, double xCoord, double yCoord) {
		name = _name;
		xCoordinate = xCoord;
		yCoordinate = yCoord;
	}
	
	
	public double x() {
		return xCoordinate;
	}
	
	
	public double y() {
		return yCoordinate;
	}
	
	
	public void setPriority(double source) {
		currPriority = source;
	}
	
	
	public double getPriority() {
		return currPriority;
	}
	
	
	public City getParent() {
		return parent;
	}
	
	
	public void setParent(City newParent) {
		parent = newParent;
	}
	
	
	public String getName() {
		return name;
	}
    
	
	public String getFullName() {
		return name + "(" + xCoordinate + "," +
				yCoordinate + ")";
	}
}
