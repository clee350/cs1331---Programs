import java.util.Scanner;
/**
*Class: HashtagCounter
*This class is described by a Scanner object.
*This is an exercise for javadocing and for programming conventions.
*@author: Charles Lee
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 1/26/2013
*Assignment: Homework 3.
*Collaboration: I have worked on this by myself.
*/
public class Conventions {
	/**
	 * Beside lacking the java docing details, this class originally lacked proper indentations, which can
	 * lead into confusing for the debugging process. Another problem was the overflowing of string text. By
	 * cutting down the text, such that it fits on the screen, this will allow easier read during the debugging
	 * process. The third and last problem of was the variable labeling. There was a lacking of consistency, which
	 * slightly annoyed me as I tried identify the variables; hence, following the general systle will help people
	 * to identify variables, objects or other things with labels easier.
	 * 
	 * @param args
	 */
    public static void main(String[] args){
    	String text = "This file is full of poor coding conventions. ";
		System.out.println(text);
		System.out.println("I want you to go through and fix each of them, ");
		System.out.println("and then write me a short paragraph about what was wrong, ");
		System.out.println("and why conventions are necessary/helpful.");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length side of a rectangle:");
		double length = input.nextDouble(); System.out.println("Enter the width side of the rectangle:");
		double width = input.nextDouble();
		//multiplication of the length and width to get rectangular area.
		double area = length*width;
		System.out.println("Rectangle area: " + area);
		String firstComment = "Crazy, eh?";
		System.out.println("And yet, the compiler has no problem with this code. Do you know why?"); 
		String secondComment = "Comments are superhelpful in code - especially when it gets more complex.";
		System.out.println(secondComment);
		System.out.println(" Create a block comment that contains your description of what is wrong with this");
		System.out.println("and why conventions are awesome.");
	}
}
