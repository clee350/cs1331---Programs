import java.util.*;

/**
*Class: SimpleCalculatorDriver
*The Driver class of the calculator.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 9.
*Collaboration: I have worked on with TA Ethan.
*/
public class SimpleCalculatorDriver{
	UnknownOperatorException e;
    /**
     * Method: The main method of the program.
     * @param String[] args
     */
	public static void main(String[] args){
		SimpleCalculator calc = new SimpleCalculator();
		boolean a=true;
		double number = 0.0;
		String checker = "";
		while(a){
			System.out.println("Result: " + number);
			System.out.println("Enter an operation or 'q' to end the program.");
			Scanner scan = new Scanner(System.in);
			try{
				checker= scan.next();
				if (checker.equals("q")){
					a=false;
				}
				else if (!checker.equals("+")&& !checker.equals("-")&& !checker.equals("*") && !checker.equals("/")&&
						!checker.equals("%")){
					throw new UnknownOperatorException();
				}
			}
			catch(UnknownOperatorException e){
				System.out.println(e.getMessage());
			}
			if(a&&(checker.equals("+")|| checker.equals("-")|| checker.equals("*") || checker.equals("/")||
					checker.equals("%"))){
				try{
					System.out.println("Please enter a number: ");
					number= scan.nextDouble();
					if (checker.equals("/")&&(number==0)){
						throw new ArithmeticException();
					}
					calc.calcSetter(number, checker);
					number =calc.CalcLogic();
				}
				catch(InputMismatchException exceptionObj){
					System.out.println("That is not a number! Please try again!");
					Scanner scan2 = new Scanner(System.in);
					number = scan2.nextDouble();
				}
				catch(ArithmeticException e){
					System.out.println("Cannot divide by zero!");
				}
			}
			
		}
	}
}
