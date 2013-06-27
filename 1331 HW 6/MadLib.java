import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*Class: MadLib
*This class is described with file object, scanner object and 2 string array objects.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 6.
*Collaboration: I have worked on this with Cassidy Bellmor, Thomas Shield, Elizebeth.
*/
public class MadLib {
	private boolean  controller = true;
	private boolean  condition;
	private String filename;
	private String[] blanks;
	private String[] blankTypes;
	private String[] row;
	private String[][] overviewArray;
	private int counter =0;
	/**
	*Constructor: takes a word from the array randomly.
	*@param: String filename
	*/
	public MadLib(String filename){
		try {
			File text = new File(filename);
			Scanner file = new Scanner(text);
			int numOfBlanks = file.nextInt();
			String line = "";
			int i = 0;
			int j=0;
			blanks = new String[numOfBlanks];
			blankTypes = new String[numOfBlanks];
			//System.out.println(numOfBlanks);
			while (controller){
				line = line+" "+ file.next();
				this.row = line.split("\n");
				this.row = line.split(" ");
				if (row[i].equals("[noun]")||(row[i].equals("[adjective]"))||(row[i].equals("[verb]"))||(row[i].equals("[adverb]"))){
					blanks[j]=row[i];
					System.out.println(blanks[j]);
					String temp = row[i].replace('[', ' ');
					temp = temp.replace(']', ' ');
					temp = temp.trim();
					this.blankTypes[j]=temp;
					j++;
					;
				}
				if(file.hasNext()== false){
					controller=false;
				}
				i++;
				//System.out.println(blankTypes);
			}
			//System.out.println(overviewArray.toString());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	*Method: Gets the type of the next word.
	*@return: String temp
	*/
	public String getNextType(){
		//System.out.println(blanks[0]);
		String temp = "";
		boolean situation = true;
		int number=0;
		while(situation){
			//System.out.println(row[counter]);
			//System.out.println(blanks[0]);
			if ((row[counter].equals(blanks[number]))){
				temp = blankTypes[number];
				//System.out.println(temp);
				situation = false;
			}
			number++;
		}
		return temp; 
	}
	/**
	*Method: fills the blank words accordingly.
	*/
	public void fillNextBlank(String word) {
		if (hasMoreBlanks()==false){
			row[counter] =word;
		}
	}
	/**
	*Method: Sees if there are any more blanks needed to be filled.
	*@return: boolean condition
	*/
	public boolean hasMoreBlanks(){
		int i=0;
		condition=true;
		while (condition&&(i<row.length)){
			if (row[i].equals("[verb]")||row[i].equals("[noun]")||row[i].equals("[adverb]")||row[i].equals("[adjective]")){
				this.counter=i;
				//System.out.println(row[counter]);
				//System.out.println(counter);
				condition=false;
			}
			i++;
		}
		//System.out.println(counter);
		return condition;
	}
	/**
	*Method: returns all of the words in order.
	*@return: String result
	*/
	public String toString(){
		String result = "";
		for (int i=0; i<row.length;i++){
			result = result + row[i]+ " ";
		}
		return result;
	}
}

//java.util.Arrays.toString(row)