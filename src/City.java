/**
 * This class represents a city which in Euclidean space is a vertex.
 * 
 * @author Jeff
 *
 */
public class City {
	public City(String _name, int xCoord, int yCoord) {
		name = _name;
		xCoordinate = xCoord;
		yCoordinate = yCoord;
	}
	
	
	public int x() {
		return xCoordinate;
	}
	
	
	public int y() {
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
	
	
	// Data members.
	private String name;
	private int xCoordinate;
	private int yCoordinate;
	private double currPriority = -1;
	private City parent = null;
}
