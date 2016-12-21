/**
 * 
 * @author Joman Wong
 * @latest edit 12/9/2016 10:42 PM
 * 
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc{

	public static void main(String[] args){
		// TODO: Read the input from the user and call produceAnswer with an equation
		//int test = 2;
		Scanner in = new Scanner (System.in);
		String userInput = in.nextLine();
		//System.out.println("Test: " + test);
		while(!userInput.equals("quit")){                 //keeps prompting until quit
			System.out.println(produceAnswer(userInput));
			//System.out.println(gcf(produceAnswer(userInput)));
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

		// operand 1 vars
		int op1Whole = parseOperand(firstOperand)[0];
		int op1Numerator = parseOperand(firstOperand)[1];
		int op1Denominator = parseOperand(firstOperand)[2];
		int[] firstOperandAsInt = {op1Whole, op1Numerator, op1Denominator};

		//operand 2 vars
		int op2Whole = parseOperand(secondOperand)[0];
		int op2Numerator = parseOperand(secondOperand)[1];
		int op2Denominator = parseOperand(secondOperand)[2];
		int[] secondOperandAsInt = {op2Whole, op2Numerator, op2Denominator};

		//String[] temp; // temporary array
		//String[] firstOperand = parseOperand(parseInput(input)[0].toString());
		//String[] secondOperand = parseOperand(parseInput(input)[1].toString());

		//call calculations here
		if(operator.equals("+")){ //finds if the operator is +
			ANS = addFrac(firstOperandAsInt, secondOperandAsInt);
			temp = toMixedNum(reduce(toImproperFrac(ANS))); //could be shortened to 1 line and return
			returnThis = whatToPrint(temp);
		}else if(operator.equals("-")){ //finds if the operator is -
			ANS = subtractFrac(firstOperandAsInt, secondOperandAsInt);
			temp = toMixedNum(reduce(toImproperFrac(ANS)));
			returnThis = whatToPrint(temp);
		}else if(operator.equals("*")){ //finds if the operator is *
			ANS = multiplyFrac(firstOperandAsInt, secondOperandAsInt);
			temp = toMixedNum(reduce(toImproperFrac(ANS)));
			returnThis = whatToPrint(temp);
		}else if(operator.equals("/")){ //finds if the operator is /
			ANS = divideFrac(firstOperandAsInt, secondOperandAsInt);
			temp = toMixedNum(reduce(ANS));
			returnThis = whatToPrint(temp);
		}else{
			returnThis = "ERROR"; 
		}
		return returnThis;
		//return "whole:" + op2Whole + " numerator:" + op2Numerator + " denominator:" + op2Denominator;
	}

	// TODO: Fill in the space below with any helper methods that you think you will need
	/*public static String[] parseInput(String in){

    }*/
	//addition, calls after parseOperand
	public static int[] addFrac(int[] op1, int[] op2){ //op1 is operand 1 array of parsedOperand(), op2 is operand 2 array of parsedOperand()
		int[] ans = new int[3]; //whole, numer, denom

		if(op1[2] != op2[2]){ //if denoms don't match
			op1[1] = op1[1] * op2[2]; //op1 numer
			op2[1] = op2[1] * op1[2]; //op2 numer
			op1[2] = op1[2] * op2[2]; //op1 denom
		}
		if(op2[0] < 0){ //if op2 is neg
			ans[0] = op1[0] - op2[0];
		}else if(op1[0] < 0){ 
			ans[0] = op2[0] - op1[0];
		}else{
			ans[0] = op1[0] + op2[0];
		}

		ans[1] = op1[1] + op2[1];
		ans[2] = op1[2];
		return ans;
	}

	public static int[] subtractFrac(int[] op1, int[] op2){ //op1 is operand 1 array of parsedOperand(), op2 is operand 2 array of parsedOperand()
		int[] ans = new int[3]; //whole, numer, denom

		if(op1[2] != op2[2]){ //if denoms don't match
			op1[1] = op1[1] * op2[2]; //op1 numer
			op2[1] = op2[1] * op1[2]; //op2 numer
			op1[2] = op1[2] * op2[2]; //op1 denom
		}
		if((op1[0] < 0 || op1[1] < 0) && (op2[0] >= 0 || op2[1] >= 0)){ //if op1 is neg and op2 is not
			ans[0] = op1[0] - (op2[0] * -1);
			ans[1] = op1[1] - (op2[1] * -1);
		}else if((op1[0] >= 0 || op1[1] >= 0) && (op2[0] < 0 || op2[1] < 0)){ //if op2 is neg and op1 is not
			ans[0] = op1[0] + (op2[0] * -1);
			ans[1] = op1[1] + (op2[1] * -1);
		}else if((op1[0] < 0 || op1[1] < 0) && (op2[0] < 0 || op2[1] < 0)){ //if both neg
			ans[0] = op1[0] + (op2[0] * -1);
			ans[1] = op1[1] + (op2[1] * -1);
		}
		ans[2] = op1[2];
		return ans;
	}

	public static int[] multiplyFrac(int[] op1, int[] op2){ //op1 is operand 1 array of parsedOperand(), op2 is operand 2 array of parsedOperand()
		int[] ans = new int[3]; //whole, numer, denom
		//int op1NumerImproper = op1[0] * op1[2] + op1[]; //make first operand improper frac
		/*int[] Improperop1 = toImproperFrac(op1);
		int[] Improperop2 = toImproperFrac(op2);

		ans[0] = 0; //since it's improper frac
		ans[1] = Improperop1[1] * Improperop2[1];
		ans[2] = Improperop1[2] * Improperop2[2]; //denom*/
		
		if(op1[0] == 0 || op2[0] == 0){
			ans[0] = 0;
			ans[1] = 0;
			ans[2] = 1;
		}else{
			ans[0] = op1[0] * op2[0];
			ans[1] = op1[1] * op2[1];
			ans[2] = op1[2] * op2[2];
		}
		return ans;
	}

	public static int[] divideFrac(int[] op1, int[] op2){ //op1 is operand 1 array of parsedOperand(), op2 is operand 2 array of parsedOperand()
		int[] ans = new int[3]; //whole, numer, denom

		/*if(op1[0] != 0 && op2[0] != 0){ //prevent boundary errors
			ans[0] = op1[0] / op2[0];
		}else{
			ans[0] = op1[0] / op2[0];
		}
		ans[1] = op1[1] * op2[2];  < \/\/\/
		ans[2] = op1[2] * op2[1]; */
		
		int[] op1Improper = toImproperFrac(op1);
		int[] op2Improper = toImproperFrac(op2);
		
		ans[1] = op1Improper[1] * op2Improper[2]; //flip one and multiply
		ans[2] = op1Improper[2]	* op2Improper[1];
		
		return ans;
	}

	//parse input into 2 operands and an operator, called first
	public static String[] parseInput(String in){
		return in.split(" ");
	} 

	//seperates operand into whole, numer, and demon, called twice, each for 1 operand
	public static int[] parseOperand(String in){
		//String instance = in;

		//XXX VARS HERE XXX
		int indexOfUnderscore = in.indexOf("_");
		int indexOfForeSlash = in.indexOf("/");
		//String instance = in.substring(indexOfUnderscore + 1);
		String wholeNum;
		String numerator;
		String denominator;

		int[] arrToReturn = new int[3]; //empty array of length 3, set [0] to whole, [1] to numer, [2] to denom, return this arr

		if(indexOfUnderscore != -1){
			wholeNum = in.substring(0, indexOfUnderscore);
			numerator = in.substring(indexOfUnderscore + 1, indexOfForeSlash);
			denominator = in.substring(indexOfForeSlash + 1);
		}else if(indexOfForeSlash != -1){
			wholeNum = "0";
			numerator = in.substring(0, indexOfForeSlash);
			denominator = in.substring(indexOfForeSlash + 1);
		}else{
			wholeNum = in;
			numerator = "0";
			denominator = "1";
		}

		arrToReturn[0] = Integer.parseInt(wholeNum);
		arrToReturn[1] = Integer.parseInt(numerator);
		arrToReturn[2] = Integer.parseInt(denominator);
		return arrToReturn;

		//too complicated
		/*if(indexOfUnderscore != -1){
    		wholeNum = in.split("_")[0]; //ex. if in = 5_3/4, this is [5,3/4]
    	}else{
    		wholeNum = "0"; //if the operand has no whole number (5/4)
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
    	}	*/
	}

	// converts to mixed num, called after reducing improper fracs
	public static int[] toMixedNum(int[] in){
		// could call reduce here instead of in produceanswer
		// passes in in[0, improperNumer, denom]
		assert in.length == 3;
		int[] toReturn = new int [3];
		int numer = in[1]; // numer
		int denom = in[2]; // denom
		int remainder = numer % denom; //remainder
		//int w = n / d; //whole num
		//if improper
		if(numer > denom){
			if(numer > 0){ //pos
				toReturn[0] =  (numer - (remainder)) / denom;
				toReturn[1] = remainder;
				toReturn[2] = denom;
			}else{ //neg
				toReturn[0] =  (numer + (remainder)) / denom;
				toReturn[1] = remainder * -1;
				toReturn[2] = denom;
			}
		}else{ //not improper, correct form
			toReturn[0] = 0;
			toReturn[1] = numer;
			toReturn[2] = denom;
		}


		/*if(n > 0){
			if(w == 0){
				toReturn[0] = 0;
				toReturn[1] = ;
				toReturn[2] = ;
			}
		} */
		/*if(a%b == 0){ //if could be simplified into whole
			toReturn[0] = a/b;
			toReturn[1] = 0;
			toReturn[2] = 1;
		}else if (a < b){ //if it is NOT improper
			toReturn[0] = 0;
			toReturn[1] = a;
			toReturn[2] = b;
		}else{  //improper, reduced or not
			toReturn[0] = (a - (a % b))/b ;
			toReturn[1] = a % b ;
			toReturn[2] = b;
		}*/
		return toReturn;
	} 

	// converts to improprt frac for easier calculation
	public static int[] toImproperFrac(int[] in){
		assert in.length == 3;
		/*int[] returnArr = new int[3];
		if(in[0] < 0){ //if op is neg
			returnArr[1] = in[0] * in[2] - in[1]; //numer
		}else{
			returnArr[1] = in[0] * in[2] + in[1]; //numer
		}
		returnArr[0] = 0; //whole
		returnArr[2] = in[2]; //denom
		return returnArr;*/

		int[] returnArr = new int[3];

		if(in[1] == 0 && in[2] == 1){//if no fractions
			returnArr[0] = in[0]; //whole
			returnArr[1] = 0; //numer
			returnArr[2] = 1; //denom
		}else if(in[0] == 0 && in[1] != 0 && in[2] != 0){//if no whole number
			returnArr[0] = in[0]; //whole
			returnArr[1] = in[1]; //numer
			returnArr[2] = in[2]; //denom
		}else{ //(in[0] != 0 && in[1] != 0 && in[2] != 0){//if mixed number
			if(in[0] > 0 ){ //if pos
				returnArr[0] = 0;
				returnArr[1] = in[0] * in[2] + in[1];
				returnArr[2] = in[2]; //denom
			}else if(in[0] < 0){ //if neg
				if(in[2] > 0){
					returnArr[0] = 0;
					returnArr[1] = in[0] * in[2] - in[1];
					returnArr[2] = in[2]; //denom
					//returnArr[1] = in[0];
				}
			}
			//returnArr[1] = in[2];
		}
		return returnArr;
	}

	//finds the greatest common factor of numer and denom to reduce a fraction, takes unput from result of toImproperFrac()
	public static int[] reduce(int[] in){
		assert in.length == 3;

		int[] toReturn = new int[3]; //reduced input

		int numer = in[1]; // could be simplified, just for the sake of typing it less -- numer
		int denom = in[2]; // could be simplified, just for the sake of typing it less -- denom

		int factor = gcd(numer, denom);
		/*if(a == b){
			factor = a;
		}else if(a == 0 || b == 0){
			factor = b;      //kinda useless here
		}*/
		/*while (b > 0){
            int c = b;
            b = a % b;
            a = c;
        }*/
		toReturn[0] = in[0];
		toReturn[1] = (in[1] / factor);
		toReturn[2] = (in[2] / factor);

		return toReturn;
	} 

	//decides to print out just a whole number or a fraction
	public static String whatToPrint(int[] temp){
		String toReturn;
		if(temp[1] != 0 && temp[2] != 1 && temp[0] !=0){ //if numer and denom are not 0 and 1, and whole numer != 0, prints mixed frac
			toReturn = temp[0] + "_" + temp[1] + "/" + temp[2];
		}else if(temp[1] != 0 && temp[2] != 1){ //if only numer and denom are not 0 and 1, prints out frac
			toReturn = temp[1] + "/" + temp[2];
		}else{
			toReturn = temp[0] + "";
		}
		return toReturn;
	}
	public static int gcd(int numer,int denom){
		int factor = 1;
		//loop divides until greatest divisor is found
		if(denom > 0){
			for(int i = 2; i <= denom; i++){
				if(numer % i == 0 && denom % i == 0){
					factor = i;
				}
			}
		}else{//for negative numbers
			for(int i = -2; i >= denom; i--){
				if(numer % i == 0 && denom % i == 0){
					factor = -i;
				}
			}
		}
		return factor;
	}
}