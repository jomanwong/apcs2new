/**
 * 
 * @author Joman Wong
 * @latest edit 12/10/2016 3:42 PM
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalcPart2{

    public static void main(String[] args){
    	// TODO: Read the input from the user and call produceAnswer with an equation
    	//int test = 2;
    	Scanner in = new Scanner (System.in);
    	String userInput = in.nextLine();
    	//System.out.println("Test: " + test);
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
    	String[] inputArr = input.split(" ");
    	String firstOperand = inputArr[0];
    	String secondOperand = inputArr[2];
    	String toReturn;
    	String operator;
    	
    	int whole = parseOperand(secondOperand)[0];
    	int numerator = parseOperand(secondOperand)[1];
    	int denominator = parseOperand(secondOperand)[2];
    	//String[] temp; // temporary array
    	//String[] firstOperand = parseOperand(parseInput(input)[0].toString());
    	//String[] secondOperand = parseOperand(parseInput(input)[1].toString());
    	
    	
    	
    	if(input.indexOf(" + ") != -1){ //finds if the operator is +
    		//inputNoSpace = input.replaceAll("\\s+",""); //no whitespaces
        	operator = " + ";
        }else if(input.indexOf(" - ") != -1){ //finds if the operator is -
        	operator = " - ";
        }else if(input.indexOf(" * ") != -1){ //finds if the operator is *
        	operator = " * ";
        }else if(input.indexOf(" / ") != -1){ //finds if the operator is /
        	operator = " / ";
        }else{
        	return "ERROR";
        }
    	return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    /*public static String[] parseInput(String in){
    	
    }*/
    
    public static int[] parseOperand(String in){
    	//String instance = in;
    	
    	//XXX VARS HERE XXX
    	int indexOfUnderscore = in.indexOf("_");
    	String instance = in.substring(indexOfUnderscore + 1);
     	int indexOfForeSlash = instance.indexOf("/");
    	String wholeNum;
    	String numerator;
    	String denominator;
    	

    	int[] arrToReturn = new int[3]; //empty array of length 3, set [0] to whole, [1] to numer, [2] to denom, return this arr
    	
    	
    	if(indexOfUnderscore != -1){
    		wholeNum = in.split("_")[0]; //ex. if in = 5_3/4, this is [5,3/4]
    	}else{
    		wholeNum = in; //if the operand has no whole number (5/4)
    	}
    	
    	if(indexOfForeSlash != -1){ //"is it a fraction?"
    		denominator = in.split("/")[1]; //ex. if in = 5_3/4, this is [5_3,(4)]
    		if(indexOfUnderscore == -1){
    			numerator = in.split("/")[0]; //ex. no underscore in in = 3/4, this is []
    		}else{
    			numerator = in.split("/")[0]; //ex. in in = 5_3/4, this is []
    		}
    	}else{
    		denominator = "1"; //if the operand has no fractions (21)
    		numerator = "0";
    	}	

    	arrToReturn[0] = Integer.parseInt(wholeNum);
    	arrToReturn[1] = Integer.parseInt(numerator);
    	arrToReturn[2] = Integer.parseInt(denominator);
    	return arrToReturn;
    }
}
