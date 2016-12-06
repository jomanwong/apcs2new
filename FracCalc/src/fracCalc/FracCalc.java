/**
 * 
 * @author Joman Wong
 * @latest edit 12/5/2016 9:42 PM
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

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
    	String[] firstOperand = parseOperand(parseInput(input)[0].toString());
    	String[] secondOperand = parseOperand(parseInput(input)[1].toString());
    	
    	
    	
    	if(input.indexOf(" + ") != -1){ //finds if the operator is +
    		//inputNoSpace = input.replaceAll("\\s+",""); //no whitespaces
    		String[] inputArr = input.split(" ");
        	firstOperand = inputArr[0].toString();
        	secondOperand = inputArr[2].toString();
        	operator = " + ";
        	return toReturn;
        }else if(input.indexOf(" - ") != -1){ //finds if the operator is -
        	String[] inputArr = input.split(" ");
        	firstOperand = inputArr[0].toString();
        	secondOperand = inputArr[2].toString();
        	operator = " - ";
        	return toReturn;
        }else if(input.indexOf(" * ") != -1){ //finds if the operator is *
        	String[] inputArr = input.split(" ");
        	firstOperand = inputArr[0].toString();
        	secondOperand = inputArr[2].toString();
        	operator = " * ";
        	return toReturn;
        }else if(input.indexOf(" / ") != -1){ //finds if the operator is /
        	String[] inputArr = input.split(" ");
        	firstOperand = inputArr[0].toString();
        	secondOperand = inputArr[2].toString();
        	operator = " / ";
        	return toReturn;
        }else{
        	return "ERROR";
        }
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String[] parseInput(String in){
    	
    }
    public static String[] parseOperand(String in){
    	
    }
}
