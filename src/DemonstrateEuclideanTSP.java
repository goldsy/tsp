import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


public class DemonstrateEuclideanTSP {
    public static int SYNC = 500;
    public static int SLEEP = 350;
    
    
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
        
        // Init the city name. Start at zero so we can index the array easily.
        Integer name = 1;
        
        for (int index = 0; index < cities.length; ++index) {
            // DEBUG
        	//System.out.println("Name is: [" + name + "]");
        	
        	cities[index] = new City(name.toString(),
        			(Math.random() * 1000),
        			(Math.random() * 1000));
        	
            // DEBUG
        	//System.out.println("New City: " + cities[index].toString());
            
        	// Update the numeric name for the next city to be added.
            name = (name + 1);
        }
        
        EuclideanTSP solver = new EuclideanTSP(cities);
        
        ArrayList<Edge> mst = solver.solve();
        
        System.out.println("\n\n-------- MST ---------");
        
        for (Edge e: mst) {
        	System.out.println(e.toString());
        }
        
        System.out.println("MST weight: " + Edge.totalDistance(mst));
        
        ArrayList<Edge> tour = solver.getTour(mst);
        
        System.out.println("\n\n-------- TOUR ---------");
        
        for (Edge e: tour) {
        	System.out.println(e.toString());
        }
        
        System.out.println("Tour weight: " + Edge.totalDistance(tour));
        
        // Graphical stuff.
        Map map = new Map();
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
        
        sleep(10000);
        
        // Draw each of the Tour edges.
        for (Edge e : tour) {
        	sleep(SLEEP);
        	
        	map.drawTourEdge(e);
        }
	}
    
    
	/**
	 * 
	 * @param milliseconds
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
