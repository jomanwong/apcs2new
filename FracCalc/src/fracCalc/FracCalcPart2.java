/**
 * 
 * @author Joman Wong
 * @latest edit 12/6/2016 10:42 PM
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalcPart2 {

	public static void main(String[] args){
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner in = new Scanner (System.in);
		String userInput = in.nextLine();
		while(!userInput.equals("quit")){                 //keeps prompting until quit
			System.out.println(produceAnswer(userInput));
			userInput = in.nextLine();
		}
		//System.out.println(produceAnswer("5_3/4 + 6_5/8"));
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input){ 
		// TODO: Implement this function to produce the solution to the input
		//stores what operator is in equation, if any. For later use in calculation, 
		//if statement test, as if(operator.equals(" * ") or " / "&& and 1st operand or 2nd .equals 0, returns 0)
		//but for division if divide by 0, returns "ERROR"

		//XXX Variables here XXX
		String toReturn;
		String firstOperand;
		String secondOperand;
		String operator;
		String whole;
		String numerator;
		String denominator;
		//String[] temp; // temporary array
		//String[] firstOperand = parseOperand(parseInput(input)[0].toString());
		//String[] secondOperand = parseOperand(parseInput(input)[1].toString());



		if(input.indexOf(" + ") != -1){ //finds if the operator is +
			//inputNoSpace = input.replaceAll("\\s+",""); //no whitespaces
			String[] inputArr = input.split(" ");
			firstOperand = inputArr[0].toString();
			secondOperand = inputArr[2].toString();
			operator = " + ";
			whole = parseOperand(secondOperand)[0].toString();
			numerator = parseOperand(secondOperand)[1].toString();
			denominator = parseOperand(secondOperand)[2].toString();
			return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		}else if(input.indexOf(" - ") != -1){ //finds if the operator is -
			String[] inputArr = input.split(" ");
			firstOperand = inputArr[0].toString();
			secondOperand = inputArr[2].toString();
			operator = " - ";
			whole = parseOperand(secondOperand)[0].toString();
			numerator = parseOperand(secondOperand)[1].toString();
			denominator = parseOperand(secondOperand)[2].toString();
			return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		}else if(input.indexOf(" * ") != -1){ //finds if the operator is *
			String[] inputArr = input.split(" ");
			firstOperand = inputArr[0].toString();
			secondOperand = inputArr[2].toString();
			operator = " * ";
			whole = parseOperand(secondOperand)[0].toString();
			numerator = parseOperand(secondOperand)[1].toString();
			denominator = parseOperand(secondOperand)[2].toString();
			return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		}else if(input.indexOf(" / ") != -1){ //finds if the operator is /
			String[] inputArr = input.split(" ");
			firstOperand = inputArr[0].toString();
			secondOperand = inputArr[2].toString();
			operator = " / ";
			whole = parseOperand(secondOperand)[0].toString();
			numerator = parseOperand(secondOperand)[1].toString();
			denominator = parseOperand(secondOperand)[2].toString();
			return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		}else{
			return "ERROR";
		}
	}

	// TODO: Fill in the space below with any helper methods that you think you will need
	/*public static String[] parseInput(String in){

    }*/

	public static String[] parseOperand(String in){
		//String instance = in;
		int indexOfSlash = in.indexOf("/");
		String[] arrToReturn = new String[3]; //empty array of length 3, set [0] to whole, [1] to numer, [2] to denom, return this arr
		String wholeNum = in.split("_")[0]; //ex. if in = 5_3/4, this is [5,3/4]
		String numerator = in.substring(indexOfSlash-1, indexOfSlash); //ex. in in = 5_3/4, this is []
		String denominator = in.split("/")[1]; //ex. if in = 5_3/4, this is [5_3,4]
		arrToReturn[0] = wholeNum;  //fix exception -3/7 - 20
		arrToReturn[1] = numerator;
		arrToReturn[2] = denominator;
		return arrToReturn;
	}
}
