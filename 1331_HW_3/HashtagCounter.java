import java.io.*;
import java.util.*;
/**
*Class: HashtagCounter
*This class is described by Scanner objects and File objects.
*@author: Charles Lee
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 1/26/2013
*Assignment: Homework 3.
*Collaboration: I have worked on this by myself.
*/
public class HashtagCounter {
	/**
	 *  reads "hashtags.csv" file and prompts user for search query then returns results.
	 * @param: args
	 */
	public static void main(String[] args){
		int counter= 0;
		boolean activator = true;
		String[] array= null;
		String ans = null;
		int total=0;
		System.out.println("Please enter a hashtag:");
		Scanner reply = new Scanner(System.in);
		String answer = reply.nextLine();
		ans = answer;
		
		try {
			File text = new File("hashtags.csv");
			Scanner file = new Scanner(text);
			while (activator){	
				String line = file.next();
				array = line.split(",");
				for (int i=0; i< array.length; i++){
					if (answer.equals(array[i])){
						counter++;		
					}
					if (i ==(array.length)-1){
						total=total+array.length;
					}
				}
				if(file.hasNext()== false){
					activator=false;
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("The hashtag "+ ans +" appears "+ counter+" time(s), out of a total of "+total+"  entries. ");
	}
}
