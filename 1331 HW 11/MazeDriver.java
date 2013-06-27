import javax.swing.*;
/**
*Class: MazeDriver	
*The Drive class for the program.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Ethan, Stefano, Evan.
*/

public class MazeDriver {
	/**
	 * Method: The Main method of the program.
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Rook Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//String w = (String)JOptionPane.showInputDialog(null,
		//		"Please enter in a width and a height for an nxn matrix size of this game:", "The Rook Game", 
		//		JOptionPane.PLAIN_MESSAGE, null,null,null); NOTE: Does work when equals or is greater than 4.
		//int width = Integer.parseInt(w);
		window.getContentPane().add(new MazePanel(6, 6));
		window.pack();
		window.setVisible(true);
	}

}
