import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DemonstrateEuclideanTSP {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        if (args.length != 1) {
        	System.out.println("Usage: DemonstrateEclideanTSP numberOfCities");
        	System.exit(1);
        }
        
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(args[0].trim());
        
        int numCities = 0;
        
        if (m.matches()) {
        	numCities = Integer.parseInt(args[0]);
        }
        else {
        	System.out.println("Number of cities must be entered as an integer.");
            System.exit(1);
        }
        
        
        City[] cities = new City[numCities];
        
        // Init the city name.
        Integer name = 1;
        
        for (int index = 0; index < cities.length; ++index) {
            // DEBUG
        	//System.out.println("Name is: [" + name + "]");
        	
        	cities[index] = new City(name.toString(),
        			(Math.random() * 1000),
        			(Math.random() * 1000));
        	
            // DEBUG
        	System.out.println("Debug location: " + cities[index].getFullName());
            
        	// Update the numeric name for the next city to be added.
            name = (name + 1);
        }
        
        EuclideanTSP solver = new EuclideanTSP(cities);
        
        ArrayList<Edge> mst = solver.solve();
        
        for (Edge e: mst) {
        	System.out.println(e.toString());
        }
	}
}
