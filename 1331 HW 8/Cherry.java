import javax.swing.ImageIcon;

/**
*Class: Cherry
* A Cherry in the game of pacman - a cherry makes
* pacman invincible for a short period of time when
* it is picked up.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class Cherry extends GameItem {
    //the value of all cherries
	static ImageIcon cherry = new ImageIcon("cherry.png");
    private static final int VALUE = 5; 
    
    /**
     * Method: Creates a new cherry at the given location
     * @param location
     */
    public Cherry(Location location){
        super(location, cherry, VALUE);

    }
}       
