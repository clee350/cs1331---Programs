import javax.swing.JFrame;
/**
*Class: PacmanDriver
*starting point of the entire program.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/13/2013
*Assignment: Homework 8.
*Collaboration: I have worked on this with Christian Battaglia, Thomas Shield, TA-Ethan 
*Head TA Elizabeth, TA - Tayler, TA - Walker, Puja.
*/
public class PacmanDriver {
    /**
     *Constructor:The main class that initiates the game. 
     *@param: Takes in an String[] paramater.
     */
    public static void main(String[] args) {
        /*
         * Sets up the thing that actually lets you see the panel that we
         * made. Don't worry about what this does for now - we will be
         * getting into all of this after Spring break
         */
        JFrame frame = new JFrame();
        frame.getContentPane().add(new PacmanGamePanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
