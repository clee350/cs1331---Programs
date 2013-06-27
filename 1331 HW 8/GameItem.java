import javax.swing.ImageIcon;
/**
*Class: GameItem
* An item in a game. All items have a specific value
* attributed to them. This  value is the amount that they 
* are worth to the player when picked up.
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
public class GameItem extends GameObject {
    private int value;
    
    /**
     * Constructor: Creates an Item at the specified location 
     * with the specified image and value.
     * 
     * @param location the location at which the item is created
     * @param image  the image to use when drawing the item
     * @param value  the value of the item
     */
    public GameItem(Location location, ImageIcon image, int value){
        super(location, image);
        this.value = value;
    }
    
    /**
     * Method: Returns the value of the item
     * 
     * @return  the value of the item
     */
    public int getValue(){
        return this.value;
    }
}
