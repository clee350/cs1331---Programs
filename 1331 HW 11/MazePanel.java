import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
*Class: MazePanel	
*The panel class for the program that combines everything together.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Ethan, Stefano, Evan.
*/
public class MazePanel extends JPanel{
	private Maze game;
	private int moves;
	private JButton [][] buttonArr;
	private Player one;
	private ArrayList<Point> coordinates;
	/**
	 * Constructor: Constructions the 6 by 6 game.
	 * @param int width
	 * @param int height
	 */
	public MazePanel(int width, int height){
		setLayout(new GridLayout(height, width));
		game = MazeFactory.generateRookMaze(width, height);
		buttonArr = new JButton[height][width];//height and width are the height and width of the array
		Point p = game.getPlayer().getLocation();
		Point goal = game.getGoal().getLocation();
		coordinates = game.getPlayer().getValidMoves();
		one = game.getPlayer();
		for (int row=0;row<height;row++){
		   for (int col=0;col<width;col++){
			   JButton button = new JButton("" + game.getWeight(row, col));
			   buttonListener buttonPush = new buttonListener(row,col); //listener will know which button is pushed
			   button.addActionListener(buttonPush);
			   buttonArr[row][col] = button;
			   add(button); 
		   }
		}
		update();
		
	}
	/**
	 * Method: Updates the colors whenever the user presses a JButton.
	 */
	public void update(){
		
		for(JButton[] btns : buttonArr)
			for(JButton btn : btns)
				btn.setBackground(null);
		
		for(Point p : one.getValidMoves())
			buttonArr[p.x][p.y].setBackground(Color.YELLOW);
		
		Point foo = game.getGoal();
		buttonArr[foo.x][foo.y].setBackground(Color.WHITE);
		Point player1 = one.getLocation();
		buttonArr[player1.x][player1.y].setBackground(Color.GREEN);
			
		}
	/**
	 * Class: the ActionListener for all of the JButton.
	 *
	 */
	private class buttonListener implements ActionListener{
	    private int row,col;
	    /**
	     * Constructor: Takes in the row and column and stores it.
	     * @param int row
	     * @param int col
	     */
	    public buttonListener(int row, int col){
	    	
	    this.row = row;
	    this.col = col;
	    }
	    /**
	     * Method: Calls the move() method and checks to see if the location is the 
	     * winning condition.
	     * @param: ActionEvent e
	     */
	    public void actionPerformed(ActionEvent e){
	    	if(one.move(row,col))
	    		moves++;
	    	
	    	update();
			if(game.checkWin())
				if(game.getSolutionLength() == moves){
					JOptionPane.showMessageDialog(null, "You Win"+ "It took you "+ moves + 
							" moves to win. This is the best solution is available in the game.");				
				}
				else
					JOptionPane.showMessageDialog(null, "You Win"+ "It took you "+ moves + 
						" moves to win. A solution is available in " +game.getSolutionLength() +" moves.");			
	    }
	}
}
