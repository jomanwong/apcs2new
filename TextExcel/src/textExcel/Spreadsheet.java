/***
 *  Joman Wong
 *  
 *  NOTE: There are a lot of white spaces, as it is less clumped, it's easier on me eyes to focus during the night.
 */



package textExcel;

import java.util.regex.*;

// Update this file with your own code.

public class Spreadsheet implements Grid{

	//XXX VARS HERE
	private static int rows = 20;
	private static int cols = 12;
	private String command; //whatever user inputs
	static Cell[][] spreadSheet = new Cell[rows][cols]; //stores full text, initalize here


	public Spreadsheet(){
		/**XXX FORMAT XXX
		 * 3 spaces, left justified, space(s) could be taken by row number
		 * then "|", followed by 10 spaces, and "|"
		 * repeat, until reaches 12th column
		 */


		System.out.println("   |A         |B         |C         |D         |E         |F         |G         |" +
				"H         |I         |J         |K         |L         |"); //classic header
		for(int i = 1; i <= 20; i++){ //need to be changed later as to do print abbrivatedCellText();

			//initalize
			for(int j = 0; j < 12; j++){
				spreadSheet[i-1][j] = new EmptyCell();
			}

			if(i < 10){
				System.out.print(i + "  |"/*2 spaces followed by |*/);
				for(int j = 0; j < 12; j++){
					System.out.print(spreadSheet[i-1][j].abbreviatedCellText() + "|"); 
				}
				System.out.println();

			}else{
				System.out.print(i + " |"/*1 space followed by |*/); 

				for(int j = 0; j < 12; j++){
					System.out.print(spreadSheet[i-1][j].abbreviatedCellText() + "|"); 
				}
				System.out.println();

			}
		}
	}

	public static boolean isNumeric(String str){
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal, part of first approach
	}


	@Override
	public String processCommand(String inputCommand){
		// TODO Auto-generated method stub
		//assert inputCommand.length() > 0: ""; 																						//Deals with cases in CP 1, empty inputs
		
		if(inputCommand.equals("")){																									//Deals with cases in CP 1, empty inputs
			return inputCommand;
		}
		
		//VAR HERE
		String command = inputCommand;
																																		//*** commands ***
		
		
		if(inputCommand.equals("quit")){																								// "quit"
			return "quit";
		}

		//VAR HERE
		String[] cmdParts = command.split(" ", 3); //really important to limit to make first 3 parts, or else will fail some tests

		
		if(cmdParts.length == 1 && !cmdParts[0].toLowerCase().equals("clear")){    														// cell inspection (i.e. A1). Return the value at that cell

			return inspectCell(cmdParts[0]);


		}else if(cmdParts.length == 3) { //only 3 part command																			// assignment to string values (i.e. A1 = "Hello").
			
			assignToCell(cmdParts[0],cmdParts[2]);
			return getGridText();
			
		}else if(cmdParts[0].toLowerCase().equals("clear") && cmdParts.length == 2){ 													// clearing a particular cell (i.e. clear A1).

			clearCell(cmdParts[1]);
			return getGridText();

		}else if(cmdParts[0].toLowerCase().equals("clear") && cmdParts.length == 1){  													// clear sheet, know it is clear because only 1 part

			clear();
			return getGridText();


		}else{
			
			return inputCommand; //WHY DOES THIS NOT GET RUN???
		
		}

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

		return spreadSheet [loc.getRow()][loc.getCol()]; //note to self, notice method returns type Cell, not String
	}

	public String inspectCell(String cell){
		//returns content of cell
		SpreadsheetLocation loc = new SpreadsheetLocation(cell); //thx to Mr DeHeer pointing out I could use SpreedsheetLocation
		return getCell(loc).fullCellText();
	}

	public void assignToCell(String cell, String in){
		//Assign the String of a cell to the input value
		SpreadsheetLocation loc = new SpreadsheetLocation(cell.toUpperCase()); //thx to Mr DeHeer pointing out I could use SpreedsheetLocation
		if(in.charAt(in.length() - 1) == '%'){ //percent Cell
			spreadSheet[loc.getRow()][loc.getCol()] = new PercentCell(in);
		}else{
			spreadSheet[loc.getRow()][loc.getCol()] = new TextCell(in.trim());
		}
	}

	public void clearCell(String cell){
		//'clear' the selected cell, aka turning it into empty cell, TODO: remember to change emptycell Strings back to 10 spaces
		SpreadsheetLocation loc = new SpreadsheetLocation(cell.toUpperCase());  
		spreadSheet [loc.getRow()][loc.getCol()] = new EmptyCell();
	}

	public void clear(){
		//'clears' the spreadsheet, aka turn all cell to empty, TODO: remember to change emptycell Strings back to 10 spaces
		for(int i = 0; i<20;i++){
			for(int j = 0;j<12;j++){

				spreadSheet [i][j] = new EmptyCell(); //well I could also call clearCell on these cell loc, but this seems easier to do
			}
		}
	}

	@Override
	public String getGridText(){

		String firstChar = "   |";
		for(char i = 'A'; i <= 'L'; i++){ //iterate through characters as if they were numbers
			firstChar += i + "         |";
		}
		String rowNum = "\n";
		for(int i = 0;i < 20; i++){

			if(i < 9){

				rowNum += (i + 1); //count to 20, first num on console is 1
				rowNum += "  |";

				for(int j = 0; j < 12; j++){

					rowNum += spreadSheet[i][j].abbreviatedCellText() + "|"; //box boundary

				}

				rowNum +="\n";

			}else{

				rowNum += (i + 1); //count to 20
				rowNum += " |";

				for(int k = 0; k < 12; k++){

					rowNum += spreadSheet[i][k].abbreviatedCellText() + "|"; //box boundary

				}

				rowNum += "\n"; //adds a new line for clear formatting
			}
		}
		return firstChar + rowNum;
	}

}
