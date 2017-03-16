package textExcel;

import java.util.regex.*;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	
	//XXX VARS HERE
	private static int rows = 20;
	private static int cols = 12;
	private String command; //whatever user inputs
	static Cell[][] spreadSheet = new Cell[rows][cols]; //stores full text
	
	
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
	
	
	@Override
	public String processCommand(String inputCommand){
		// TODO Auto-generated method stub
		this.command = inputCommand;
		String cmdParts[] = this.command.split("[A-L]");									//*** commands ***
		
		if(this.command.equalsIgnoreCase("quit")){											//"quit"
			return "quit"; //works also with return this.command, b/c it types in quit	   	//cell i.e. "D20" 
		}else if(this.command.matches("[A-L][1-9]") || this.command.matches("[A-L][1][0-9]") || this.command.matches("[A-L][2][0]")){	
			
			Cell value = spreadSheet[(Integer.parseInt(cmdParts[1]) - 1)][this.command.charAt(0) - 65]; //65 is from ASCII decimal value of A
			return value.fullCellText();
			
			//cmdParts[0] = this.command.charAt(0) + "";
			/*//Tests values: OBSELETE
			spreadSheet[0][0] = "Hello"; //A1
			spreadSheet[19][1] = "Hai"; //B20
			spreadSheet[12][9] = "Hello again"; //J13
			*/
			
		/*}else if(this.command.split(" ")[1].equalsIgnoreCase("=")){ //assign value
			String locInput = this.command.split(" ")[0] + "";
			String cmdParts2[] = locInput.split("[A-L]");
			String value = this.command.split("\"")[2];
	//	}else if(this.command.split("")){
			
		*/
		}else{
			return this.command;
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
		String cmdParts[] = this.command.split("[A-L]");				
		Cell value = spreadSheet[(Integer.parseInt(cmdParts[1]) - 1)][this.command.charAt(0) - 65]; //65 is from ASCII decimal value of A
		return value; //null is holder?
	}

	@Override
	public String getGridText(){
		// TODO Auto-generated method stub
		String returnThis = "";
		for(Cell[] i: this.spreadSheet){
			for(Cell j: i){
				returnThis += j.fullCellText();
			}
		}
		return returnThis; //null is holder?
	}

}
