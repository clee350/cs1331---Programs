import java.awt.Graphics;

import javax.swing.ImageIcon;
/**
*Class: GameObject
*A Drawable element of a game. Elements of a game can include
*players, enemies, and items.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public abstract class GameObject implements Drawable{
    //the location of the object
    protected Location location;
    //the image that will be drawn to represent the object
    private ImageIcon image;
    
    /**
     * Constructor: Creates a new GameObject at the given location with the given
     * image
     * 
     * @param location the location of the object
     * @param image  the image of the object
     */
    public GameObject(Location location, ImageIcon image){
        this.location = location;
        this.image = image;
    }
    
    /**
     * Method:Get the location of the object
     * @return: Return the location of the object
     */
    public Location getLocation(){
		return location;
    }
    
    
    @Override
    /**
     * Method: Draw the images onto the JPanel
     * @return: Takes in graphics component.
     */
    public void draw(Graphics g) {
        // this draws the image at its correct location by row and column - you do not
        // need to worry about how this works
        g.drawImage(image.getImage(), location.getCol()*PacmanGamePanel.IMAGE_WIDTH, 
                location.getRow()*PacmanGamePanel.IMAGE_HEIGHT, image.getImageObserver());
        
    }
}
