package textExcel;

import java.util.regex.*;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	
	//XXX VARS HERE
	private static int rows = 20;
	private static int cols = 12;
	private String command; //whatever user inputs
	String[][] spreadSheet = new String[rows][cols];
	
	
	public static void Spreadsheet(){
		/**XXX FORMAT XXX
		 * 3 spaces, left justified, space(s) could be taken by row number
		 * then "|", followed by 10 spaces, and "|"
		 * repeat, until reaches 12th column
		 */
		
		
		
		System.out.println("   |A         |B         |C         |D         |E         |F         |G         |" +
				"H         |I         |J         |K         |L         |");
		for(int i = 1; i <= 20; i++){
			if(i < 10){
				System.out.println(i + "  |"/*2 spaces followed by |*/ + "          |          |          |" +
						"          |          |          |          |          |          |          |"+
						"          |          |");
		
			}else{
				System.out.println(i + " |"/*1 space followed by |*/ + "          |          |          |" +
						"          |          |          |          |          |          |          |"+
						"          |          |");
			}
		}
	}
	
	
	@Override
	public String processCommand(String inputCommand){
		// TODO Auto-generated method stub
		this.command = inputCommand;
														//*** commands ***
		if(this.command.equalsIgnoreCase("quit")){		//"quit"
			return "exit loop";							//cell i.e. "D20" 
		}else if(this.command.matches("[A-L][1-9]") || this.command.matches("[A-L][1][0-9]") || this.command.matches("[A-L][2][0]")){	
			String cmdParts[] = this.command.split("[A-L]");
			//cmdParts[0] = this.command.charAt(0) + "";
			//Tests values:
			spreadSheet[0][0] = "Hello"; //A1
			spreadSheet[19][1] = "Hai"; //B20
			spreadSheet[12][9] = "Hello again"; //J13
			
			String value = spreadSheet[Integer.parseInt(cmdParts[1]) - 1][this.command.charAt(0) - 65]; //65 is from ASCII decimal value of A
			return value;
		}
		return this.command; //for checkpoint 1 only the command "quit" needs to be done correctly
	}

	@Override
	public int getRows(){
		// TODO 20 rows are required
		return this.rows; //same as returning length of spreadSheet array but shorter
	}

	@Override
	public int getCols(){
		// TODO 12 columns are required
		return this.cols; //same as returning length of spreadSheet array but shorter
	}

	@Override
	public Cell getCell(Location loc){
		// TODO Auto-generated method stub
		return null; //null is holder?
	}

	@Override
	public String getGridText(){
		// TODO Auto-generated method stub
		return null; //null is holder?
	}

}
