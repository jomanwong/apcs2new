package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel{
	
	//XXX VARS HERE
	private static String userInput;
	
	public static void main(String[] args){
	    // Add your command loop here
		//XXX could model after magpie4 runner or fracCalc
		//\/\/ test initalize
		
		Spreadsheet ss = new Spreadsheet(); //prints out sheet format
		//Spreadsheet.Spreadsheet();
		Scanner console = new Scanner(System.in);
		userInput = console.nextLine();
		
		while(ss.processCommand(userInput).equalsIgnoreCase("quit") == false){
			System.out.println(ss.processCommand(userInput));
			//if(userInput.equalsIgnoreCase("quit")){
		///*let's*/	break; //it down!
			//}
			userInput = console.nextLine();
		}
		console.close();
	}
}
