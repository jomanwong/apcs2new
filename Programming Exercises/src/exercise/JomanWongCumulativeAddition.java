package exercise;

//Joman Wong 9/28/16 APCS2

//This program promts the user for "x" amount of numbers to add up, and it adds ONLY even numbers.
//It also displays the biggest and smallest numbers, biggest even number, and sum, of the first "x" amount of numbers
//the user enters, and if the user put "x" amount as an unreasonable number, the code stops running to prevent error, on purpose.


import java.util.Scanner;
import java.util.ArrayList;

public class CumulativeAddition{
  public static void main(String[] args){
	  boolean shouldRun = true;
      Scanner sc1 = new Scanner(System.in);
      System.out.println("Please enter the integral value for the amount of numbers:"); // prompts for amount of values
      int xNums = sc1.nextInt();                        //use ArrayList for easier adding
      if (xNums <= 0){
    	  System.out.println("Run the program again, and please enter a value greater than or equal to 1, for the amount of numbers.");
    	  shouldRun = false;
      }
      if(shouldRun){
    	  ArrayList<Integer> numList = new ArrayList<Integer>();                        // keeps track of all values for min, max
    	  System.out.println("Please enter the intergers you want to add up, seperated by the RETURN (ENTER) Key, or spaces:");  // prompts for values to add up
    	  for (int j = 0; j < xNums; j++){
    		  int num = sc1.nextInt();
    		  numList.add(num);
    	  }
    	  int timesExec = 0;                                      //stores how many times executed
    	  int maxEven = numList.get(0);                                            //temp value for biggest even number, if any
    	  int min = numList.get(0);                               //min only exists if the array stores more than 1 value
    	  int max = numList.get(0);                               // temp value for max
    	  int sum = 0;
    	  for(int i = 0; i < xNums; i ++){                                    // finds max
    		  if (max < numList.get(i)){
    			  max = numList.get(i);  
    		  }                               
    		  if (min > numList.get(i)){									// finds min
    			  min = numList.get(i);  
    		  }                          
    		  if(numList.get(i) % 2 == 0){                 //checks if even
    			  sum += numList.get(i);                  //adds ONLY THE EVENS
    			  timesExec++;                        //tracks if this was run at all
    		  }
    		  if(numList.get(i) % 2 == 0 && numList.get(i) >= maxEven){           //checks if one even is bigger than another
    			  maxEven = numList.get(i);                                       //sets new biggest even(pos)
    		  }
    	  }
      
    	  System.out.println();                                           //whitespace
    	  System.out.println(max + " is the biggest number");               //displays max
    	  System.out.println(min + " is the smallest mumber");               //displays min
    	  if(timesExec != 0 ){                                             //checks if there are even numbers
    		  System.out.println("The sum of all even(s) is " + sum +",  the largest even number is " + maxEven); //displays sum with largest even number, IF THERE ARE EVENS
    	  }else{
    		  System.out.println("There were no even numbers to add up.");         //when there are no even numbers
    	  }
      }
  }
}

