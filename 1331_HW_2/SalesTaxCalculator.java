import java.text.NumberFormat;
import java.util.Locale;
import java.util.*;
/**
*Class: SalesTaxCalculator
*This class is described Scanner objects.
*@author: Charles Lee
*GTID: 902760050
*Course: CS1331
*Teacher: Monica Sweat
*@version: 1.0	
*Assignment: Homework 2.
*Collaboration: I have worked on this by myself.
*/
public class SalesTaxCalculator {
	public static void main(String[] args){
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance( );
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the tax percentage (for example, if tax is 6.5%, enter 6.5) ");
		double percentage = scan1.nextDouble();
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter the cost of the item: ");
		double cost = scan2.nextDouble();
		double tax = cost*(percentage/100);
		double total = cost + tax;
		System.out.println("The tax on your item is: " + moneyFormatter.format(tax));
		System.out.println("The total cost of your purchase is "+ moneyFormatter.format(total));
	}		
}
