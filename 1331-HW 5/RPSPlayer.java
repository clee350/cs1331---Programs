/**
*Class: RPSPlayer
*This class is described by methods and private instances for the RPSPlayer.
*@author: Charles Lee
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 5.
*Collaboration: I have worked on this with two TA Taylor and Thomas.
*/
public class RPSPlayer {
	private String name;
	private int score;
	private String choice;
	public RPSPlayer(String name, int score, String choice){
		this.name = name;
		this.score = score;
		this.choice = choice;
	}
	/**
	*Method: sets the player's choice.
	* @param: String choice
	*/
	public void makeChoice(String choice){
		if (choice.equalsIgnoreCase(RPSGame.option1)||choice.equalsIgnoreCase(RPSGame.option2)||choice.equalsIgnoreCase(RPSGame.option3)){
			this.choice = choice;
		}
		else{
			choice="none";
		}
	}
	/**
	*Method: returns the player's choice.
	* @return: String choice
	*/
	public String getChoice(){
		return choice;
	}
	/**
	*Method: returns the player's name.
	* @return: String name
	*/
	public String getName(){
		return name;
	}
	/**
	*Method: returns the player's score.
	* @return: int score
	*/
	public int getScore(){
		return score;
	}
	/**
	*Method: increment the player's score.
	*/
	public void incrementScore(){
		incrementScore(1);
	}
	/**
	*Method: add 1 to the player's score.
	* @param: int add
	*/
	public void incrementScore(int add){
		score+=add;
		
	}
}