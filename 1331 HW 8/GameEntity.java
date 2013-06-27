import javax.swing.ImageIcon;

/**
*Class: GameEntity
*A Movable GameObject
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public abstract class GameEntity extends GameObject implements Movable {
    //the initial location of the GameEntity
    private Location origin;
    //the direction the entity is facing
    private int facingDirection;

    /**
     * Constructor: Creates a GameEntity at the given location with the given image
     * 
     * @param location the initial location of the entity
     * @param image  the image of the entity to be drawn
     */
    public GameEntity(Location location, ImageIcon image) {
        super(location, image);
        origin = location.clone();
        facingDirection = Movable.NORTH;
    }

    @Override
    /**
     * Method: move the Game enity by 1 unit in the direction it
     *is facing - remember, only move it if it results in
     *a valid location (ie, not a wall) 
     * @parem: passes in a Level Object into the method.
     */
    public void move(Level level) {
    	Location temp = location.clone();
    	temp.moveByDirection(getFacingDirection());
    	if (level.isValidLocation(temp)){
    		location.moveByDirection(getFacingDirection());
    	}
    	else{
    		turn(level.isValidLocation(temp));
    	}
    }

    @Override
    /**
     * Method: returns whether there is a collision. 
     * @parem: passes in a GameObject into the method.
     * @return: returns true or false.
     */
    public boolean collide(GameObject object) {
    		return object.location.equals(location);
    }
    @Override
    /**
     * Method:Gets the direction of the object
     * @return the direction of the object.
     */
    public int getFacingDirection() {
        return facingDirection;
    }

    @Override
    /**
     * Method:Sets the direction of the object
     * @param: passes in the direction for the object.
     */
    public void setFacingDirection(int direction) {
     facingDirection = direction;   
    }

    /**
     * Method: Moves the GameEntity back to where it initially started
     */
    public void moveToOrigin() {
    	location = origin.clone();
    }

    /**
     * Method: Turns the GameEntity. A turn can be right or left, and
     * results in a change of the Entity's facing direction. For example,
     * if the GameEntity was facing North, and it executed a right turn, it should
     * now be facing East.
     * 
     * @param tells the turn method to turn left or right.
     */
    public void turn(boolean right) {
    	if(right){
    		turnRight();
    	}
    	else{
    		turnRight();
    		turnRight();
    		turnRight();
    	}
    }

    /*
     * Method: A helper methods for turning right - think about how you can use
     * this method to execute both right and left turns 
     */
    private void turnRight() {
    	if(facingDirection == Movable.NORTH){
        	setFacingDirection(EAST);
    	}
    	else if(facingDirection == Movable.EAST){
    		setFacingDirection(SOUTH);
    	}
    	else if(facingDirection == Movable.SOUTH){
    		setFacingDirection(WEST);
    	}
    	else{
    		setFacingDirection(NORTH);
    	}
    }
}
