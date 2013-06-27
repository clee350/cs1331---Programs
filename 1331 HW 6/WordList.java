import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
*Class: WorldList
*This class is described with a file object, a scanner object and a random object.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 5.
*Collaboration: I have worked on this with Cassidy Bellmor, Thomas Shield, Elizebeth.
*/
public class WordList {
	boolean activator= true;
	private Random rand;
	private String[] words;
	private String word;
	String line;
	/**
	*Constructor: reads the files and creates an array for wordlist.
	*@param: String fileName
	*/
	public WordList(String fileName){
		try {
			File text = new File(fileName);
			Scanner file = new Scanner(text);
			int spaces = file.nextInt();
			words = new String[spaces];
			int i = 0;
			while ((activator)&& (i<words.length)){	
				words[i]=file.next();
				//System.out.println(words[i]);
				i++;
				if(file.hasNext()== false){
					activator=false;
				}
			}
			//System.out.println(words[1]);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	*Method: takes a word from the array randomly.
	*@return: String word
	*/
	public String getRandomWord(){
		rand = new Random();
		int generator = rand.nextInt(words.length);
		word= words[generator];
		return word;
	}
}
