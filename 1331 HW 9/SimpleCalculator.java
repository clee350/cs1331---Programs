/**
*Class: SimpleCalculator
*The logic of the calculator.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 9.
*Collaboration: I have worked on with TA Ethan.
*/
public class SimpleCalculator {
	double result=0;
	String operator;
	double number;
    /**
     * Method: add the numbers.
     * @param: double result, double number
     * @return: double result
     */
	public double add(double result, double number){
		result+=number;
		return result; 
	}
    /**
     * Method: multiply the numbers.
     * @param: double result, double number
     * @return: double result
     */
	public double multiply(double result, double number){
		result*=number;
		return result;	
	}
    /**
     * Method: divide the numbers.
     * @param: double result, double number
     * @return: double result
     */
	public double divide(double result, double number){
		result/=number;
		return result;
	}
    /**
     * Method: subtract the numbers.
     * @param: double result, double number
     * @return: double result
     */
	public double subtract(double result, double number){
		result-=number;
		return result;
	}
    /**
     * Method: The logic of the calculator.
     * @return: double result
     */
	public double CalcLogic(){
		if (operator.equals("+")){
			result = add(result, number);
		}
		else if (operator.equals("-")){
			result = subtract(result, number);
		}
		else if (operator.equals("/")){
			result = divide(result, number);
		}
		else if (operator.equals("%")){
			System.out.println("We don't support this operation!");
		}
		else if (operator.equals("*")){
			result = multiply(result, number);
		}
		return result;
	}
    /**
     * Method: setter for the values in the calculator.
     * @param: double args, String sign
     */
	public void calcSetter(double args, String sign){
		this.number = args;
		this.operator = sign;
	}
}