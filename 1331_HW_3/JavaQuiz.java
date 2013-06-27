import java.io.*;
import java.util.*;

/**
*Class: JavaQuiz
*This class is described by a scanner object and file object.
*@author: Charles Lee
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 1/26/2013
*Assignment: Homework 3.
*Collaboration: I have worked on this by myself.
*/
public class JavaQuiz {
	/**
	 *  reads "questions.txt" file and prompts user answers to questions
	 * @param: args
	 */
	public static void main(String[] args){

		boolean activator=true;
		Scanner file = null;
		File text = new File("questions.txt");
		
		try {
			 file = new Scanner(text);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int skip = 0;
		int guess = 0;
		int correct = 0;
		for (int i=0; i <5; i++){
			String question = file.nextLine();
			String cuts = question.substring(0, question.indexOf("|"));
			String ans = question.substring(question.indexOf("|")+2, question.length());
			System.out.println(cuts);
			Scanner reply = new Scanner(System.in);
			String answer = reply.nextLine();
			activator = true;
			guess++;
			while (activator){
				if (answer.equals(ans)){
					correct++;
					activator = false;
				}
				else if(answer.equals("q")){
					skip++;
					activator=false;
				}
				else{
					System.out.println("That is incorrect. Please try again:");
					answer = reply.nextLine();
				}
			}
		}
		System.out.println("You got "+ correct +" questions correct.");
		System.out.println("You skipped " + skip + " questions.");
		System.out.println("And for the questions you completed, you averaged " + ((double) guess/(double)correct) + " guesses.");
	}
}
