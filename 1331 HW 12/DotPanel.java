import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.event.*;
/**
*Class: DotPanel	
*The panel class that compiles the GUI and the JPanel
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 4/13/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Evan, Thomas, Stefano, Taylor, Ahmed.
*/

public class DotPanel extends JPanel{
	boolean flag = false;
	boolean controller =false;
	private Point point;
	private JLabel coordinates, total;
	DotLinkedList rem33over;
	Dot dot;
	Color color = Color.RED;
	Graphics s;
	/**
	 * Constructor: Constructs the JPanel components.
	 */
	DotPanel(){
		setPreferredSize(new Dimension(500,500));
		rem33over = new DotLinkedList();
		coordinates = new JLabel("");
		total= new JLabel("There are: "+ rem33over.getColorCount(Color.RED)+ " red dots "
				+rem33over.getColorCount(Color.GREEN)+" green dots "+ 
				rem33over.getColorCount(Color.BLUE)+" blue dots.");
		setFocusable(true);
		setLayout(new BorderLayout());
		add(coordinates, BorderLayout.WEST);
		add(total, BorderLayout.SOUTH);
		addMouseListener(new DotAdder());
		addKeyListener(new RemoveColor());
		addKeyListener(new ColorChange());
		addKeyListener(new DisplayChanger());
		
	}
	/**
	* Class: the KeyListener for removing the color
	*
	*/
	private class RemoveColor implements KeyListener{
		/** 
		*Method: calls methods to remove the specified color.
		*@param: KeyEvent event
		*/
		 public void keyPressed(KeyEvent e) {
	            switch (e.getKeyCode()) {
	                case KeyEvent.VK_1 :
	                	rem33over.removeAllByColor(Color.RED);
	                    break;
	                case KeyEvent.VK_2 :
	                	rem33over.removeAllByColor(Color.GREEN);
	                    break;
	                case KeyEvent.VK_3 :
	                	rem33over.removeAllByColor(Color.BLUE);
	                    break;
	            }
	            repaint();
		 }
		 
		/** 
		*Method:correlates the KeyListener to user input.
		*@param: KeyEvent event
		*/
		public void keyTyped(KeyEvent event){
		}
		/** 
		*Method:correlates the KeyListener to user input.
		*@param: KeyEvent e
		*/
		public void keyReleased(KeyEvent event){
		}
	}
	/**
	* Class: the KeyListener for changing the color
	*
	*/
	private class ColorChange implements KeyListener{
		/** 
		*Method: calls methods to change the specified color.
		*@param: KeyEvent event
		*/
		 public void keyPressed(KeyEvent e) {
	            switch (e.getKeyCode()) {
	                case KeyEvent.VK_R :
	                	color = Color.RED;
	                    break;
	                case KeyEvent.VK_G :
	                	color = Color.GREEN;
	                    break;
	                case KeyEvent.VK_B :
	                	color = Color.BLUE;
	                    break;
	            }
	    		update();
	    		repaint();
		 }
		/** 
		*Method:correlates the KeyListener to user input.
		*@param: KeyEvent event
		*/
		public void keyTyped(KeyEvent event){
		}
		/** 
		*Method:correlates the KeyListener to user input.
		*@param: KeyEvent e
		*/
		public void keyReleased(KeyEvent event){
		}
	}
	/** 
	*Class: displays the strings position in the JPanel.
	*/
	private class DisplayChanger implements KeyListener{
		/** 
		*Method: displays the strings position in the JPanel.
		*@param: KeyEvent event
		*/
		public void keyPressed(KeyEvent e) {
	            switch (e.getKeyCode()) {
	                case KeyEvent.VK_S :
	                	if(flag){
	                		coordinates.setText("");
	                		flag=false;
	                	}
	                	else{
	                		coordinates.setText(rem33over.toString());
	                		
	                		flag=true;
	                	}
	            }
	     }
		public void keyTyped(KeyEvent event){
		}
		/** 
		*Method:correlates the KeyListener to user input.
		*@param: KeyEvent e
		*/
		public void keyReleased(KeyEvent event){
		}
	}
	/** 
	*Class: adds dots when mouse clicks on the JPanel.
	*/
	private class DotAdder extends MouseAdapter{
		/** 
		*Method: calls methods when mouse is pressed.
		*@param MouseEvent e
		*/
		public void mousePressed(MouseEvent e){
			point = e.getPoint();
			boolean isRemoved = false;
			if(rem33over.size()>0){
				for(int i = 0; i<rem33over.size();i++){
					if(rem33over.get(i).contains(point)){
						rem33over.remove(rem33over.get(i));
						isRemoved = true;
					}
				}
				if(!isRemoved){
					dot = new Dot(point, color);
					rem33over.add(dot);
				}
			}
			else{
				dot = new Dot(point, color);
				rem33over.add(dot);
			}
			update();
			repaint();	
		}	
	}
	/** 
	*Method: paints the dot onto the JPanel.
	*@param Graphics g
	*/
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i<rem33over.size(); i++){
			rem33over.get(i).draw(g);
		}
	}
	/** 
	*Method: updates the dot position.
	*/
	public void update(){
		if(!flag){
			controller=true;
		}
		if(flag && controller){
    		coordinates.setText(rem33over.toString());
		}
		else{
			coordinates.setText("");
		}
		total.setText("There are: "+ rem33over.getColorCount(Color.RED)+ " red dots "
				+rem33over.getColorCount(Color.GREEN)+" green dots "+ 
				rem33over.getColorCount(Color.BLUE)+" blue dots.");
	}

}
