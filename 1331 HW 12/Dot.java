import java.awt.*;
import java.awt.Graphics;
import java.awt.Point;
/**
*Class: Dot	
*The Drive class for the program.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 4/13/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Evan, Thomas, Stefano, Taylor, Ahmed.
*/
public class Dot {
    private static final int DIAMETER = 20;
    private Point point;
    private Color color;
    
    /**
     * Create a new dot at the specified point with the 
     * specified color - note, the point should be the CENTER 
     * of the dot
     * 
     * @param point
     * @param color
     */
    public Dot(Point point, Color color){
        this.point = point;
        this.color = color;
    }
    /**
     * Draw the dot on the graphics object - remember, the point
     * is the dot's center
     * 
     * @param g
     */
    public void draw(Graphics g){
    	g.setColor(color);
        g.fillOval(point.x-(DIAMETER/2), point.y-(DIAMETER/2), DIAMETER, DIAMETER);
    }
    
    /**
     * Determine if the given point is within the dot
     * 
     * @param Point p
     * @return boolean indicator
     */
    public boolean contains(Point p){
    	boolean indicator = false;
    	double distance = (Math.sqrt(((point.x-p.x)*(point.x-p.x))+((point.y-p.y)*(point.y-p.y))));
    	if(distance<=(DIAMETER/2)){
    		indicator = true;
    	}
    	
        return indicator; 
    }
    
    /**
     * Determine if the dot is equal to the object. To be equal,
     * the object must be a dot, and it must be at the same location 
     * and have the same color
     * @param Object o
     * @return boolean a 
     */
    public boolean equals(Object o){
    	boolean a = false;
    	if (o instanceof Dot){
    		Dot D = (Dot) o;
    		if ((D.contains(point))&&(D.getColor().equals(color))){
        		a=true;
    		}
    	}
    	return a;
    }
    
    /**
     * Get the color of the dot
     * 
     * @return the color
     */
    public Color getColor(){
       return color;
    }
    
    /**
     * Get the location of the dot
     * 
     * @return the location of the point
     */
    public Point getPoint(){
        return point;
    }
    
    /**
     * Get a string representation of the dot - this should contain
     * the color of the dot and it's location. If the color is Red, Green, or Blue,
     * it should state that. Otherwise, it should just have the values of rgb for the
     * unknown colors (Hint: Color has a useful toString for getting the rgb values)
     * 
     * @return String
     */
    public String toString(){
    	String temp = "";
    	double x = getPoint().getX();
    	double y = getPoint().getY();
    	if (color.equals(Color.RED)){
    		temp = "Red, Location: "+ x+" "+y;
    	}
    	else if (color.equals(Color.GREEN)){
    		temp = "Green, Location: "+ x+" "+y;
       	}
       	else{
       		temp = "Blue, Location: "+ x+" "+y;
       	}
        return "Color: "+ temp+ "\n";
    }
}
