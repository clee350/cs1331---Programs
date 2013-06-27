import java.awt.Graphics;

/**
*Class: Drawable
*An object that is Drawable is an object that can be drawn on a Graphics
*object. The draw method defines how that object draws itself
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public interface Drawable {
    
    /**
     * Method: Draws the object onto the specified Graphics object
     * 
     * @param g the graphics object on which to draw
     */
    public abstract void draw(Graphics g);
}
