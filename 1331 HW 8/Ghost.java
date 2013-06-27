import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
*Class: Ghost
* A ghost of the Pacman game
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class Ghost extends GameEntity {
    private Random rand;
    /**
     * Constructor: Creates a Ghost at the specified location
     * @param location the location at which the Ghost is created
     */
    public Ghost(Location location){
    	super(location, PacmanGamePanel.GHOST_IMAGE);
    	this.rand = new Random();
    }
    
    /**
     * Method: Handles what happens when a ghost runs into pacman.
     * If pacman is invincible, the ghost should be moved back to it's
     * origin point.
     * @param passes the game object to this method.
     * @return: returns whether or not the ghost collided
     * with something.
     */
    public boolean collide(GameObject object) {
    	boolean temp=super.collide(object);
    	if(temp&&(object instanceof Pacman)){
    		if(((Pacman) object).isInvincible()){
    			moveToOrigin();
    			
    		}
    	}
    	return temp;
    }

    @Override
    /**
     * Method:Ghosts move in a special way, so we need to override the move defined in
     * GameEntity.
     * 
     * When move is called, a Ghost should have an 80% chance of actually moving.
     * 
     * If it can continue going in the direction it is facing, it should move that way.
     * 
     * If not, it should pick a way to turn (right or left), and turn until it can move in 
     * the direction it is facing.
     * @param passes in the Level object for ghost to move.
     */
    public void move(Level level) {
    	double number =  rand.nextDouble();
		if(number>.2){
			int choice = rand.nextInt(3);
			if (choice==0){
			Location temp = location.clone();
	    	temp.moveByDirection(getFacingDirection());
	    		if (level.isValidLocation(temp)){
	    			location.moveByDirection(getFacingDirection());
	    		}
			}
			else if(choice==1){
		    	turn(true);
				Location temp = location.clone();
		    	temp.moveByDirection(getFacingDirection());
		    		if (level.isValidLocation(temp)){
		    			location.moveByDirection(getFacingDirection());
		    		}
			}
	    	else{
		    	turn(false);
				Location temp = location.clone();
		    	temp.moveByDirection(getFacingDirection());
		    		if (level.isValidLocation(temp)){
		    			location.moveByDirection(getFacingDirection());
		    		}
	    	}
    	}
		
    }
}
