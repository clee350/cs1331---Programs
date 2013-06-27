import java.util.Scanner;

/**
*Class: StringFun
*This class is described Scanner object .
*@author: Charles Lee
*GTID: 902760050
*Course: CS1331
*Teacher: Monica Sweat
*@version: 1.0
*Assignment: Homework 2.
*Collaboration: I have worked on this by myself.
*/
public class StringFun {
	public static void main(String[] args){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("please input a string of text: ");
		String text = scan1.nextLine();
		String firstHalf = text.substring(0, (text.length()/2));
		String secondHalf =text.substring((text.length()/2), text.length());
		System.out.println(secondHalf.toLowerCase()+firstHalf.toUpperCase());
		Scanner scan2 = new Scanner(System.in);
		System.out.println("please input another string of text: ");
		String text2 = scan2.nextLine();
		System.out.println("The first 'a' is located at index " + text2.indexOf('a'));
		text2 = text2.replace('e', '3');
		text2 = text2.replace('a', 'A');
		System.out.print(text2);
		
	}
}
