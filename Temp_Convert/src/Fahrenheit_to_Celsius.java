
public class Fahrenheit_to_Celsius {
	public static void main (String[]args){
		//fahrenheit value \/\/\/\/
		double fahrenheit = 62.5;
		double celsius = (fahrenheit - 32)/9*5;
		celsius = Math.round(celsius * 1000.0)/1000.0 ;
		System.out.print("The rounded Celsius equivalent of Fahrenheit value " + fahrenheit + ":");
		System.out.print("\n" + celsius);
	}
}