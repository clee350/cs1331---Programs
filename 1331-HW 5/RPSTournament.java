/**
*Class: RPSTournament
*This class is described as the driver class along with a Scanner object, an RPSGame object and two RPSPlayer objects.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 2/13/2013
*Assignment: Homework 5.
*Collaboration: I have worked on this with two TA Taylor and Thomas.
*/
import java.util.*;
public class RPSTournament {
	private RPSPlayer player1;
	private RPSPlayer player2;
	/**
	*Method: the driver method that initialize the RPS Game and announces the winner.
	* @param: String[] args
	*/
	public static void main(String[] args){
		int a = 0;
		int b = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("please enter the number of games you want to play: ");
		int game = scan.nextInt();
		String choice = "";
		RPSPlayer player1 = new RPSPlayer(name, 0, choice);
		RPSPlayer player2 = new RPSPlayer("Rival", 0, generateComputerChoice());
		while (a<game){
			System.out.println("Please enter your choice: ");
			choice = scan.next();
			player1.makeChoice(choice);
			RPSGame gameOverView = new RPSGame();
			int result=gameOverView.duelTime(player1, player2);
			System.out.println("Your Rival chose: " + player2.getChoice());
			if (result==0){
				System.out.println("You tied!");
			}
			else if (result==1){
				System.out.println("You win!");
			}
			else if (result==2){
				System.out.println("You lose!");
			}
			else if (result==3){
				System.out.println("You lose!");
			}
			else if (result==4){
				System.out.println("You lose!");
			}
			else if (result==5){
				System.out.println("You win!");
			}
			else if (result==6){
				System.out.println("You win!");
			}
			System.out.println("Current Score:\t"+player1.getName()+": "+ player1.getScore()+"\t Your Rival:"+ player2.getScore());
			player2.makeChoice(RPSTournament.generateComputerChoice());
			a++;
		}
		int winner = announceWinner(player1, player2);
		if (winner==0){
			System.out.println(player1.getName()+" won, with " +player1.getScore()+"/"+game+" games.");	
		}
		else if(winner==1){
			System.out.println(player1.getName()+" won, with " +player1.getScore()+"/ "+game+" games.");	
		}
		else{
			System.out.println(player1.getName()+" and "+ player2.getName()+" tied, with " +player1.getScore()+"/"+game+" games.");
		}
	}
	/**
	*Method: Generates choices for computer player.
	* @return: String decision
	*/
	public static String generateComputerChoice(){
		Random rand =new Random();
		String decision = "";
		int options = rand.nextInt(3);
		if (options == 0){
			decision = "rock";
		}
		else if(options == 1){
			decision = "paper";
		}
		else{
			decision = "scissor";
		}
		return decision;
	}
	/**
	*Method: sees which player won the game.
	*@param: RPSPlayer player1, RPSPlayer player2
	* @return: int op
	*/
	public static int announceWinner(RPSPlayer player1, RPSPlayer player2){
		int op=0;
		if (player1.getScore()>player2.getScore()){
			op=0;
		}
		else if (player1.getScore()<player2.getScore()){
			op=1;
		}
		else{
			op=2;
		}
		return op;
	}
}