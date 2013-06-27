/**
*Class: Recursion	
*The recursions for hailstone and handshake.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 9.
*Collaboration: I have worked on this alone.
*/
public class Recursion {
	static int handshakes = 0;
	static int sequences;
    /**
     * Method: The main class that tests both recursion methods.
     * @param: String[] args
     */
	public static void main(String[] args){
		int test = handshake(-1);//test case 1 -negatives
		System.out.println("Handshakes: "+test+"\n----------------------");
		int test2 = handshake(0);//test case 2 - zero
		System.out.println("Handshakes: "+test2+"\n----------------------");
		int test3 = handshake(1);//test case 3 - one
		System.out.println("Handshakes: "+test3+"\n----------------------");
		int test4 = handshake(5);//test case 4 - prime and odd
		System.out.println("Handshakes: "+test4+"\n----------------------");
		int test5 = handshake(100);//test case 5 - even
		System.out.println("Handshakes: "+test5+"\n----------------------");
		System.out.println("Hailstone:");
		hailstone(29); // prime number and odd
		System.out.println("----------------------");
		System.out.println("Hailstone:");
		hailstone(40); // even number and odd
		System.out.println("----------------------");
		System.out.println("Hailstone:");
		hailstone(0); // zero
		System.out.println("----------------------");
		System.out.println("Hailstone:");
		hailstone(1); // 1
		System.out.println("----------------------");
		System.out.println("Hailstone:");
		hailstone(-1); // negative
		System.out.println("----------------------");
	}
    /**
     * Method: counts the number of handshakes based on the number of
     * people.
     * @param: int people
     * @return: int handshakes
     */
	public static int handshake(int people){
		if(people<0){
		}
		else if((people==0)||(people==1)){
			handshakes += 0;
		}
		else if(people>1){
			handshakes += people-1;
			handshake(people-1);
		}
	return handshakes;
	}
    /**
     * Method: the recursive algorithm for the hailstone method.
     * @param: int number
     */
	public static void hailstone(int number){
		boolean a=true;
		while(a){
			if(number==1){
				System.out.println(number);
				a=false;
			}
			else if (number<=0){
				System.out.println("Must be a positive integer!");
				a=false;
			}
			else if ((number%2)==0){
				System.out.println(number);
				hailstone(number/2);
				a=false;
			}
			else{
				System.out.println(number);
				hailstone(3*number+1);
				a=false;
			}
		}
	}
}