/**
*Class: Pellet
* A pellet in the game of pacman.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class Pellet extends GameItem {
    private final static int VALUE = 1;
    /**
     *Constructor:Creates a new pellet at the given location.
     *@param location the location at which the pellet is created
     */
    public Pellet(Location location){
        super(location, PacmanGamePanel.PELLET_IMAGE, VALUE);
    }
}
