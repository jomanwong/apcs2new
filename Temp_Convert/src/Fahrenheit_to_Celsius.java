// Joman Wong APCS period 2
import java.util.Scanner;
public class Fahrenheit_to_Celsius {
	public static void main (String[]args){
		Scanner userInput = new Scanner (System.in);
		System.out.println("Please enter below, only "
				+ "a numeric value value for degrees in Fahrenheit.");
		double n = userInput.nextDouble();
		//Fahrenheit value \/\/\/\/
		double fahrenheit = n;
		double celsius = (fahrenheit - 32)/9*5; 
		celsius = Math.round(celsius * 100.0)/100.0 ;
		System.out.print("The rounded Celsius equivalent of "+ fahrenheit + " degrees Fahrenheit" + ":");
		System.out.print("\n" + celsius);
	}
}
