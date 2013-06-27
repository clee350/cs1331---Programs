import java.awt.Color;
import java.awt.Point;
/**
*Class: DotLinkedList	
*A singly-linked list for DotNode objects.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 4/13/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Evan, Thomas, Stefano, Taylor, Ahmed.
*/
public class DotLinkedList {
    private DotNode head;
    private int size;
    
    /**
     *Adds the Dot to the end of the list
     * 
     *@param Dot dot
     */
    public void add(Dot dot){
    	if(head==null){
    		DotNode node = new DotNode(dot);
    		head = node;
    		head.next = null;
    		size++;
    	}
    	else{
    		DotNode current = head;
    		while (current.next != null) {
    			current = current.next;
    		}
    		current.next=new DotNode(dot);
    		size++;
    	}
    }
    
    /**
     *Removes the Dot from the list
     * 
     *@param Dot dot
     */
    public void remove(Dot dot){
    	DotNode list = head;
    	DotNode prev = head;
    	int index =0;
    	boolean condition = false;
    	while (index<size()&&(!condition)){
	    	if(list.dot.equals(dot)){
	    		if(index==0){
	    			head = prev.next;
	    		} 
	    		else {
	    			prev.next = list.next;
	    		}
	    		condition = true;
	    		size--;
	    	}
	    	index++;
	    	prev = list;
		    list = list.next;
	    }
    }   
    /**
     *Gets the Dot at the specified index. If the index
     *does not occur within the list, return null
     *@param int i
     *@return Dot location
     */
    public Dot get(int i){
    	Dot location = null;
    	if(i<size()){
    		DotNode temp = head;
    		for(int number=0; number<i; number++){
    			temp=temp.next;
    		}
			location=temp.dot;
    	}
        return location;	
    }
    
    /**
     *Get the dot that contains the specified Point. If
     *such a dot does not exist within the list, return null.
     * 
     *@param Point p
     *@return Dot coordinates
     */
    public Dot getDotAtPoint(Point p){
    	Dot coordinates = null;
    	DotNode position = head;
    	while(position!=null){
    		if(position.dot.contains(p)){
    			coordinates = position.dot;
    		}
    		position=position.next;
    	}
    	return coordinates;
         
    }
    
    /**
     *Remove all of the dots within the list that 
     *have the specified color
     * 
     *@param Color c
     */
    public void removeAllByColor(Color c){
    	for(int i = 0; i<size(); i++){
        	if(get(i).getColor().equals(c)){
        			remove(get(i));
        			i--;
        	}
        }
    }
    
    /**
     *Get the size of the list
     *@return int size
     */
    public int size(){
    	return size;
    }
    
    /**
     *Get the number of dots that are the specified
     *color within the list.
     *@param Color c
     *@return int counter
     */
    public int getColorCount(Color c){
    	int counter = 0;
    	DotNode curr = head;
    	while(curr!=null){
    		if(curr.dot.getColor()==c){
    			counter++;
    		}
    		curr=curr.next;
    	}
    	return counter;
    }

    /**
     *Get a string representation of the list
     *@return string list
     */
    public String toString(){
    	String list = "";
    	DotNode present = head;
    	while(present != null){
    		list+=present.toString()+ "\n";
    		present = present.next;
    	}
    	return "<html><pre>"+list+"</pre></html>";
    }
    
    /**
     *Class to contain a dot and the reference to the 
     *next DotNode in the list
     * 
     */
    private class DotNode{
        private Dot dot;
        private DotNode next;
        
        /**
        *Create a new DotNode to contain the specified Dot
        * 
        *@param dot
        */
        public DotNode(Dot dot){
                this.dot = dot;
                next = null;
        }
        /**
         *String representation of the node. This should
         *just be the String representation of the Dot that
         *the node contains
         *@return string dot.toString();
         */
        public String toString(){

            return dot.toString();
        }
    }
}