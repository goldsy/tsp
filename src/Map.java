import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 * This class is used to display the results of the TSP graphically on the
 * screen.
 * 
 * @author Jeff Goldsworthy
 *
 */
public class Map extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private Color backgroundColor = Color.LIGHT_GRAY;
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<Edge> mst = new ArrayList<Edge>();
    private ArrayList<Edge> tour = new ArrayList<Edge>();

	public Map() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void paintComponent(Graphics g) {
    	g.setColor(backgroundColor);
    	g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // Paint mst lines.
    	for (Edge e : mst) {
    		g.setColor(Color.BLACK);
    		
    		// Draw the line for this tour edge.
            // TODO: (goldsy) This needs to be an int, so we'll need to do some scaling.
            g.drawLine((int)e.getStartCity().x(), (int)e.getStartCity().y(), 
            		(int)e.getEndCity().x(), (int)e.getEndCity().y());
    	}
    	
    	// Paint tour lines.
    	for (Edge e : tour) {
    		g.setColor(Color.RED);
    		
    		// Draw the line for this tour edge.
            // TODO: (goldsy) This needs to be an int, so we'll need to do some scaling.
            g.drawLine((int)e.getStartCity().x(), (int)e.getStartCity().y(), 
            		(int)e.getEndCity().x(), (int)e.getEndCity().y());
    	}
        
    	// Paint the cities.
    	for (City c : cities) {
            // Set the color for the city marker.
    		g.setColor(Color.BLUE);
            
            // TODO: (goldsy) SCALING NEEDS TO BE DONE HERE TOO!
    		g.fillOval((int)c.x(), (int)c.y(), 4, 4);
            
            // Set the color for the text.
    		g.setColor(Color.BLACK);
    		
    		// Shift the text a little bit so that it doesn't obscure the 
    		// city marker.
            int tempX = (int)c.x() - 5;
            
            // If at the left edge of the screen put it on the other side of
            // the marker.
            if (tempX < 5) {
            	tempX = (int)c.x() + 5;
            }
            
            int tempY = (int)c.y();
            
            // If at the top edge, then put the text below the marker.
            if (tempY < 5) {
            	tempY = (int)c.y() + 5;
            }
            
            g.drawString(c.getName(), tempX, tempY);
    	}
    }
    
    public void drawCity(City c) {
        cities.add(c);
        
        repaint();
    }

    public void drawMstEdge(Edge e) {
        mst.add(e);
        
        repaint();
    }
    
    public void drawTourEdge(Edge e) {
        tour.add(e);
        
        repaint();
    }
}
