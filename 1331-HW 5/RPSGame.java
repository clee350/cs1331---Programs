/**
*Class: RPSGame
*This class is described by a Scanner object and the game logic for RPS Game.
*@author: Charles Lee
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 5.
*Collaboration: I have worked on this with two TA Taylor and Thomas.
*/
public class RPSGame {
	public static final String option1= "scissor", option2 = "paper", option3 = "rock";
	private RPSPlayer player1;
	private RPSPlayer player2;
	private int a;
	/**
	*Method: figures out who won and increments the scores.
	* @param: RPSPlayer player1, RPSPlayer player2
	* @return: int a
	*/
	public int duelTime(RPSPlayer player1, RPSPlayer player2){	
		this.player1 = player1;
		this.player2 = player2;
		if (player1.getChoice().equalsIgnoreCase(player2.getChoice())){
			a = 0;
			return a;
		}
		else if ((player1.getChoice().equalsIgnoreCase("rock")&&(player2.getChoice().equalsIgnoreCase("scissor")))){
			a= 1;
			player1.incrementScore();
			return a;
		}
		else if((player1.getChoice().equalsIgnoreCase("paper")&&(player2.getChoice().equalsIgnoreCase("scissor")))){
			a=2;
			player2.incrementScore();
			return a;
		}
		else if ((player1.getChoice().equalsIgnoreCase("rock")&&(player2.getChoice().equalsIgnoreCase("paper")))){
			a=3;
			player2.incrementScore();
			return a;
		}
		else if ((player1.getChoice().equalsIgnoreCase("scissor")&&(player2.getChoice().equalsIgnoreCase("rock")))){
			a=4;
			player2.incrementScore();
			return a;
		}
		else if ((player1.getChoice().equalsIgnoreCase("scissor")&&(player2.getChoice().equalsIgnoreCase("paper")))){
			a=5;
			player1.incrementScore();
			return a;
		}
		else if ((player1.getChoice().equalsIgnoreCase("paper")&&(player2.getChoice().equalsIgnoreCase("rock")))){
			a=6;
			player1.incrementScore();
			return a;
		}
		return a;
	}
	
}