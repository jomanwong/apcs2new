/**
 * 
 * @author Joman Wong
 * @latest edit 12/20/2016 10:42 PM
 * 
 */
package fracCalc;

import java.util.Arrays;
import java.util.Scanner;


public class FracCalc{
	public static void main (String[] args){
		// TODO: Read the input from the user and call produceAnswer with an equation
		//int test = 2;
		System.out.println("========================================================================================================");
		System.out.println("\t\t\t\t\t\tCalculator On");
		System.out.println("========================================================================================================");

		Scanner in = new Scanner (System.in);
		String userInput = in.nextLine();
		//System.out.println("Test: " + test);
		while(!userInput.equals("quit")){                 //keeps prompting until quit
			System.out.println(produceAnswer(userInput));
			//System.out.println(gcd(produceAnswer(userInput)));
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
		String returnThis;
		//String[] in.split(" ");
		String firstOperand = parseInput(input)[0];
		String operator = parseInput(input)[1]; //determines what calculate function to run
		String secondOperand = parseInput(input)[2];
		int[] ANS = new int[3]; //it is to shorten the return command line, replaces "XFrac(firstOperandAsInt, secondOperandAsInt)"
		int[] temp = new int[3];
		//String toReturn;
		//String operator;

		// operand 1 indiv vars
		int OP1Whole = parseOperand(firstOperand)[0];
		int OP1Numerator = parseOperand(firstOperand)[1];
		int OP1Denominator = parseOperand(firstOperand)[2];
		int[] firstOperandAsInt = {OP1Whole, OP1Numerator, OP1Denominator};

		//operand 2 indiv vars
		int OP2Whole = parseOperand(secondOperand)[0];
		int OP2Numerator = parseOperand(secondOperand)[1];
		int OP2Denominator = parseOperand(secondOperand)[2];
		int[] secondOperandAsInt = {OP2Whole, OP2Numerator, OP2Denominator};



		String operator= parseInput(input)[1];

		int[] operandOne= parseOperand(splitParse[0]);
		int[] operandTwo= parseOperand(splitParse[2]);

		int[] impropOperandOne=toImproperFrac(operandOne);

		int[] impropOperandTwo=toImproperFrac(operandTwo);
		String answer;
		if ( operator.equals("+") ){
			answer = toMixedFrac(addingFractions(impropOperandOne,impropOperandTwo));
		}
		else if(operator.equals("-")){
			answer = toMixedFrac(subtractingFractions(impropOperandOne,impropOperandTwo));
		}
		else if(operator.equals("*")){
			answer = toMixedFrac(multiplyingFractions(impropOperandOne,impropOperandTwo));
		}
		else if(operator.equals("/")){
			answer = toMixedFrac(dividingFractions(impropOperandOne,impropOperandTwo));	
		}
		else{
			answer = "ERROR";
		}
		return answer;
	}

	public static String[] parseInput(String in){
		return in.split(" ");
	} 

	public static int[] parseOperand(String operand){
		String[] partsOfOperand=new String [3];
		if (operand.indexOf("_")<0 && operand.indexOf("/")<0) {
			// Integers
			partsOfOperand[0] = operand;
			partsOfOperand[1] = "0";
			partsOfOperand[2] = "1";
		}
		else if(operand.indexOf("_")<0 && operand.indexOf("/")>0 ){
			// Improper Fraction
			partsOfOperand[0] = "0";
			partsOfOperand[1] = operand.substring(0, operand.indexOf("/"));
			partsOfOperand[2] = operand.substring(operand.indexOf("/")+1);
		}
		else if(operand.indexOf("_")>0 && operand.indexOf("/")>0){
			//Mixed Number
			partsOfOperand[0] = operand.substring(0,operand.indexOf("_"));
			partsOfOperand[1]=operand.substring(operand.indexOf("_")+1,operand.indexOf("/"));
			partsOfOperand[2] = operand.substring(operand.indexOf("/")+1);
		}
		int[] parseOfOperand=new int [3];

		for(int i = 0; i < 3; i++) {
			parseOfOperand[i]= Integer.parseInt(partsOfOperand[i]);
		}
		return parseOfOperand;
	}

	//Change mixed to improper
	public static int[] toImproperFrac (int[] operand) {
		int[] improperFraction=new int [2];
		if(operand[0]<0){   // Note : Checks if the fraction is a negative number

			improperFraction[0] = (operand[0]*operand[2])+(operand[1]*-1)	;
			improperFraction[1] = operand[2];
		}
		else{
			improperFraction[0] =((operand[0]*operand[2])+operand[1]);
			improperFraction[1]=operand[2];
		}
		return improperFraction;
	}

	public static String toMixedFrac(int[] answer) {

		String reducedAnswer;
		int gcd = gcd(answer[0],answer[1]);
		if(gcd!=1) {
			answer[0] = answer[0]/gcd;	// Numer
			answer[1] = answer[1]/gcd;	// Denom
		}
		if(answer[1]<0){
			answer[1]=Math.abs(answer[1]);
			answer[0]=answer[0]*-1;
		}
		int coefficient = answer[0]/answer[1];
		int remainder = answer[0] % answer[1];
		if (coefficient<0){
			if(remainder==0 && answer[1]==1){
				reducedAnswer = (Integer.toString(coefficient));
			}else if(remainder==0 && answer[1]==-1){
				reducedAnswer = (Integer.toString(coefficient));
			}else{
				reducedAnswer = coefficient + "_" + Math.abs(remainder) + "/" + Math.abs(answer[1]);
			}
		}else if(remainder==0){
			reducedAnswer = coefficient+"";		
		}else if(coefficient==0){			
			if(remainder<0 && answer[1]<0){
				int newNum = remainder*-1;
				int newDenom = answer[1]*-1;
				reducedAnswer = newNum + "/" + newDenom;
			}else{
				reducedAnswer = remainder + "/" + answer[1];
			}
		}else if(remainder<0 && answer[1]<0){
			int numerator = remainder*-1;
			int denominator = answer[1]*-1;
			reducedAnswer = coefficient + "_" + numerator + "/" + denominator;
		}else{
			reducedAnswer = coefficient + "_" + remainder + "/" + answer[1];
		}

		return reducedAnswer;
	}	

	public static int gcd(int a, int b){
		while(a!=0 && b!=0){
			int c = b;
			b = a%b;
			a = c;
		}
		return Math.abs(a+b);
	}

	// Note : Find common denominator, then cross multiply the improper fractions, then add up numerators 	

	public static int[] addingFractions(int[] operandOne, int[] operandTwo){ 
		int[] answer =new int[2];
		int numerator1 = operandOne[0];
		int denominator1 = operandOne[1];
		int numerator2 = operandTwo[0];
		int denominator2 = operandTwo[1];
		answer[0] = denominator2 * numerator1 + denominator1 * numerator2;
		answer[1] = denominator1 * denominator2;
		return answer;
	}

	// Note : Multiply both numerators and denominators

	public static int[] multiplyingFractions(int[] operandOne, int[] operandTwo){ 
		int[] answer =new int[2];
		int numerator1 = operandOne[0];
		int denominator1 = operandOne[1];
		int numerator2 = operandTwo[0];
		int denominator2 = operandTwo[1];
		answer[0] = numerator1 * numerator2;
		answer[1] = denominator1 * denominator2;
		return answer;
	}

	// Note : Find common denominator,cross multiply then subtract numerators 

	public static int[] subtractingFractions(int[] operandOne, int[] operandTwo){ 
		int[] answer =new int[2];
		int numerator1 = operandOne[0];
		int denominator1 = operandOne[1];
		int numerator2 = operandTwo[0];
		int denominator2 = operandTwo[1];
		answer[0] = denominator2 * numerator1 - denominator1 * numerator2;
		answer[1] = denominator1 * denominator2;
		return answer;
	}

	//Reverse the second operand numerator and denominator then multiply

	public static int[] dividingFractions(int[] operandOne, int[] operandTwo){ 
		int[] answer =new int[2];
		int numerator1 = operandOne[0];
		int denominator1 = operandOne[1];
		int numerator2 = operandTwo[0];
		int denominator2 = operandTwo[1];
		answer[0] = numerator1 * denominator2;
		answer[1] = denominator1 * numerator2;
		return answer;
	}
}