/**
*Class: Counter
*This class is described with calculating methods and instances.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 5.
*Collaboration: I have worked on this with two TA Taylor and Thomas.
*/

public class Counter {
	private String itemName;
	private int count;
	static private int totalCount;
	/**
	*Method: Constructor of Counter class.
	* @param: String itemName, int count
	*/
	public Counter(String itemName, int count){
		this.count = count;
		totalCount += count;
	}
	/**
	*Method: resets the count.
	*/
	public void reset(){
		totalCount -=count;
		count = 0;	
	}
	/**
	*Method: decrements the count.
	* @param: boolean increment
	* @return: int count
	*/
	public int changeCount(boolean increment){
		if (increment == false){
			count--;
			totalCount--;
			return count;
		}
		else{
			count++;
			totalCount++;
			return count;
		}
	}
	/**
	*Method: decrements the count but takes in two variables.
	* @param: boolean increment, int amount
	* @return: int count
	*/
	public int changeCount(boolean increment, int amount) {
		if (increment ==false){
			count-=amount;
			totalCount-=amount;
			return count; 
		}
		else{
			count+=amount;
			totalCount+=amount;
			return count;
		}
		
	}
	/**
	*Method: returns the current count.
	* @return: this.count
	*/
	public int getCount(){
		return this.count;
	}
	/**
	*Method: returns the current total count.
	* @return: int totalCount
	*/
	public static int getTotalCount(){
		return totalCount;
	}
}
