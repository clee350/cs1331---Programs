/**
*Class: UnknownOperatorException
*Handles the unknown operator exceptions.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 9.
*Collaboration: I have worked on this with TA Ethan.
*/
public class UnknownOperatorException extends RuntimeException{
    /**
     * Constructor: Calls the parent class.
     */
	public UnknownOperatorException(){
		super("Illegal Operations!");
	}
}
