import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Timer;
/**
*Class: Pacman
*Pacman in a game of Pacman.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class Pacman extends GameEntity implements Movable{
    //whether or not pacman is invincible
    private boolean invincible;
    //pacman's score
    private int score;
    //the number of lives pacman has left
    private int lives;
    /**
     *Constructor: built the necessary components for the pacman object.
     *Creates a new Pacman with 3 lives at the given location. 
     *@param location the location at which the pacman is created.
     */
    public Pacman(Location location) {
        super(location, PacmanGamePanel.PACMAN_IMAGE);
    	this.lives = 3;
    	score=0;
    	invincible=false;
    	System.out.println(toString());
    }
    
    /**
     *Method:If pacman collides with another pacman, simply return 
     *  that pacman hit something
     *  
     *  If with an item, pick up that item
     * 
     *  If with a ghost and invincible, return that pacman hit something 
     *  
     *  If with a ghost and not invincible, be eaten, lose a life, start back at origin point
     * 
     *Pacman looses life or defeats ghost or pickup object when colliding with an object.
     *@param: The GameObject object are passed to check for collision.
     *@return: Returns whether or not Pacman collided with something.
     */
    public boolean collide(GameObject object){
        boolean temp = super.collide(object);
        if (temp && (object instanceof Ghost)){
        	if(!isInvincible()){
        		loseLife();
        	}
        	else{
        		((Ghost)object).moveToOrigin();
        	}
        }
        else if(temp && (object instanceof GameItem)){
        	pickUpItem((GameItem) object);
        }
		return temp;
    } 
    
    /**
     *Method: Helper method that allows pacman to pick up the item that
     * it collided with.
     * 
     * When an item is picked up, the score should be increased and
     * invincibility handled correctly if the item is a cherry
     *@param: The items are passed into this method.
     */
    private void pickUpItem(GameItem item){
        score+=item.getValue();
    	if(item instanceof Cherry){
        	invincible = true;
        }
    }
    
    /**
     *Method: Causes pacman to no longer be invincible
     */
    public void loseInvincibility(){
    	invincible = false;
    }
    
    /**
     *Method: Returns whether or not pacman is invincible
     * 
     * @return the state of pacman's invincibility 
     */
    public boolean isInvincible(){
        return this.invincible;
    }
    /**
     *Method: Causes pacman to lose a life and
     * move back to its origin point
     */
    public void loseLife(){
    	lives--;
    	moveToOrigin();
    }
    
    /**
     *Method: Returns the number of lives that pacman has left
     *@return the number of lives that pacman has left
     */
    public int getLives(){
        return this.lives;
    }
    
    /**
     *Method: Returns pacman's score
     *@return pacman's score
     */
    public int getScore(){
        return this.score;
    }
    /**
     *Method: handles the rotation of the image 
     *depending on what direction pacman is facing
     *@param: takes in the graphics component.
     */
    public void draw(Graphics g) {

        g.translate(location.getCol() * PacmanGamePanel.IMAGE_WIDTH
                + PacmanGamePanel.IMAGE_WIDTH / 2, location.getRow()
                * PacmanGamePanel.IMAGE_HEIGHT + PacmanGamePanel.IMAGE_HEIGHT
                / 2);

        switch (getFacingDirection()) {
            case Movable.NORTH :
                ((Graphics2D) g).rotate(-Math.PI / 2);
                break;
            case Movable.SOUTH :
                ((Graphics2D) g).rotate(Math.PI / 2);
                break;
            case Movable.WEST :
                ((Graphics2D) g).rotate(Math.PI);
                break;

        }

        g.translate(-location.getCol()*PacmanGamePanel.IMAGE_WIDTH - PacmanGamePanel.IMAGE_WIDTH / 2,
                -location.getRow()* PacmanGamePanel.IMAGE_HEIGHT - PacmanGamePanel.IMAGE_HEIGHT / 2);
        super.draw(g);
    }
}
