/**
*Class: MadLibDriver
*This class is described 4 WordList objects, 3 MadLib objects, and a string array.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 6.
*Collaboration: I have worked on this with Cassidy Bellmor, Thomas Shield, Elizebeth.
*/
public class MadLibDriver {
	MadLib  mermaidMadLib;
	MadLib   psychologyMadLib;
	MadLib   zooMadLib;
	/**
	*Method: The main method that creates the objects and uses the methods.
	*@param: String[] args
	*/
	public static void main(String[] args){
		WordList verbs = new WordList("verbs.txt");
		WordList nouns = new WordList("nouns.txt");
		WordList adjectives = new WordList("adjectives.txt");
		WordList adverbs = new WordList("adverbs.txt");
		MadLib mermaidMadLib = new MadLib("mermaidMadLib.txt");
		MadLib   psychologyMadLib= new MadLib("psychologyMadLib.txt");
		MadLib   zooMadLib = new MadLib("zooMadLib.txt");
		String[] array = new String[3];
		MadLib[] libs = {mermaidMadLib, psychologyMadLib, zooMadLib};
		for (int i = 0; i<libs.length;i++){
			 System.out.println(libs[i]);
			 boolean location = libs[i].hasMoreBlanks();				 
			 while (location == false){
				 //System.out.println(location);
				 String type = libs[i].getNextType();
				 //System.out.println(type);
				 if (type.equals("noun")){
					 String word =nouns.getRandomWord();
				//	 System.out.println(word);
					 libs[i].fillNextBlank(word);
				 }
				 if(type.equals("verb")){
					 String word =verbs.getRandomWord();
					 libs[i].fillNextBlank(word);
				 }
				 if(type.equals("adverb")){
					 String word = adverbs.getRandomWord();
					 libs[i].fillNextBlank(word);
				 }
				 if(type.equals("adjective")){
					 String word = adjectives.getRandomWord();
					 libs[i].fillNextBlank(word);
				 }
				 libs[i].hasMoreBlanks();
				 if (libs[i].hasMoreBlanks()==true){
					 location = true;
				 }
			 }
			 System.out.println(libs[i]+"\n");
		}
	}
}