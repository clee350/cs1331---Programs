import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

/**
*Class: PacmanGame
*This class defines the logic for a game of pacman. 
*It contains all the objects needed for a game, and handles
*all of the logic that actually runs the game.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class PacmanGame {
    //array of ghosts
    private Ghost[] ghosts;
    //pacman!
    private Pacman pacman;
    //the level for the game
    private Level level;
    //whether or not the game is still playing
    private boolean playing;
    
    //an arraylist is useful here because the number of items
    //we have is constantly changing
    private ArrayList<GameItem> items;
    //a timer to control pacmans invincibility
    private Timer invincibilityTimer;

    /**
     * Constructor:Creates a new game of pacman based off of the 2D char
     * array that represents the level
     * @param levelTiles the representation of the level
     */
    public PacmanGame(char[][] levelTiles) {
    	this.playing = true;
    	this.level=new Level(levelTiles);
        this.pacman = new Pacman(level.getPacmanOrigin());
        this.ghosts = new Ghost[4];
        this.items = new ArrayList<GameItem>(); 
        for (int i=0; i<4; i++){
        	ghosts[i] = new Ghost(level.getGhostOrigin());
        	ghosts[i].moveToOrigin();
        }
        Location[] temp = level.getCherryLocations();
        for (int i = 0; i<temp.length; i++){
        	items.add(new Cherry(temp[i]));
        }
        Location[] secondTemp = level.getPelletLocations();
        for (int i = 0; i<secondTemp.length; i++){
        	items.add(new Pellet(secondTemp[i]));
        }
        //makes a timer that controls the amount of time that pacman
        //is invincible for
        invincibilityTimer = new Timer(6000, new InvincibilityChanger());
        invincibilityTimer.setRepeats(false);
        

    }

    /**
     * Method:Moves pacman in the indicated direction
     * @param direction the direction to move pacman
     */
    public void movePacman(int direction) {
    	if(isPlaying()){
    		pacman.setFacingDirection(direction);
    		pacman.move(level);
    	}
    }

    /*
     * Method: helper method that checks all of the items to see if pacman collided
     * with them - if it did, this removes the items from play.
     */
    private void pickUpItems() {
        ArrayList<GameItem> removedItems = new ArrayList<GameItem>();
        for (GameItem item : items) {
            if (pacman.collide(item)) {
                removedItems.add(item);
                if (item instanceof Cherry) {
                    invincibilityTimer.start();
                }

            }
        }

        items.removeAll(removedItems);

    }

    /**
     * Method:Moves the ghosts in the game.
     */
    private void moveGhosts() {
    	for (int i = 0; i<ghosts.length;i++){
    		ghosts[i].move(level);
    	}
    }
    
    /**
     * Method:Gets the level associated with the game
     * @return the current level of the game.
     */
    public Level getLevel() {
     return this.level;
    }
    
    /**
     * Method:Checks to see if any collisions occured between
     * pacman and the ghosts and between pacman and the items.
     */
    public void checkCollisions() {
    	boolean checker = true;
        for(int i=0;i<ghosts.length;i++){
        	ghosts[i].collide(pacman);
        	pacman.collide(ghosts[i]);
        }
        pickUpItems();
    }

    /**
     * Method:Returns whether or not the game is still being played
     * @return the state of gameplay
     */
    public boolean isPlaying() {
        return this.playing;
    }

    /**
     *Method:Returns whether or not there are any items left in the game 
     * @return whether or not items are left
     */
    public boolean itemsLeft() {
        return (items.size()>0);
    }
    
    /**
     *Method: Updates the game. 
     * an update includes moving the ghosts, checking collisions,
     * and stopping game play if pacman runs out of lives or items to 
     * pick up
     */
    public void update(){
		if (pacman.getLives() <=0) {
			playing = false;
		}
		if (!itemsLeft()) {
			playing = false;
		}
		else{
			moveGhosts();
	        checkCollisions();
		}
    }

    /**
     * Method:Draws all of the game elements
     * @param g the graphics object on which the elements are drawn
     */
    public void drawEverything(Graphics g) {
        //changes the color when pacman is invincible
        if (pacman.isInvincible()) {
            g.setColor(new Color(255, 255, 0, 50));
            g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        }
        for (GameItem item : items) {
            item.draw(g);
        }
        for (Ghost ghost : ghosts) {
            ghost.draw(g);
        }

        pacman.draw(g);
    }


    
    //Class: controls pacman's invincibility - again, do not worry about how this works
    private class InvincibilityChanger implements ActionListener {

        @Override
        /**
         *Method:makes pacman looses invincibility.
         *@parem: passes in an ActionEvent parameter. 
         */
        public void actionPerformed(ActionEvent arg0) {
            pacman.loseInvincibility();
        }

    }
    /**
     *Method:Convert's Pacman's score and lives into a string.
     *@return: returns Pacman's score and lives. 
     */
    public String toString() {
    	String line = "You have : "+(pacman.getLives()+"")+ 
    			" lives left!\n Your score is: "+(pacman.getScore()+"")+"."; 
        return line;
    } 
}
