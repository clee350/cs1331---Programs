import javax.swing.*;

import java.awt.*;
/**
*Class: ToDoListDriver	
*The Drive class for the program.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Ethan and Thomas.
*/
public class ToDoListDriver {
	/** 
	*Method:The main method of the program.
	*/
	public static void main(String[] args){
	    JFrame frame = new ToDoList();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
}
