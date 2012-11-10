import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


/**
 * This is the top level class to demonstrate the traveling salesman problem
 * solution.
 * 
 * @author Jeff Goldsworthy
 *
 */
public class DemonstrateEuclideanTSP {
    public static int SYNC = 500;
    
    // Time in ms between drawing of each vertex or edge on the screen.
    public static int SLEEP = 250;
    
    // This value adjusts the scale of the x and y values and therefore the size
    // of the window on the screen.
    // If you have the monitor space, drawing looks much cleaner with a scaling
    // factor of 1000.
    public static int scalingFactor = 500;
    
    
	/**
     * This is the main entry point for the program.
     * 
	 * @param args
     * Program arguments.
	 */
	public static void main(String[] args) {
        if (args.length != 1) {
        	System.out.println("Usage: DemonstrateEclideanTSP numberOfCities");
        	System.exit(1);
        }
        
        // This is used to make sure that only an integer argument is provided.
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(args[0].trim());
        
        int numCities = 0;
        
        // Verify that the user entered an integer number of cities.
        if (m.matches()) {
        	numCities = Integer.parseInt(args[0]);
        }
        else {
        	System.out.println("Number of cities must be entered as an integer.");
            System.exit(1);
        }
        
        City[] cities = new City[numCities];
        
        // Init the city name. Start at zero so we can index the array easily.
        Integer name = 1;
        
        // Create some cities. This could be replaced a list of City() ctor
        // calls so that the same set of cities is analyzed.
        for (int index = 0; index < cities.length; ++index) {
            // DEBUG
        	//System.out.println("Name is: [" + name + "]");
        	
        	cities[index] = new City(name.toString(),
        			(Math.random() * scalingFactor),
        			(Math.random() * scalingFactor));
        	
            // DEBUG
        	//System.out.println("New City: " + cities[index].toString());
            
        	// Update the numeric name for the next city to be added.
            name = (name + 1);
        }
        
        // Class used the solve the traveling salesman problem.
        EuclideanTSP solver = new EuclideanTSP(cities);
        
        // Get the minimum spanning tree.
        ArrayList<Edge> mst = solver.solve();
        
        // Print the MST info.
        System.out.println("\n\n-------- MST ---------");
        
        for (Edge e: mst) {
        	System.out.println(e.toString());
        }
        
        System.out.println("MST weight: " + Edge.totalDistance(mst));
        
        // Determine the tour from the MST.
        ArrayList<Edge> tour = solver.getTour(mst);
        
        // Print the tour info.
        System.out.println("\n\n-------- TOUR ---------");
        
        for (Edge e: tour) {
        	System.out.println(e.toString());
        }
        
        System.out.println("Tour weight: " + Edge.totalDistance(tour));
        
        // Graphical stuff.
        Map map = new Map(scalingFactor);
        JFrame frame = new JFrame("Map of the TSP Soln (MST [Black] and Tour [Red])");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(map);
        frame.pack();
        frame.setVisible(true);
        sleep(SYNC);
        
        // Draw each of the cities.
        for (int index = 0; index < cities.length; ++index) {
            sleep(SLEEP);
            
        	map.drawCity(cities[index]);
        }
        
        // Draw each of the MST edges.
        for (Edge e : mst) {
        	sleep(SLEEP);
        	
        	map.drawMstEdge(e);
        }
        
        // DEBUG - just some time before slamming the tour on the screen.
        //sleep(5000);
        
        // Draw each of the Tour edges.
        for (Edge e : tour) {
        	sleep(SLEEP);
        	
        	map.drawTourEdge(e);
        }
	}
    
    
	/**
	 * Method used to slow down the drawing of elements on the screen.
     * 
	 * @param milliseconds
     * Number of milliseconds to wait.
	 */
	public static void sleep(long milliseconds) {
		Date d;
		long start;
		long now;
        d = new Date();
        start = d.getTime();
        
        do {
        	d = new Date();
        	now = d.getTime();
        } while ((now - start) < milliseconds);
	}
}
